import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
       int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
    private static int minSubArrayLen(int target, int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int currSum =0;
        int start =-1;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(currSum - target == 0){
                start =0;
                if(minLength > i-start +1) minLength = i-start +1;
            }
            if(map.containsKey(currSum - target)){
                start = map.get(currSum-target)+1;
                if(minLength > i-start +1) minLength = i-start+1;
            }
            map.put(currSum,i);
        }
        return minLength == Integer.MAX_VALUE  ? 0 : minLength;
    }
}
