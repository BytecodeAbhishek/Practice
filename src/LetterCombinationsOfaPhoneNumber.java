import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {
       // pad("" , "12");
    }
    static List<String> pad (String p , String up){
        if( up.isEmpty()){
            List<String> list = new ArrayList<>();
            if(!p.isEmpty())
                list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();
        if(digit <=6) {
            for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p+ch , up.substring(1)));
            }
        }else if(digit == 7) {
            for (int i = (digit - 2) * 3; i < ((digit - 1) * 3) + 1; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p+ch , up.substring(1)));
            }
        }
        else if( digit == 8){
            for (int i = ((digit - 2) * 3) +1 ; i < ((digit - 1) * 3)+1; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p+ch , up.substring(1)));
            }
        }
        else {
            for (int i = ((digit - 2) * 3)+1; i < ((digit - 1) * 3) + 2; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(pad(p+ch , up.substring(1)));
            }
        }
        return ans;
    }
    static void pad2(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) -'0';
        for(int i = (digit-1)*3; i< digit*3; i++){
            char ch = (char)('a' + i);
            pad2(p+ch , up.substring(1));
        }
    }
}
