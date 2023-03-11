import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        boolean[][] maze  = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        //path("",maze,0,0);
        pathMaze("",maze,0,0,path,1);
    }
    static void path (String p , boolean[][] maze , int row , int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        // without backtracking if we want to travel all the paths it will result in stack overflow error
        // so we use backtracking
        // we mark ever cell while traversing
        maze[row][col] = false;
        if( row < maze.length-1){
            path(p+'D' , maze, row+1 , col);
        }
        if( col < maze[0].length-1){
            path(p+'R',maze,row,col+1);
        }
        if(row > 0){
            path(p+'U',maze,row-1,col);
        }
        if(col > 0){
            path(p+'L',maze,row,col-1);
        }
        // here we undo all the changes that we have made
        maze[row][col] = true;
    }
    // For path
    // take a step array
    // update the path variable
    // print it in base condition
    // Backtrack
    static void pathMaze (String p , boolean[][] maze , int row , int col , int[][] path , int step){
        if(row == maze.length-1 && col == maze[0].length-1){
            path[row][col] = step;
            for (int [] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[row][col]){
            return;
        }
        // without backtracking if we want to travel all the paths it will result in stack overflow error
        // so we use backtracking
        // we mark ever cell while traversing
        maze[row][col] = false;
        path[row][col] = step;
        if( row < maze.length-1){
            pathMaze(p+'D' , maze, row+1 , col,path,step+1);
        }
        if( col < maze[0].length-1){
            pathMaze(p+'R',maze,row,col+1 , path , step+1);
        }
        if(row > 0){
            pathMaze(p+'U',maze,row-1,col , path , step+1);
        }
        if(col > 0){
            pathMaze(p+'L',maze,row,col-1 , path , step+1);
        }
        // here we undo all the changes that we have made
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
