public class LongestCommonSubstring {
    public static void main(String[] args) {
       String x = "xyzabcd";
       String y = "abcabcg";
        System.out.println(lcsDp(x,y,x.length(),y.length()));
        System.out.println(lcsRec(x,y,x.length(),y.length(),0));
    }
    private static int lcsDp(String x, String y, int n, int m){
        int[][] dp = new int[x.length()+1][y.length()+1];
        // initialisation
        int ans = 0;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 || j==0) dp[i][j] =0;
            }
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    if(dp[i][j] > ans) ans = dp[i][j];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    private static int lcsRec(String x , String y , int n , int m , int count){
        if(n==0 || m==0) return count;
        if(x.charAt(n-1) == y.charAt(m-1)){
            return lcsRec(x,y,n-1,m-1 , count+1);
        }else{
            return Math.max(lcsRec(x,y,n-1,m ,0) , lcsRec(x,y,n,m-1,0));
        }
    }
}
