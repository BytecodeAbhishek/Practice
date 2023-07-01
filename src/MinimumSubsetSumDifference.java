public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
       int [] arr = {1,6,11,5};
       int sum =0;
       for(int num : arr) sum+= num;
       int sum1 = 0;
       for(int i=sum/2; i>=0; i--){
           if(equalSum(arr,i)){
               sum1 = i;
               break;
           }
       }
       int sum2 = sum- sum1;
        System.out.println("Min Diff : "+(sum2-sum1));
    }
    private static boolean equalSum(int[] arr , int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[arr.length][sum];
    }
    //another appr. take the full sum and pass it to the function the pickup the last row traverse it till half and
    // store the max value where the block is true
}
