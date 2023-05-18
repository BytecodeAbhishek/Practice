import java.util.Scanner;

public class BinaryTree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(size(root));
        System.out.println(max(root));
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
