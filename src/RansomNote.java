public class RansomNote {
    public static void main(String[] args) {
     String ransomNote = "bg";
     String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
     RansomNote ob = new RansomNote();
        System.out.println(ob.canConstruct(ransomNote , magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int count =0;
        for(int i =0; i<magazine.length(); i++){
            if(compare(magazine.charAt(i) , ransomNote)){
                count++;
                char ch = magazine.charAt(i);
                ransomNote.replace("ch","");
        }
        }
        if ( count >= ransomNote.length())
            return true;
        return false;
    }
    static boolean compare (char ch ,  String ransomNote){
        int i =0;
        while(i< ransomNote.length()){
            if (ransomNote.charAt(i) == ch){
                return true;
            }
                i++;
        }
        return false;
    }
}
