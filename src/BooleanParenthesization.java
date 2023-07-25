import java.util.ArrayDeque;
import java.util.Arrays;

public class BooleanParenthesization {
    public static void main(String[] args) {
        System.out.println(solve("T^F&T",0,4,1));
        String s = "T^F&T";
        int[][][] dp= new int[s.length()+1][s.length()+1][2];
        for(int[][] row : dp){
            for(int[] col : row) Arrays.fill(col,-1);
        }
        System.out.println(memo(s,0,s.length()-1,1,dp));
    }
    private static int solve(String s, int i, int j, int isTrue){
        if(i>j) return 0;

        if(i==j){
            if(isTrue == 1) return s.charAt(i) == 'T' ? 1:0;
            else return s.charAt(i) == 'F' ? 1:0;
        }
        int ans =0;
        for(int k=i+1; k<j; k+=2){
            int lT = solve(s,i,k-1,1);
            int lF = solve(s,i,k-1,0);
            int rT = solve(s,k+1,j,1);
            int rF = solve(s,k+1,j,0);

            if(s.charAt(k) == '&'){
                if(isTrue == 1) ans += lT*rT;
                else ans += lF*rF + lT*rF + lF*rT;
            }
            else if(s.charAt(k) == '|'){
                if(isTrue == 1) ans += lT*rT + lT*rF + lF*rT;
                else ans += lF*rF;
            }
            else if(s.charAt(k) == '^'){
                if(isTrue==1) ans += lF*rT + lT*rF;
                else ans += lF*rF + lT*rT;
            }
        }
        return ans;
    }
    private static int memo(String s, int i, int j, int isTrue, int[][][] dp){
        if(i>j) return 0;

        if(i==j){
            if(isTrue == 1) return s.charAt(i) == 'T' ? 1:0;
            else return s.charAt(i) == 'F' ? 1:0;
        }
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ans =0;
        for(int k=i+1; k<j; k+=2){
            int lT = memo(s,i,k-1,1,dp);
            int lF = memo(s,i,k-1,0,dp);
            int rT = memo(s,k+1,j,1,dp);
            int rF = memo(s,k+1,j,0,dp);

            if(s.charAt(k) == '&'){
                if(isTrue == 1) ans += lT*rT;
                else ans += lF*rF + lT*rF + lF*rT;
            }
            else if(s.charAt(k) == '|'){
                if(isTrue == 1) ans += lT*rT + lT*rF + lF*rT;
                else ans += lF*rF;
            }
            else if(s.charAt(k) == '^'){
                if(isTrue==1) ans += lF*rT + lT*rF;
                else ans += lF*rF + lT*rT;
            }
        }
        return dp[i][j][isTrue] = ans;
    }
}
