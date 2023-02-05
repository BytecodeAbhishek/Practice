import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
     int arr [] = {2,4,67,8,3,23,7};
     int target = 4;
        System.out.println(search(arr, target, 0));
    }
    static ArrayList<Integer> search (int [] arr , int target , int index){
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length){
            return list;
        }
        // ans only of the current function call
        if(arr[index] == target){
            list.add(index);
        }
        // this will all the answers that we are finding list will carry all the ans
        ArrayList<Integer> ansFromBelowCalls = search(arr , target , index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
