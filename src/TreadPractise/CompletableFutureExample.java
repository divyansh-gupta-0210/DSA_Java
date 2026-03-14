package TreadPractise;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
           try{
               Thread.sleep(1000);
           }
           catch (InterruptedException ex){
               Thread.currentThread().interrupt();
           }
           return "Result from Completable future";
        }).thenAccept(result -> {
           System.out.println("Completable future example " + result);
           System.out.println("Processing after completable future");
        });

        System.out.println("Main Thread is free to do other tasks. . .");
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
