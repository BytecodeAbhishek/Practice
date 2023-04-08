public class SudokuSolver {
    public static void main(String[] args) {
        int board [][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        //System.out.println(solve(board));
        if(solve(board)){
            display(board);
        }
    }
    private static boolean solve(int [][] board){
       int row = -1;
       int col =-1;
       boolean emptyleft = true;
       for (int i =0 ; i< board.length; i++){
           for (int j=0; j< board.length; j++){
               if(board[i][j] == 0){
                   row = i;
                   col = j;
                   emptyleft = false;
                   break;
               }
           }
           // if already found empty element then break
           if(!emptyleft){
               break;
           }
       }
       if(emptyleft){
           return true;
           // soduku is solved
       }
       // backtrack
        for(int number =1 ; number <=9; number++){
            if(isSafe(board,row,col,number)){
                board[row][col] = number;
                // this can be false
                if(solve(board)){
                    //display(board);
                    //System.out.println();
                    return true;
                }else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void display(int[][] board) {
        for(int[] row : board){
            for( int num : row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int[][] board , int row , int col , int num){
        // check the row
        for(int i =0 ; i< board.length; i++){
           if(board[row][i] == num){
               return false;
           }
        }
        // check the col
        for(int[] nums : board){
            if(nums[col] == num){
               return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for(int r =rowStart; r < rowStart +sqrt; r++){
            for (int c = colStart; c< colStart + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
