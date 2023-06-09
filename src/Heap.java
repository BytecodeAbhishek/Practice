public class Heap {
    public static void main(String[] args) {

    }
    // construction of heap;
    private static void heapify(int[] arr , int n , int i){
        int largest =i;
        int l = 2*i;
        int r = 2*i+1;
        if(l<=n && arr[largest] < arr[l]) largest = l;
        if(r<=n && arr[largest] < arr[r]) largest = r;
        if(largest != i){
            swap(arr,i,largest);
            heapify(arr,n,largest);
        }
    }
    private static void buildHeap(int[] arr , int n){
        for(int i=n/2; i>0; i--){
            heapify(arr,n,i);
        }
    }
    // method for heapsort
    private static void heapSort(int[] arr ,int n){
        for(int i=n; i>0; i--){
            // swap the first element with the last element
            swap(arr,1,i);
            // heapify the remaining tree
            heapify(arr,i-1,1);
        }
    }
    // insert method in a heap
    private static void insert(int[] arr , int n , int element){
        n = n+1;
        arr[n] = element;
        int i = n;
        while(i>1){
            int parent = i/2;
            if(arr[parent] < arr[i]){
                swap(arr,i,parent);
                i = parent;
            }else return;
        }
    }

    // method for deletion inside a heap
    private static void delete(int[] arr , int n){
        arr[0] = arr[n];
        n = n-1;
        int i =1;
        while(i<n){
            int leftChild = arr[2*i];
            int rightChild = arr[2*i+1];
            int larger = leftChild > rightChild ? 2*i : 2*i+1;
            if(larger <=n  && arr[i] < arr[larger]){
                swap(arr,i,larger);
                i = larger;
            }else return;
        }
    }

    private static void swap(int[] arr, int i, int parent) {
        int temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;
    }
}
