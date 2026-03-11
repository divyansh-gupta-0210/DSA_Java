package TreadPractise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockReentrantTryLock {
    private final ReentrantLock lock = new ReentrantLock();

    public void longTask(String taskName){
        lock.lock();
        try{
            System.out.println(taskName + " acquired the lock and is performing a long task.");
            Thread.sleep(5000);
            System.out.println(taskName + " finished the task and is releasing the lock.");
        }
        catch (InterruptedException ex){
            System.out.println(taskName + " was interrupted.");
            Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();
        }
    }
    public void tryLockTask(String taskName){
        try{
            if(lock.tryLock(8, TimeUnit.SECONDS)){
                try {
                    System.out.println(taskName + " acquired the lock using tryLock and is performing its task.");
                }finally {
                    lock.unlock();
                }
            }
            else{
                System.out.println(taskName + " could not acquire the lock using tryLock with 2 seconds");
            }
        }
        catch (InterruptedException ex){
            System.out.println(taskName + " was interrupted while waiting for the lock.");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        LockReentrantTryLock lockReentrantTryLock = new LockReentrantTryLock();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> lockReentrantTryLock.longTask("Task-A"));
        try{
            Thread.sleep(100);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        executorService.submit(() -> lockReentrantTryLock.tryLockTask("Task-B"));
        executorService.shutdown();
    }

}
