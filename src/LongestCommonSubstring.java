public class LongestCommonSubstring {
    public static void main(String[] args) {
       String x = "xyzabc";
       String y = "abcabc";
        System.out.println(lcsDp(x,y,x.length(),y.length()));
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
                    dp[i][j] = 0;
                }
            }
        }
        return dp[x.length()][y.length()];
    }
}
