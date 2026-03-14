package TreadPractise;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {

    public static void main(String[] args) throws InterruptedException {

        final Map<Integer, String> hashMap = Collections.synchronizedMap(new HashMap<>());
        final ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        Thread hashMapUpdater = new Thread(() -> {
           for(int i = 0; i <= 5; i++){
               hashMap.put(i, "Value " + i);
           }
           try{
               Thread.sleep(50);
           }
           catch (InterruptedException e){
               Thread.currentThread().interrupt();
           }
        });

        Thread hashMapIterator = new Thread(() ->{
            try{
                Thread.sleep(25);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            synchronized (hashMap){
                for(Map.Entry<Integer, String> entry : hashMap.entrySet()){
                    System.out.println("HashMap iteration - key : " + entry.getKey() + ", VALUE : " + entry.getKey());
                }
            }
        });
        hashMapUpdater.start();
        hashMapIterator.start();
        hashMapUpdater.join();
        hashMapIterator.join();
        System.out.println("Final hashmap: " + hashMap);

        Thread concurrentHashMapUpdater = new Thread(() -> {
            for(int i = 0; i <= 5; i++){
                concurrentMap.put(i, "Value " + i);
            }
            try{
                Thread.sleep(50);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        Thread concurrentMapIterator = new Thread(() -> {
           try{
               Thread.sleep(25);
           }
           catch (InterruptedException ex){
               Thread.currentThread().interrupt();
           }
           for(Map.Entry<Integer, String> entry : concurrentMap.entrySet()){
               System.out.println("Concurrent Iteration - Key: " + entry.getKey() + ", VALUE: " + entry.getValue());
           }
        });
        concurrentHashMapUpdater.start();
        concurrentMapIterator.start();
        concurrentHashMapUpdater.join();
        concurrentMapIterator.join();
        System.out.println("Final hashmap: " + concurrentMap);
    }
}
