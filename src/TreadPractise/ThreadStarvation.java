package TreadPractise;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadStarvation {
    private static final AtomicInteger[] completedTasks = new AtomicInteger[3];
    static {
        for(int i = 0; i < completedTasks.length; i++){
            completedTasks[i] = new AtomicInteger(0);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Example 1: Without Thread Pool (Potential Starvation) ---");
        withoutThreadPool();
        for(AtomicInteger counter : completedTasks){
            counter.set(0);
        }
        System.out.println("--- Example 2: With Thread Pool (Fair Scheduling) ---");
        withThreadPool();
    }

    private static void withoutThreadPool() throws InterruptedException{
        final Object sharedResource = new Object();
        for(int i = 0; i < 30; i++){
            Thread thread = new Thread(new PriorityTask(i%2, sharedResource));
            thread.setPriority(Thread.MIN_PRIORITY + (i % 3 ) * 1);
            thread.start();
        }
        Thread.sleep(5000);
        System.out.println("Tasks completed by priority: ");
        System.out.println("Low Priority: " + completedTasks[0].get());
        System.out.println("Medium Priority: " + completedTasks[1].get());
        System.out.println("High Priority: " + completedTasks[2].get());
    }

    private static void withThreadPool() throws InterruptedException{
        final Object sharedResource = new Object();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, 4, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(), new ThreadPoolExecutor.CallerRunsPolicy()
        );
        executor.setThreadFactory(r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
        for(int i = 0; i < 30; i++){
            executor.submit(new PriorityTask(i%3, sharedResource));
        }
        Thread.sleep(5000);
        System.out.println("Tasks completed by priority: ");
        System.out.println("Low Priority: " + completedTasks[0].get());
        System.out.println("Medium Priority: " + completedTasks[1].get());
        System.out.println("High Priority: " + completedTasks[2].get());
        executor.shutdown();
    }

    static class PriorityTask implements Runnable{
        private final int priority;
        private final Object sharedResource;
        public PriorityTask(int priority, Object sharedResource){
            this.priority = priority;
            this.sharedResource = sharedResource;
        }

        @Override
        public void run(){
            try{
                for(int i = 0; i < 10; i++){
                    synchronized (sharedResource){
                        Thread.sleep(20 + (10L * priority));
                        completedTasks[priority].incrementAndGet();
                    }
                    Thread.sleep(10);
                }
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }
}
