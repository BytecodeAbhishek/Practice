// Implementation of Singly Linked List
public class LinkedListJava {
    private Node head;
    private Node tail;
    private int size;
    public LinkedListJava(){
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size += 1;
    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size += 1;
    }
    public void insert(int val , int index){
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size ++;
    }
    // insert using recursion
    public void insertRec(int val , int index){
        head = insertRec(val, index,head);
    }
    private Node insertRec(int val , int index , Node node){
        if(index == 0){
            Node temp = new Node(val , node);
            size++;
            return temp;
        }
        node.next = insertRec(val,index--,node.next);
        return node;
    }
    public void display(){
        Node  temp = head;
        while(temp != null){
            System.out.print(temp.value + "--> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null)
            tail = null;
        size--;
        return val;
    }
    public Node get(int index){
        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }
    public int deleteLast(){
        if(size<=1)
            return deleteFirst();
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public int delete(int index){
        if(index == 0)
            return deleteFirst();
        if(index == size-1)
            return deleteLast();
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public void removeDuplicates(){
        Node node = head;
        while(node.next!=null){
            if(node.value == node.next.value){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
    }
    // leetcode merge two sorted lists
     public  LinkedListJava merge(LinkedListJava first , LinkedListJava second){
        Node f = first.head;
        Node s = second.head;
        LinkedListJava ans = new LinkedListJava();
        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while( f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while( s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }
    private Node getMid() {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void bubbleSort(){
        bubbleSort(size-1,0);
    }
    private void bubbleSort(int row , int col){
        if(row == 0){
            return;
        }
        if(col < row){
            Node first = get(col);
            Node second = get(col+1);
            if(first.value > second.value){
               // Swap
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node previous = get(col-1);
                    previous.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }else{
                    Node previous = get(col-1);
                    previous.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row,col+1);
        }else {
            bubbleSort(row - 1, 0);
        }
    }
    private void reverseRecursive(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverseRecursive(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    // In place Reversal of linked list
    public void Reverse(){
        if(size < 2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;
    }
    public Node reverseBetween(Node head, int left, int right) {
         if(left == right){
             return head;
         }
         // skip the first left-1 nodes
         Node present = head;
         Node prev = null;
         for(int i =0; present!= null && i< left-1; i++){
             prev = present;
             present = present.next;
         }
         Node last = prev;
         Node newEnd = present;
         Node next = present.next;
         // reverse between left and right
        for(int i =0; present != null && i< right-left+1; i++){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        if(last != null){
           last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = present;
        return head;
    }
//    public boolean isPalindrome(Node head) {
//        Node mid = getMid();
//        //Node headSecond = Reverse();
//        //Node reverseHead = headSecond;
//        // Compare both the halves
////        while(head != null && headSecond != null){
////            if(head.value != headSecond.value ){
////                break;
////            }
////            head = head.next;
////            headSecond = headSecond,next;
////        }
//        //Reverse();
//        //return head == null || headSecond== null;
//    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value , Node next){
            this.value = value;
            this.next = next;
        }
    }
}
