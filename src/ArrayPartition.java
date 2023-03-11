import java.util.Arrays;

public class ArrayPartition {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(arrayPairSum(arr));
    }
    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum =0;
        for(int i=0; i<nums.length-1; i += 2){
            if(nums[i] < nums[i+1]){
                sum += nums[i];
            }else{
                sum += nums[i+1];
            }
        }
        return sum;
    }
}
