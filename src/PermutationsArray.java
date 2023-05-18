import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsArray {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        boolean[] arr = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subset(res,current,nums,0);
        System.out.println(res.toString());
    }
    private static void permutations(List<List<Integer>> res, List<Integer> current, int[] nums,
                                     boolean[] arr){
        if(current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i< nums.length; i++){
            if(arr[i]){
                continue;
            }
            arr[i] = true;
            current.add(nums[i]);
            permutations(res,current,nums,arr);
            arr[i] = false;
            current.remove(current.size()-1);
        }
    }
    private static void subset(List<List<Integer>> res, List<Integer> current, int[] nums , int index){
        if(index == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subset(res,current, nums , index+1);
        current.remove(current.size()-1);
        subset(res,current, nums,index+1);
    }
}
