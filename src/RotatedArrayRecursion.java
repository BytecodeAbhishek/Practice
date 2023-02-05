public class RotatedArrayRecursion {
    public static void main(String[] args) {
     int [] arr = {4,5,6,7,8,9,10,1,2};
     int target = 7;
        System.out.println(search(arr,target,0, arr.length-1));
    }
    static int search (int[] arr , int target , int start , int end){
        if (start > end){
            return -1;
        }
        int m = start + (end-start)/2;
        if (arr[m] == target){
            return m;
        }
        if(arr[start] <= arr[m]){
            if ( target >= arr[start] && arr[m] >= target ){
                return search(arr,target,start,m-1);
            }
        }
        if ( target >= arr[m] && target <=arr[end]){
            return search(arr,target,m+1,end);
        }
        else {
            return search(arr,target,start,m-1);
        }
    }
}
