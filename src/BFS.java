import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }
    private static boolean bfd(ArrayList<ArrayList<Integer>> adj , int source , int destination , int v , int[]pred,
                               int [] dist){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[v+1];
        for(int i=0; i<=v; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        // distance when source is starting vertex else add source
        visited[1] = true;
        dist[1] = 0;
        q.add(source);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0; i<adj.get(curr).size(); i++){
                int neighbour = adj.get(curr).get(i);
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    dist[neighbour] = dist[curr]+1;
                    pred[neighbour] = curr;
                    q.add(neighbour);
                    if(neighbour == destination) return true;
                }
            }
        }
        return false;
    }
}
