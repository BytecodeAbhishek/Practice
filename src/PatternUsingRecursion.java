public class PatternUsingRecursion {
    public static void main(String[] args) {
      // triangle(4,0);
        triangle2(4,0);
    }
    static void triangle(int r , int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print(" *");
            triangle(r, c + 1);
        } else {
            System.out.println();
            triangle(r - 1, 0);
        }
    }
    static void triangle2(int r , int c) {
        if (r == 0) {
            return;
        }
        // print will execute after all the method calls are executed
        // therefore it will print triangle in opposite way
        if (c < r) {
            triangle2(r, c + 1);
            System.out.print(" *");
        } else {
            triangle2(r - 1, 0);
            System.out.println();
        }
    }
}
