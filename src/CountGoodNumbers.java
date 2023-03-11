

public class CountGoodNumbers {
    public static void main(String[] args) {
        count(50);
    }
    static int mod = 1_000_000_007;
    private static void count(long n){
        long result = n%2 ==0 ? 1:5;
        long x = 20;
        for(long i = n/2; i>0; i =i/2){
            if( i%2 != 0) result = (result*x) % mod;
            x = x*x % mod;
        }
        System.out.println((int)result);
    }
}
