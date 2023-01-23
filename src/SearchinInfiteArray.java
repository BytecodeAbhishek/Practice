public class SearchinInfiteArray {
    public static void main(String[] args) {
     int[] arr = {2,3,4,5,6,7,8,9,10};
     int target = 5;
        System.out.println(ans(arr,target));
    }
    // we cannot use the size as the array is infinite so we ll to find the start and end values
    static int ans(int[] arr , int target){
     int start = 0;
     int end = 1;
     while(target > arr[end]){
         int newStart = end;               // use temp because we dont want to update the value of start
                                           // because we need that value in end
          end = end + (end-start)*2;
          start = newStart;
     }
     return binarySearch(arr,target,start,end);
    }
    static int binarySearch (int [] arr , int target , int start , int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < arr[mid])
                end = mid - 1;
            else if (target > arr[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    }

