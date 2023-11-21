package task2_2_9_1_copy1_otpravleno_na_kiberforumy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service1 = Executors.newFixedThreadPool(1);
        Thread t1 = new Thread(new MyThread1());
        t1.start();
        service1.shutdown();

        ExecutorService service2 = Executors.newFixedThreadPool(1);
        Thread t2 = new Thread(new MyThread2());
        t2.start();
        service2.shutdown();

        ExecutorService service3 = Executors.newFixedThreadPool(1);
        Thread t3 = new Thread(new MyThread3());
        t3.start();
        service3.shutdown();

        ExecutorService service4 = Executors.newFixedThreadPool(1);
        Thread t4 = new Thread(new MyThread4());
        t4.start();
        service4.shutdown();

    }

    static class MyThread1 implements Runnable {
        @Override
        public void run() {
            synchronized (strings) {
                System.out.println("1. Создать класс, реализующий интерфейс Runnable." +
                        "\nРеализовано на примере создания счётчика от 1-го до 5-ти:");

                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Runnable count " + (i + 1));
                }
                System.out.println();
            }
        }
    }

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            synchronized (strings) {
                System.out.println("2. Переопределить run() метод. Создать цикл for. В цикле распечатать значения " +
                        "\nот 0 до 100 делящиеся на 10 без остатка:");

                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i % 10 == 0) {
                        System.out.println(i);
                    }
                }
                System.out.println();
            }
        }
    }


    static class MyThread3 implements Runnable {
        @Override
        public void run() {
            synchronized (strings) {
                System.out.println("""
                        3. Использовать статический метод Thread.sleep(), чтобы сделать паузу.
                        Реализовано путём создания паузы 1500 миллисекунд между выводом на печать\s
                        значений счетчика '1' и '2':""");

                for (int i = 0; i < 2; i++) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Counter value: " + (i + 1));
                }
                System.out.println();
            }
        }
    }


    static class MyThread4 implements Runnable {
        @Override
        public void run() {
            synchronized (strings) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("4. Создать три потока, выполняющих задачу распечатки значений." +
                        "\nРеализовано на примере вывода уведомлений о старте и финише трёх потоков:");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread" + (i + 1) + " started");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread" + (i + 1) + " finished");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            System.exit(0);
        }
    }
}
