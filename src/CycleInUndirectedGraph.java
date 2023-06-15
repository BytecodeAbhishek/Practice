import java.util.ArrayList;

public class CycleInUndirectedGraph {
    public static void main(String[] args) {

    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        // to handle non connected componets
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,-1)) return true; // cycle is present
            }
        }
        return false;
    }
    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent){
        visited[v] = true;
        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,v)) return true;
            }
            else if(parent != neighbour) return true;
        }
        return false;
    }
}
