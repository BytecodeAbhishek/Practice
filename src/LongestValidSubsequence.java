public class LongestValidSubsequence {
    public static void main(String[] args) {
        // leetcode daily problem with dp approach
//        You choose any number of obstacles between 0 and i inclusive
//        You must include the ith obstacle in the course
//        You must put the chosen obstacles in the same order as they appear in obstacles
//        Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it
    }
    private int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ans = new int[obstacles.length];
        int j=0;
        // dp tp store valid sequences
        int[] dp = new int[obstacles.length];
        int length =0;
        while(j<obstacles.length){
            int left =0;
            int right = length;
            while(left < right){
                int mid = left + (right-left)/2;
                if(dp[mid] <= obstacles[j]) left = mid+1;
                else right = mid;
            }
            ans[j] = left+1;
            if(left == length) length++;
            dp[left] = obstacles[j++];
        }
        return ans;
    }
}
