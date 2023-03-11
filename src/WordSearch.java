public class WordSearch {
    public static void main(String[] args) {
    char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'},
    };
    String word = "ABCCED";
        System.out.println(search2(0,board,word,0,0));
    }
    static boolean search (String p , char[][] board, String word, int row, int col){
        if(p.length() == word.length()){
            if(p.equals(word)){
                return true;
            }
        }
        if(word.charAt(p.length()-1) != p.charAt(p.length()-1))
            return false;
        char ch = board[row][col];
        board[row][col] ='*';
        if( row < board.length-1){
           return search(p+board[row+1][col],board,word,row+1,col);
        }
        if( col < board[0].length-1 ){
           return search(p+board[row][col+1],board,word,row,col+1);
        }
        if( col > 0 ){
            return search(p+board[row][col-1],board,word,row,col-1);
        }
        if( row > 0){
            return search(p+board[row-1][col],board,word,row-1,col);
        }
        board[row][col] =ch;
        return false;
    }
    static boolean search2 (int count , char[][] board, String word, int row, int col){
        if(count == word.length()){
                return true;
        }
        if(row ==board.length || col == board[0].length ||
               col == -1 || row == -1 ||  word.charAt(count) != board[row][col])
            return false;
        char ch = board[row][col];
        board[row][col] = '*';
         boolean ans =   search2(count+1,board,word,row+1,col) ||
             search2(count+1,board,word,row-1,col) ||
             search2(count+1,board,word,row,col+1) ||
             search2(count+1,board,word,row,col-1);
        board[row][col] = ch;
        return ans;
    }
}
