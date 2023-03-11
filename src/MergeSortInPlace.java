import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
      int [] arr = {5,4,3,2,1};
      mergeSort(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr , int start , int end){
        if (end - start == 1){
            return;
        }
        int mid = (start + end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid,end);
        merge(arr,start,mid,end);
    }
    static void merge(int[] arr , int start , int mid , int end){
        int [] newarr = new int[end- start];
        int i = start;
        int j =mid;
        int k =0;
        while (i< mid && j < end){
            if (arr[i] < arr [j]){
                newarr[k] = arr[i];
                i++;
            }
            else {
                newarr[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible one of the arrays is not completed
        // adding remaining elements of left arr
        while(i < mid){
            newarr[k] = arr[i];
            i++;
            k++;
        }
        // adding remaining elements of right arr
        while(j < end){
            newarr[k] = arr[j];
            j++;
            k++;
        }
        for(int l =0 ; l < newarr.length; l++){
            arr[start+l] = newarr[l];
        }
    }
}
