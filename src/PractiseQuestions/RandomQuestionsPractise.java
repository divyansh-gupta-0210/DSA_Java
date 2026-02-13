package PractiseQuestions;

import static PractiseQuestions.ArraysPractise.*;

public class RandomQuestionsPractise {

    public static void main(String[] args) {
        int[] arr = {-11,-21,2,3,-1,-2};
//        moveNegativesAtEnd(arr);
        maxSubArrary(arr);
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
