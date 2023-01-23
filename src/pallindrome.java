public class pallindrome {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    static boolean isPalindrome(int x) {
        int reverse = 0;
        int y = x;
        if (x<0)
            x = -x;
        while (x != 0) {
            int remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        if (reverse == y)
            return true;
        return false;
    }
}

