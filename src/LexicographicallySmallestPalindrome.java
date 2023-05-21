public class LexicographicallySmallestPalindrome {
    public static void main(String[] args) {
        String s = "seven";
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                if(s.charAt(i) > s.charAt(j))
                    s = s.substring(0,i) + s.charAt(j) + s.substring(i+1);
                else
                    s = s.substring(0,j) + s.charAt(i) + s.substring(j+1);
                i++;
                j--;
            }
        }
    }
}
