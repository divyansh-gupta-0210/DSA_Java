package TreadPractise;

public class SleepAndWait {
    public static void main(String[] args) {
        sleepExample();
        waitExample();
    }

    public static void waitExample(){
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(() -> sharedResource.waitExample(), "Thread-1");
        Thread t2 = new Thread(() -> sharedResource.waitExample(), "Thread-2");

        Thread notifier = new Thread(() -> {
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
            sharedResource.notifyOne();
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
            sharedResource.notifyOne();
        }, "Notifier");
        t1.start();
        t2.start();
        notifier.start();
    }

    public static void sleepExample(){
        SharedResourceSleep sharedResourceSleep = new SharedResourceSleep();
        Thread sleeper1 = new Thread(() -> sharedResourceSleep.sleepExample(), "Thread-1");
        Thread sleeper2 = new Thread(() -> sharedResourceSleep.sleepExample(), "Thread-2");
        sleeper1.start();
        sleeper2.start();
    }
}

class SharedResourceSleep{
    synchronized void sleepExample(){
        System.out.println(Thread.currentThread().getName() + " Entering sleep example. . .");
        try{
            System.out.println(Thread.currentThread().getName() + " Going to sleep. . .");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " woke up after sleep. . .");
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}

class SharedResource{
    synchronized void waitExample(){
        System.out.println(Thread.currentThread().getName() + " Entering wait");
        try{
            System.out.println(Thread.currentThread().getName() + " calling wait");
            wait();
            System.out.println(Thread.currentThread().getName() + " resumed after waiting");
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    synchronized void notifyOne(){
        System.out.println("Notifying a waiting thread. . .");
        notify();
    }
}
