public class SplitArrayLargestsum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums,k));
    }
    static int splitArray(int[] nums, int m) {
        int start  = nums[0];
        int end = 0;
        for(int i=0 ; i< nums.length; i++){
            end = end+nums[i];
            if (start < nums[i]) {
                start = nums[i];
            }
        }
        while(start < end){
            int mid = (start + end)/2;
            int count =1;
            int sum =0;
            for(int i =0 ; i<nums.length; i++){
                sum = sum+nums[i];
                if(sum > mid){
                   sum = 0;
                   i--;
                   count++;
                }
            }
            if(count <= m){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}
