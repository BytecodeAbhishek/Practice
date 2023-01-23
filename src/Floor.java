public class Floor {
    public static void main(String[] args) {
        int arr [] = {2, 3, 5, 9, 14, 16, 18};
        int target =7;
        System.out.println(search(arr , target));
    }
    static  int search (int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        if(target < arr[0])
            return -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return arr[mid];
            else if (arr[mid] > target){
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }

        return arr[end]; // floor is greatest number <= target number

    }
}
