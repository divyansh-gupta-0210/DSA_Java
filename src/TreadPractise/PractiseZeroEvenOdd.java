package TreadPractise;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PractiseZeroEvenOdd {
    private int n;
    private final Semaphore zeroSemaphore;
    private final Semaphore evenSemaphore;
    private final Semaphore oddSemaphore;

    public PractiseZeroEvenOdd(int n){
        this.n = n;
        zeroSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
        oddSemaphore = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException{
        boolean isOdd = true;
        for(int i = 1; i <= n; i++){
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if(isOdd){
                oddSemaphore.release();
            }
            else{
                evenSemaphore.release();
            }
            isOdd = !isOdd;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException{
        for(int i = 2; i <= n; i+=2){
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException{
        for(int i = 1; i <= n; i+=2){
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public static void main(String[] args) {
        PractiseZeroEvenOdd obj = new PractiseZeroEvenOdd(5);

        IntConsumer printNumber = x -> System.out.print(x);

        Thread t1 = new Thread(() -> {
            try { obj.zero(printNumber); } catch (InterruptedException e) {}
        });

        Thread t2 = new Thread(() -> {
            try { obj.even(printNumber); } catch (InterruptedException e) {}
        });

        Thread t3 = new Thread(() -> {
            try { obj.odd(printNumber); } catch (InterruptedException e) {}
        });

        t1.start();
        t2.start();
        t3.start();
    }

}
