public class SubsetSumProblem {
    public static void main(String[] args) {
     // problem is find any subset in the array that is equal to the sum
        int[] arr = {2,3,7,8,10};
        System.out.println(equalSum(arr,14));
        System.out.println(sum(arr,12,0));
    }
    // Recursive code
    private static boolean sum(int[] arr , int sum , int index){
        if(index == arr.length) return sum ==0;
        if(sum == 0) return true;
        if(arr[index] <= sum)
            return sum(arr,sum-arr[index],index+1) || sum(arr,sum,index+1);
        else
            return sum(arr,sum,index+1);
    }
    private static boolean equalSum(int[] arr , int sum){
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }
        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][sum];
    }
}
