import java.util.Arrays;

public class SelectionSort {
    //select an element place at its right position
    // O(n^2)
    public static void main(String[] args) {
        int [] arr = {1,6,5,2,9};
        Selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static  void Selection(int [] arr ){
        for (int i =0; i< arr.length; i++){
            int last = arr.length-i-1;
            int max = getMaxIndex(arr,0,last);
            swap(arr, max, last);
        }
    }
    static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    static int getMaxIndex(int [] arr , int start , int end){
        int max = start;
        for(int i =start; i<=end; i++){
            if (arr[max] < arr[i]) {
                max =i;
            }
        }
        return max;
    }
}
