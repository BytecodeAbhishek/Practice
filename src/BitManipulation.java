public class BitManipulation {
    public static void main(String[] args) {

    }
    // method to find no of 1 bits in a number
    public int numSetBits(long a) {
        int count =0;
        while(a != 0){
            a = a & (a-1);
            count++;
            //count += a & 1;
            //a >>>=1;
        }
        return count;
    }
    // method to find non repeating element in an array where every element repeats twice
    public int singleNumber(final int[] A) {
        int res  = 0;
        for(int i=0; i<A.length; i++){
            res = res ^ A[i];
        }
        return res;
    }
    // method to find no to bits to change for making a | b == c
    public int minFlips(int a, int b, int c) {
        int count =0;
        while(a>0 || b>0 || c>0){
            int lastbitA = a & 1;
            int lastbitB = b & 1;
            int lastbitC = c &1 ;
            if(lastbitC == 0){
                count += lastbitA + lastbitB;
            }else{
                if(lastbitA == 0 && lastbitB == 0) count++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}
