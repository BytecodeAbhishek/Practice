

public class DoublyLinkedListJava {
    Node head;
    int size;
    public DoublyLinkedListJava() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null)
            head.prev = node;
        head = node;
        size++;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            last = temp;
            System.out.print(temp.value+"-->");
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println("Printing Reverse : ");
        while(last != null){
            System.out.print(last.value+"-->");
            last = last.prev;
        }
        System.out.println("START");
    }
    public void insertLast(int val){
        Node node = new Node(val);
        node.next = null;
        Node last = head;
        if(head == null){
            head = node;
            return;
        }
        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
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
    public void insert(int val , int index){
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }
        Node p = find(index);
        if(p==null){
            System.out.println("Node does not exist");
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next.prev != null)
        node.next.prev = node;
        size ++;
    }
    private class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value){
           this.value = value;
        }
        public Node(int value, Node next , Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
