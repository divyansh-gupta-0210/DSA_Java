package TreadPractise;

// Implementing thread with interface
class MyRunnable implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Thread " + Thread.currentThread().getId() + " is running : " + i);
            try{
                Thread.sleep(500);
            } catch (Exception ex){
                System.out.print("Thread is interrupted");
            }
        }
    }
}

class RunnableExample{
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}

// Implementing thread with a class
public class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Thread " + Thread.currentThread().getId() + " is running : " + i);
            try{
                Thread.sleep(500);
            } catch (Exception ex){
                System.out.print("Thread is interrupted");
            }
        }
    }
}

class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}
