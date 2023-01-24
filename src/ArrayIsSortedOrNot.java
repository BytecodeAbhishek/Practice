public class ArrayIsSortedOrNot {
    public static void main(String[] args) {
    int [] arr = {1};
        System.out.println(sorted(arr,0));
    }
    static boolean sorted(int[] arr , int i){
        if(arr[i] == arr[arr.length-1]){
            return true;
        }
       return (arr[i] < arr[i+1] && sorted(arr , i+1));
    }
}
