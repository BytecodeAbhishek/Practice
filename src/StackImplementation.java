public class StackImplementation {
     protected int[] data;
     int ptr = -1;
     private static final int DEFAULT_SIZE = 10;
     public StackImplementation(){
         this(DEFAULT_SIZE);
     }
     public StackImplementation(int size){
         // giving size to the array
          this.data = new int[size];
     }
     public boolean push(int item){
         if(isFull()){
             System.out.println("Stack is Full");
             return false;
         }
         ptr++;
         data[ptr] = item;
         return true;
     }
     public int pop() throws StackException{
         if(isEmpty()){
             throw new StackException("Cannot pop from an empty stack");
         }
//         int element = data[ptr];
//         ptr--;
//         return element;
         return data[ptr--];
     }
     public int peek() throws StackException{
         if (isEmpty()){
             throw new StackException("Cannot peek from an empty stack");
         }
         return data[ptr];
     }
    public boolean isFull() {
        return ptr == data.length-1; // ptr is at last index
    }
    public boolean isEmpty() {
        return ptr == -1;
    }
}
