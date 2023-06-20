import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    public static void main(String[] args) {
     int[][] edges = {{0,1,5} ,{1,2,3} ,{0,2,1}};
        System.out.println(spanningTree(3,3,edges));
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v , int wt){
            this.v =v;
            this.wt = wt;
        }
        public int compareTo(Pair that){
            return Integer.compare(this.wt,that.wt);
        }
    }
    // the problem in this is it is a undirected graph so we need to add the vetrtes in reverse also
    static int spanningTree(int V, int E, int edges[][]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();
        for(int i=0; i<V; i++){
            list.add(new ArrayList<>());
        }
        for(int[] i : edges){
            list.get(i[0]).add(new Pair(i[1],i[2]));
            list.get(i[1]).add(new Pair(i[0],i[2]));
        }
        pq.add(new Pair(0,0));
        int ans = 0;
        while(pq.size() != 0){
            Pair curr = pq.poll();
            int u = curr.v;
            if(visited[u]) continue;  // already visited skip this
            ans += curr.wt;
            visited[u] = true;
            for(Pair p : list.get(u)){
                    int v = p.v;
                    int wt = p.wt;
                    if(!visited[v]){
                        pq.add(new Pair(v,wt));
                    }
            }
        }
        return ans;
    }
}
