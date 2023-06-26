public class RotateArray {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        if(k<0) rotations = nums.length -k;
        // reverse first half of the array
        reverse(nums,0,nums.length-rotations-1);
        // reverse the second half
        reverse(nums,nums.length-rotations,nums.length-1);
        //reverse the whole array
        reverse(nums,0,nums.length-1);
    }
    private static void reverse(int[] nums , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
