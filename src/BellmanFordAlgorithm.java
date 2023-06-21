import java.util.Arrays;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {

    }
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        if(edges.length == 0) return 0;
        // source distance zero
        dist[edges[0][0]] = 0;

        //n-1 times
        for(int i=1; i<n; i++){
            for(int j=0; j<edges.length; j++){
                int src = edges[j][0];
                int dest = edges[j][1];
                int wt = edges[j][2];
                if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[dest])
                    dist[dest] = dist[src] + wt;
            }
        }
        // agr cycle hogi to ek bar or chalane p ye if condition m jaega
        for(int j=0; j<edges.length; j++){
            int src = edges[j][0];
            int dest = edges[j][1];
            int wt = edges[j][2];
            if(dist[src] != Integer.MAX_VALUE && dist[src] + wt < dist[dest])
                return 1;
        }
        return 0;
    }
}
