public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        System.out.println(SCS(x,y,x.length(),y.length()));
        printScs("acbcf","abcdaf");
    }
    private static int SCS(String x , String y , int n , int m){
        // calculate Lcs and subtract it from the total length
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
        return n+m - dp[n][m];
    }
    private static void printScs(String x, String y){
        // calculate Lcs and subtract it from the total length
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
        int i = x.length();
        int j = y.length();
        String ans = "";
        while(i>0 && j>0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                ans = x.charAt(i-1)+ans;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    ans = x.charAt(i-1)+ans;
                    i--;
                }
                else{
                    ans = y.charAt(j-1)+ans;
                    j--;
                }
            }
        }
        while(i>0){
            ans = x.charAt(i-1)+ans;
            i--;
        }
        while(j>0){
            ans = y.charAt(j-1)+ans;
            j--;
        }
        System.out.println(ans);
    }
}
