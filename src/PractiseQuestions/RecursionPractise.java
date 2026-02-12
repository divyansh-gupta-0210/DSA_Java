package PractiseQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RecursionPractise {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};

//        printNameNTimes(0, 5);
//        printNTo1(5);
//        print1ToNWithBacktracking(5);
//        printSum(3, 0);
//        print(printSumDifferently(3));
//        print(printFact(5));
//        reverseAnArray(arr, 0, arr.length-1);
//        print(checkIfStringIsPalindrome("racecar", 0));
//        printArr(arr);
//        print(fibonacciNumber(5));
        ArrayList<Integer> ans = new ArrayList<>();
//        printSubSequence(0, arr, ans, arr.length);
//        printSubSequenceWhoseSumIsK(0, arr, ans, arr.length, 0, 3);
//        print(countSubSequenceWhoseSumIsK(0, arr, ans, arr.length, 0, 3));
//        combinationSumI(arr, 0, 7, ans);
        ArrayList<ArrayList<String>> finalAns = new ArrayList<>();
//        combinationSumII(arr, 0, 4, ans, hashSet);
//        subsetSum(arr, 0, ans, 0);
//        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> fans = new ArrayList<>();

//        subSets(arr, 0, ans, fans);

//        boolean[] used = new boolean[arr.length];
//        permutations(arr, 0, ans, fans);
        findKthPermutation(4, 17);

//        nQueens(30);
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };

