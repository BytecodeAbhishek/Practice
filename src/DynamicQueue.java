public class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super();
    }
    public DynamicQueue(int size){
        super(size);
    }
    @Override
    public boolean insert(int item){
        if(this.isFull()){
            int[] temp = new int[data.length*2];
            // copy all previous item in new
            for(int i =0; i<data.length; i++){
                temp[i] = data[(front+i) % data.length];
            }
            // Because the array is full now
            front =0;
            end = data.length;
            data = temp;
        }
        // insert item
        return super.insert(item);
    }
}
