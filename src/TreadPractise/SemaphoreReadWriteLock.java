package TreadPractise;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class SemaphoreReadWriteLock {
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore wrt = new Semaphore(1);
    int readCount = 0;

    public void lockRead() throws InterruptedException{
        mutex.acquire();
        readCount++;
        if(readCount == 1){
            wrt.acquire();
        }
        mutex.release();
    }

    public void unlockRead() throws InterruptedException{
        mutex.acquire();
        readCount--;
        if(readCount == 0){
            wrt.release();
        }
        mutex.release();
    }

    public void lockWrite() throws InterruptedException{
        wrt.acquire();
    }

    public void unlockWrite(){
        wrt.release();
    }

    public static void main(String[] args) {
        SemaphoreReadWriteLock rwLock = new SemaphoreReadWriteLock();
        Runnable readerTask = () -> {
          try{
              rwLock.lockRead();
              System.out.println(Thread.currentThread().getName() + " is reading. ");
              Thread.sleep(500);
              System.out.println(Thread.currentThread().getName() + " finished reading");
              rwLock.unlockRead();
          }
          catch (InterruptedException ex){
              Thread.currentThread().interrupt();
          }
        };

        Runnable writerTask = () -> {
            try{
                rwLock.lockWrite();
                System.out.println(Thread.currentThread().getName() + " is writing. ");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " finished writing");
                rwLock.unlockWrite();
            }
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        };

        Thread reader1 = new Thread(readerTask, "Reader-1");
        Thread reader2 = new Thread(readerTask, "Reader-2");
        Thread writer1 = new Thread(writerTask, "Writer-1");
        reader1.start();
        reader2.start();
        writer1.start();
    }
}
