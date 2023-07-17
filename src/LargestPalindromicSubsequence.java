public class LargestPalindromicSubsequence {
    public static void main(String[] args) {
        String x = "agbcba";
        System.out.println(lpSubsequence(x));
    }
    // for subsequence
    private static int lpSubsequence(String x){
        StringBuilder sb = new StringBuilder(x);
        String y = sb.reverse().toString();
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

    // leetcode 5. Longest Palindromic Substring
    public String longestPalindrome(String s) {
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev += s.charAt(i);
        }
        return lcs(s,rev,s.length(),rev.length());
    }
    private String  lcs(String x, String y, int n, int m){
        int[][] dp = new int[x.length()+1][y.length()+1];
        // initialisation
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i==0 || j==0) dp[i][j] =0;
            }
        }
        String ans = "";
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    if(dp[i][j] > ans.length()){
                        String temp = x.substring(i-dp[i][j] , i);
                        StringBuilder sb = new StringBuilder(temp);
                        String rev = sb.reverse().toString();
                        if(temp.equals(rev)) ans = temp;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
