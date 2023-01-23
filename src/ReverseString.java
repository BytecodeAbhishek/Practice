import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    static void reverseString(char[] s) {
        int left = 0;
        int end = s.length - 1;
        while (left < end) {
            //swap
            char temp = s[left];
            s[left] = s[end];
            s[end] = temp;

            left++;
            end--;
        }
    }
}
