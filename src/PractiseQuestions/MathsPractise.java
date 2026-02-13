package PractiseQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MathsPractise {static int max = 1000000;
    static int[] spf = new int[max+1];

    public static void main(String[] args) {
//        System.out.println(reverse(-123));
//        System.out.println(gcd(3, 9));
//        printDivisiors(36);
//        System.out.println(checkPrime(41));
//        System.out.println(checkPrime(36));
//
//        printPrime(60);
//        printMathPow(2, 8);
//        printPrimeTillN(30);

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        MathsPractise obj = new MathsPractise();
        obj.sieve();
        while(q-->0){
            int x = sc.nextInt();
            printPrimeFactors(x);
        }
    }

    public void sieve(){
        for(int i = 1; i < max; i++){
            spf[i] = i;
        }
        for(int i = 2; i * i < max; i++){
            if(spf[i] == i){
                for(int j = i * i; j <= max; j+=i){
                    spf[j] = i;
                }
            }
        }
    }

    static void printPrimeFactors(int x){
        while(x!=1){
            System.out.print(spf[x] + " ");
            x = x / spf[x];
        }
        System.out.println();
    }

    public static void printPrimeTillN(int n){
        int[] prime = new int[n];

        // O(n)
        Arrays.fill(prime, 1);

        // N log(logN)
        for(int i = 2; i * i < n; i++){
            if(prime[i] == 1){
                for(int j = i * i; j < n; j+=i){
                    prime[j] = 0;
                }
            }
        }

        // O(n)
        for(int i = 2; i < n; i++){
            if(prime[i] == 1){
                System.out.println(i);
            }
        }
    }

    public static void printMathPow(int a, int b){
        int ans = 1;
        while(b>0){
            if(b%2==1){
                ans=ans*a;
                b=b-1;
            }
            else{
                b=b/2;
                a=a*a;
            }
        }
        System.out.print(ans);
    }

    public static void printPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n%i==0){
                while(n%i==0){
                    n=n/i;
                    System.out.println(i);
                }
            }

        }
        if (n > 1) {
            System.out.println(n);
        }

//        for(int i = 1; i < Math.sqrt(n); i++){
//            if(n%i == 0){
//                if(checkPrime(i)){
//                    System.out.println(i);
//                }
//                if(n/i != i){
//                    if(checkPrime(n/i)){
//                        System.out.println(n/i);
//                    }
//                }
//            }
//        }
    }

    public static boolean checkPrime(int n){
        for(int i = 2; i*i <= n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void printDivisiors(int a){
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i = 1; i*i <= a; i++){
            if(a%i == 0) {
                arr.add(i);
                if (a / i != i) {
                    arr.add(a/i);
                }
            }
        }
        System.out.println(arr);
    }

    public static int gcd(int a, int b){

        while(a>0&&b>0){
            if(a>b){
                a = a % b;
            }
            else{
                b = b % a;
            }
            if(a==0){
                return b;
            }
            else{
                return a;
            }
        }

//        for(int i = Math.min(a,b); i >= 0; i--){
//            if(a%i == 0 && b%i==0){
//                return i;
//            }
//        }
        return 0;
    }

    public static int reverse(int x) {
        long rn = 0;
        while(x!=0){
            int ln = x%10;
            rn = (rn*10)+ln;
            x=x/10;
        }
        if(rn<Integer.MIN_VALUE || rn > Integer.MAX_VALUE){
            return 0;
        }
        return (int)rn;
    }
}
