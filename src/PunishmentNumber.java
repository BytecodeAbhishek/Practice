public class PunishmentNumber {
    public static void main(String[] args) {
        System.out.println(punishmentNumber(37));
    }
    private static int punishmentNumber(int n) {
        int sum =0;
        for(int i=36; i<=n; i++){
            if(findSquare(i) == i) sum += i*i;
        }
        return sum;
    }
    private static int findSquare(int num){
        if (num * num < 10) return num * num;
        if(num == 10 || num == 100  || num == 1000 ) return num;
        else{
            int n = num * num;
            int s =0;
            while(n>0){
                s += n%10;
                n = n/10;
            }
            return s;
        }
    }
}
