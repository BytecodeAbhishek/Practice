import java.util.Arrays;

public class InsertionSortRecursion {
    public static void main(String[] args) {
     int [] arr = {2,6,3,4,1};
     insertion(arr,1,1);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion (int [] arr , int first , int c){
        if ( first == arr.length){
            return;
        }
        if (first > 0 ){
            if (arr[first] < arr[first-1]){
                // swap
                int temp = arr[first];
                arr[first] = arr[first-1];
                arr[first-1] = temp;
            }
            insertion(arr, first-1,c);
        }
        else {
            insertion(arr,c+1,c+1);
        }
    }
}
