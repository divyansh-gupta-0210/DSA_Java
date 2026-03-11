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
            Thread.sleep(1500);
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
