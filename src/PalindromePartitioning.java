import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg";
        System.out.println(pp(s,0,s.length()-1));
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp) Arrays.fill(row,-1);
        //System.out.println(ppMemo(s,0,s.length()-1,dp));
        System.out.println(ppOptimised(s,0,s.length()-1,dp));
    }
    private static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private static int pp(String s, int i, int j){
        if(i>=j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int tempAns = 1 + pp(s,i,k) + pp(s,k+1,j);
            ans = Math.min(ans,tempAns);
        }
        return ans;
    }
    private static int ppMemo(String s, int i, int j , int[][] dp){
        if(i>=j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int tempAns = 1 + pp(s,i,k) + pp(s,k+1,j);
            ans = Math.min(ans,tempAns);
        }
        return dp[i][j] = ans;
    }
    private static int ppOptimised(String s, int i, int j , int[][] dp){
        if(i>=j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int left =0;
            int right =0;
            if(dp[i][k] != -1) left = dp[i][k];
            else{
                left = ppOptimised(s,i,k,dp);
                dp[i][k] = left;
            }

            if(dp[k+1][j] != -1) right = dp[k+1][j];
            else{
                right = ppOptimised(s,k+1,j,dp);
                dp[k+1][j] = right;
            }

            int tempAns = 1 + left + right;
            ans = Math.min(ans,tempAns);
        }
        return dp[i][j] = ans;
    }
}
