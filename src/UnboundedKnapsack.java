public class UnboundedKnapsack {
    public static void main(String[] args) {
        int wt [] = {1,3,4,5};
        int val [] = {1,4,5,7};
        System.out.println(kp(wt,val,7,4));
        System.out.println(unboundKp(wt,val,7));
    }
    // unlimited supply
    //Recursive Code
    private static int kp(int[] wt , int[] val, int capacity , int n){
        if(capacity == 0 || n == 0){
            return 0;
        }
        if(wt[n-1] <= capacity){
            return Math.max(val[n-1]+kp(wt,val,capacity-wt[n-1],n),kp(wt,val,capacity,n-1));
        }
        return kp(wt,val,capacity,n-1);
    }
    private static int unboundKp(int[] wt, int[] val, int capacity){
        int[][] dp = new int[wt.length+1][capacity+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[wt.length][capacity];
    }
}
