public class CircularLinkedListJava {
    private Node head;
    private Node tail;

    public CircularLinkedListJava() {
        this.head = null;
        this.tail = null;
    }
    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }
    public void display(){
        Node node = head;
        if(node != null){
            do {
                System.out.print(node.value + "--->");
                node = node.next;
            }while (node != head);
        }
        System.out.println("HEAD");
    }
    public void delete(int val){
        Node node = head;
        if(node == null)
            return;
        if(node.value == val){
            head = head.next;
            tail.next = head;
        }
        do {
            Node n = node.next;
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        }while (node!= head);
    }
    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
