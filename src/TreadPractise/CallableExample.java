package TreadPractise;

import java.util.ArrayList;
import java.util.List;
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

// Example of having runnable inside a callable class
class WorkerThread implements Runnable{
    private final int taskId;
    public WorkerThread(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is processing task: " + taskId);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            System.out.println("Task Interrupted " + ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished task: " + taskId);
    }
}

class ThreadPoolQueueExample{
    public void customThread(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for(int i = 1; i <= 10; i++){
            final int taskId = 1;
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is processing " + taskId);
            });
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        threadPoolExecutor.shutdown();
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ThreadPoolQueueExample threadPoolQueueExample = new ThreadPoolQueueExample();
        threadPoolQueueExample.customThread();
        Callable<String> callable1 = new MyCallable("Task 1");
        Callable<String> callable2 = new MyCallable("Task 2");
        System.out.println(Runtime.getRuntime().availableProcessors());
        try{
            Future<String> future1 = executorService.submit(callable1);
            Future<String> future2 = executorService.submit(callable2 );
            System.out.println("Result from first task: ");
            System.out.println(future1.get());
            System.out.println("Result from first task: ");
            System.out.println(future2.get());
            System.out.println("*********************************");
            List<Future<?>> futures = new ArrayList<>();
            for(int i = 0; i <= 5; i++){
//                executorService.submit(new WorkerThread(i));
                futures.add(executorService.submit(new WorkerThread(i)));
            }
            for(Future<?> f : futures){
                f.get();
            }
        }
        catch (InterruptedException | ExecutionException ex){
            System.out.println("Task execution interrupted: " + ex.getMessage());
        }
        finally {
            executorService.shutdown();
        }
    }
}
