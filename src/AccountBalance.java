import java.util.Arrays;

public class AccountBalance {
    public static void main(String[] args) {
        int a[] = { 7,1,2,3,4};
        int n = a.length;

        // Function call
        System.out.println("Length of lis is " + lis(a, n));
    }
    static int f(int idx, int prev_idx, int n, int a[],
                 int[][] dp)
    {
        if (idx == n) {
            return 0;
        }

        if (dp[idx][prev_idx + 1] != -1) {
            return dp[idx][prev_idx + 1];
        }

        int notTake = f(idx + 1, prev_idx, n, a, dp);
        int take = Integer.MIN_VALUE;
        if (prev_idx == -1 || a[idx] > a[prev_idx]) {
            take = 1 + f(idx + 1, idx, n, a, dp);
        }

        return dp[idx][prev_idx + 1]
                = Math.max(take, notTake);
    }

    // The wrapper function for _lis()
    static int lis(int arr[], int n)
    {
        // The function _lis() stores its result in max
        int dp[][] = new int[n + 1][n + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return f(0, -1, n, arr, dp);
    }
}
