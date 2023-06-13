import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=i; j>=0; j--){
                //list.add(helper(i,j));
                if(j==0 || j==i) list.add(1);
                else list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(list);
        }
        return ans;
    }
    // private static int helper(int row , int col){
    //     if(col ==0 || row == col) return 1;
    //     else return helper(row-1,col-1) + helper(row-1,col);
    // }
}
