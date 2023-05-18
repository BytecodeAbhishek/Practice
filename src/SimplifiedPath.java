import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SimplifiedPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c"));
    }
    // we can use stack and deque to implement this
    private static String simplifyPath(String path) {
        Stack<String> ans = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");
        for(int i=0; i<p.length; i++){
            if(!ans.isEmpty() && p[i].equals("..")){
                ans.pop();
            }else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
                ans.push(p[i]);
            }
        }
        if(ans.isEmpty()){
            return "/";
        }
        while(!ans.isEmpty()){
            res.insert(0,ans.pop()).insert(0,"/");
            // only change in while loop in case of deque
            // res.append("/").append(ans.pollLast)
        }
        return res.toString();
    }
}