//        solveSudoko(board);
//        print(construct(board));
//        palindromicPartition(0, "aabb", finalAns, ans);
//        int[][] maze = {
//                {1,0,0,0},
//                {1,1,0,1},
//                {1,1,0,0},
//                {0,1,1,1}
//        };
//        ratInAMaze(4, maze);
//        print(finalAns);
    }

    public static void findKthPermutation(int n, int k){
        int fact = 1;
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i < n; i++){
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        System.out.println(nums + " : " + fact);
        String ans = "";
        k = k - 1;
        while(true){
            System.out.println(ans + " " + fact + " k " + k);
            ans += nums.get(k / fact);
            nums.remove(k / fact);
            if(nums.isEmpty()){
                break;
            }
            k = k % fact;
            fact = fact / nums.size();
            System.out.println("After processing " + ans + " " + fact);
        }
        print("FINAL ANS "+ ans);
    }

    public static void ratInAMaze(int n, int[][] maze){
        ArrayList<String> finalAns = new ArrayList<>();
        if(maze[0][0] == 0){
            print(finalAns);
        }
        boolean[][] vis = new boolean[n][n];
        solveRatInAMaze(0, 0, maze, n, finalAns, "", vis);
        print(finalAns);
    }

    public static void solveRatInAMaze(int i, int j, int[][] maze, int n, ArrayList<String> ans, String move, boolean[][] vis){
        if(i == n - 1 && j == n-1){
            print(move);
            ans.add(move);
            return;
        }

        // check Down -> Left -> Right -> Up
        if(i+1<n && !vis[i+1][j] && maze[i+1][j] == 1){
            vis[i][j] = true;
            solveRatInAMaze(i+1, j, maze, n, ans, move + "D", vis);
            vis[i][j] = false;
        }
        if(j+1<n && !vis[i][j+1] && maze[i][j+1] == 1){
            vis[i][j] = true;
            solveRatInAMaze(i, j+1, maze, n, ans, move + "L", vis);
            vis[i][j] = false;
        }
        if(j-1>0 && !vis[i][j-1] && maze[i][j-1] == 1){
            vis[i][j] = true;
            solveRatInAMaze(i, j-1, maze, n, ans, move + "R", vis);
            vis[i][j] = false;
        }
        if(i-1>0 && !vis[i-1][j] && maze[i-1][j] == 1){
            vis[i][j] = true;
            solveRatInAMaze(i-1, j, maze, n, ans, move + "U", vis);
            vis[i][j] = false;
        }
    }

    public static void palindromicPartition(int ind, String s, ArrayList<ArrayList<String>> finalAns, ArrayList<String> ans){
        if(ind == s.length()){
            finalAns.add(new ArrayList<>(ans));
            return;
        }

        for(int i = ind; i < s.length(); i++) {
            if (isPalindrome(s, ind, i)) {
                ans.add(s.substring(ind, i+1));
                palindromicPartition(i+1, s, finalAns, ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }

    public static boolean solveSudoko(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;

                            if(solveSudoko(board)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char c){

        for(int i = 0; i < 9; i++){
            //check row
            if(board[i][col] == c){
                return false;
            }

            // check col
            if(board[row][i] == c){
                return false;
            }

            // check diagonals
            if(board[3*(row/3)+i/3][3*(col/3)+i%3] == c){
                return false;
            }

        }

        return true;
    }

    public static void nQueens(int n){
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        solveNQueens(0, ans, board, n);
    }

    public static void solveNQueens(int col, ArrayList<ArrayList<String>> ans, char[][] board, int n){
        if(col == n){
            ans.add(new ArrayList<>(construct(board)));
            print(construct(board));
            return;
        }
        for(int row = 0; row < n; row++){
            if(ifSafe(row, col, board, n)){
                board[row][col] = 'Q';
                solveNQueens(col + 1, ans, board, n);
                board[row][col] = '.';
            }
        }
    }

    public static boolean ifSafe(int row, int col, char[][] board, int n){

        //check left size only
        int duprow = row;
        int dupcol = col;

        //check upper left
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--; col--;
        }

        //check left row
        col = dupcol; row = duprow;
        while(col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        //check lower left
        col = dupcol; row = duprow;
        while(row<n && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++; col--;
        }

        return true;
    }

    private static ArrayList<String> construct(char[][] board) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

//    public static void permutations(int[] arr, boolean[] used, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> finalAns){
    public static void permutations(int[] arr, int ind, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> finalAns){
//        Optimal
        if(ind == arr.length){
            ans = new ArrayList<>();
            for(int i : arr){
                ans.add(i);
            }
            print(ans);
            finalAns.add(new ArrayList<>(ans));
            return;
        }
        for(int i = ind; i < arr.length; i++){
            swap(arr, ind, i);
            permutations(arr, ind+1, ans, finalAns);
            swap(arr, ind, i);
        }

//        Brute
//        if(ans.size() == arr.length){
//            print(ans);
//            finalAns.add(new ArrayList<>(ans));
//            return;
//        }
//
//        for(int i = 0; i < arr.length; i++){
//            if(used[i]){
//                continue;
//            }
//            used[i] = true;
//            ans.add(arr[i]);
//            permutations(arr, used, ans, finalAns);
//            ans.remove(ans.size()-1);
//            used[i] = false;
//        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void subSets(int[] arr, int ind, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> hashSet){

//        Optimal
        if(ind == arr.length){
            print(ans);
            hashSet.add(new ArrayList<>(ans));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            if(i!=ind && arr[i] == arr[i-1]){
                continue;
            }
            ans.add(arr[i]);
            subSets(arr, i+1, ans, hashSet);
            ans.remove(ans.size()-1);
        }

//        Brute
//        if(ind == arr.length){
//            hashSet.add(new ArrayList<>(ans));
//            return;
//        }
//        ans.add(arr[ind]);
//        subSets(arr, ind+1, ans, hashSet);
//        ans.remove(ans.size()-1);
//        subSets(arr, ind+1, ans, hashSet);
    }

    public static void subsetSum(int[] arr, int i, ArrayList<Integer> ans, int sum){

        if(i == arr.length){
            ans.add(sum);
            return;
        }
        subsetSum(arr, i+1, ans, sum+arr[i]);
        subsetSum(arr, i+1, ans, sum);

//        Brute
//        if(i == arr.length){
//            fans.add(sum);
//            System.out.println(ans + " " + fans);
//            return;
//        }
//        ans.add(arr[i]);
//        subsetSum(arr, i+1, ans, sum+arr[i]);
//        ans.remove(ans.size()-1);
//        subsetSum(arr, i+1, ans, sum);
    }

    public static void combinationSumII(int[] arr, int i, int target, ArrayList<Integer> ans, HashSet<ArrayList<Integer>> hashSet){

//        Optimal
        if(target == 0){
            hashSet.add(new ArrayList<>(ans));
            System.out.println(ans);
            return;
        }
        for(int j = i; j < arr.length; j++){
            if(j > i && arr[j] == arr[j-1]){
                continue;
            }
            if(arr[j] > target){
                break;
            }
            ans.add(arr[j]);
            combinationSumII(arr, j+1, target - arr[j], ans, hashSet);
            ans.remove(ans.size()-1);
        }

//        Brute
//        if(target == 0){
//            hashSet.add(new ArrayList<>(ans));
//            return;
//        }
//
//        if(target < 0 || i == arr.length){
//            return;
//        }
//
//        if(arr[i] <= target){
//            ans.add(arr[i]);
//            combinationSumII(arr, i+1, target-arr[i], ans, hashSet);
//            ans.remove(ans.size()-1);
//        }
//        combinationSumII(arr, i+1, target, ans, hashSet);
    }

    public static void combinationSumI(int[] arr, int i, int target, ArrayList<Integer> ans){
        if(target == 0){
            System.out.println(ans);
            return;
        }

        if(target < 0 || i == arr.length){
            return;
        }

        if(arr[i] <= target){
            ans.add(arr[i]);
            combinationSumI(arr, i, target-arr[i], ans);
            ans.remove(ans.size()-1);
        }
        combinationSumI(arr, i+1, target, ans);
    }

    public static int countSubSequenceWhoseSumIsK(int i, int[] arr, ArrayList<Integer> ans, int n, int toGet, int sum){
        if(i == n){
            if(toGet == sum){
                print(ans);
                return 1;
            }
            else{
                return 0;
            }
        }
        // take
        ans.add(arr[i]);
        int l = countSubSequenceWhoseSumIsK(i+1, arr, ans, n, toGet + arr[i], sum);

        // backtrack
        ans.remove(ans.size()-1);
        int r = countSubSequenceWhoseSumIsK(i+1, arr, ans, n, toGet, sum);
        return l+r;
    }

    public static boolean printSubSequenceWhoseSumIsK(int i, int[] arr, ArrayList<Integer> ans, int n, int toGet, int sum){
        if(i == n){
            if(toGet == sum){
                print(ans);
                return true;
            }
            else{
                return false;
            }
        }
        // take
        ans.add(arr[i]);
        if(printSubSequenceWhoseSumIsK(i+1, arr, ans, n, toGet + arr[i], sum)){
            return true;
        }

        // backtrack
        ans.remove(ans.size()-1);
        if(printSubSequenceWhoseSumIsK(i+1, arr, ans, n, toGet, sum)){
            return true;
        }
        return false;
    }

    public static void printSubSequence(int i, int[] arr, ArrayList<Integer> ans, int n){
        if(i==arr.length){
            print(ans);
            return;
        }
        ans.add(arr[i]);
        printSubSequence(i + 1, arr, ans, arr.length);
        ans.remove(ans.size()-1);
        printSubSequence(i+1, arr, ans, arr.length);
    }

    public static int fibonacciNumber(int n){
        if(n <= 1){
            return n;
        }
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    public static boolean checkIfStringIsPalindrome(String s, int i){
        if(i>=s.length()/2){
            return true;
        }
        if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return false;
        }
        return checkIfStringIsPalindrome(s, i+1);
    }

    public static void reverseAnArray(int[] arr, int l, int r){
        if(l>=r){
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverseAnArray(arr, l+1, r-1);
    }

    public static int printFact(int n){
        if(n==0||n==1){
            return 1;
        }
        return n * printFact(n-1);
    }

    public static int printSumDifferently(int n){
        if(n==0){
            return 0;
        }
        return n + printSumDifferently(n-1);
    }

    public static void printSum(int i, int sum){
        if(i < 1){
            print(sum);
            return;
        }
        printSum(i-1, sum+i);
    }

    public static void print1ToNWithBacktracking(int n){
        if(n<1){
            return;
        }
        print1ToNWithBacktracking(n-1);
        print(n);
    }

    public static void printNTo1(int n){
        if(n==0){
            return;
        }
        print(n);
        printNTo1(n-1);
    }

    public static void printNameNTimes(int i, int n){
        if(i==n){
            return;
        }
        print("Divyansh " + i);
        printNameNTimes(i+1, n);
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            print(arr[i]);
        }
        System.out.println();
    }

    public static void print(Object object){
        System.out.println(object + " ");
    }

}
