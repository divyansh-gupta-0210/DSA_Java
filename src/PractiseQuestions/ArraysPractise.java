package PractiseQuestions;

import java.util.*;

public class ArraysPractise {
    public static void main(String[] args) {

//        int[][] arr = new int[][]{{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
//        int[] arr1 = new int[]{1,1,2,3,4,5};
//        int[] arr2 = new int[]{2,3,4,4,5, 6};
//        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int[] arr = new int[]{3,1,2,4};

//        print(findLargest(arr));
//        print(secondLargest(arr));
//        removeDuplicates(arr);
//        leftRotate(arr, 3);
//        moveZerosToEnd(arr);
//        unionOf2SortedArray(arr1, arr2);
//        intersectionOf2SortedArray(arr1, arr2);
//        missingNumber(arr, 5);
//        maxConsecutiveOnes(arr);
//        numberAppearsTwice(arr);
//        longestSubarraySum(arr, 3);
//        twoSum(arr, 14);
//        sort012(arr);
//        majorityElement(arr);
//        maxSubarray(arr);
//        rearrangeTheArrayWithSigns(arr);
//        bestTimeToBuyAndSellStock(arr);
//        nextPermutation(arr);
//        leadersInAnArray(arr);
//        longestConsecutiveSequence(arr);
//        setMatrixZeros(arr, 4,4);
//        rotateMatrix(arr, 4, 4);
//        spiralMatrix(arr);
//        numberOfSubarraysWithSumK(arr, 6);
//        pascalsTriangleRC(5, 3); //Given R and C print the number present there
//        pascalsTriangleAnyRow(3); //Print any row
//        printPascalsTriangle(5);
    }

