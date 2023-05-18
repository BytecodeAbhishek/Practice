// Leetcode
// solve again with hashset
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    private static int lengthOfLongestSubstring(String s) {
        String ans = "";
        int length = 0;
        int k =0;
        while(k < s.length()){
            ans = ""+s.charAt(k);
            for(int i=k+1; i<s.length(); i++){
                boolean flag = true;
                for(int j=0; j<ans.length(); j++){
                    if(ans.charAt(j) == s.charAt(i)){
                        flag = false;
                        break;
                    }
                }
                if(flag) ans += s.charAt(i);
                else break;
            }
            if(length < ans.length()) length = ans.length();
            ans = "";
            k++;
        }
        return Math.max( length , ans.length());
    }
}
