public class hIndex {
    public static void main(String[] args) {
        int[] citations = {1,1,1,1,1,4,4,5,6};
        System.out.println(index(citations));
    }
    private static int index(int[] citations){
        int [] bucket = new int[citations.length+1];
        for(int i =0; i< citations.length; i++){
            if(citations[i] > citations.length){
                bucket[citations.length]++;
            }else{
                bucket[citations[i]]++;
            }
        }
        int count =0;
        for(int i =citations.length ; i>0; i--){
            count += bucket[i];
            if(count >= i){
                return i;
            }
        }
        return 0;
    }
    //O(n)
    public int index2(int[] citations) {
        int N = citations.length;
        int index = 0;
        while(index < N && N - index > citations[index]){
            index++;
        }
        return N - index;
    }

    //O(logn)
    public int index3(int[] citations) {

        int left = 0, right = citations.length - 1;
        int N = citations.length;
        while(left <= right){
            int h = left + (right - left)/2;
            if(citations[h] == N - h)
                return N - h;
            else if(citations[h] > N - h)
                right = h - 1;
            else
                left = h + 1;
        }
        return N-left;
    }
}
