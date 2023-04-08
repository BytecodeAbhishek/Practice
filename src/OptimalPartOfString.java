public class OptimalPartOfString {
    public static void main(String[] args) {
        System.out.println(partitionString("ababdhszssgvszgerhtjtrsaewefewfsefasefeefeffffefgbvsgvsgsdfhadhjerh"));
    }
    private static int partitionString(String p , String up , int count){
        if(up.length() == 0){
            if(p.length()==0) {
                return count;
            }else{
                return count+1;
            }
        }
        char ch = up.charAt(0);
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == ch){
                count++;
                return partitionString(""+ch,up.substring(1),count++);
            }
        }
        return partitionString(p+ch, up.substring(1),count);
    }
    private static int PartitionString(String s) {
        int count=0, sum=0;
        int traverse=0;
        while(traverse<s.length()){
            int pos = (s.charAt(traverse) - 'a');
            if ((sum & (1 << pos)) != 0) {
                sum=0;
                count++;
            }

            sum|=(1<<pos);
            traverse++;
        }

        if (sum != 0) {
            count++;
        }
        return count;
    }
    public static int partitionString(String s) {
        int count =0;
        if(s.length() == 1){
            return 1;
        }
        String p = "" +s.charAt(0);
        for(int i = 1 ; i<s.length(); i++){
            for(int j =0; j<p.length(); j++){
                if(p.charAt(j) == s.charAt(i)){
                    count++;
                    p = ""+s.charAt(i);
                    break;
                }
            }
            p = p+s.charAt(i);
        }
        return count+1;
    }
}
