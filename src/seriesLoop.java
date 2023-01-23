// series = a+2^0 *b , a+2^0*b+2^1*b , a=2^0*b+2^1*b ..... 2^n-1*b
import java.util.Scanner;
public class seriesLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int i=0; i<t; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            for(int j=0; j<n; j++){
                a += (int)Math.pow(2,j)*b;
                System.out.print(a+" ");
           }
            System.out.println();
        }
    }
}
