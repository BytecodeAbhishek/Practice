import java.util.PriorityQueue;

public class ConnectNRopesWithMinCost {
    public static void main(String[] args) {
     int [] arr ={2,5,4,8,6,9};
        System.out.println(minCost(arr));
    }
    // in this question we have to connect two ropes with min cost cost is euqal to addition of
    // two ropes we take to connect
    private static int minCost(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) pq.offer(num);
        int cost =0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            cost += first+second;
            pq.offer(first+second);
        }
        return cost;
    }
}
