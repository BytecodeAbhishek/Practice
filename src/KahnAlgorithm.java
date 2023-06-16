import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class KahnAlgorithm {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 5;
        int[] inDeg = new int[v];
        for(ArrayList<Integer> list : adj){
            for(int e : list){
                inDeg[e]++;
            }
        }
    }
    private static void bfs(int v ,ArrayList<ArrayList<Integer>> adj, int[] inDeg, ArrayList<Integer> ans){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i< inDeg.length; i++){
            if(inDeg[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(Integer neighbour : adj.get(curr)){
                if(--inDeg[neighbour] == 0) q.add(neighbour);
            }
        }
    }
}
