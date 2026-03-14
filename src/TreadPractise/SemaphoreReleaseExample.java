package TreadPractise;

import java.util.concurrent.Semaphore;

public class SemaphoreReleaseExample {

    private final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        SemaphoreReleaseExample semaphoreReleaseExample = new SemaphoreReleaseExample();
        semaphoreReleaseExample.semaphore.release();
        System.out.println("Permit count aft er extra release: " + semaphoreReleaseExample.semaphore.availablePermits());
        for(int i = 1; i <= 3; i++){
            new Thread(semaphoreReleaseExample::accessResource, "SemaphoreThread-" + i).start();
        }
    }

    public void accessResource(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " released semaphore");
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released semaphore");
            semaphore.release();
        }
    }

}
