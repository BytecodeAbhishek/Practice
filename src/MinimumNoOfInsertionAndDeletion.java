public class MinimumNoOfInsertionAndDeletion {
    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";
        System.out.println(convert(a,b,a.length(),b.length()));
    }
    // convert a --> b
    private static int convert(String a, String b, int n, int m){
        int[][] dp = new int[a.length()+1][b.length()+1];
        // initialisation
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 || j==0) dp[i][j] =0;
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]);
                }
            }
        }
        int deletion = a.length() - dp[n][m];
        int insertion = b.length() - dp[n][m];
        return deletion + insertion;
    }
}
