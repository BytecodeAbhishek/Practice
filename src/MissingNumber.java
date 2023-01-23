public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {0,1};
        System.out.println(missing(arr));
    }
    static int missing(int[] nums){
     Cyclic(nums);
     for(int i =0; i< nums.length; i++){
         if(nums[i] != i){
            return i;
         }
     }
     return nums.length;
    }
    static void Cyclic(int [] nums){
        int i =0;
        while( i<nums.length){
            int correct = nums[i];
            if( nums[i] < nums.length && nums[i] != nums[correct]){
                swap(nums,i,correct);
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
