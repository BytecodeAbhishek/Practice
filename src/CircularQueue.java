public class CircularQueue {
    protected int data[];
    int end =0;
    int front =0;
    private int size = 0;
    private static final int DEFAULT_SIZE = 10;
    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull() {
        return size == data.length; // ptr is at last index
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public CircularQueue(int size){
        this.data = new int[size];
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        end = end% data.length;
        size++;
        return true;
    }
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot delete from empty queue");
        }
        int removed = data[front++];
        front = front%data.length;
        size--;
        return removed;
    }
    public int peek () throws Exception{
        if(isEmpty()){
            throw new Exception(("Cannot peek"));
        }
        return data[front];
    }
    public void display(){
        if (isEmpty()){
            System.out.println("Empty");
            return;
        }
        int i = front;
        do{
            System.out.println(data[i]);
            i++;
            i = i%data.length;
        }while(i != end);
    }
}
