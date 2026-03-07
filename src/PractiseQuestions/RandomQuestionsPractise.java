package PractiseQuestions;

import java.util.*;

import static PractiseQuestions.ArraysPractise.*;

public class RandomQuestionsPractise {

    static int operations = 0;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
//        int[] arr = {-11,-21,2,3,-1,-2};
//        moveNegativesAtEnd(arr);
//        maxSubArrary(arr);
//        ArrayList<Integer> initial = new ArrayList<>();
//        ArrayList<Integer> expected = new ArrayList<>();
//        ArrayList<Integer> treeFrom = new ArrayList<>();
//        ArrayList<Integer> treeTo = new ArrayList<>();
//
//        initial.add(1);initial.add(1);initial.add(0);initial.add(1);
//        expected.add(0);expected.add(1);expected.add(1);expected.add(0);
//        treeFrom.add(0);treeFrom.add(0);treeFrom.add(1);
//        treeTo.add(1);treeTo.add(2);treeTo.add(3);
//
//        print(getMinimumOperations(4, treeFrom, treeTo, initial, expected));

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2); arr.add(4);arr.add(8);arr.add(2);
        print(evenproduct(arr));
    }

    public static int evenproduct(List<Integer> nums) {
        long mod = 1000000007L;
        int n = nums.size();

        long oddCount = 0;

        // count odd numbers
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        long totalTriplets = combination(n);
        long oddTriplets = combination(oddCount);

        long result = (totalTriplets - oddTriplets) % mod;
        if (result < 0) result += mod;

        return (int) result;
    }

    private static long combination(long x) {
        if (x < 3) return 0;
        return (x * (x - 1) * (x - 2)) / 6;
    }

    public static int getMinimumOperations(int treeNodes,
                                           List<Integer> treeFrom,
                                           List<Integer> treeTo,
                                           List<Integer> initial,
                                           List<Integer> expected) {

        // Build adjacency list
        graph = new ArrayList<>();
        for (int i = 0; i < treeNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < treeFrom.size(); i++) {
            int u = treeFrom.get(i);
            int v = treeTo.get(i);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        operations = 0;

        // Start DFS from root (0)
        dfs(0, -1, 0, 0, initial, expected);

        return operations;
    }
    private static void dfs(int node,
                            int parent,
                            int evenFlip,
                            int oddFlip,
                            List<Integer> initial,
                            List<Integer> expected) {

        int current = initial.get(node);

        // Apply flips caused by ancestors
        if (node % 2 == 0) {
            if (evenFlip % 2 == 1) {
                current ^= 1;
            }
        } else {
            if (oddFlip % 2 == 1) {
                current ^= 1;
            }
        }

        int newEvenFlip = evenFlip;
        int newOddFlip = oddFlip;

        if (current != expected.get(node)) {
            operations++;

            if (node % 2 == 0) {
                newEvenFlip++;
            } else {
                newOddFlip++;
            }
        }

        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node, newEvenFlip, newOddFlip, initial, expected);
            }
        }
    }

    public static void maxSubArrary(int[] arr){
        int sum = 0, maxi = Integer.MIN_VALUE, start = 0, ansEnd = 0, ansStart = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum == 0){
                start = i;
            }
            sum += arr[i];
            if(sum > maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum<0){
                sum = 0;
            }
        }
        for(int i = ansStart; i <= ansEnd; i++){
            print(arr[i]);
        }
    }

    public static void moveNegativesAtEnd(int[] arr){

        int j = -1;
        printArr(arr);
        for(int i= 0;i< arr.length; i++){
            if(arr[i] < 0){
                j=i;
                break;
            }
        }

        for(int i = j; i < arr.length; i++){
            if(arr[i] > 0){
                swap(arr, i, j);
                j++;
            }
        }
        printArr(arr);
    }

}
