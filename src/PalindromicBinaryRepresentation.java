public class PalindromicBinaryRepresentation {
    public static void main(String[] args) {
        System.out.println(solve(20000));
    }
    // need optimisation
    public static int solve(int A) {
        int count =0;
        int num = 1;
        while(count < A){
            String binary = Integer.toBinaryString(num);
            int start =0;
            int end = binary.length()-1;
            boolean isPalindrome = true;
            while(start < end){
                if(binary.charAt(start) != binary.charAt(end)){
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;
            }
            if(isPalindrome) count++;
            if(count == A) return num;
            num++;
        }
        return -1;
    }
}
