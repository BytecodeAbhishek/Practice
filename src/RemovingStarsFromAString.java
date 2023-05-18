import java.util.Iterator;
import java.util.Stack;

public class RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println(removeStars("lee**code"));
    }
    private static String removeStars(String s) {
        Stack<Character> character = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '*'){
                character.push(s.charAt(i));
            }else{
                character.pop();
            }
        }
        String res = "";
        Iterator<Character> itr = character.iterator();
        while(itr.hasNext()){
            res += itr.next();
        }
        return res;
    }
}
