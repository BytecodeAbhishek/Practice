public class ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
    static int reverse(int x) {
        boolean negative = false;
        if(x<0){
            negative = true;
            x = -x;
        }
        long reverse = 0;
        while(x>0){
          int rem = x%10;
          reverse = reverse*10 + rem;
          x = x/10;
        }
        if(reverse > Integer.MAX_VALUE){
            return 0;
        }
        if(negative){
            return (int)(-reverse);
        }
        else{
            return (int) reverse;
        }
    }
}
