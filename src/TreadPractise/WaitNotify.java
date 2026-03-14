package TreadPractise;

public class WaitNotify {
    private final Object lock = new Object();
    private boolean conditionMet = false;

    public void doWait(){
        synchronized (lock){
            while(!conditionMet){
                try{
                    System.out.println(Thread.currentThread().getName() + " is waiting.");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " was interrupted.");
                }
            }
            System.out.println(Thread.currentThread().getName() + " resumed execution.");
        }
    }
    public void doNotify(){
        synchronized (lock){
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " called notify.");
            lock.notify();
        }
    }

     public void doNotifyAll(){
        synchronized (lock){
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " called notifyAll.");
            lock.notifyAll();
        }
     }

    public static void main(String[] args) {
        System.out.println("Demonstrating notifyAll(): ");
        WaitNotify waitNotifyAll = new WaitNotify();
        Thread waiter1 = new Thread(waitNotifyAll::doWait, "Waiter-1");
        Thread waiter2 = new Thread(() -> waitNotifyAll.doWait(), "Waiter-2");
        Thread waiter3 = new Thread(() -> waitNotifyAll.doWait(), "Waiter-3");
        waiter1.start();
        waiter2.start();
        waiter3.start();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        Thread notifyAll = new Thread(waitNotifyAll::doNotifyAll, "Notifier-All");
        notifyAll.start();

        try{
            waiter1.join(); waiter2.join(); waiter3.join(); notifyAll.join();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        // ------------------------------------------ //
        System.out.println("\nDemonstrating notify(): ");
        WaitNotify waitNotify = new WaitNotify();
        Thread waiterN1 = new Thread(() -> waitNotify.doWait(), "Waiter-N1");
        Thread waiterN2 = new Thread(() -> waitNotify.doWait(), "Waiter-N2");
        Thread waiterN3 = new Thread(() -> waitNotify.doWait(), "Waiter-N3");
        waiterN1.start();
        waiterN2.start();
        waiterN3.start();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        Thread notifier = new Thread(() -> waitNotify.doNotify(), "Notifier");
        notifier.start();

        try{
            Thread.sleep(2000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        System.out.println("Calling notifyAll() to wake up the remaining thread.");
        Thread notifier2 = new Thread(() -> waitNotify.doNotifyAll(), "Notifier2");
        notifier2.start();

        try{
            waiterN1.join();
            waiterN2.join();
            waiterN3.join();
            notifier.join();
            notifier2.join();
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("Main thread: execution finished");
    }

}
