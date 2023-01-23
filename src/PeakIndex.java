public class PeakIndex {
    public static void main(String[] args) {
        int [] arr = {0,1,0};
        System.out.println(PeakIndexOfMountainArray(arr));
        System.out.println(find(arr));
    }
    static int PeakIndexOfMountainArray(int[] arr){
        int start =1;
        int end = arr.length-2;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1]) {
                return mid;
            }
            else if (arr[mid] < arr[mid-1]) {
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return -1;
    }
    static int find(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid+1]) {
                // we are in the ascending part of the array
                end = mid; // because this may be my potential answer
            }
            else{
                start = mid +1;
                // int the end start == mid hence my answer is the max element
            }
        }
        return start;
    }
}
