import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KRadiusSubarrayAverages {
    // leetcode 2090
    public static void main(String[] args) {
        int[] nums = {100000};
        System.out.println(Arrays.toString(getAverages(nums,2)));
    }
    private static int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Map<Integer , Integer> map = new HashMap<>();
        Integer currSum = 0;
        int start = 0;
        int divisor = 2*k + 1;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            map.put(i,currSum);
            if(i<k || nums.length-i <= k) ans[i] = -1;
            if( i == 2*k){
                ans[i-k] = map.get(i)/divisor;
            }
            else if (i>2*k){
                System.out.println(map.get(i));
                ans[i-k] = (map.get(i)- map.get(start++))/divisor;
            }
        }
        return ans;
    }
}
