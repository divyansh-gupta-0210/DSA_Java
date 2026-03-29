package TreadPractise;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PractiseFizzBuzz {
    private int n;
    private Semaphore numberSemaphore;
    private Semaphore fizzSemaphore;
    private Semaphore buzzSemaphore;
    private Semaphore fizzbuzzSemaphore;

    public PractiseFizzBuzz(int n){
        this.n = n;
        numberSemaphore = new Semaphore(1);
        fizzSemaphore = new Semaphore(0);
        buzzSemaphore = new Semaphore(0);
        fizzbuzzSemaphore = new Semaphore(0);
    }

    public void fizz(Runnable printFizz) throws InterruptedException{
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 != 0){
                fizzSemaphore.acquire();
                printFizz.run();
                numberSemaphore.release();
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException{
        for(int i = 1; i <= n; i++){
            if(i % 3 != 0 && i % 5 == 0){
                buzzSemaphore.acquire();
                printBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    public void fizzBuzz(Runnable printFizzBuzz) throws InterruptedException{
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                fizzbuzzSemaphore.acquire();
                printFizzBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException{
        for(int i = 1; i <= n; i++){
            numberSemaphore.acquire();
            if(i % 3 == 0 && i % 5 == 0){
                fizzbuzzSemaphore.release();
            }
            else if(i % 3 != 0 && i % 5 == 0){
                buzzSemaphore.release();
            }
            else if(i % 3 == 0 && i % 5 != 0){
                fizzSemaphore.release();
            }
            else{
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        PractiseFizzBuzz obj = new PractiseFizzBuzz(15);
        Runnable printFizz = () -> System.out.print("Fizz ");
        Runnable printBuzz = () -> System.out.print("Buzz ");
        Runnable printFizzBuzz = () -> System.out.print("Fizzbuzz ");
        IntConsumer printNumber = x -> System.out.print(x + " ");

        Thread t1 = new Thread(() -> {
            try { obj.fizz(printFizz); } catch (InterruptedException e) {}
        });

        Thread t2 = new Thread(() -> {
            try { obj.buzz(printBuzz); } catch (InterruptedException e) {}
        });

        Thread t3 = new Thread(() -> {
            try { obj.fizzBuzz(printFizzBuzz); } catch (InterruptedException e) {}
        });

        Thread t4 = new Thread(() -> {
            try { obj.number(printNumber); } catch (InterruptedException e) {}
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
