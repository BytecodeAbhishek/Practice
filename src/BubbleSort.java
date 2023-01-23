import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,57,1,6,42,3};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        // run the steps n-1 times
        for(int i =0; i<arr.length; i++ ){
            for( int j =1; j<arr.length-i; j++){
                if(arr[j] < arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                // or the bubble is swapped
            }
        }
    }
}
