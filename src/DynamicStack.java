public class DynamicStack extends StackImplementation {
    public DynamicStack(){
        super(); // It will call non parametrised constructor of parent class.
    }
    public DynamicStack(int size){
        super(size); // It will call parametrised constructor of parent class.
    }
    @Override
    public boolean push(int item){
        if(this.isFull()){
            int[] temp = new int[data.length*2];
            // copy all previous item in new
            for(int i =0; i<data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        // insert item
        return super.push(item);
    }
}
