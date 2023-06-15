import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {

    }
    private static void dfs(int v , ArrayList<ArrayList<Integer>> adj , boolean[] visited,
                            ArrayList<Integer> list){

        list.add(v);
        visited[v] = true;
        for(Integer neighbour : adj.get(v)){
            if(!visited[neighbour])
                dfs(neighbour,adj,visited,list);
        }
    }
}
