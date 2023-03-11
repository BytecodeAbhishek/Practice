public class DiceThrow {
    public static void main(String[] args) {
     //Dice("" , 5);
        System.out.println(isPowerOfTwo(4));
    }
    static void Dice(String p , int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i =1 ; i<6 && i<= target; i++){
            Dice(p+i,target-i);
        }
    }
    static int  count =0;
    static  boolean isPowerOfTwo(int n) {
        if((int)Math.pow(2,count) == n){
            return true;
        }
        if((int)Math.pow(2,count) < n){
            count++;
            return isPowerOfTwo(n);
        }
        return false;
    }
}
