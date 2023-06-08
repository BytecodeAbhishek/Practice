import java.util.Arrays;

public class MathForCompetitive {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(sieveOfEratoSthenes(20)));
        System.out.println(gcd(12,60));
    }

    // prime number using sieve of erato sthenes
    private static boolean[] sieveOfEratoSthenes(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i*i <= n; i++){
            for(int j=2*i; j<=n; j+= i){
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
    // method to calculate gcd of two  numbers
    private static int gcd(int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    // method to calculate power
    public double myPow(double x, int n) {
        if(n==0 || x==1)
            return 1;
        if(x==0)
            return 0;

        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n%2==0 ? myPow(x*x,n/2) : x*myPow(x*x,n/2));
    }

}
