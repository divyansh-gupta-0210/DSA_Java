package PractiseQuestions;

import java.util.ArrayList;

public class BitmanipulationPractise {

    public static void main(String[] args) {
//        convertToBinary(13);
//        System.out.println(convert2Decimal("1101"));
//        System.out.println(13&4);
//        System.out.println(countSetBits(13));
        System.out.println(powerSet(new int[]{1,2,3}));
        System.out.println((1&(1<<0)) != 0);
    }

    public static ArrayList<ArrayList<Integer>> powerSet(int[] arr){
        int subSets = 1 << arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int num = 0; num <= subSets-1; num++){
            ArrayList<Integer> subArr = new ArrayList<>();
            for(int i = 0; i <= arr.length; i++){
                if((num & (1<<i)) != 0){
                    subArr.add(arr[i]);
                }
            }
            ans.add(subArr);
        }
        return ans;
    }

    public static int countSetBits(int n){
        int c = 0;
        while(n>1){
            c = c + n&1;
            n = n>>1;
        }
        if (n == 1) {
            c++;
        }
        return c;
    }

    public static int convert2Decimal(String s){
        int len = s.length();
        int num = 0;
        int p2 = 1;
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i)=='1'){
                num = num + p2;
            }
            p2 = p2 * 2;
        }
        return num;
    }

    public static void convertToBinary(int n){
        String res = "";
        while(n!=1){
            if(n%2==1){
                res=res+"1";
            }
            else{
                res=res+"0";
            }
            n=n/2;
        }
        if(n==1){
            res=res+"1";
        }
        System.out.println(reverse(res));
    }
    public static String reverse(String s){
        String reversed = "";
        for(int i = s.length()-1; i >= 0; i--){
            reversed+=s.charAt(i);
        }
        return reversed;
    }
}
