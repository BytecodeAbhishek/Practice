public class PatternPrinting {
    public static void main(String[] args) {
    pattern9(4);
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row +1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <=row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n) {
        for (int row = 1; row <= 2*n -1; row++) {
            int totalColsinRow = row > n ? 2*n - row-1 : row;
            for (int col = 1; col <= totalColsinRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n) {
        for (int row = 1; row <= 2*n; row++) {
            int totalColsinRow = row > n ? 2*n - row: row;
            for(int k =1; k<= n-totalColsinRow; k++){
                System.out.print(" ");
            }
            for (int col = 1; col <= totalColsinRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            for(int k =1; k<= n-row; k++){
                System.out.print(" ");
            }
            for (int col = row; col >=1; col--) {
                System.out.print(col);
            }
            for (int col = 2; col <=row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
    static void pattern7(int n) {
        for (int row = 1; row <= 2*n; row++) {
            int c = row > n ? 2*n - row: row;
            for(int k =1; k<= n-c; k++){
                System.out.print("  ");
            }
            for (int col = c; col >=1; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <=c; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern8(int n){
        for (int row = 0; row <= 2*n; row++) {
            for (int col = 0; col <=2*n; col++) {
                int c = n - Math.min(Math.min(col, 2*n - col),Math.min(row, 2*n - row));
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    static void pattern9(int n){
        for (int row = 0; row <= 2*n; row++) {
            for (int col = 0; col <=2*n; col++) {
                int c = Math.min(Math.min(col, 2*n - col),Math.min(row, 2*n - row));
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}