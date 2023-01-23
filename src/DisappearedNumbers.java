import java.util.ArrayList;
import java.util.List;
public class DisappearedNumbers {
    public static void main(String[] args) {
     int[] arr = {1,1};
     DisappearedNumbers ob = new DisappearedNumbers();
        System.out.println(ob.findDisappearedNumbers(arr));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> list = new ArrayList<>();
      Cyclic(nums);
      for (int i =0; i< nums.length; i++){
          if (nums[i] != (i+1)){
              list.add(i+1);
          }
      }
      return list;
    }
    static void Cyclic(int [] arr){
        int i =0;
        while( i<arr.length){
            int correct = arr[i] -1;
            if( arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }
        }
    }
    static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
