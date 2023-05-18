public class Dota2Senate {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDDR"));
    }
    private static String predictPartyVictory(String senate) {
        int Rcount =0;
        int Dcount =0;
        boolean[] arr = new boolean[senate.length()];
        String victory = senate.charAt(0) == 'R' ? "Radiant" : "Dire";
        for(int i=0; i<senate.length(); i++){
            if(!arr[i]){
                if(senate.charAt(i) == 'R'){
                    if(victory == "Radiant"){
                        Rcount++;
                        for(int j=i+1; j<senate.length(); j++){
                            if(senate.charAt(j) == 'D'){
                                if(arr[j]) continue;
                                else{
                                    arr[j] = true;
                                    break;
                                }
                            }
                        }
                        if(i+1 < senate.length() && senate.charAt(i+1) == 'R') continue;
                        else if(i+1 < senate.length()) i++;
                    }
                    else {
                        victory = "Radiant";
                        Rcount++;
                    }
                }else{
                    if(victory == "Dire"){
                        Dcount++;
                        for(int j=i+1; j<senate.length(); j++){
                            if(senate.charAt(j) == 'R'){
                                if(arr[j]) continue;
                                else{
                                    arr[j] = true;
                                    break;
                                }
                            }
                        }
                        if(i+1 < senate.length() && senate.charAt(i+1) == 'D') continue;
                        else if (i+1 < senate.length()) i++;
                    }
                    else{
                        victory = "Dire";
                        Dcount++;
                    }
                }
            }
        }
        return Rcount > Dcount ? "Radiant" : "Dire";
    }
}
