import java.util.ArrayList;

public class CycleInDirectedGraph {
    public static void main(String[] args) {

    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] resS = new boolean[V]; // backtracking for having the element of current recursion
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,resS)) return true;
            }
        }
        return false;
    }
    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] resS){
        visited[v] = true;
        resS[v] = true;
        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                if(dfs(neighbour,adj,visited,resS)) return true;
            }
            else if(resS[neighbour]) return true;
        }
        resS[v] = false;
        return false;
    }
}
