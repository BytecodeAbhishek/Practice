public class MaximumNoOfVowels {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef",3));
    }
    private static  int maxVowels(String s, int k) {
        int count =0;
        for(int i=0; i<=s.length()-k; i++){
            int tempCount =0;
            for(int j=i; j<i+k; j++){
                if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' ||
                        s.charAt(j) == 'o'|| s.charAt(j) == 'u') tempCount++;
            }
            if(count < tempCount) count = tempCount;
        }
        return count;
    }
}
