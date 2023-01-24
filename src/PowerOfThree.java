public class PowerOfThree {
    public static void main(String[] args) {
    int n = 27;
        System.out.println(isPowerOfThree(n));
    }

    static boolean isPowerOfThree(int n) {
        return helper(n, 0);
    }

    private static boolean helper(int n, int count) {

        if (Math.pow(3, count) > n) {
            return false;
        }
        if ((Math.pow(3, count)) < n) {
            return helper(n,count+1);
        }
        if ((Math.pow(3, count)) == n){
            return true;
        }
        return false;
    }
}