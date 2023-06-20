import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    public static void main(String[] args) {

    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        int[] ans = new int[V];
        for(int i=0; i<V; i++){
            ans[i] = Integer.MAX_VALUE;
        }
        pq.add(new Pair(S ,0));
        ans[S] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.v;
            if(visited[u]) continue;
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbour = adj.get(u);
            for(ArrayList<Integer> list : neighbour){
                int v = list.get(0);
                int wt = list.get(1);
                if(ans[v] > ans[u] + wt){
                    ans[v] = ans[u] +wt;
                    pq.add(new Pair(v,ans[v]));
                }
            }
        }
        return ans;
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        public Pair(int v , int wt){
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Pair that){
            return Integer.compare(this.wt , that.wt);
        }
    }
}
