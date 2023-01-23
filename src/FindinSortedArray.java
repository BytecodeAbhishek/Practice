import java.util.Arrays;

public class FindinSortedArray {
    public static void main(String[] args) {
        int [] nums = {5,6,6,8,8,10};
        int target = 6;
        System.out.println(""+Arrays.toString(findposition(nums,target)));
    }
    public static int[] findposition(int[] nums , int target){
        int start=0 , end= nums.length-1 , index1 = -1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(nums[mid]==target){
                index1 = mid;
                end = mid-1;
            }
            else if (nums[mid] > target)
                end = mid -1;
            else
                start = mid+1;
        }
        start =0; end = nums.length-1;
        int index2 = -1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(nums[mid]==target){
                index2 = mid;
                start = mid+1;
            }
            else if (nums[mid] > target)
                end = mid -1;
            else
                start = mid+1;
        }
        int[] result = {index1 , index2};
        return result;
    }

}
