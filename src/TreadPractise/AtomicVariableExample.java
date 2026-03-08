package TreadPractise;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableExample {
    private AtomicInteger counter = new AtomicInteger(0);
    public void increment(){
        int newValue = counter.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " incremented counter to " + newValue);
    }
    public int getCounter(){
        return counter.get();
    }

    public static void main(String[] args) {
        final AtomicVariableExample atomicVariableExample = new AtomicVariableExample();
        int numberOfThreads = 10;
        int incrementsPerThread = 100;

        Thread[] threads = new Thread[numberOfThreads];
        for(int i = 0; i < numberOfThreads; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < incrementsPerThread; j++){
                        atomicVariableExample.increment();
                    }
                }
            }, "Thread- " + (i+1));
            threads[i].start();
        }
        for(int i = 0; i < numberOfThreads; i++){
            try{
                threads[i].join();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("Final counter value: " + atomicVariableExample.getCounter());
    }
}
