public class RichestCustomer {
    public static void main(String[] args) {
        int[][] accounts  = {{1, 2, 3} , {3, 2, 1}};
        System.out.println(maxWealth(accounts));
    }
    static int maxWealth (int[][] accounts) {
        int[] arr = new int[accounts.length];
            for (int row = 0; row < accounts.length; row++) {
                 arr[row] = sum(accounts[row]);
            }
           int  max = arr[0];
            for (int j = 0; j < arr.length; j++) {
                if (max < arr[j])
                    max = arr[j];
            }
        return max;
    }
    static int sum (int[] arr){
        int sum =0;
        for (int i =0; i< arr.length; i++)
            sum = sum +arr[i];
        return sum;
    }
}
