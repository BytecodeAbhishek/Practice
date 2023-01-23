public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'a' , 'b' , 'c' , 'd'};
        char target = 'b';
        System.out.println(nextGreatestLetter(letters , target));
    }
    static  char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if (letters[mid] > target){
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        //if (target == letters[letters.length-1])
          //  return letters[0];
        return letters[start % letters.length];
    }
}