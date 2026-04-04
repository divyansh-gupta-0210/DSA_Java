package PractiseQuestions;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;

public class DynamicProgrammingPractise {

    public static void main(String[] args) {
//        int n = 5;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        print(fibonacci(n, dp));

//        int[] path = {30,10,60,10,60,50};
//        int[] dp = new int[path.length + 1]; Arrays.fill(dp, -1);
//        print(frogJumps(path, dp, path.length - 1));
//        print(frogKJumps(path, dp, path.length - 1, 3));
//        print(Arrays.toString(dp));

//        int[] arr = {2, 1, 4, 9};
//        int[] dp = new int[arr.length + 1]; Arrays.fill(dp, -1);
//        print(maximumSumOfNonAdjEle(arr, dp, arr.length - 1));
//        print(houseRobber(arr, dp, arr.length - 1));   // Circular -> Last house links the 1st

//         int[][] arr = {{2,1,3},{3,4,6},{10,1,6},{8,3,7}};
//         int[][] dp = new int[arr.length][4];
//         for(int i = 0;  i < arr.length; i++){
//             Arrays.fill(dp[i], -1);
//         }
//         print(ninjasTraining(arr, dp, arr.length - 1, 0));

//        int[][] grid = new int[3][3];
//        int[][] dp = new int[3][3];
//        for(int i = 0;  i < dp.length; i++){
//             Arrays.fill(dp[i], -1);
//        }
//        print(uniquePaths(grid, dp, grid.length-1, grid[0].length - 1));
//        int[][] grid = {{0,0,0},{0,-1,0},{0,0,0}};
//        int[][] dp = new int[grid.length][grid[0].length];
//        for(int i = 0; i < dp.length; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(gridMazeObstacles(grid, dp, grid.length, grid[0].length));

//        int[][] grid = {{10,8,2},{10,5,100},{1,1,2}};
//
//        int[][] dp = new int[grid.length][grid[0].length];
//        for(int i = 0; i < dp.length; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(minimumPathSum(grid, dp, grid.length - 1, grid[0].length - 1));

//        int[][] grid = {{1},{2,3},{3,6,7},{8,9,6,10}};
//
//        int[][] dp = new int[grid.length][];
//        for (int i = 0; i < grid.length; i++) {
//            dp[i] = new int[grid[i].length];
//            Arrays.fill(dp[i], -1);
//        }
//        print(triangleFixedStartingAndVariableEndingPoint(grid, dp, 0, 0));

//        int[][] grid = {
//                {1,2,10,4},
//                {100,3,2,1},
//                {1,1,20,2},
//                {1,2,2,1}};
//        int[][] dp = new int[grid.length][];
//        for (int i = 0; i < grid.length; i++) {
//            dp[i] = new int[grid[i].length];
//            Arrays.fill(dp[i], -1);
//        }
//        int max = Integer.MIN_VALUE;
//        for (int j = 0; j < grid[0].length; j++) {
//            max = Math.max(max, minimumMaximumFallingPathSum(grid, dp, grid.length - 1, j));
//        }
//        print(minimumMaximumFallingPathSum(grid, dp, grid.length - 1, grid[0].length - 1));
//        System.out.println(max);

//        int[][] grid = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[][][] dp = new int[n][m][m];
//        for (int i = 0; i < n; i++) {
//            for (int j1 = 0; j1 < m; j1++) {
//                Arrays.fill(dp[i][j1], -1);
//            }
//        }
//        print(cherryPickUp(grid, dp /*, 0, 0, m - 1)*/));

//        int[] arr = {1, 2, 3, 4}; int target = 100;
//        int[][] dp = new int[arr.length][target+1];
//        for(int i = 0; i < arr.length; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(subSetSumEqualsTarget(arr, dp, arr.length - 1, target));

//        int[] arr = {2,3};
//        int sum = 0;
//        for (int num : arr) {
//            sum += num;
//        }
//        if (sum % 2 != 0) {
//            System.out.println(false);
//            return;
//        }
//        int target = sum / 2;
//        int[][] dp = new int[arr.length][target+1];
//        for(int i = 0; i < arr.length; i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(canPartition(arr, target));

//        int[] arr = {1,10,3};
//        print(minSubsetSumDifference(arr, arr.length));

//        int[] arr = {0,0,1};
//        int sum = 1;
//        int[][] dp = new int[arr.length][sum + 1];
//        for(int i = 0; i < dp.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        print(countNumberOfSubsetsWithSumK(arr, dp, arr.length - 1, sum));

//        int[] arr = {5,2,6,4};
//        int diff = 3;
//        print(countNumberOfPartitionsWithDifference(arr, diff));

//        int[] wt = {3,2,5};
//        int[] val = {30, 40, 60};
//        int bgWt = 6;
//        int[][] dp = new int[wt.length][bgWt + 1];
//        for(int i = 0; i < wt.length; i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(knapsack(wt, val, bgWt, wt.length - 1, dp));

//        int[] arr = {1, 2, 3};
//        int target = 7;
//        int[][] dp = new int[arr.length][target + 1];
//        for(int i = 0; i < arr.length; i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(minimumCoins(arr, dp, arr.length - 1, target));

//        int[] arr = {1, 2, 3, 1};
//        int target = 3;
//        print(targetSum(arr, target));

//        int[] arr = {1, 2, 3};
//        int target = 4;
//        int[][] dp = new int[arr.length][target + 1];
//        for(int i = 0; i < arr.length; i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(minimumCoinsProvidedAnyElementCanBeUsedAnyNumberOfTimes(arr, dp, arr.length - 1, target));

//        int[] wt = {2,4,6};
//        int[] val = {5,11,13};
//        int bgWt = 10;
//        int[][] dp = new int[wt.length][bgWt + 1];
//        for(int i = 0; i < wt.length; i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(unboundedKnapsack(wt, val, bgWt, wt.length - 1, dp));

//        int[] price = {2,5,7,8,10};
//        int rodLength = 5;
//        int[][] dp = new int[price.length][rodLength + 1];
//        for(int i = 0; i < price.length; i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(rodCutting(price, dp, price.length - 1, rodLength));

//        String s1 = "adcdc";
//        String s2 = "dcadb";
//        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for(int i = 0; i < s1.length(); i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(longestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1, dp));

//        String s1 = "abcde";
//        String s2 = "bdgek";
//        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for(int i = 0; i < s1.length(); i++){
//            Arrays.fill(dp[i], -1);
//        }
//        print(printLongestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1, dp));

//        String s1 = "abcjklp";
//        String s2 = "acjkp";
//        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for(int i = 0; i < s1.length(); i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(printLongestCommonSubstring(s1, s2, dp));

//        String s1 = "bbabcbcab";
//        String s2 = reverseString(s1);
//        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        for(int i = 0; i <= s1.length(); i++){
//            Arrays.fill(dp[i], 0);
//        }
//        print(longestPalindromicSubsequence(s1, s2, dp));

//        String s = "codingninjas";
//        print(minimumInsertionsToMakeStringPalindrome(s));

//        String str1 = "abcd";
//        String str2 = "anc";
//        print(minimumNumberOfInsertionsAndDeletionNeededToConvertS1toS2(str1, str2));

        String s1 = "brute";
        String s2 = "groot";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        print(shortestCommonSuperSequence(s1, s2, dp));
    }

