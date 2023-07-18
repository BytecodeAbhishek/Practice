public class LargestRepeatingSubsequence {
    public static void main(String[] args) {
        System.out.println(lrs("aabebcdd"));
    }
    private static int lrs(String a){
        String b = a;
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if (i==0 || j==0) dp[i][j] =0;
            }
        }
        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(a.charAt(i-1) == b.charAt(j-1) && i != j){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
