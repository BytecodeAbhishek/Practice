import java.util.Arrays;

public class FindTheWidthOfTheColumnOfTheGrid {
    public static void main(String[] args) {
        int[][] grid = {{1},{22},{333}};
        System.out.println(Arrays.toString(findColumnWidth(grid)));
    }
    private static int[] findColumnWidth(int[][] grid) {
        int [] length = new int[grid[0].length];
        for(int i=0; i<grid[0].length; i++){
            length[i] = getMaxLength(i,grid);
        }
        return length;
    }
    private static int getMaxLength(int j ,int[][] grid){
        int maxLength = 0;
        int i =0;
        while(i<grid.length){
            if(maxLength < lengthOf(grid[i][j])){
                maxLength = lengthOf(grid[i][j]);
            }
            i++;
        }
        return maxLength;
    }
    private static int lengthOf(int num){
        int length = 0;
        if(num < 0) {
            length = 1;
            num *= -1;
        }
        if(num == 0) return 1;
        while(num >0){
            length++;
            num = num /10;
        }
        return length;
    }
}
