import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3,1,1,3};
        countDistinctElements(arr,4);
    }
    // method to return a non repeating no in array where every element repeats twice
    private static int nonRepeating(int[] arr){
        // declare a hash map and store the frequency and return whose frequency is one
        // naive approach would be traverse entire array for each element

        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            if(!map.containsKey(i)) map.put(i,1);
            else map.put(i, map.get(i)+1);
        }
        for(int i: arr){
            if(map.get(i) == 1) return i;
        }
        return -1;
    }
    // method to find distinct elements in an array
    private static int distinct(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        return set.size();
    }
    // method for union of two arrays
    private static int union(int[] arr1 , int[] arr2){
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        for(int i : arr2){
            set.add(i);
        }
        return set.size();
    }
    // method to find intersection of two arrays
    private static int intersection(int[] arr1 , int[] arr2){
        Set<Integer> set = new HashSet<>();
        for(int i : arr1){
            set.add(i);
        }
        int count =0;
        for(int i : arr2){
            if(set.contains(i)){
                count++;
                set.remove(i); // removing is imp coz it will store multiple values for the same occurence
            }
        }
        return count;
    }
    // GFG , Leetcode Find the subarray with the given sum
    private static List<Integer> subArraySum(int[] nums , int sum){
        int currSum =0;
        int start =0;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(currSum - sum == 0){
                list.add(start);
                list.add(i);
                return list;
            }
            if(map.containsKey(currSum - sum)){
                start = map.get(currSum - sum)+1;
                list.add(start);
                list.add(i);
                return list;
            }
            map.put(currSum,i);
        }
        list.add(-1);
        return list;
    }
    // leetcode
    public int subarraySum(int[] nums, int k) {
        int currSum =0;
        int count =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if(currSum - k == 0){
                count++;
            }
            if(map.containsKey(currSum - k)){
                count += map.get(currSum-k);
            }
            if(!map.containsKey(currSum)) map.put(currSum,1);
            else map.put(currSum,map.get(currSum)+1);
        }
        return count;
    }
    // leetcode
    public boolean checkSubarraySum(int[] nums, int k) {
        int currSum =0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            if (k != 0) currSum %= k;
            if( (currSum) % k == 0){
                if(i>0) return true;
            }
            if(map.containsKey(currSum)){
                int start = map.get(currSum)+1;
                if(i> start) return true;
            }else
                map.put(currSum,i);
        }
        return false;
    }
    // sliding window problem count distinct element in window
    private static void countDistinctElements(int[] arr , int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<k; i++){
            map.put(arr[i] , map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map.size());
        for(int i=k; i<arr.length; i++){
            if(map.get(arr[i-k]) == 1) map.remove(arr[i-k]);
            else map.put(arr[i-k], map.get(arr[i-k])-1);
            map.put(arr[i] ,map.getOrDefault(arr[i] ,0)+1);
            System.out.println(map.size());
        }
    }
}
