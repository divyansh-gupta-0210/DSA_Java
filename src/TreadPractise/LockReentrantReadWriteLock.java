package TreadPractise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockReentrantReadWriteLock {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int logValue = 0;
    private void simulateWork(){
        long sum = 0;
        for(int i = 0; i < 500000; i++){
            sum+=i;
        }
    }

    public void writeValue(String taskName, int newValue){
        rwLock.writeLock().lock();
        try{
            System.out.println(taskName + " (write) : Acquired write lock.");
            simulateWork();
            logValue = newValue;
            System.out.println(taskName + " (write): Updated logValue to " + logValue);
        }
        finally {
            System.out.println(taskName + " (write): Released write lock");
            rwLock.writeLock().unlock();
        }
    }

    public void readValue(String taskName){
        rwLock.readLock().lock();
        try{
            System.out.println(taskName + " (read) : Acquired read lock. Reading logValue: " + logValue);
            simulateWork();
            System.out.println(taskName + " (read) : Finished reading.");
        }
        finally {
            System.out.println(taskName + " (read) : Reading read lock");
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        LockReentrantReadWriteLock logExample = new LockReentrantReadWriteLock();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(() -> logExample.readValue("Reader-2"));
        executor.submit(() -> logExample.readValue("Reader-3"));
        executor.submit(() -> logExample.writeValue("Writer-1", 100));
        executor.submit(() -> logExample.readValue("Reader-4"));
        executor.submit(() -> logExample.readValue("Reader-5"));

        executor.submit(() -> logExample.writeValue("Writer-2", 200));
        executor.submit(() -> logExample.readValue("Reader-6"));
        executor.shutdown();
    }
}
