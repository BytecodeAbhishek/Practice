import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
      int[] spells = {3,1,2};
      int[] potions = {8,5,8};
        System.out.println(Arrays.toString(successfulPairs(spells,potions,16)));
    }
    private static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            int left =0;
            int right = potions.length;
            while(left < right){
                int mid = left + (right - left)/2;
                if( (long)spells[i] *(long)potions[mid] >= success){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            pairs[i] = potions.length - left;
        }
        return pairs;
    }
}
