import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
//        String up = "abc";
//        subseq("", up);
//        System.out.println(subseqRet("", up));
        int [] arr = {1,2,3};
        List<List<Integer>> list = subset(arr);
        for(List<Integer> ans : list){
            System.out.println(ans);
        }
    }

    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    static ArrayList<String> subseqRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list1 = subseqRet(p + up.charAt(0), up.substring(1));
        ArrayList<String> list2 = subseqRet(p, up.substring(1));
        list1.addAll(list2);
        return list1;
    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int a : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(a);
                outer.add(inner);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i =0 ; i< arr.length; i++) {
            start =0 ;
            if( i>0 && arr[i] == arr[i-1]){
                start = end +1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}