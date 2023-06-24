import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KruskalAlgorithm {
    public static void main(String[] args) {

    }
    private static int minimumSpanningTree(int V , ArrayList<ArrayList<ArrayList<Integer>>> adj){
        boolean[][] added = new boolean[V][V];
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=0; i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); i++){
                ArrayList<Integer> curr = adj.get(i).get(j);
                if(!added[i][curr.get(i)]){
                    added[i][curr.get(i)] = true;
                    added[curr.get(i)][i] = true;
                    edges.add(new Edge(i, curr.get(0), curr.get(1)));
                }
            }
        }
        parent = new int[V];
        for(int i=0; i<V; i++){
            parent[i] = i;

        }
        Collections.sort(edges);
        int count =1;
        int ans =0;
        for(int i=0; count<V; i++){
            Edge edge = edges.get(i);
            int rX = find(edge.src);
            int rY = find(edge.dest);
            if(rX != rY){
                union(rX,rY);
                count++;
                ans += edge.wt;
            }

        }
        return ans;
    }
    static  class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        public int compareTo(Edge that){
            return this.wt - that.wt;
        }
    }
    static int parent[];
    public static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    public static void union (int a , int b) {
        // without rank complexity will be more coz height of tree may be large
        int x = find(a);
        int y = find(b);
        if(x == y) return;
        parent[y] = x;
    }
}
