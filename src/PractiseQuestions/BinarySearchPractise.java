package PractiseQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchPractise {

    public static void main(String[] args) {

//        int[] arr = new int[]{2,3,6,7,8,8,11,11,11,12};
//        print(binarySearchIterative(arr, 6));
//        print(binarySearchRecursive(arr, 0, arr.length - 1, 6));
//        print(lowerBoundSmallestIndex(arr, 11  , arr.length));
//        print(upperBoundSmallestIndex(arr, 11  , arr.length));
//        print(searchInsertPosition(arr, 5, arr.length));
//        print(floor(arr, 8));
//        print(ceil(arr, 8));
//        print(firstAndLastOccurringIndex(arr, 8));

//        int[] arr = new int[]{7,8,9,1,2,3,4,5,6};
//        print(searchElementInASortedArray(arr, 1));

        int[] arr = new int[]{7,8,9,1,2,3,3,3,4,5,6};
        print(searchElementInADuplicatedSortedArray(arr, 3));

    }
    public static int searchElementInADuplicatedSortedArray(int[] arr, int tar){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == tar){
                return mid;
            }
            if(arr[mid] == arr[low] && arr[mid] == arr[high]){
                low += 1;
                high -= 1;
                continue;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= tar && tar <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(arr[mid] <= tar && tar <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int searchElementInASortedArray(int[] arr, int tar){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == tar){
                return mid;
            }
            if(arr[low] <= arr[mid]){
                if(arr[low] <= tar && tar <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(arr[mid] <= tar && tar <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static String firstAndLastOccurringIndex(int[] arr, int x){

//       Optimal
        int[] ans = new int[2];
        ans[0] = firstIndex(arr, x);
        ans[1] = lastIndex(arr, x);
        return Arrays.toString(ans);

//        Brute
//        int[] ans = new int[2];
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] == x){
//                if(ans[0] == 0){
//                    ans[0] = i;
//                }
//                ans[1] = i;
//            }
//        }
//        return Arrays.toString(ans);
    }

    public static int firstIndex(int[] arr, int tar){
        int first = -1;
        int low = 0, high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == tar){
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < tar){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }

    public static int lastIndex(int[] arr, int tar){
        int last = -1;
        int low = 0, high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == tar){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < tar){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }

    public static int floor(int[] arr, int tar){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] <= tar){
                ans = arr[mid];
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(int[] arr, int tar){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= tar){
                ans = arr[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int searchInsertPosition(int[] arr, int tar, int n){
        return upperBoundSmallestIndex(arr, tar, n);
    }

    public static int upperBoundSmallestIndex(int[] arr, int tar, int n){
        int low = 0;
        int high = n - 1;
        int ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] > tar){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lowerBoundSmallestIndex(int[] arr, int tar, int n){
        int low = 0;
        int high = n - 1;
        int ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= tar){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int tar){
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if(arr[mid] == tar){
            return mid;
        }
        else if(tar > arr[mid]){
            return binarySearchRecursive(arr, mid + 1, high, tar);
        }
        return binarySearchRecursive(arr, low, mid - 1, tar);
    }

    public static int binarySearchIterative(int[] arr, int tar){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == tar){
                return mid;
            }
            else if(arr[mid] < tar){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void print(Object obj){
        System.out.println(obj);
    }

}
