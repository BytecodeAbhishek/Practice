public class CountOfSubsetOfGivenSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        System.out.println(countSubset(arr,17));
        System.out.println(count(arr,17,0,0));
    }
    private static int countSubset(int[] arr , int sum){
        int[][] dp = new int[arr.length+1][sum+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;
            }
        }
        for(int i=1; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][sum];
    }
    //Recursive Code
    private static int count(int[]arr , int sum , int currSum , int index){
        if(index == arr.length){
            if(currSum == sum) return 1;
            return 0;
        }
        if(currSum == sum) return 1;
        if(arr[index] <= sum){
            return count(arr,sum,currSum+arr[index],index+1)+count(arr,sum,currSum,index+1);
        }
        else
            return count(arr,sum,currSum,index+1);
    }
}
