
import java.util.*;
import java.util.Scanner;

public class BinaryTree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
//        inOrder(root);
//        System.out.println();
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        System.out.println(size(root));
//        System.out.println(max(root));
        printLeftView(root);
    }
    // to define the type of data
    static Node createTree(){
        Node root = null;
        System.out.println("Enter Data : ");
        int data = sc.nextInt();
        if(data == -1) return null;
        root = new Node(data);
        System.out.println("Enter left for : "+data);
        root.left = createTree();
        System.out.println("Enter right for : "+data);
        root.right = createTree();
        return root;
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }
    static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left) , height(root.right))+1;
    }
    static int size(Node root){
        if(root == null ) return 0;
        //int count =0;
        //count = count+size(root.left);
        //count = count+size(root.right);
        //return count+1;
        return size(root.left) + size(root.right) + 1;
    }
    static int max(Node root){
        if(root == null) return Integer.MIN_VALUE; // to make the comparison easy
        int ans = 0;
        ans = Math.max(root.data, Math.max(max(root.left) , max(root.right)));
        return ans;
    }
    static void printLeftViewUtil(Node root , ArrayList list, int level){
        if(root == null) return;
        // checking the current index is null opr not (gave raw use exception)
        if(level >= list.size()) list.add(root);
        printLeftViewUtil(root.left,list,level+1);
        printLeftViewUtil(root.right,list,level+1);
    }
    static void printLeftView(Node root){
        ArrayList<Node> list = new ArrayList<>();
        printLeftViewUtil(root,list,0);
        for(Node curr : list) System.out.println(curr.data+" ");
    }
    static void printRightViewUtil(Node root , List<Integer> list, int level){
        if(root == null) return;
        if (level == list.size()) {
            list.add(root.data);
        } else {
            list.set(level, root.data);
        }
        printRightViewUtil(root.left,list,level+1);
        printRightViewUtil(root.right,list,level+1);
    }
    static List<Integer> preorder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            List<Integer> ans = new ArrayList<>();
            return ans;
        }
        list.add(root.data);
        preorder(root.left);
        preorder(root.right);
        return list;
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            map.put(curr.hd,curr.node.data);
            if(curr.node.left != null) q.add(new Pair(curr.hd-1,curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.hd+1,curr.node.right));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(!map.containsKey(p.hd)){
                map.put(p.hd,p.node.data);
            }
            if(p.node.left != null) q.add(new Pair(p.hd-1,p.node.left));
            if(p.node.right != null) q.add(new Pair(p.hd+1,p.node.right));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
    private static ArrayList <Integer> verticalOrder(Node root){
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer , ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.node.data);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.data);
                map.put(curr.hd,temp);
            }
            if(curr.node.left != null) q.add(new Pair(curr.hd-1,curr.node.left));
            if(curr.node.right != null) q.add(new Pair(curr.hd+1,curr.node.right));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }
    static class Pair{
        int hd;
        Node node;
        public Pair(int hd , Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    // conversion of Binary tree to Dll in inorder
    Node head = null;
    Node prev = null;
    void convertDll(Node root){
        if(root == null) return;
        convertDll(root.left);
        if(prev == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertDll(root.right);
    }
    // diameter is the max distance between two leaf node of the binary tree
    int diameter(Node root){
        if(root == null) return 0;
        int dl = diameter(root.left);
        int dr = diameter(root.right);
        int curr = height(root.left) + height(root.right);
        return Math.max(curr,Math.max(dl,dr));
    }
    // Lowest Common ancestor in a binary tree
    static Node lca(Node root , int a , int b){
        if(root == null) return null;
        if(root.data == a || root.data == b) return root;
        Node left = lca(root.left,a,b);
        Node right = lca(root.right,a,b);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
    // Time to burn a tree from a leaf node
    // wrapper class to pass the reference of depth
    static class Depth{
        int d;
        public Depth(int d){
            this.d = d;
        }
    }
    // implementation
    static int ans = -1;
    static int burningTree(Node root , int target){
        Depth depth = new Depth(-1);
        burn(root,target,depth);
        return ans;
    }
    // this function will calculate the height as well a teh answer
    static int burn(Node root , int target , Depth depth){
       if(root == null) return 0;
       if(root.data == target){
           depth.d =0;
           return 0;
       }
       Depth ld = new Depth(-1);
       Depth rd = new Depth(-1);
       int lh = burn(root.left,target,ld);
       int rh = burn(root.right,target,rd);
       if(ld.d != -1){
           ans = Math.max(ans,ld.d+1+rh);
           depth.d = ld.d +1;
       }
       if (rd.d != -1){
           ans = Math.max(ans,rd.d+1+lh);
           depth.d = rd.d+1;
       }
       return Math.max(lh,rh)+1;
    }
}
class Node{
    Node left , right;
    int data;
    public Node(int data){
        this.data = data;
    }
    public Node(int data , Node left , Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
