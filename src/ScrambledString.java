import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScrambledString {
    public static void main(String[] args) {
        String a;
        String b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        sc.close();
        Map<String,Boolean> map = new HashMap<>();
        if(a.length() != b.length()) System.out.println(false);
        if(a.length()==0 && b.length() == 0) System.out.println(true);
        System.out.println(solve(a,b));
        System.out.println(solveMemo(a,b,map));
    }
    private static boolean solve(String a, String b){
        if(a.equals(b)) return true;
        if(a.length() <= 1) return false;
        int n = a.length();
        boolean flag = false;

        for(int i=1; i<n; i++){
            boolean condition1 = solve(a.substring(0,i),b.substring(n-i,n)) && solve(a.substring(i,n),b.substring(0,n-i));
            boolean condition2 = solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i,n),b.substring(i,n));
            if(condition1 || condition2){
                flag = true;
                break;
            }
        }
        return flag;
    }
    private static boolean solveMemo(String a, String b, Map<String,Boolean> map){
        if(a.equals(b)) return true;
        if(a.length() <= 1) return false;
        int n = a.length();
        boolean flag = false;

        String key = a+" "+b;
        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i=1; i<n; i++){
            boolean condition1 = solveMemo(a.substring(0,i),b.substring(n-i,n),map) && solveMemo(a.substring(i,n),b.substring(0,n-i),map);
            boolean condition2 = solveMemo(a.substring(0,i),b.substring(0,i),map) && solveMemo(a.substring(i,n),b.substring(i,n),map);
            if(condition1 || condition2){
                flag = true;
                break;
            }
        }
        map.put(key,flag);
        return flag;
    }
}
