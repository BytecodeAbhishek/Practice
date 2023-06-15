public class CoinChange{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        count1("",arr,4);
    }
    private static long count(int coins[], int index, int sum) {
        if(index == coins.length) {
            if (sum == 0) return 1;
            return 0;
        }
        int count =0;
        if(coins[index] <= sum){
            count += count(coins,index,sum-coins[index]);
        }
        count += count(coins,index+1,sum);
        return count;
//        return coins[index] < sum ? count(coins,index,sum-coins[index]) : count(coins,index+1,sum);
    }
    // this will give all possible combination so there will be repetition which we dont want
    private static void count1(String p , int[] arr , int sum){
        if(sum ==0){
            System.out.println(p);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= sum)
            count1(p+arr[i] ,arr, sum-arr[i]);
        }
    }
}
