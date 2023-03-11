
import java.util.ArrayList;

public class MazeProblems {
    public static void main(String[] args) {
        //System.out.println(count(5,5));
       // System.out.println(paths("",3,3));
        //System.out.println(pathsDiagonal("",4,4));
        boolean[][] maze  = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathWithRestriction("",maze,0,0);
    }
    static int count(int row , int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int left = count(row-1,col);
        int right = count(row,col-1);
        return left+right;
    }
    static ArrayList<String> paths(String p , int row , int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(row>1) {
            ans.addAll(paths(p + 'D', row - 1, col));
        }
        if(col>1) {
            ans.addAll(paths(p + 'R', row, col - 1));
        }
        return ans;
    }
    static ArrayList<String> pathsDiagonal(String p , int row , int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(row>1) {
            ans.addAll(pathsDiagonal(p + 'D', row - 1, col));
        }
        if(col>1) {
            ans.addAll(pathsDiagonal(p + 'R', row, col - 1));
        }
        if (row >1 && col > 1){
            ans.addAll(pathsDiagonal(p+'D',row-1,col-1));
        }
        return ans;
    }
    static void pathWithRestriction(String p , boolean[][] maze , int row , int col){
        if( row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        if( row < maze.length-1){
            pathWithRestriction(p+'D',maze,row+1,col);
        }
        if (col < maze[0].length-1){
            pathWithRestriction(p+'R',maze,row,col+1);
        }
    }
}
