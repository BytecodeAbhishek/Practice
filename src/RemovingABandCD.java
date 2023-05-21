import java.util.Stack;

public class RemovingABandCD {
    public static void main(String[] args) {
        String s= "ABFCACDB";
        Stack<Character> stack = new Stack<>();
        //if(s=="" || s == "AB" || s == "CD") return 0;
        stack.push(s.charAt(0));
        int i=1;
        while(i<s.length()){
            if(s.charAt(i) == 'B' && !stack.isEmpty() && stack.peek() == 'A'){
                stack.pop();
                i++;
            }
            else if(s.charAt(i) == 'D' && !stack.isEmpty() && stack.peek() == 'C'){
                stack.pop();
                i++;
            }
            if(i<s.length()) {
                stack.push(s.charAt(i));
                i++;
            }
        }
        //return ans.length();
        System.out.println(stack.size());
    }
}
