public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhg";
        System.out.println(lcsRec(x,y,x.length(),y.length()));
        int[][] dp = new int[x.length()+1][y.length()+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(lcsMemo(x,y,x.length(),y.length(),dp));
        System.out.println(lcsDp(x,y,x.length(),y.length()));
    }
    // subsequence can be discontinuous whereas substring is continuous
    // Recursive code
    private static int lcsRec(String x , String y , int n , int m){
       if(n==0 || m==0) return 0;
       if(x.charAt(n-1) == y.charAt(m-1)){
           return lcsRec(x,y,n-1,m-1)+1;
       }else{
           return Math.max(lcsRec(x,y,n-1,m) , lcsRec(x,y,n,m-1));
       }
    }
    private static int lcsMemo(String x, String y, int n, int m, int[][] dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(x.charAt(n-1) == y.charAt(m-1)){
            return dp[n][m] = lcsRec(x,y,n-1,m-1)+1;
        }else{
            return dp[n][m] = Math.max(lcsRec(x,y,n-1,m) , lcsRec(x,y,n,m-1));
        }
    }
    private static int lcsDp(String x, String y, int n, int m){
        int[][] dp = new int[x.length()+1][y.length()+1];
        // initialisation
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
               if(i==0 || j==0) dp[i][j] =0;
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]);
                }
            }
        }
        return dp[x.length()][y.length()];
    }
}
