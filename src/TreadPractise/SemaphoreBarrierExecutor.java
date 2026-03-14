package TreadPractise;

import java.util.concurrent.*;

public class SemaphoreBarrierExecutor {
    static class SemaphoreBarrier{
        private final int parties;
        private int count;
        private final Semaphore mutex = new Semaphore(1);
        private final Semaphore barrier = new Semaphore(0);
        public SemaphoreBarrier(int parties){
            this.parties = parties;
            this.count = parties;
        }

        public void await() throws InterruptedException{
            mutex.acquire();
            count--;
            if(count == 0){
                barrier.release(parties-1);
                count = parties;
                mutex.release();
            }
            else{
                mutex.release();
                barrier.acquire();
            }
        }
    }

    public static void main(String[] args) {
        final int numThreads = 5;
        final SemaphoreBarrier barrier = new SemaphoreBarrier(numThreads);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads,
                new ThreadFactory() {
                    private int counter = 1;
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r, "Worker-" + counter);
                        counter++;
                        return t;
                    }
                });
        for(int i = 0; i < numThreads; i++){
            executor.submit(() -> {
                try{
                    System.out.println(Thread.currentThread().getName() + " doing phase 1 work");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(Thread.currentThread().getName() + " arrived at barrier after phase 1");
                    barrier.await();

                    System.out.println(Thread.currentThread().getName() + " doing phase 2 work");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(Thread.currentThread().getName() + " finished phase 2");
                    barrier.await();

                    System.out.println(Thread.currentThread().getName() + " doing phase 3 work");
                    barrier.await();
                }
                catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            });
        }
        executor.shutdown();
        try{
            if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("Some tasks did not finish in time");
                executor.shutdownNow();
            }
        }
        catch (InterruptedException ex){
            System.out.println("Main Thread Interrupted");
            executor.shutdown();
        }
        System.out.println("All tasks completed");
    }
}
