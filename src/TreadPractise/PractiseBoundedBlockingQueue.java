package TreadPractise;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class PractiseBoundedBlockingQueue {
    private Semaphore full;
    private Semaphore empty;
    private ConcurrentLinkedDeque<Integer> deque;

    public PractiseBoundedBlockingQueue(int capacity){
        full = new Semaphore(0);
        empty = new Semaphore(capacity);
        deque = new ConcurrentLinkedDeque<>();
    }

    public void enqueue(int element) throws InterruptedException{
        empty.acquire();
        deque.addFirst(element);
        full.release();
    }

    public int dequeue() throws InterruptedException{
        int result = -1;
        full.acquire();
        result = deque.pollLast();
        empty.release();
        return result;
    }

    public int size() throws InterruptedException{
        int result = 0;
        result = deque.size();
        return result;
    }

    public static void main(String[] args) {
        PractiseBoundedBlockingQueue queue = new PractiseBoundedBlockingQueue(3);

        // Producer thread
        Runnable producer = () -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("Producing: " + i);
                    queue.enqueue(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Consumer thread
        Runnable consumer = () -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    int value = queue.dequeue();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create threads
        Thread producerThread1 = new Thread(producer);
        Thread producerThread2 = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);

        // Start threads
        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();

        // Wait for threads to finish
        try {
            producerThread1.join();
            producerThread2.join();
            consumerThread1.join();
            consumerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final queue size: " + queue.deque.size());
    }

}
