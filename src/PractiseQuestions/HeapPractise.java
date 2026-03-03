package PractiseQuestions;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.text.Collator;
import java.util.*;


class PairPQ{
//    String name;
//    int marks;
//    public PairPQ(String name, int marks){
//        this.name = name;
//        this.marks = marks;
//    }
    int dif;
    int num;
    public PairPQ(int dif, int num){
        this.dif = dif;
        this.num = num;
    }
}

class PairCoordinates{
    int dis;
    ArrayList<Integer> xy;
    public PairCoordinates(int dis, ArrayList<Integer> xy){
        this.dis = dis;
        this.xy = xy;
    }
}

public class HeapPractise {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,12,5,15,11};
//        minHeap(arr);
//        maxHeap(arr);
//        PairComparisonWithHeap();
//        kthSmallestElement(arr, 3);
//        kthLargestElement(arr, 3);
//        kLargestElements(arr, 3);
//        kSmallestElements(arr, 3);
//        sortKSortedArray(arr, 4);
//        kClosestArray(arr, 3, 7);
//        kFrequentElements(arr, 2);
//        frequencySort(arr);
//        int[][] arr_2d = new int[][]{{1,3}, {-2,2}, {5,8}, {0,1}};
//        closestPointToOrigin(arr_2d, 2);
//        connectRopesToMinimizeCost(arr);
        sumOfElementsBetweenK1andK2smallest(arr, 3, 6);
    }

    public static void sumOfElementsBetweenK1andK2smallest(int[] arr, int k1, int k2){
        int f = kthSmallest(arr, k1);
        int s = kthSmallest(arr, k2);
        int sum = 0;
        for(int i : arr){
            if(i > f && i < s){
                sum += i;
            }
        }
        print(sum);
    }

    public static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            priorityQueue.add(i);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

    public static void connectRopesToMinimizeCost(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // min heap
        for(int i : arr){
            priorityQueue.add(i);
        }
        int total_cost = 0;

        while (priorityQueue.size() > 1){

            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            int sum = first + second;
            total_cost = total_cost + sum;
            priorityQueue.add(sum);
        }
        print(total_cost);
    }

    public static void closestPointToOrigin(int[][] arr, int k){
        PriorityQueue<PairCoordinates> priorityQueue = new PriorityQueue<>((a, b) -> b.dis - a.dis);
        for(int[] i : arr){
            int distance = i[0] * i[0] + i[1] * i[1];
            ArrayList<Integer> pairs = new ArrayList<>();
            pairs.add(i[0]); pairs.add(i[1]);
            priorityQueue.add(new PairCoordinates(distance, pairs));
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()){
            print(priorityQueue.poll().xy);
        }
    }

    public static void frequencySort(int[] arr){
        PriorityQueue<PairPQ> priorityQueue = new PriorityQueue<>((a, b) -> b.dif - a.dif); // max heap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.add(new PairPQ(entry.getValue(), entry.getKey()));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            PairPQ pq = priorityQueue.poll();
            int freq = pq.dif;
            int num = pq.num;
            while (freq != 0){
                ans.add(num);
                freq--;
            }
        }
        print(ans);
    }

    public static void kFrequentElements(int[] arr, int k){
        PriorityQueue<PairPQ> priorityQueue = new PriorityQueue<>((a, b) -> a.dif - b.dif);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.add(new PairPQ(entry.getValue(), entry.getKey()));
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        while(!priorityQueue.isEmpty()){
            print(priorityQueue.poll().num);
        }
    }

    public static void kClosestArray(int[] arr, int k, int x){
        PriorityQueue<PairPQ> priorityQueue = new PriorityQueue<>((a, b) -> b.dif - a.dif);
        for(int i : arr){
            priorityQueue.add(new PairPQ(Math.abs(i-x), i));
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()){
            print(priorityQueue.poll().num);
        }
    }

    public static void sortKSortedArray(int[] arr, int k){
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while(i < arr.length){
            priorityQueue.add(arr[i]);
            i++;
            if(priorityQueue.size() > k){
                ans.add(priorityQueue.poll());
            }
        }
        while(!priorityQueue.isEmpty()){
            ans.add(priorityQueue.poll());
        }
        print(ans);
    }

    public static void kSmallestElements(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : arr){
            priorityQueue.add(i);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()){
            print(priorityQueue.poll());
        }
    }

    public static void kLargestElements(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : arr){
            priorityQueue.add(i);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()){
            print(priorityQueue.poll());
        }
    }

    public static void kthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : arr){
            priorityQueue.add(i);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        print(priorityQueue.peek());
    }

    public static void kthSmallestElement(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : arr){
            priorityQueue.add(i);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        print(priorityQueue.peek());
    }

    public static void PairComparisonWithHeap(){
//        PriorityQueue<PairPQ> priorityQueue = new PriorityQueue<>((a, b) -> a.marks - b.marks);
//        priorityQueue.add(new PairPQ("Divyansh_1", 90));
//        priorityQueue.add(new PairPQ("Divyansh_3", 70));
//        priorityQueue.add(new PairPQ("Divyansh_5", 60));
//        while (!priorityQueue.isEmpty()){
//            print(priorityQueue.poll().name);
//        }
    }

    public static void minHeap(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : arr){
            priorityQueue.add(i);
        }
        System.out.println("MAX HEAP");
        while (!priorityQueue.isEmpty()){
            print(priorityQueue.poll());
        }
    }

    public static void maxHeap(int[] arr){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : arr){
            priorityQueue.add(i);
        }
        System.out.println("MIN HEAP");
        while (!priorityQueue.isEmpty()){
            print(priorityQueue.poll());
        }
    }

    public static void print(Object obj){
        System.out.print(obj + " ");
    }

}
