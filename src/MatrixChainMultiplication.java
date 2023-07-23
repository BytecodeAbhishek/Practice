import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
       int[] arr ={40,20,30,10,30};
        System.out.println(mcm(arr,1, arr.length-1));
        int[][] dp = new int[2][arr.length];
        for(int[] row : dp) Arrays.fill(row,-1);
        System.out.println(mcmMemo(arr,1, arr.length-1, dp));
    }
    private static int mcm(int[] arr, int i, int j){
        if(i>=j) return 0;
        int ans =Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int tempAns = mcm(arr,i,k)+mcm(arr,k+1,j)+ (arr[i-1]*arr[k]*arr[j]);
            ans = Math.min(ans,tempAns);
        }
        return ans;
    }
    private static int mcmMemo(int[] arr, int i, int j , int[][] dp){
        if(i>=j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans =Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int tempAns = mcm(arr,i,k)+mcm(arr,k+1,j)+ (arr[i-1]*arr[k]*arr[j]);
            ans = Math.min(ans,tempAns);
        }
        return dp[i][j] = ans;
    }
}