    public static String shortestCommonSuperSequence(String s1, String s2, int[][] dp){
        for(int j = 0; j <= s2.length(); j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= s1.length(); i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        String ans = "";
        int i = s1.length(); int j = s2.length();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans+= s1.charAt(i-1);
                i--; j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans += s1.charAt(i-1);
                i--;
            }
            else{
                ans += s2.charAt(j-1);
                j--;
            }
        }
        while(i > 0){
            ans += s1.charAt(i-1);
            i--;
        }
        while(j > 0){
            ans += s2.charAt(j-1);
            j--;
        }
        return reverseString(ans);
    }

    public static int minimumNumberOfInsertionsAndDeletionNeededToConvertS1toS2(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length(); i++){
            Arrays.fill(dp[i], 0);
        }
        return s1.length() + s2.length() - 2 * longestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1, dp);
    }

    public static int minimumInsertionsToMakeStringPalindrome(String s1){
        String s2 = reverseString(s1);
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            Arrays.fill(dp[i], 0);
        }
        return s1.length() - longestPalindromicSubsequence(s1, s2, dp);
    }

    public static String reverseString(String s){
        String rev = "";
        for(int i = s.length() - 1; i >= 0; i--){
            rev += s.charAt(i);
        }
        return rev;
    }

    public static int longestPalindromicSubsequence(String s1, String s2, int[][] dp){
        for(int j = 0; j <= s2.length(); j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= s1.length(); i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static int printLongestCommonSubstring(String s1, String s2, int[][] dp){
        for(int j = 0; j <= s2.length(); j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= s1.length(); i++){
            dp[i][0] = 0;
        }
        int ans = 0;
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(dp[i][j], ans);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static String printLongestCommonSubsequence(String s1, String s2, int ind1, int ind2, int[][] dp){
        for(int j = 0; j <= s2.length(); j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= s1.length(); i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int len = dp[s1.length()][s2.length()];
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < len; i++){
            ans.append("$");
        }
        int index = len - 1;
        int i = s1.length(); int j = s2.length();
        while(i>0 && j >0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.setCharAt(index, s1.charAt(i-1));
                index--;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return ans.toString();
    }

        public static int longestCommonSubsequence(String s1, String s2, int ind1, int ind2, int[][] dp){

//      Space Optimization
        int[] prev = new int[s1.length() + 1];
        for(int j = 0; j <= s2.length(); j++){
            prev[j] = 0;
        }
        for(int i = 1; i <= s1.length(); i++){
            int[] curr = new int[s2.length() + 1];
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[s2.length()];

//        Tabulation
//        for(int j = 0; j <= s2.length(); j++){
//            dp[0][j] = 0;
//        }
//        for(int i = 0; i <= s1.length(); i++){
//            dp[i][0] = 0;
//        }
//        for(int i = 1; i <= s1.length(); i++){
//            for(int j = 1; j <= s2.length(); j++){
//                if(s1.charAt(i-1) == s2.charAt(j-1)){
//                    dp[i][j] = 1 + dp[i-1][j-1];
//                }
//                else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[s1.length()][s2.length()];

//        Brute and Better
//        if(ind1 == 0 || ind2 == 0){
//            return 0;
//        }
//        if(dp[ind1][ind2]!=-1){
//            return dp[ind1][ind2];
//        }
//        if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
//            return 1 + longestCommonSubsequence(s1, s2, ind1- 1, ind2 - 1, dp);
//        }
//        return dp[ind1][ind2] = Math.max(longestCommonSubsequence(s1, s2, ind1 - 1, ind2, dp),
//                longestCommonSubsequence(s1, s2, ind1, ind2 - 1, dp));
    }

    public static int rodCutting(int[] price, int[][] dp, int ind, int n){

//        Tabulation
        for(int i = 0; i <= n; i++){
            dp[0][i] = i * price[0];
        }
        for(int i = 1; i < price.length; i++){
            for(int j = 0; j <= n; j++){
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                int rodLen = i+1;
                if(rodLen <= j){
                    take = price[i] + dp[i][j-rodLen];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[price.length - 1][n];

//        Brute and Better
//        if(ind == 0){
//            return n * price[0];
//        }
//        if(dp[ind][n] != -1){
//            return dp[ind][n];
//        }
//        int notTake = rodCutting(price, dp, ind-1, n);
//        int take = Integer.MIN_VALUE;
//        int rodLen = ind+1;
//        if(rodLen <= n){
//            take = price[ind] + rodCutting(price, dp, ind, n - rodLen);
//        }
//        return dp[ind][n] = Math.max(take, notTake);
    }

    public static int unboundedKnapsack(int[] weight, int[] value, int bagWeight, int ind, int[][] dp){

//        Space Optimization
        int[] prev = new int[bagWeight + 1];
        for(int i = 0; i <= bagWeight; i++){
            prev[i] = (i / weight[0]) * value[0];
        }

        for(int i = 1; i < weight.length; i++){
//            int[] curr = new int[bagWeight + 1];
            for(int j = 0; j <= bagWeight; j++){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j){
                    take = value[i] + prev[j - weight[i]];
                }
                prev[j] = Math.max(take, notTake);
            }
//            prev = curr;
        }
        return prev[bagWeight];

//        Tabulation
//        for(int i = 0; i <= bagWeight; i++){
//            dp[0][i] = (i / weight[0]) * value[0];
//        }
//
//        for(int i = 1; i < weight.length; i++){
//            for(int j = 0; j <= bagWeight; j++){
//                int notTake = dp[i-1][j];
//                int take = Integer.MIN_VALUE;
//                if(weight[i] <= j){
//                    take = value[i] + dp[i][j - weight[i]];
//                }
//                dp[i][j] = Math.max(take, notTake);
//            }
//        }
//        return dp[weight.length-1][bagWeight];

//        Brute + Better
//        if(ind == 0){
//            return (bagWeight / weight[ind]) * value[0];
//        }
//        if(dp[ind][bagWeight] != -1){
//            return dp[ind][bagWeight];
//        }
//        int notTake = unboundedKnapsack(weight, value, bagWeight, ind - 1, dp);
//        int take = Integer.MIN_VALUE;
//        if(weight[ind] <= bagWeight){
//            take = value[ind] + unboundedKnapsack(weight, value, bagWeight - weight[ind], ind, dp);
//        }
//        return dp[ind][bagWeight] = Math.max(take, notTake);
    }

    public static int minimumCoinsProvidedAnyElementCanBeUsedAnyNumberOfTimes(int[] arr, int[][] dp, int ind, int target){

//       Space Optimization
        int[] prev = new int[target + 1];

        for(int i = 0; i <= target; i++){
            prev[i] = (i%arr[0] == 0) ? 1 : 0;
        }

        for(int i = 1; i < arr.length; i++){
            int[] curr = new int[target + 1];
            for(int j = 0; j <= target; j++){
                int notTake = prev[j];
                int take = 0;
                if(arr[i] <= j){
                    take = curr[j - arr[i]];
                }
                curr[j] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];

//        Tabulation
//        for(int i = 0; i <= target; i++){
//            dp[0][i] = (i%arr[0] == 0) ? 1 : 0;
//        }
//
//        for(int i = 1; i < arr.length; i++){
//            for(int j = 0; j <= target; j++){
//                int notTake = dp[i-1][j];
//                int take = 0;
//                if(arr[i] <= j){
//                    take = dp[i][j - arr[i]];
//                }
//                dp[i][j] = take + notTake;
//            }
//        }
//        return dp[arr.length - 1][target];


//        Brute and Better
//        if(ind == 0){
//            return target % arr[ind] == 0 ? 1 : 0;
//        }
//        if(dp[ind][target] != -1){
//            return dp[ind][target];
//        }
//        int notTake = minimumCoinsProvidedAnyElementCanBeUsedAnyNumberOfTimes(arr, dp, ind-1, target);
//        int take = 0;
//        if(arr[ind] <= target){
//            take = minimumCoinsProvidedAnyElementCanBeUsedAnyNumberOfTimes(arr, dp, ind, target - arr[ind]);
//        }
//        return dp[ind][target] = take + notTake;
    }

    public static int targetSum(int[] arr, int target){
        return countNumberOfPartitionsWithDifference(arr, target);
    }

    public static int minimumCoins(int[] arr, int[][] dp, int ind, int target){

//        Tabulation
        int[] prev = new int[target + 1];
        for(int t = 0; t <= target; t++){
            if(t % arr[0] == 0){
                prev[t] = t / arr[0];
            }
            else{
                prev[t] = (int)(1e9);
            }
        }

        for(int i = 1; i < arr.length; i++){
            int[] curr = new int[target + 1];
            for(int j = 0; j <= target; j++){
                int notTake = prev[j];
                int take = (int)1e9;
                if(arr[i] <= j){
                    take = 1 + curr[j - arr[i]];
                }
                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }
        if(prev[target] >= (int)1e9){
            return -1;
        }
        return prev[target];

//        if(ind == 0){
//            return target % arr[ind] == 0 ? target / arr[ind] : (int)1e9;
//        }
//        if(dp[ind][target] != -1){
//            return dp[ind][target];
//        }
//        int notTake = minimumCoins(arr, dp, ind - 1, target);
//        int take = (int)1e9;
//        if(arr[ind] <= target){
//            take = 1 + minimumCoins(arr, dp, ind, target - arr[ind]);
//        }
//        return dp[ind][target] = Math.min(take, notTake);
    }

    public static int knapsack(int[] weight, int[] value, int bagWeight, int ind, int[][] dp){

//        Space optimization
        int[] prev = new int[bagWeight + 1];
        for(int i = weight[0]; i <= bagWeight; i++){
            prev[i] = value[0];
        }
        for(int i = 1; i < weight.length; i++){

//            for(int w = 0; w <= bagWeight; w++){
            for(int w = bagWeight; w >= 0; w--){
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= w){
                    take = value[i] + prev[w - weight[i]];
                }
                prev[w] = Math.max(notTake, take);
            }
        }
        return prev[bagWeight];

//        Tabulation
//        for(int i = weight[0]; i <= bagWeight; i++){
//            dp[0][i] = value[0];
//        }
//        for(int i = 1; i < weight.length; i++){
//            for(int w = 0; w <= bagWeight; w++){
//                int notTake = dp[i-1][w];
//                int take = Integer.MIN_VALUE;
//                if(weight[i] <= w){
//                    take = value[i] + dp[i-1][w - weight[i]];
//                }
//                dp[i][w] = Math.max(notTake, take);
//            }
//        }
//        return dp[weight.length - 1][bagWeight];

//        Brute + Better
//        if(ind == 0){
//            if(weight[ind] <= bagWeight){
//                return value[ind];
//            }
//            else{
//                return 0;
//            }
//        }
//        if(dp[ind][bagWeight]!=-1){
//            return dp[ind][bagWeight];
//        }
//        int notTake = knapsack(weight, value, bagWeight, ind - 1, dp);
//        int take = Integer.MIN_VALUE;
//        if(weight[ind] <= bagWeight){
//            take = value[ind] + knapsack(weight, value, bagWeight - weight[ind], ind - 1, dp);
//        }
//        return dp[ind][bagWeight] = Math.max(notTake, take);
    }

    public static int countNumberOfPartitionsWithDifference(int[] arr, int diff){
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        if(totalSum - diff < 0 || (totalSum - diff) % 2 != 0){
            return 0;
        }
        int sum = (totalSum - diff) / 2;
        int[][] dp = new int[arr.length][sum + 1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], 0);
        }
        return countNumberOfSubsetsWithSumK(arr, dp,arr.length -1, sum);
    }

    public static int countNumberOfSubsetsWithSumK(int[] arr, int[][] dp, int ind, int sum){

//        Space Optimization
        int[] prev = new int[sum+1];
        prev[0] = 1;
        if(arr[0] <= sum){
            prev[arr[0]] = 1;
        }
        for(int i = 1; i < arr.length; i++){
            int[] curr = new int[sum + 1];
            for(int j = 0; j <= sum; j++){
                int notPick = prev[j];
                int pick = 0;
                if(arr[i] <= j){
                    pick = prev[j - arr[i]];
                }
                curr[j] = pick + notPick;
            }
            prev = curr;
        }
        return prev[sum];

//        Tabulation
//        if(arr[0] == 0) {
//            dp[0][0] = 2;
//        }
//        else{
//            dp[0][0] = 1;
//        }
//        if(arr[0] != 0 && arr[0] <= sum){
//            dp[0][arr[0]] = 1;
//        }
//
//        for(int i = 1; i < arr.length; i++){
//            for(int j = 0; j <= sum; j++){
//                int notPick = dp[i-1][j];
//                int pick = 0;
//                if(arr[i] <= j){
//                    pick = dp[i-1][j - arr[i]];
//                }
//                dp[i][j] = pick + notPick;
//            }
//        }
//        return dp[arr.length-1][sum];

//      Better and Brute

//        if(ind == 0){
//            if(sum == 0 && arr[0] == 0){
//                return 2;
//            }
//            if(sum == 0 || sum == arr[0]){
//                return 1;
//            }
//            return 0;
//        }
//        if(dp[ind][sum] != -1){
//            return dp[ind][sum];
//        }
//        int notPick = countNumberOfSubsetsWithSumK(arr, dp, ind-1, sum);
//        int pick = 0;
//        if(arr[ind] <= sum){
//            pick = countNumberOfSubsetsWithSumK(arr, dp, ind-1, sum - arr[ind]);
//        }
//        return dp[ind][sum] = pick + notPick;
    }

    public static int minSubsetSumDifference(int[] arr, int n){
        int totalSum = 0;

        for(int i : arr) totalSum += i;

        boolean[][] dp = new boolean[n][totalSum+1];
        if(arr[0] <= totalSum){
            dp[0][arr[0]] = true;
        }

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= totalSum; target++){
                boolean notTake = dp[i-1][target];
                boolean take = false;
                if(arr[i] <= target){
                    take = dp[i-1][target - arr[i]];
                }
                dp[i][target] = take | notTake;
            }
        }
        for(int i = 0; i < dp.length; i++){
            print(Arrays.toString(dp[i]));
        }

        // dp[n-1][col -> 0... target]
        int mini = (int)1e9;
        for(int s1 = 0; s1 <= totalSum/2; s1++){
            if(dp[n-1][s1]){
                mini = Math.min(mini, Math.abs(totalSum - 2 * s1));
            }
        }
        return mini;
    }

    public static boolean canPartition(int[] arr, int target) {
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int tar = 1; tar <= target; tar++) {
                boolean notTake = prev[tar];
                boolean take = false;
                if (arr[i] <= tar) {
                    take = prev[tar - arr[i]];
                }
                curr[tar] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }

    public static boolean subSetSumEqualsTarget(int[] arr, int[][] dp, int ind, int target){

//        Space optimization
        boolean[] prev = new boolean[target+1];

        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        for(int i = 1; i < arr.length; i++){
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for(int tar = 0; tar <= target; tar++){
                boolean notTake = prev[tar];
                boolean take = false;
                if(arr[i] <= tar){
                    take = prev[tar-arr[i]];
                }
                curr[tar] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];

//        Tabulation
//        boolean[][] dpTabulation = new boolean[arr.length][target + 1];
//        dpTabulation[0][arr[0]] = true;
//
//        for(int i = 1; i < arr.length; i++){
//            for(int tar = 1; tar <= target; tar++){
//                boolean notTake = dpTabulation[i-1][tar];
//                boolean take = false;
//                if(arr[i] <= tar){
//                    take = dpTabulation[i-1][tar-arr[i]];
//                }
//                dpTabulation[i][tar] = take | notTake;
//            }
//        }
//        for(int i = 0; i < dp.length; i++){
//            print(Arrays.toString(arr));
//            print(Arrays.toString(dpTabulation[i]));
//        }
//        return dpTabulation[arr.length-1][target];

//        Brute and Better
//        if(target == 0){
//            return true;
//        }
//        if(ind == 0){
//            return arr[0] == target;
//        }
//        if(dp[ind][target] != -1){
//            return dp[ind][target] == 1;
//        }
//        boolean notTaken = subSetSumEqualsTarget(arr, dp, ind - 1, target);
//        boolean taken = false;
//        if(target >= arr[ind]){
//            taken = subSetSumEqualsTarget(arr, dp, ind - 1, target - arr[ind]);
//        }
//        dp[ind][target] = (notTaken || taken) ? 1 : 0;
//        return notTaken || taken;
    }

    public static int cherryPickUp(int[][] grid, int[][][] dp /*,int i, int j1, int j2*/){

//        Tabulation
        int n = grid.length;
        int m = grid[0].length;

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = 0;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value;
                            if (j1 == j2)
                                value = grid[i][j1];
                            else
                                value = grid[i][j1] + grid[i][j2];
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;
                            if (newJ1 >= 0 && newJ1 < m && newJ2 >= 0 && newJ2 < m)
                                value += dp[i + 1][newJ1][newJ2];
                            else
                                value += -1e8;
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];

//        Better and Brute
//        int n = grid.length;
//        int m = grid[0].length;
//        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
//            return Integer.MIN_VALUE;
//        }
//        if (i == n - 1) {
//            if (j1 == j2) return grid[i][j1];
//            else return grid[i][j1] + grid[i][j2];
//        }
//        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
//        int maxi = Integer.MIN_VALUE;
//        for (int dj1 = -1; dj1 <= 1; dj1++) {
//            for (int dj2 = -1; dj2 <= 1; dj2++) {
//
//                int value;
//                if (j1 == j2) value = grid[i][j1];
//                else value = grid[i][j1] + grid[i][j2];
//
//                value += cherryPickUp(grid, dp, i + 1, j1 + dj1, j2 + dj2);
//
//                maxi = Math.max(maxi, value);
//            }
//        }
//        return dp[i][j1][j2] = maxi;
    }

    public static int minimumMaximumFallingPathSum(int[][] grid, int[][] dp, int row, int col){

        int[] prev = new int[grid.length];

        for(int i = 0; i < grid.length; i++){
            prev[i] = grid[0][i];
        }

        for(int i = 1; i < grid.length; i++){
            int[] curr = new int[grid.length];
            for(int j = 0; j < grid[0].length; j++){
                int up = grid[i][j] + prev[j];
                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;
                if(j - 1 >= 0){
                    ld = grid[i][j] + prev[j - 1];
                }
                if(j + 1 < grid.length){
                    rd = grid[i][j] + prev[j + 1];
                }
                curr[j] = Math.max(up, Math.max(ld, rd));
            }

            prev = curr;
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < grid.length; j++) {
            max = Math.max(max, prev[j]);
        }
        return max;

//        Tabulation
//        for(int j = 0; j < grid.length ; j++){
//            dp[0][j] = grid[0][j];
//        }
//
//        for(int i = 1; i < grid.length; i++){
//            for(int j = 0; j < grid[i].length; j++){
//                int ld = Integer.MIN_VALUE; int rd = Integer.MIN_VALUE;
//                int up = grid[i][j] + dp[i-1][j];
//                if(j - 1 >= 0) ld = grid[i][j] + dp[i-1][j-1];
//                if(j + 1 < grid.length) rd = grid[i][j] + dp[i-1][j+1];
//                dp[i][j] = Math.max(up, Math.max(ld, rd));
//            }
//        }
//        int max = Integer.MIN_VALUE;
//        for (int j = 0; j < grid[0].length; j++) {
//            max = Math.max(max, dp[grid.length - 1][j]);
//        }
//        print(Arrays.toString(dp[dp.length-1]));
//        return max;

//        Brute and Better
//        if(col < 0 || col >= grid[0].length){
//            return Integer.MIN_VALUE;
//        }
//        if(row == 0){
//            return grid[0][col];
//        }
//        if(dp[row][col] != -1) return dp[row][col];
//        int up = grid[row][col] + minimumMaximumFallingPathSum(grid, dp, row - 1, col);
//        int rightDi = grid[row][col] + minimumMaximumFallingPathSum(grid, dp, row - 1, col + 1);
//        int leftDi = grid[row][col] + minimumMaximumFallingPathSum(grid, dp, row - 1, col - 1);
//        return dp[row][col] = Math.max(up, Math.max(rightDi, leftDi));
    }

    public static int triangleFixedStartingAndVariableEndingPoint(int[][] grid, int[][] dp, int row, int col){

//        Space Optimization
        int[] prev = new int[grid[grid.length - 1].length];
        for (int j = 0; j < grid[grid.length - 1].length; j++) {
            prev[j] = grid[grid.length - 1][j];
        }
        for(int i = grid.length - 2; i >= 0; i--){
            int[] curr = new int[i+1];
            for(int j = 0; j <= i; j++){
                int down = grid[i][j] + prev[j];
                int dai = grid[i][j] + prev[j+1];
                curr[j] = Math.min(dai, down);
            }
            prev = curr;
        }
        return prev[0];

//        Tabulation
//        for (int j = 0; j < grid[grid.length - 1].length; j++) {
//            dp[grid.length - 1][j] = grid[grid.length - 1][j];
//        }
//
//        for(int i = grid.length - 2; i >= 0; i--){
//            for (int j = 0; j <= i; j++){
//                int down = grid[i][j] + dp[i+1][j];
//                int dia = grid[i][j] + dp[i+1][j+1];
//                dp[i][j] = Math.min(down, dia);
//            }
//        }
//        return dp[0][0];

//        Brute + Better
//        if(row == grid.length - 1){
//            return grid[row][col];
//        }
//        if (dp[row][col] != -1) return dp[row][col];
//        int down = grid[row][col] + triangleFixedStartingAndVariableEndingPoint(grid, dp, row + 1, col);
//        int diagonal = grid[row][col] + triangleFixedStartingAndVariableEndingPoint(grid, dp, row + 1, col + 1);
//        return dp[row][col] = Math.min(down, diagonal);
    }

    public static int minimumPathSum(int[][] grid, int[][] dp, int row, int col){

        int[] prev = new int[col + 1];

        for(int i = 0; i <= row; i++){
            int[] curr = new int[col + 1];
            for(int j = 0; j <= col; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    if(i > 0) up = prev[j] + grid[i][j];
                    if(j > 0) left = curr[j - 1] + grid[i][j];

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[col];
        
//        Tabulation
//        for(int i = 0; i <= row; i++){
//            for(int j = 0; j <= col; j++){
//                if(i == 0 && j == 0){
//                    dp[i][j] = grid[0][0];
//                }
//                else{
//                    int up = Integer.MAX_VALUE;
//                    int left = Integer.MAX_VALUE;
//                    if(i > 0) up = grid[i][j] + dp[i-1][j];
//                    if(j > 0) left = grid[i][j] + dp[i][j-1];
//                    dp[i][j] = Math.min(up, left);
//                }
//            }
//        }
//        return dp[row][col];

//        if(row == 0 && col == 0){
//            return grid[0][0];
//        }
//        if(row < 0 || col < 0){
//            return Integer.MAX_VALUE;
//        }
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//        int up = minimumPathSum(grid, dp, row - 1, col);
//        int left = minimumPathSum(grid, dp, row, col-1);
//
//        if(up != Integer.MAX_VALUE) up += grid[row][col];
//        if(left != Integer.MAX_VALUE) left += grid[row][col];
//
//        return dp[row][col] = Math.min(up, left);
    }

    public static int gridMazeObstacles(int[][] grid, int[][] dp, int row, int col){

//      Optimal - Space Optimization
        int[] prev = new int[row];
        for(int i = 0; i < row; i++){
            int[] curr = new int[row];
            for(int j = 0; j < col; j++){
                int up = 0, left = 0;
                if(grid[i][j] == -1){
                    curr[j] = 0;
                }
                else if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else{
                    if(i > 0){
                        up = prev[j];
                    }
                    if(j > 0){
                        left = curr[j - 1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[grid.length-1];

//        Optimal - Tabulation
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                if(grid[i][j] == -1){
//                    dp[i][j] = 0;
//                    continue;
//                }
//                if(i == 0 && j == 0){
//                    dp[i][j] = 1;
//                    continue;
//                }
//                int up = 0;
//                int left = 0;
//                if(i > 0) up = dp[i-1][j];
//                if(j > 0) left = dp[i][j-1];
//                dp[i][j] = up + left;
//            }
//        }
//
//        return dp[row - 1][col - 1];

//        Better and Brute
//        if(row >= 0 && col >= 0 && grid[row][col] == -1){
//            return 0;
//        }
//        if(row == 0 && col == 0){
//            return 1;
//        }
//        if(row < 0 || col < 0){
//            return 0;
//        }
//        if(dp[row][col] != -1){
//            return dp[row][col];
//        }
//        int up = gridMazeObstacles(grid, dp, row -1, col);
//        int left = gridMazeObstacles(grid, dp, row, col - 1);
//        return dp[row][col] = up + left;
    }

    public static int uniquePaths(int[][] grid, int[][] dp, int row, int col){

//        Optimal
        int[] prev = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            int[] curr = new int[grid.length];
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else{
                    int up = 0, left = 0;
                    if(i > 0){
                        up = prev[j];
                    }
                    if(j > 0){
                        left = curr[j-1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[grid[0].length-1];

//        Tabulation
//        dp[0][0] = 1;
//        for(int i = 0; i < grid.length; i++){
//            for(int j = 0; j < grid[0].length; j++){
//                if(i == 0 && j == 0){
//                    dp[0][0] = 1;
//                }
//                else{
//                    int up = 0, left = 0;
//                    if(i > 0){
//                        up = dp[i-1][j];
//                    }
//                    if(j > 0){
//                        left = dp[i][j-1];
//                    }
//                    dp[i][j] = up + left;
//                }
//            }
//        }
//        return dp[grid.length-1][grid[0].length-1];

//        Brute + Better
//        if(i < 0 || j < 0){
//            return 0;
//        }
//        if(i == 0 && j == 0){
//            return dp[i][j] = 1;
//        }
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//        int up = uniquePaths(grid, dp, i-1, j);
//        int left = uniquePaths(grid, dp, i, j-1);
//        return dp[i][j] = up + left;
    }

    public static int ninjasTraining(int[][] arr, int[][] dp, int day, int last){

//        Space Optimized
        int[] prev = new int[4];
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));


        for(int i = 1; i < arr.length; i++){
            int[] temp = new int[4];

            for(int j = 0; j < 4; j++){
                temp[j] = 0;

                for(int task = 0; task < 3; task++){
                    if(task != j){
                        temp[j] = Math.max(arr[i][task] + prev[task], temp[j]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];


//        Optimal
//        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
//        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
//        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
//        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
//
//        for(int i = 1; i < arr.length; i++){
//            for(int j = 0; j < 4; j++){
//                dp[i][j] = 0;
//                for(int task = 0; task < 3; task++){
//                    if(task != j){
//                        dp[i][j] = Math.max(arr[i][task] + dp[i-1][task], dp[i][j]);
//                    }
//                }
//            }
//        }
//
//        return dp[arr.length-1][3];

//        Brute and Better
//        if(day == 0){
//            int maxi = 0;
//            for(int i = 0; i < 3; i++){
//                if(i != last){
//                    maxi = Math.max(maxi, arr[0][i]);
//                }
//            }
//            return dp[day][last] = maxi;
//        }
//        if(dp[day][last] != -1){
//            return dp[day][last];
//        }
//        int maxi = 0;
//        for(int i = 0; i < 3; i++){
//            if(i != last){
//                int points = arr[day][i] + ninjasTraining(arr, dp, day - 1, i);
//                maxi = Math.max(points, maxi);
//            }
//        }
//        return dp[day][last] = maxi;
    }

    public static int houseRobber(int[] arr, int[] dp, int ind){
        int n = arr.length;
        if(n == 1){
            return arr[0];
        }
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];

        for(int i = 0; i < n - 1; i++){
            temp1[i] = arr[i + 1];
            temp2[i] = arr[i];
        }

        return Math.max(maximumSumOfNonAdjEle(temp1, dp, 0), maximumSumOfNonAdjEle(temp2, dp, 0));
    }

    public static int maximumSumOfNonAdjEle(int[] arr, int[] dp, int ind){

//        Optimal
        int prev = arr[0];
        int prev2 = 0;
        for(int i = 0; i < arr.length; i++){
            int take = arr[i];
            if(i>1){
                take+=prev2;
            }
            int notTake = prev2;
            int cur_i = Math.max(take, notTake);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;

//        Better
//        dp[0] = arr[0];
//        for(int i = 1; i < arr.length; i++){
//            int take = arr[i];
//            if(i > 1){
//                take += dp[i-2];
//            }
//            int notTake = dp[i-1];
//            dp[i] = Math.max(take, notTake);
//        }
//        return dp[arr.length - 1];

//        Better and Brute
//        if(ind == 0){
//            return arr[ind];
//        }
//        if(ind < 0){
//            return 0;
//        }
//        if(dp[ind] != -1){
//            return dp[ind];
//        }
//        int pick = arr[ind] + maximumSumOfNonAdjEle(arr, dp, ind - 2);
//        int not_pick = maximumSumOfNonAdjEle(arr, dp, ind-1);
//        return dp[ind] = Math.max(pick, not_pick);
    }

    public static int frogKJumps(int[] path, int[] dp, int ind, int k){

//        Optimal
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < path.length; i++){
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    dp[i] = Math.min(dp[i], dp[i-j] + Math.abs(path[i] - path[i-j]));
                }
            }
        }
        return dp[path.length-1];
//        Better + Brute
//        if(ind == 0){
//            return dp[0] = 0;
//        }
//
//        if(dp[ind]!=-1){
//            return dp[ind];
//        }
//
//        int minSteps = Integer.MAX_VALUE;
//        for(int i = 1; i <= k; i++){
//            if(ind - i >= 0){
//                int jump = frogKJumps(path, dp, ind - i, k) + Math.abs(path[ind] - path[ind - i]);
//                minSteps = Math.min(minSteps, jump);
//            }
//        }
//        return dp[ind] = minSteps;
    }

    public static int frogJumps(int[] path, int[] dp, int ind){

//        Optimal
        int prev = 0; int prev2 = 0;
        int ss = Integer.MAX_VALUE;
        for(int i = 1; i < path.length; i++){
            int fs = prev + Math.abs(path[i] - path[i-1]);
            if(i > 1){
                ss = prev2 + Math.abs(path[i] - path[i-2]);
            }
            int cur_i = Math.min(fs, ss);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;

//        Better
//        dp[0] = 0;
//        int ss = Integer.MAX_VALUE;
//        for(int i = 1; i < path.length; i++){
//            int fs = dp[i-1] + Math.abs(path[i] - path[i-1]);
//            if(i > 1){
//                ss = dp[i-2] + Math.abs(path[i] - path[i-2]);
//            }
//            dp[i] = Math.min(fs, ss);
//        }
//        return dp[path.length-1];

//        Brute
//        if(ind == 0){
//            return dp[ind] = 0;
//        }
//        if(dp[ind] != -1){
//            return dp[ind];
//        }
//        int left = frogJumps(path, dp, ind - 1) + Math.abs(path[ind] - path[ind - 1]);
//        int right = Integer.MAX_VALUE;
//        if(ind > 1){
//            right = frogJumps(path, dp, ind - 2) + Math.abs(path[ind] - path[ind - 2]);
//        }
//        return dp[ind] = Math.min(left, right);
    }

    public static int fibonacci(int n, int[] dp){

        int prev2 = 0;
        int prev1 = 1;
        for(int i = 2; i < n; i++){
            int cur_i = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur_i;
        }
        return prev1;

//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i = 2; i <= n; i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n-1];

//        Recursion
//        if(n <= 1){
//            return n;
//        }
//        if(dp[n] != -1){
//            return dp[n];
//        }
//        return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
    }

    public static void print(Object obj){
        System.out.println(obj + "\n");
    }

}
