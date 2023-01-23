public class Ceiling {
    public static void main(String[] args) {
        int arr [] = {2, 3, 5, 9, 14, 16, 18};
        int target =7;
        System.out.println(search(arr , target));
    }
    static  int search (int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        if(target > arr[arr.length-1])
            return -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return arr[mid];
            else if (arr[mid] > target){
                 end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        //int value = 0;
        //or (int i =0; i<= arr.length; i++){
           // if(arr[i] > target){
                //value = arr[i];
               /// break;
       // }
   // }
        return arr[start]; // in case of ceiling of floor we have to find the least greatest element >= on
                           // condition breking start will be the answer and vice versa for floor
                           // because the condition is violated when s > e
}
}
