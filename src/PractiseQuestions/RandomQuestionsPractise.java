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

//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(2); arr.add(4);arr.add(8);arr.add(2);
//        print(evenproduct(arr));

//        int m = 5, n = 3;
//        System.out.println("Total squares in " + m + "x" + n + ": " + countSquares(m, n));
        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(2);arr.add(-3);
//        arr.add(4);arr.add(6);arr.add(1);
//        print(gainMaxValue(arr, 2));
       arr.add(4);arr.add(-8);arr.add(2);arr.add(-10);arr.add(3);arr.add(-20);
        print(getMaximumGrossValue(arr));

    }

    public static long getMaximumGrossValue(List<Integer> arr) {
        int n = arr.size();

        // Prefix sum
        long[] P = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            P[i] = P[i - 1] + arr.get(i - 1);
        }

        long ans = Long.MIN_VALUE;

        for (int i2 = 1; i2 <= n; i2++) {

            // best i1 ≤ i2
            long bestLeft = Long.MIN_VALUE;
            for (int i1 = 1; i1 <= i2; i1++) {
                bestLeft = Math.max(bestLeft, P[i1 - 1]);
            }

            // try all i3 ≥ i2
            for (int i3 = i2; i3 <= n + 1; i3++) {
                long right = (i3 == n + 1) ? P[n] : P[i3 - 1];

                long value = bestLeft - P[i2 - 1] + right;
                ans = Math.max(ans, value);
            }
        }

        return 2 * ans - P[n];
    }

    public static int getResponseTimeSum(List<Integer> responseTime) {
        int n = responseTime.size();
        long mod = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && responseTime.get(stack.peek()) <= responseTime.get(i)) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && responseTime.get(stack.peek()) < responseTime.get(i)) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            long L = left[i];
            long R = right[i];
            long val = responseTime.get(i);

            long sumL = L * (L + 1) / 2 % mod;
            long sumR = R * (R + 1) / 2 % mod;

            long contribution = (R * sumL % mod + L * sumR % mod - L * R % mod + mod) % mod;

            result = (result + val * contribution % mod) % mod;
        }

        return (int) result;
    }

    public static int maxRequestInWindow(List<Integer> timestamp, int windowSize) {
        Collections.sort(timestamp);

        int left = 0;
        int maxCount = 0;

        // Step 2: Sliding window
        for (int right = 0; right < timestamp.size(); right++) {

            // Maintain strict window size
            while (timestamp.get(right) - timestamp.get(left) >= windowSize) {
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }

    public static int gainMaxValue(List<Integer> game_val, int k) {
        int n = game_val.size();
        long[] dp = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = game_val.get(i);
            if (i + k < n) {
                dp[i] += dp[i + k];
            }
            max = Math.max(max, dp[i]);
        }
        return (int) max;
    }

    public static long countSquares(int m, int n) {
        long totalSquares = 0;

        // Squares can only be as large as the shorter side
        int minSide = Math.min(m, n);

        for (int k = 1; k <= minSide; k++) {
            totalSquares += (long) (m - k + 1) * (n - k + 1);
        }

        return totalSquares;
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
