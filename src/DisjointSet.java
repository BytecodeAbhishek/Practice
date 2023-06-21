public class DisjointSet {
    public static void main(String[] args) {

    }
    private int N = 8;
    private int[] parent = new int[N];
    private int[] rank = new int[N];
    public DisjointSet(){
        for(int i=0; i<N; i++){
            parent[i] =i;
            rank[i] =0;
        }
    }
    public int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    public void union (int a , int b){
        // without rank complexity will be more coz height of tree may be large
//        int x = find(a);
//        int y = find(b);
//        if(x == y) return;
//        parent[y] = x;
        int xRoot = find(a);
        int yRoot = find(b);
        if(xRoot == yRoot) return;
        if(rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot;
        else if(rank[yRoot] < rank[xRoot]) parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot]+1;
        }
    }
}
