public class RotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {5,1,3};
        int target = 5;
        System.out.println(search(nums , target));
    }
    static int search(int[] nums, int target) {
        int pivot = pivot(nums);
        if(index(nums,0,pivot,target) != -1) {
            return index(nums, 0, pivot, target);
        }
        return index(nums,pivot+1,nums.length-1,target);
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
            else if (arr[mid] <= arr[start])
                end = mid -1;
            else
                start = mid+1;
        }
        return -1;
    }
    static int index (int[] nums , int start , int end , int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < nums[mid]) {
                end = mid-1;
            }
            else if (target > nums[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
