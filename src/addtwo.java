
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addtwo {
    public static void main(String[] args) {
        int[] nums = {2,7,9,11,15};
        int target = 18;
        System.out.println("" + Arrays.toString(sumtwo(nums , target)));
    }
    public static int [] sumtwo( int[] nums , int target){
        //List<Integer> list = new ArrayList<>();
        int index1 =0;
        int index2 =0;
        for(int i = 0 ; i< nums.length;i++){
            for(int j= i+1; j< nums.length;j++){
                if( nums[i]+nums[j] == target){
                    //list.add(i);
                    //list.add(j);
                    index1=i;
                    index2=j;
                    break;
                }
            }
        }
        //int [] result = new int [2];
        int [] result = {index1 , index2};
       // for (int i = 0 ; i< result.length; i++)
       //     result[i] = list.get(i);
        return result;
    }
}
