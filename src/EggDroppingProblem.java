import java.util.Arrays;

public class EggDroppingProblem {
    public static void main(String[] args) {
        System.out.println(solve(5,10));
        int e =5;
        int f = 10;
        int[][] dp = new int[e+1][f+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        //System.out.println(solveMemo(e,f,dp));
        System.out.println(solveOptimisation(e,f,dp));
    }
    private static int solve(int e, int f) {
        if (f == 0 || f == 1) return f;
        if(e==1) return f;
        int ans = Integer.MAX_VALUE;

        for(int k=1; k<=f; k++){
            int tempAns = 1 + Math.max(solve(e-1,k-1),solve(e,f-k));
            ans = Math.min(tempAns,ans);
        }
        return ans;
    }

    private static int solveMemo(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) return f;
        if(e==1) return f;
        int ans = Integer.MAX_VALUE;

        if(dp[e][f] != -1) return dp[e][f];
        for(int k=1; k<=f; k++){
            int tempAns = 1 + Math.max(solveMemo(e-1,k-1,dp),solveMemo(e,f-k,dp));
            ans = Math.min(tempAns,ans);
        }
        return dp[e][f] = ans;
    }

    private static int solveOptimisation(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) return f;
        if(e==1) return f;
        int ans = Integer.MAX_VALUE;

        if(dp[e][f] != -1) return dp[e][f];
        for(int k=1; k<=f; k++){
            int breaking;
            int notBreak;
            if(dp[e-1][k-1] != -1) breaking = dp[e-1][k-1];
            else{
                breaking = solveOptimisation(e-1,k-1,dp);
                dp[e-1][k-1] = breaking;
            }
            if(dp[e][f-k] != -1) notBreak = dp[e][f-k];
            else{
                notBreak = solveOptimisation(e,f-k,dp);
                dp[e][f-k] = notBreak;
            }
            int tempAns = 1 + Math.max(breaking,notBreak);
            ans = Math.min(tempAns,ans);
        }
        return dp[e][f] = ans;
    }
}
