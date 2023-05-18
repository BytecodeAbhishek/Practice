public class QueueImplementation {
    protected int data[];
    int end =0;
    private static final int DEFAULT_SIZE = 10;
    public QueueImplementation(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull() {
        return end == data.length; // ptr is at last index
    }
    public boolean isEmpty() {
        return end == 0;
    }
    public QueueImplementation(int size){
        this.data = new int[size];
    }
    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }
    // deletion from queue takes O(n) time
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot delete from empty queue");
        }
        int removed = data[0];
        for(int i=1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    public int peek () throws Exception{
        if(isEmpty()){
            throw new Exception(("Cannot peek"));
        }
        return data[0];
    }
    public void display(){
        for(int i =0; i<end; i++){
            System.out.print(data[i]+ " ");
        }
    }
}
