import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(i,adj,stack,visited);
            }
        }
        int[] res = new int[V];
        int i=0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }
    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj , Stack<Integer> stack, boolean[] visited){
        visited[v] = true;
        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour,adj,stack,visited);
            }
        }
        stack.push(v);
    }
}
