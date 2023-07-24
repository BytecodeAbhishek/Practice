import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningList {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s,0,ans,temp);
        return ans;
    }
    private static void solve(String s, int i, List<List<String>> ans, List<String> temp){
        if(i == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int k=i; k<s.length(); k++){
            if(isPalindrome(s,i,k)){
                temp.add(s.substring(i,k+1));
                solve(s,k+1,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
