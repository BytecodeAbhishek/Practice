import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int wt [] = {1,3,4,5};
        int val [] = {1,4,5,7};
        System.out.println(knapsackRec(wt,val,7,4));
        int[][] dp = new int[wt.length+1][8]; // W +1
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(wt,val,7,4 ,dp));
        System.out.println(knapsack(wt,val,7,4));
    }
    // Recursive
    private static int knapsackRec(int[] wt , int[] val , int W , int n){
        if(W ==0 || n  == 0) return 0;
        if(wt[n-1] <= W){
            return Math.max( val[n-1] + knapsackRec(wt,val,W-wt[n-1] ,n-1)  ,
                    knapsackRec(wt,val,W,n-1));
        }
        return knapsackRec(wt,val,W,n-1);
    }
    // Memoization
    private static int knapsack(int[] wt , int[] val, int W, int n , int[][] dp){
        if(W ==0 || n == 0) return 0;
        if(dp[n][W] != -1) return dp[n][W];
        if(wt[n-1] <= W){
            return dp[n][W] = Math.max( val[n-1] + knapsack(wt,val,W-wt[n-1] ,n-1, dp)  ,
                    knapsack(wt,val,W,n-1, dp));
        }
        return dp[n][W] = knapsack(wt,val,W,n-1, dp);
    }
    // Top Down
    private static int knapsack(int[] wt , int[] val, int W, int n){
        int[][] dp = new int[n+1][W+1];
        // initialisation
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0 || j== 0) dp[i][j] = 0;
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}
