import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
       int[] asteroids = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            boolean isPush = true;
            while(!stack.isEmpty()){
                if(stack.peek() >=0 && asteroids[i] < 0){
                    if(Math.abs(stack.peek()) < Math.abs(asteroids[i])){
                        stack.pop();
                    }else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                        isPush = false;
                        stack.pop();
                        break;
                    }
                    else{
                        isPush = false;
                        break;
                    }
                }else break;
            }
            if(isPush) stack.push(asteroids[i]);
        }
        int[] res = new int[stack.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
    private static boolean isOpp(int a , int b){
        return a>=0 && b<0 || a<0 && b>=0;
    }
}
