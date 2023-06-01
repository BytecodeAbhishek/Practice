import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        if(root == null) return false;
        if(root.data == x) return true;
        else if(root.data > x) return search(root.left,x);
        else return search(root.right,x);
    }
    // Function to insert a node in a BST. recursive in notebook
    Node insert(Node root, int Key) {
        Node node = new Node(Key);
        Node parent = null;
        Node curr = root;
        while(curr != null){
            parent = curr;
            if(curr.data > Key) curr = curr.left;
            else curr = curr.right;
        }
        if(parent == null) return node;
        if(parent.data > Key) parent.left = node;
        else if(parent.data == Key) return root;
        else parent.right = node;
        return root;
    }
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int X) {
        if(root == null) return null;
        if(root.data > X){
            root.left = deleteNode(root.left,X);
        }else if(root.data < X){
            root.right = deleteNode(root.right,X);
        }else{
            if(root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteNode(root.right,root.data);
        }
        return root;
    }
    //Function to check whether a Binary Tree is BST or not.
    Node prev = null;
    boolean isBST(Node root)
    {
        //   return isValid(root, Long.MIN_VALUE , Long.MAX_VALUE);
        if(root != null){
            if(!isBST(root.left)) return false;
            if(prev != null && root.data <= prev.data) return false;
            prev = root;
            return isBST(root.right);
        }
        return true;
    }
    // private static boolean isValid(Node root , long min , long max){
    //     if(root == null) return true;
    //     if(root.data <= min || root.data  >= max){
    //         return false;
    //     }
    //     return isValid(root.left,min,root.data) &&
    //             isValid(root.right,root.data,max);
    // }

    // Function to find ceil and floor
    private static int floor(Node root , int key){
      int ans = Integer.MAX_VALUE;
      // ceil is jst the opposite
      while(root != null){
          if(root.data == key) return root.data;
          else if(root.data > key) root = root.left;
          else {
              ans = root.data;
              root = root.right;
          }
      }
      return ans;
    }
    // function to find if pair is present in the bst or not
    private static int pair(Node root , int sum){
        Set<Integer> set = new HashSet<>();
        boolean ans = pairUtil(root,sum,set);
        return ans ? 1:0;
    }
    private static boolean pairUtil(Node root , int sum , Set<Integer> set){
        if(root == null) return false;
        if(pairUtil(root.left,sum,set)) return true;
        if(set.contains(sum-root.data)) return true;
        set.add(root.data);
        return pairUtil(root.right,sum,set);
    }

    private static int minValue(Node root){
        int value = 0;
        while(root != null){
            value = root.data;
            root = root.left;
        }
        return value;
    }
    private class Node{
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
}

