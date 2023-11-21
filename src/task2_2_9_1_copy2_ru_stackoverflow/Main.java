package task2_2_9_1_copy2_ru_stackoverflow;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    //функция, которую нужно выполнить в отдельном потоке
    public static String executePost(String targetURL, String urlParameters) {
        return "any";}

    static class SomeThing implements Callable<String>
    {
        String targetURL;
        String urlParameters;

        SomeThing(String url, String params) {
            this.targetURL = url;
            this.urlParameters = params;
        }

        @Override
        public String call() throws Exception {
            System.out.println("Привет из побочного потока!");
            return executePost(targetURL, urlParameters);
        }
    }

    private static SomeThing mThing;

    public static void main(String[] args) {

        String forSearch = "Radioactive";
        mThing = new SomeThing("https://itunes.apple.com/search?term=" +
                forSearch, "");

        FutureTask<String> task = new FutureTask<>(mThing);
        Thread myThready = new Thread(task);
        myThready.start();

        try {
            String quest = task.get();
            System.out.println(quest);
        } catch (InterruptedException | ExecutionException e) {
            //something
        }
    }
}
