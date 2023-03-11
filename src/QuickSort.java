import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
     int [] arr = {3,2,5,7,9,10};
     sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static  void sort (int[] arr , int low , int high){
        if (low >= high) {
            return;
        }
        int start = low ;
        int end = high;
        int mid = start + ( end - start)/2;
        while (start <= end ){
            while(arr[start] < arr[mid])
                start++;
            while(arr[end] > arr[mid]){
                end--;
            }
            // if array is already sorted we will not sort it again using this check
            // condition may be violated already so we need to put this check
            if ( start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        // pivot is at correct index sort the two halves
        sort(arr,low,end);
        sort(arr,start,high);
    }
}