    public static void printPascalsTriangle(int n){

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            ans.add(generateRow(i));
        }
        print(ans);
//        Brute
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col <= row; col++) {
//                pascalsTriangleRC(row, col);
//            }
//            System.out.println();
//        }
    }

    public static ArrayList<Integer> generateRow(int row){
        int ans = 1;
        ArrayList<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col = 1; col < row; col++){
            ans = ans * (row - col);
            ans = ans / (col);
            ansRow.add(ans);
        }
        return ansRow;
    }

    public static void pascalsTriangleAnyRow(int row){

        int ans = 1;
        print(ans);
        for(int i = 1; i < row; i++){
            ans = ans * (row - i);
            ans = ans / i;
            print(ans);
        }

//        Brute
//        for (int c = 0; c <= row; c++) {
//            pascalsTriangleRC(row, c);
//        }
    }

    public static void pascalsTriangleRC(int n, int r){

//        Optimal
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        print(res);
//        Brute -> r-1 C c-1
    }

    public static void numberOfSubarraysWithSumK(int[] arr, int k){
//        Optimal
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        int cnt = 0;
        for (int j : arr) {
            preSum = preSum + j;
            int rem = preSum - k;
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        print(cnt);
    }

    public static void spiralMatrix(int[][] arr){
        printMatrix(arr, 4, 4);
        int n = arr.length;
        int m = arr[0].length;
        int left = 0, right = m-1;
        int top = 0, bottom = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while(top<=bottom && left<=right){
            for(int i = left; i <= right; i++){
                ans.add(arr[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; i++){
                ans.add(arr[i][right]);
            }
            right--;

            if(top<=bottom){
                for(int i = right; i >= left; i--){
                    ans.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    ans.add(arr[i][left]);
                }
                left++;
            }
        }
        print(ans);
    }

    public static void rotateMatrix(int[][] arr, int m, int n){

        printMatrix(arr, m, n);

//        Optimal
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j<n; j++){
                if(i != j){
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            reverse(arr[i], 0, arr[0].length-1);
        }
        printMatrix(arr, m, n);

//        Brute
//        printMatrix(arr, m, n);
//        int[][] temp = new int[m][n];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j<n; j++){
//                temp[j][n-1-i] = arr[i][j];
//            }
//        }
//        printMatrix(temp, m, n);
    }

    public static void setMatrixZeros(int[][] arr, int m, int n){

        int[] col = new int[n];
        int[] row = new int[m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] == 1|| col[j] == 1){
                    arr[i][j] = 0;
                }
            }
        }

        printMatrix(arr, m, n);

//      Brute
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(arr[i][j] == 0){
//                    markRow(arr, i, n);
//                    markCol(arr, j, m);
//                }
//            }
//        }
//
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(arr[i][j] == -1){
//                    arr[i][j] = 0;
//                }
//            }
//        }
//
    }

    public static void printMatrix(int[][] arr, int m, int n){
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void markRow(int[][] arr, int i, int n){
        for(int j = 0; j < n; j++){
            if(arr[i][j] != 0){
                arr[i][j] = -1;
            }
        }
    }

    public static void markCol(int[][] arr, int j, int m){
        for(int i = 0; i < m; i++){
            if(arr[i][j] != 0){
                arr[i][j] = -1;
            }
        }
    }

    public static void longestConsecutiveSequence(int[] arr){

//        Optimal
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr) {
            set.add(num);
        }
        int longest = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int current = num;
                int c = 1;
                while(set.contains(current+1)){
                    current++;
                    c++;
                }
                longest = Math.max(longest, c);
            }
        }
        print(longest);

//        Better
//        Arrays.sort(arr);
//        int longest = 1, cnt_cur = 0, last_smallest = Integer.MIN_VALUE;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i]-1 == last_smallest){
//                cnt_cur++;
//                last_smallest = arr[i];
//            }
//            else if(arr[i] != last_smallest){
//                last_smallest = arr[i];
//                cnt_cur=1;
//            }
//            longest = Math.max(longest, cnt_cur);
//        }
//        print(longest);

//        Brute
//        int longest = 0;
//        for(int i = 0; i < arr.length; i++){
//            int current = arr[i];
//            int c = 1;
//            while(linearSearch(arr, current + 1)){
//                current++;
//                c++;
//            }
//            longest = Math.max(c, longest);
//        }
//        print(longest);
    }

    public static boolean linearSearch(int[] arr, int toFind){
        for(int i : arr){
            if(i == toFind){
                return true;
            }
        }
        return false;
    }

    public static void leadersInAnArray(int[] arr){
//        Everything in the right should be smaller

//        Optimal
        ArrayList<Integer> ans = new ArrayList<>();
        int maxOnRight = Integer.MIN_VALUE;
        for(int i = arr.length-1; i>=0; i--){
            if(maxOnRight<arr[i]){
                maxOnRight = arr[i];
                ans.add(arr[i]);
            }
        }
        print(ans);

//        Brute
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        for(int i = 0; i < arr.length; i++){
//            boolean isLeader = true;
//            for(int j = i+1; j < arr.length; j++){
//                if(arr[i] < arr[j]){
//                    isLeader = false;
//                    break;
//                }
//            }
//            if(isLeader){
//                ans.add(arr[i]);
//            }
//        }
//        print(ans);
    }

    public static void nextPermutation(int[] arr){

//        Optimal
        int index = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
        if(index==-1){
            reverse(arr, 0, arr.length-1);
            printArr(arr);
        }
        else{
            for(int i = arr.length - 1; i >= index; i--){
                if(arr[i] > arr[index]){
                    swap(arr, i, index);
                    break;
                }
            }
            reverse(arr, index+1, arr.length-1);
            printArr(arr);
        }

//        Brute
//        Recursion to generate all permutations ->
//        Linear Search to search the one given in the question ->
//        return nextIndex
    }

    public static void bestTimeToBuyAndSellStock(int[] arr){
        int mini = arr[0];
        int profit = 0;
        for(int i = 1; i < arr.length; i++){
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, arr[i]);
        }
        print(profit);
    }

    public static void rearrangeTheArrayWithSigns(int[] arr){

//        Unequal number of positives and negatives
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int j : arr) {
            if (j < 0) {
                neg.add(j);
            } else {
                pos.add(j);
            }
        }

        if(pos.size() > neg.size()){
            for(int i = 0; i < neg.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int j = neg.size() ; j < pos.size(); j++){
                arr[index] = pos.get(j);
                index++;
            }
        }
        else{
            for(int i = 0; i < pos.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i+1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int j = pos.size() ; j < neg.size(); j++){
                arr[index] = neg.get(j);
                index++;
            }
        }

        printArr(arr);

//      Optimal
//        int[] ans = new int[arr.length];
//        int posIndex = 0;
//        int negIndex = 1;
//        for (int j : arr) {
//            if (j < 0) {
//                ans[negIndex] = j;
//                negIndex += 2;
//            } else {
//                ans[posIndex] = j;
//                posIndex += 2;
//            }
//        }
//        printArr(ans);

