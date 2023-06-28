public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5,2};
        int sum =0;
        boolean ans;
        for(int num : arr) sum += num;
        if(sum%2 != 0) ans = false;
        else ans = equalSum(arr,sum/2);
        System.out.println(ans);
    }
    private static boolean equalSum(int[] arr , int sum){
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }
        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][sum];
    }
}
