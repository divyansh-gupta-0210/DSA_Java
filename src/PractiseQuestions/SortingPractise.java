package PractiseQuestions;

import java.util.ArrayList;

public class SortingPractise {
    public static void main(String[] args) {
        int[] arr = new int[]{13,46,24,52,20,9};
//        mergeSort(arr, 0, arr.length-1);
//        quickSort(arr, 0, arr.length - 1);
//        selectionSort(arr);
//        bubbleSort(arr);
        insertionSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void insertionSort(int[] arr){
        for(int i = 0; i <= arr.length-1; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i >= 1; i--){
            int didSwap = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap == 0){
                break;
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i <= arr.length-2; i++){
            int mini = i;
            for(int j = i; j <= arr.length-1; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
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
