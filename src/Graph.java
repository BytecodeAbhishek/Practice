import java.util.ArrayList;
import java.util.LinkedList;
// implementation of graph
public class Graph {
    public static void main(String[] args) {
        // vertex and edges bt the user
        // connection between source and edges also provided by user;
        int v = 5;
        int edge = 6;
        int[][] adjacencyMatrix = new int[v+1][v+1]; // +1 so that we dont have to do -1 again and again
        ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
        // initialisation of linked list
        for(int i=0; i<=v; i++){
            adj.add(new LinkedList<>());
        }
    }
    private static void  addEdge(int[][] a , int source , int destination){
        a[source][destination] = 1;
        a[destination][source] = 1;
        // because the graph is bidirectional
    }
    private static void addEdge(ArrayList<LinkedList<Integer>> adj , int source , int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }
}
