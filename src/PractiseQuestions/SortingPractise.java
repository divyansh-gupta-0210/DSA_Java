package PractiseQuestions;

import java.util.ArrayList;

public class SortingPractise {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,2,5,7,9,1,3};
//        mergeSort(arr, 0, arr.length-1);
        quickSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int partitionIndex = f(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int f(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high;
        while(i<j){
            while(arr[i] <= pivot && i < high){
                i++;
            }
            while(arr[j] > pivot && j >= low){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        System.out.println("PIVOT Index: " + j + " PIVOT number: " +arr[j]);
        return j;
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){

        int left = low;
        int right = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
