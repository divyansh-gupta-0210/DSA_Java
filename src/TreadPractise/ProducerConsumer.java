package TreadPractise;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (this){
                while (buffer.size() == capacity){
                    System.out.println("Buffer is full, producer is waiting . . .");
                    wait();
                }
                System.out.println("Producer produced: " + value);
                buffer.offer(value++);
                notifyAll();
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException{
        while (true){
            synchronized (this){
                while (buffer.isEmpty()){
                    System.out.println("Buffer is empty, consumer is waiting . . .");
                    wait();
                }
                int value = buffer.poll();
                System.out.println("Consumer consumed: " + value);
                notifyAll();
            }
            Thread.sleep(1300);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    producerConsumer.produce();
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    System.err.println("Producer Thread Interrupted");
                }
            }
        }, "Producer Thread");

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    producerConsumer.consume();
                }catch (InterruptedException ex){
                    Thread.currentThread().interrupt();
                    System.err.println("Consumer Thread Interrupted");
                }
            }
        }, "Consumer Thread");

        producerThread.start();
        consumerThread.start();

    }

}



/*
* This code implements the classic Producer–Consumer problem using Java threads,
* a shared queue (buffer), and synchronization. The producer thread continuously generates integers
* and adds them to a queue, while the consumer thread removes them. Both methods use synchronized (this)
* to ensure only one thread accesses the buffer at a time (mutual exclusion).
* If the buffer is full, the producer calls wait()—this releases the lock and
* pauses the producer until notified; similarly, if the buffer is empty, the consumer waits.
*  After producing or consuming, notifyAll() is called to wake up all waiting threads so they can
* re-check conditions and proceed if possible. The while loops around wait() ensure the condition is
* rechecked (avoiding issues like spurious wakeups). Thread.sleep() simply slows execution for demonstration.
* In short: producer adds → notifies → consumer wakes and removes → notifies → repeat, maintaining safe
* communication between threads without conflicts.
*/
