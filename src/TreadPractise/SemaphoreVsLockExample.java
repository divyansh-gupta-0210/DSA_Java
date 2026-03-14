package TreadPractise;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreVsLockExample {

    private final Semaphore semaphore = new Semaphore(3);
    private final Lock lock = new ReentrantLock();

    public void accessWithSemaphore(){
        try{
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " accessing resource with Semaphore");
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " releasing Semaphore permit");
            semaphore.release();
        }
    }

    private void accessWithLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " accessing resource with lock");
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " unlocking lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SemaphoreVsLockExample semaphoreVsLockExample = new SemaphoreVsLockExample();
        for(int i = 1; i <= 5; i++){
            Thread semaphoreThread = new Thread(semaphoreVsLockExample::accessWithSemaphore, "SemaphoreThread-" + i);
            Thread lockThread = new Thread(semaphoreVsLockExample::accessWithLock, "LockThread-" + i);
            semaphoreThread.start();
            lockThread.start();
        }
    }
}
