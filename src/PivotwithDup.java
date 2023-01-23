public class PivotwithDup {
    public static void main(String[] args) {
        int [] nums = {2,8,9,2,2,2};
        System.out.println(pivot(nums));
    }
    // rotation count is always equal to pivot+1;
    static int pivot(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            // 4 cases  over here
            int mid = start + (end-start)/2;
            if (mid < end && arr[mid] > arr[mid+1]) {

                return mid;
            }
            else if (mid > start && arr[mid] < arr[mid-1]){
                return mid-1;

            }
            // delete the duplicate elements
            if(arr[start] == arr[mid] && arr[end] == arr[mid]){
             //check whether start is the pivot
             if(arr[start] > arr[start+1])
                 return start;
             start++;
             //check if end is the pivot
             if(arr[end-1] > arr[end])
                 return end-1;
             end--;
            }
            //left hand side is sorted so pivot must be in the right hand side
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]))
                start = mid+1;
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
