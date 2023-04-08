public class LinkedListMain {
    public static void main(String[] args) {
       // LinkedListJava list = new LinkedListJava();
//        list.insertFirst(1);
//        list.insertFirst(2);
//        list.insertFirst(3);
//        list.insertLast(4);
//        list.insert(5,2);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.insertLast(1);
//        list.display();
        DoublyLinkedListJava list = new DoublyLinkedListJava();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insert(6,5);
        list.display();
        CircularLinkedListJava list1 = new CircularLinkedListJava();
        list1.insert(23);
        list1.insert(24);
        list1.insert(25);
        list1.display();
        list1.delete(24);
        list1.display();
    }
}
