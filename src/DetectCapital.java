public class DetectCapital {
    public static void main(String[] args) {
     String word = "usa";
        System.out.println(detectCapitalUse(word));
    }
    static boolean detectCapitalUse(String word) {

        if(Character.isUpperCase(word.charAt(0))){
            int count =1;
            for(int i =1; i<word.length(); i++){
                if(Character.isUpperCase(word.charAt(i)))
                count++;

            }
        if(count == 1)
            return true;
        else if(count == word.length())
            return true;
        }
        else {
            int count =1;
            for(int i =1; i<word.length(); i++){
                if(Character.isLowerCase(word.charAt(i)))
                count++;

            }
            if(count == word.length())
                return true;

        }
        return false;
}
}
