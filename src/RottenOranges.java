import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {

    }
    //Leetcode 994
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        int cntFresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else visited[i][j] = 0;
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int time =0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int count =0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            time = Math.max(time,p.t);
            for(int i=0; i<4; i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >=0 && nrow <n && ncol>=0 && ncol <m && grid[nrow][ncol] == 1 && visited[nrow][ncol] ==0){
                    visited[nrow][ncol] =2;
                    count++;
                    q.add(new Pair(nrow,ncol,p.t+1));
                }
            }
        }
        if(count != cntFresh) return -1;
        return time;
    }
    static class Pair{
        int row;
        int col;
        int t;
        public Pair(int row, int col, int t){
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }
}
