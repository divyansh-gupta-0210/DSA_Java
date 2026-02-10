package PractiseQuestions;

import java.util.ArrayList;
import java.util.HashSet;

public class RecursionPractise {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2};

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
        ArrayList<Integer> fans = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
//        printSubSequence(0, arr, ans, arr.length);
//        printSubSequenceWhoseSumIsK(0, arr, ans, arr.length, 0, 3);
//        print(countSubSequenceWhoseSumIsK(0, arr, ans, arr.length, 0, 3));
//        combinationSumI(arr, 0, 7, ans);
//        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
//        combinationSumII(arr, 0, 4, ans, hashSet);
        subsetSum(arr, 0, fans, ans, 0);
    }

    public static void subsetSum(int[] arr, int i, ArrayList<Integer> fans, ArrayList<Integer> ans, int sum){



//        Brute
//        if(i == arr.length){
//            fans.add(sum);
//            System.out.println(ans + " " + fans);
//            return;
//        }
//        ans.add(arr[i]);
//        subsetSum(arr, i+1, fans, ans, sum+arr[i]);
//        ans.remove(ans.size()-1);
//        subsetSum(arr, i+1, fans, ans, sum);
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
