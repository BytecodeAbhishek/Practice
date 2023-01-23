import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] arr = new int[3][3];
        for(int row=0; row < arr.length ; row++){
            for (int col = 0 ; col < arr[row].length; col++){
                arr[row][col] = sc.nextInt();
            }
        }
        for(int row=0; row < arr.length ; row++){
            for (int col = 0 ; col < arr[row].length; col++){
                System.out.print(arr[row][col]+ "");
            }
            System.out.println();
        }
        for(int row=0; row < arr.length ; row++){
            System.out.println(Arrays.toString(arr[row]));
        }
        int target = 1;
        System.out.println(Arrays.toString(search(arr , target)));
    }
    static int[] search (int [][] arr , int target){
        if (arr.length == 0)
            return new int[]{-1, -1};
        for(int row = 0 ; row < arr.length; row++){
            for (int col=0; col< arr[row].length; col++){
                if(arr[row][col] == target)
                    return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }
}
