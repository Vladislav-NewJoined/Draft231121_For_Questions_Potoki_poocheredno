package task2_2_9_1_copy4_ru_stackoverflow_OkRabotaet;

class A implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ClassA : A");
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

class B implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ClassB : B");
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

class C implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ClassC : C");
        System.out.println("""
                3. Использовать статический метод Thread.sleep(), чтобы сделать паузу.
                Реализовано путём создания паузы 1200 миллисекунд между выводом на печать\s
                значений счетчика '1' и '2':""");

        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Counter value: " + (i + 1));
        }
        System.out.println();
    }
}

class D implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ClassD : D");
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
        System.exit(0);
            }
    }

// источник: https://stackoverflow-com.translate.goog/questions/15997483/how-to-ensure-java-threads-run-in-a-particular-order?_x_tr_sl=en&_x_tr_tl=ru&_x_tr_hl=ru
public class OrderedThreadApp {
    public static void main(String[] args) {

        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        Thread c = new Thread(new C());
        Thread d = new Thread(new D());

        a.start();
        try {
            a.join();
            b.start();
            b.join();
            c.start();
            c.join();
            d.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
