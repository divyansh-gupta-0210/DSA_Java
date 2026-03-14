package TreadPractise;

import java.util.concurrent.Semaphore;

public class SemaphoreBinarySemaphore {
    private static final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> accessCriticalSection("Thread-1"));
        Thread t2 = new Thread(() -> accessCriticalSection("Thread-2"));
        t1.start();
        t2.start();
    }

    private static void accessCriticalSection(String threadName){
        try{
            System.out.println(threadName + " is attempting to acquire lock");
            mutex.acquire();
            System.out.println(threadName + " acquired the lock");
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        finally {
            mutex.release();
            System.out.println(threadName + " released the lock");
        }
    }

}
