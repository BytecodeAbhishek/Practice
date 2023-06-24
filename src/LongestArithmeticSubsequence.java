public class LongestArithmeticSubsequence {
    public static void main(String[] args) {

    }
    private static int longestArithSeqLength(int[] nums) {
        int max =1;
        for(int i=0; i<nums.length-1; i++){
            for(int j= i+1; j<nums.length; j++){
                int a = nums[i];
                int d = nums[j] - a;
                int currMax = 1;
                for(int k=j; k<nums.length; k++){
                    if( a + d == nums[k]){
                        currMax++;
                        a = nums[k];
                    }
                }
                if(currMax > max) max = currMax;
            }
        }
        return max;
    }
}