//        Brute
//        int[] neg = new int[arr.length/2];
//        int[] pos = new int[arr.length/2];
//        int po = 0, ne = 0;
//        for (int j : arr) {
//            if (j < 0) {
//                neg[ne++] = j;
//            } else {
//                pos[po++] = j;
//            }
//        }
//
//        for(int i = 0; i < arr.length/2; i++){
//            arr[2*i] = pos[i];
//            arr[2*i+1] = neg[i];
//        }
//        printArr(arr);
    }

    public static void maxSubarray(int[] arr){

//        Optimal (Kadan's Algo) -> To find the maximum sum and the subarray
        int sum = 0, maxi = Integer.MIN_VALUE, start = 0, ansStart = -1, ansEnd = -1;
        for(int i = 0; i < arr.length; i++){
            if(sum == 0){
                start = i;
            }
            sum = sum + arr[i];
            if(sum>maxi){
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum<0){
                sum = 0;
            }
        }
//        print(sum);
        for(int i = ansStart; i <= ansEnd; i++){
            print(arr[i]);
        }

//        Better
//        int maxi = Integer.MIN_VALUE;
//        for(int i = 0; i < arr.length; i++){
//            int sum = 0;
//            for(int j = i; j < arr.length; j++){
//                sum+=arr[j];
//                maxi = Math.max(sum, maxi);
//            }
//        }
//        print(maxi);

//        Brute
//        int maxi = Integer.MIN_VALUE;
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i; j < arr.length; j++){
//                int sum = 0;
//                for(int k = i; k <= j; k++){
//                    sum+=arr[k];
//                }
//                maxi = Math.max(sum, maxi);
//            }
//        }
//        print(maxi);
    }

    public static void majorityElement(int[] arr){

//        Optimal (Moore's voting algorithm)
        int cnt = 0;
        int el = 0;
        for(int i = 0; i < arr.length; i++){
            if(cnt==0){
                el = arr[i];
            }
            if(el == arr[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == el){
                cnt1++;
            }
        }
        if(cnt1>arr.length/2){
            print(el);
        }

//        Better
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int j : arr) {
//            map.put(j, map.getOrDefault(j, 0) + 1);
//        }
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() > arr.length / 2){
//                print(entry.getKey());
//            }
//        }

//        Brute
//         for(int i = 0; i < arr.length; i++){
//            int c = 0;
//            for(int j = 0; j < arr.length; j++){
//                if(arr[j] == arr[i]){
//                    c++;
//                }
//            }
//            if(c>arr.length/2){
//                print(arr[i]);
//            }
//        }
    }

    public static void sort012(int[] arr){

//        Optimal (DUTCH NATIONAL FLAG ALGO.)
        int low = 0, mid = 0, high = arr.length-1;
        while(mid<=high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                mid++;
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
        printArr(arr);

//        Better
//        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] == 0){
//                cnt0++;
//            }
//            else if (arr[i] == 1) {
//                cnt1++;
//            }
//            else{
//                cnt2++;
//            }
//        }
//        for(int i = 0; i < cnt0; i++){
//            arr[i] = 0;
//        }
//        for(int i = cnt0; i < cnt0+cnt1; i++){
//            arr[i] = 1;
//        }
//        for(int i = cnt0+cnt1; i < arr.length; i++){
//            arr[i] = 2;
//        }
//        printArr(arr);
    }

    public static void twoSum(int[] arr, int sum){

//        Optimal
        int i = 0, j = arr.length-1;
        while(i<j){
            int s = arr[i] + arr[j];
            if(s == sum){
                print(arr[i] + " " + arr[j]);
                break;
            }
            else if(s < sum){
                i++;
            }
            else{
                j--;
            }
        }

//        Better
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < arr.length; i++){
//             int rem = sum - arr[i];
//             if(map.containsKey(rem)){
//                 print(rem + " " + arr[i]);
//             }
//             else{
//                 map.put(arr[i], i);
//             }
//         }

//        Brute
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i; j < arr.length; j++){
//                if(arr[i]+ arr[j] == sum){
//                    print(arr[i] + " " + arr[j]);
//                }
//            }
//        }
    }

    public static void longestSubarraySum(int[] arr, int s){

//        Optimal for numbers which are positive and zeros
        int i = 0, j = 0;
        int sum = 0;
        int max = 0;
        while(j<arr.length){
            while(i<=j && sum > s){
                sum-=arr[i];
                i++;
            }
            if(sum==s){
                max = Math.max(max, j-i+1);
            }
            j++;
            if(j<arr.length){
                sum+=arr[j];
            }
        }
        print(max);

//        Better if numbers are both positive and negative
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        int preSum = 0;
//        int maxLen = 0;
//        for(int i = 0; i < arr.length; i++){
//            preSum+=arr[i];
//            if(preSum==s){
//                maxLen = Math.max(maxLen, i+1);
//            }
//            int rem = preSum-s;
//            if (map.containsKey(rem)) {
//                int len = i - map.get(rem);
//                maxLen = Math.max(maxLen, len);
//            }
//            if (!map.containsKey(preSum)) {
//                map.put(preSum, i);
//            }
//        }
//        print(maxLen);

//        Brute (1)
//        int max = 0;
//        for(int i = 0; i < arr.length; i++){
//            int sum = 0;
//            for(int j = i; j < arr.length; j++){
//                sum+=arr[j];
//                if(s==sum){
//                    max = Math.max(max, j-i+1);
//                }
//            }
//        }
//        print(max);

//        Brute (2)
//        int max = 0;
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i; j < arr.length; j++){
//                int sum = 0;
//                for(int k = i; k <= j; k++){
//                    sum+=arr[k];
//                }
//                if(s==sum){
//                    max = Math.max(max, j-i+1);
//                }
//            }
//        }
//        print(max);
    }

    public static void numberAppearsTwice(int[] arr){

//        Optimal
        int xor = 0;
        for(int i : arr){
            xor=i^xor;
        }
        print(xor);

//        Better(1)
//        int max = arr[0];
//        for(int i = 0; i < arr.length; i++){
//            max = Math.max(max, arr[i]);
//        }
//        int[] hash = new int[max];
//        for(int i = 0; i < hash.length; i++){
//            hash[arr[i]]++;
//        }
//        for(int i = 0; i < hash.length; i++){
//            if(hash[arr[i]] == 1){
//                print(arr[i]);
//            }
//        }

//        Better (2)
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i<arr.length; i++){
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//        for(int i = 1; i < map.size(); i++){
//            if(map.get(i) == 1){
//                print(i);
//                break;
//            }
//        }

//        Brute
//        for(int i = 0; i < arr.length; i++){
//            int num = arr[i], c= 0;
//            for(int j = 0; j <arr.length; j++){
//                if(arr[j] == num){
//                    c++;
//                }
//            }
//            if(c==1){
//                print(arr[i]);
//            }
//        }

    }

    public static void maxConsecutiveOnes(int[] arr){

//        Optimal
        int max = 0, c = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                c++;
                max = Math.max(c, max);
            }
            else{
                c=0;
            }
        }
        print(max);

//        Brute
//        int max = 0;
//        for(int i = 0; i < arr.length; i++){
//            int c = 0;
//            for(int j = i; j< arr.length; j++){
//                if(arr[j]==1){
//                    c++;
//                    max= Math.max(c, max);
//                }
//                else{
//                    break;
//                }
//            }
//        }
//        print(max);
    }

    public static void missingNumber(int[] arr, int N){

//        Optimal (1)
        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
            xor = xor ^ (i+1);
        }
        print(xor^N);

