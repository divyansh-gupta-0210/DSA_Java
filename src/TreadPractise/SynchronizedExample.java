package TreadPractise;

public class SynchronizedExample {

    private int count = 0;
    private final Object lock = new Object();

    public synchronized void synchronizedMethodIncrement(){
        System.out.println("Synchronized Method = Start increment: " + Thread.currentThread().getName());
        count++;
        System.out.println("Synchronized Method = Counter value: " + count);
        System.out.println("Synchronized Method = End increment: " + Thread.currentThread().getName());
    }

    public void synchronizedBlockIncrement(){
        System.out.println("Non-Synchronized Method: " + Thread.currentThread().getName());
        synchronized (lock){
            System.out.println("Synchronized Block = Start increment: " + Thread.currentThread().getName());
            count++;
            System.out.println("Synchronized Block = Counter value: " + count);
            System.out.println("Synchronized Block = End increment: " + Thread.currentThread().getName());
        }
        System.out.println("Synchronized Method = End increment: " + Thread.currentThread().getName());
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        SynchronizedExample counter = new SynchronizedExample();
        int numberOfThreads = 5;
        Thread[] threads = new Thread[numberOfThreads];
        for(int i = 0; i < numberOfThreads; i++){
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    counter.synchronizedBlockIncrement();
                }
            }, "Thread - " + (i+1));
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

    }

}
