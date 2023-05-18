import java.util.ArrayList;
import java.util.List;
// Do it again with dp
public class GameOfTwoStacks {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(4);
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(1);
        list2.add(2);
        list2.add(1);
        list2.add(8);
        list2.add(5);
        System.out.println(twoStacks(10,list1,list2));
    }
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacks(maxSum, a, b, 0,0)-1;
    }
    private static int twoStacks(int maxSum , List<Integer> a , List<Integer> b , int sum , int count){
        if(sum > maxSum){
            return count;
        }
        if(a.isEmpty() || b.isEmpty()){
            return count;
        }
        int ans1 = twoStacks(maxSum, a.subList(1, a.size()), b, sum+a.get(0), count+1);
        int ans2 = twoStacks(maxSum, a, b.subList(1, b.size()), sum+b.get(0), count+1);
        return Math.max(ans1, ans2);
    }
}
