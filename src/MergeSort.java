import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
     int [] arr = {8,3,4,12,5,6};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    // method to return arr
    static int[] mergeSort (int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int [] left =  mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    // method to merge the array after sorting them
    static int[] merge(int [] left , int [] right){
        int [] newarr = new int[left.length+ right.length];
        int i = 0;
        int j =0;
        int k =0;
        while (i< left.length && j < right.length){
            if (left[i] < right [j]){
                newarr[k] = left[i];
                i++;
            }
            else {
                newarr[k] = right[j];
                j++;
            }
            k++;
        }
        // it may be possible one of the arrays is not completed
        // adding remaining elements of left arr
        while(i < left.length){
            newarr[k] = left[i];
            i++;
            k++;
        }
        // adding remaining elements of right arr
        while(j < left.length){
            newarr[k] = right[j];
            j++;
            k++;
        }
        return newarr;
    }
}
