package TreadPractise;

import java.util.concurrent.Semaphore;

public class SemaphoreCountingSemaphore {
    private static final Semaphore resourcePool = new Semaphore(3);

    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++){
            final int threadNum = i;
            Thread t = new Thread(() -> accessThread("Thread-" + threadNum));
            t.start();
        }
    }

    private static void accessThread(String threadName){
        try{
            System.out.println(threadName + " is attempting to acquire lock");
            resourcePool.acquire();
            System.out.println(threadName + " acquired the lock");
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        finally {
            resourcePool.release();
            System.out.println(threadName + " released the lock");
        }
    }

}
