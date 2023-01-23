import java.util.Scanner;

public class RandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number A : ");
        long A = sc.nextLong();
        System.out.println("Enter number B : ");
        long B = sc.nextLong();
        System.out.println(probability(A,B));
    }
    public static int probability ( long a , long b){
        long gcd = 0;
        for (long i =1;  i<= a && i<=b; i++){
            if( a%i ==0 && b%i==0){
                gcd =i;
            }
        }
        int count = 0;
        for (long i =1; i<=b ; i++){
              if (check(i, b , gcd))
                  count++;
             }
          int probab = (int) ((count)*1000000);
          int finalProbability = (int) (probab/b);
            return finalProbability;
             }
    public static  boolean check (long num , long b , long target){
        long gcd = 0;
        for( long i=1 ; i<=num ; i++){
            if( num%i ==0 && b%i == 0)
                gcd = i;
        }
        if (gcd==target)
            return true;
        return false;
    }

        }