//        Optimal (2)
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++){
//            sum += arr[0];
//        }
//        int n = arr.length;
//        int s2 = (n * n+1)/2;
//        print(s2-sum);

//        Better
//        int[] hash = new int[arr.length+1];
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i]<=arr.length){
//                hash[arr[i]]= 1;
//            }
//        }
//        for(int i = 1; i < hash.length; i++){
//            if(hash[i] == 0){
//                print(i);
//                break;
//            }
//        }

//        Brute
//        for(int i = 1; i <= arr.length; i++){
//            int flag = 0;
//            for(int j = 0; j < arr.length - 1; j++){
//                if(arr[j] == i){
//                    flag = 1;
//                    break;
//                }
//            }
//            if(flag == 0){
//                print(i);
//            }
//        }
    }

    public static void intersectionOf2SortedArray(int[] arr1, int[]  arr2){

        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        print(ans);

//        Brute
//        int[] vis = new int[arr2.length];
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i = 0; i < arr1.length; i++){
//            for(int j = 0; j < arr2.length; j++){
//                if((arr1[i]==arr2[j]) && vis[j]==0){
//                    ans.add(arr1[i]);
//                    vis[j]=1;
//                    break;
//                }
//                if(arr1[i]>arr2[j]){
//                    break;
//                }
//            }
//        }
//        print(ans);
    }

    public static void unionOf2SortedArray(int[] arr1, int[] arr2){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0; int j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                if(ans.isEmpty() || ans.get(ans.size()-1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                i++;
            }
            else{
                if(ans.isEmpty() || ans.get(ans.size()-1) != arr2[j]){
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while(j< arr2.length){
            if(ans.isEmpty() || ans.get(ans.size()-1) != arr2[j]){
                ans.add(arr2[j]);
            }
            j++;
        }
        while(i< arr1.length){
            if(ans.isEmpty() || ans.get(ans.size()-1) != arr1[i]){
                ans.add(arr1[i]);
            }
            i++;
        }
        print(ans);
    }

    public static void moveZerosToEnd(int[] arr){

//        Optimal
        int j = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        for(int i = j; i < arr.length; i++){
            if(arr[i]!=0){
                swap(arr, i, j);
                j++;
            }
        }
        printArr(arr);

//        Brute
//        int[] temp = new int[arr.length];
//        int j = 0;
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i]!=0){
//                temp[j]=arr[i];
//                j++;
//            }
//        }
//        printArr(temp);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void leftRotate(int[] arr, int places){

//        Optimal
        reverse(arr, 0, places-1);
        printArr(arr);
        reverse(arr, places, arr.length-1);
        printArr(arr);
        reverse(arr, 0, arr.length-1);
        printArr(arr);
//        Brute
//        int[] temp = new int[places%arr.length];
//        for(int i = 0; i < temp.length; i++){
//            temp[i] = arr[i];
//        }
//        for(int i = places; i < arr.length; i++){
//            arr[i-places] = arr[i];
//        }
//
//        for(int i = arr.length-places; i < arr.length; i++){
//            arr[i] = temp[i-(arr.length - places)];
//        }
//        printArr(arr);

//        One place
//         int temp = arr[0];
//         for(int i = 1; i < arr.length; i++){
//             arr[i-1] = arr[i];
//         }
//         arr[arr.length-1]=temp;
//         printArr(arr);
    }

    public static void reverse(int[] arr, int left, int right){
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void removeDuplicates(int[] arr){
//        Better
        int i = 0;
        for(int j = 1; j < arr.length; j++){
            if(arr[j]!=arr[i]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        print(i+1);
//        Brute
//        HashSet<Integer> ans = new HashSet<>();
//        for(int i = 0; i < arr.length; i++){
//            ans.add(arr[i]);
//        }
//        print(ans);
    }

    public static int secondLargest(int[] arr){

        int slargest = secLargest(arr, arr.length);
        int ssmallest = secSmallest(arr, arr.length);
        print(slargest + " , " + ssmallest);
        return 0;
//        Better
//        int largest = findLargest(arr);
//        int secondLargest = -1;
//        for(int i = 0; i < arr.length - 1; i++){
//            if(arr[i]> secondLargest && arr[i] != largest){
//                secondLargest =arr[i];
//            }
//        }
//        return secondLargest;

//        Brute
//        Arrays.sort(arr);
//        int secondLargest = arr[arr.length-1];
//        for(int i = arr.length-1; i >=0; i--){
//            if(arr[i] < secondLargest){
//                return arr[i];
//            }
//        }
//        return arr[arr.length-1];
    }

    public static int secLargest(int[] arr, int n){
        int largest = arr[0];
        int secondLargest = -1;

        for(int i = 1; i < n; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] < largest && arr[i] > secondLargest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }

    public static int secSmallest(int[] arr, int n){
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(arr[i] < smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] > smallest && arr[i] < secondSmallest){
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static int findLargest(int[] arr){

        int largest = 0;
        for(int i = 0; i <= arr.length-1; i++){
            if(largest < arr[i]){
                largest=arr[i];
            }
        }
        return largest;
//        Brute
//        Arrays.sort(arr);
//        return arr[arr.length-1];
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            print(arr[i]);
        }
        System.out.println();
    }

    public static void print(Object n){
        System.out.print(n + " ");
    }
}
