import java.util.PriorityQueue;

public class KthLargestOrSmallestElement {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6};
       kthLargest(arr,2);
    }
    // kth largest element we will implement the normal min heap and insert the element upto k
    // after that we will check the incoming element if it is greater than we will push it
    private static void kthLargest(int[] arr , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< arr.length; i++){
            if(pq.size() < k) pq.offer(arr[i]);
            else{
                if(pq.peek() < arr[i]) {
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }
        }
        System.out.println(pq.peek());
    }
}
