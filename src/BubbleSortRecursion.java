import java.util.Arrays;

public class BubbleSortRecursion {
    public static void main(String[] args) {
       int [] arr = {4,3,2,1,2};
       bubble(arr.length-1,0 , arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble (int last , int first , int [] arr){
        if (last == 0){
            return;
        }
        if (first < last) {
            if (arr[first] > arr[first + 1]) {
                // swap
                int temp = arr[first];
                arr[first] = arr[first + 1];
                arr[first + 1] = temp;
            }
            bubble(last, first + 1, arr);
        }
        else{
            bubble(last-1,0,arr);
        }
    }
}
