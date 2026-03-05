package TreadPractise;

import java.util.concurrent.*;

class MyCallable implements Callable<String>{
    private final String name;
    public MyCallable(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception{
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 5; i++){
            result.append("Callable ")
                    .append(name).append(" is running: ")
                    .append(i).append(" ").append(Thread.currentThread().getId())
                    .append("\n");
        }
        return result.toString();
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> callable1 = new MyCallable("Task 1");
        Callable<String> callable2 = new MyCallable("Task 2");
        try{
            Future<String> future1 = executorService.submit(callable1);
            Future<String> future2 = executorService.submit(callable2);
            System.out.println("Result from first task: ");
            System.out.println(future1.get());
            System.out.println("Result from first task: ");
            System.out.println(future2.get());
        }
        catch (InterruptedException | ExecutionException ex){
            System.out.println("Task execution interrupted: " + ex.getMessage());
        }
        finally {
            executorService.shutdown();
        }
    }
}
