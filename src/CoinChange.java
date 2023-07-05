import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //count1("",arr,4);
        //System.out.println(countCoins(arr,3,5));
        long[][] dp = new long[3+1][5+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(countMemo(arr,3,5,dp));
    }
    private static long countMemo(int[] coins, int N, int sum, long[][] dp){
        if(N==0){
            return sum==0 ? 1:0;
        }
        if(dp[N][sum] != -1) return dp[N][sum];
        if(coins[N-1] <= sum){
            return dp[N][sum] = countMemo(coins,N,sum-coins[N-1],dp)+
                    countMemo(coins,N-1,sum,dp);
        }else{
            return dp[N][sum] = countMemo(coins,N-1,sum,dp);
        }
    }
    public static long countCoins(int coins[], int N, int sum) {
        long[][] dp = new long[N+1][sum+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] =1;
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
    private static long count(int coins[], int index, int sum) {
        if(index == coins.length) {
            if (sum == 0) return 1;
            return 0;
        }
        int count =0;
        if(coins[index] <= sum){
            count += count(coins,index,sum-coins[index]);
        }
        count += count(coins,index+1,sum);
        return count;
//        return coins[index] < sum ? count(coins,index,sum-coins[index]) : count(coins,index+1,sum);
    }
    // this will give all possible combination so there will be repetition which we dont want
    private static void count1(String p , int[] arr , int sum){
        if(sum ==0){
            System.out.println(p);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= sum)
            count1(p+arr[i] ,arr, sum-arr[i]);
        }
    }
    // min coins required to form the sequence
    private static long minCoins(int[] coins , long[] dp , int sum){
        if(sum == 0) return 0;
        long ans = Long.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            if(sum - coins[i] >= 0){
                long subAns = 0;
                if(dp[sum-coins[i]] != -1){
                    subAns = dp[sum-coins[i]];
                }else{
                    subAns = minCoins(coins,dp,sum-coins[i]);
                }
                // tree m sabse chota hamara ans hoga
                if(subAns +1 < ans) ans = subAns+1;
            }
        }
        return dp[sum] = ans;
    }
}
