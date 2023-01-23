public class evendigit {
    public static void main(String[] args) {
        int[]  arr = {11,12,2,4,1345,333,3333,123456};
        System.out.println(counting(arr));
    }

    static int counting(int[] arr){
      int count =0;
      for (int num : arr){
          if(even(num))
              count++;
      }
      return count;
    }
    static boolean even(int num){
        int digitcount = digit(num);
        if(digitcount%2==0)
            return true;
        else
            return false;
    }
    static int digit(int num){
        int count =0;
        while(num>0){
            num=num/10;
            count++;
        }
        return count;
    }
}

