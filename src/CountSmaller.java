import java.util.ArrayList;
import java.util.List;
public class CountSmaller {
    public static void main(String[] args) {
      int [] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        CountSmaller ob = new CountSmaller();
        System.out.println(ob.count(nums));
    }
    public  List count(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length;i++ ){
            list.add(checksmall(nums[i] , i , nums));
            }


        return list;
    }
    public static int checksmall(int arr , int position , int[] nums){
        int count = 0;

        for(int i = position; i<nums.length;i++ ){
            if( arr > nums[i]){
                count++;
            }
        }
        return count;
    }
    }
