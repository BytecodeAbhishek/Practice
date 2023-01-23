public class FindMountainArray {
    public static void main(String[] args) {
        int[] mountainArr = {1, 3, 4, 5, 3, 2, 1};
        int target = 2;
        System.out.println(findInMountainArray(target, mountainArr));
    }
    static  int findInMountainArray(int target , int[] mountainArr){
        int peak = peak(mountainArr);
        if(bs(mountainArr,target,0,peak) != -1){
            return bs(mountainArr,target,0,peak);
        }
        return bs(mountainArr,target,peak+1,mountainArr.length-1);
    }
    static int peak(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid+1]) {
                // we are in the ascending part of the array
                end = mid; // because this may be my potential answer
            }
            else{
                start = mid +1;
                // int the end start == mid hence my answer is the max element
            }
        }
        return start;
    }
    static  int bs( int[] arr , int target , int start , int end){
        boolean isAS = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end - start)/2;
            if (target == arr[mid])
                return mid;
            if(isAS){
                if(target < arr[mid])
                    end = mid - 1;
                else if (target > arr[mid])
                    start = mid + 1;
                else
                    return mid;
            }
            else {

                if(target > arr[mid])
                    end = mid - 1;
                else if (target < arr[mid])
                    start = mid + 1;
                else
                    return mid;
            }
        }
        return -1;
    }
}

