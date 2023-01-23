import java.util.Arrays;
import java.util.Scanner;
public class addORremove {
    public static void main(String[] args) {
        addORremove ob = new addORremove();
       //ob.insert();
      // ob.delete();
       usingArray obj = new usingArray();
        System.out.println(""+ Arrays.toString(obj.add()));
        System.out.println(""+Arrays.toString(obj.delete()));
    }
    public  int [] delete () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements in array  : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
            System.out.println("Enter at which index you want to delete the element : ");
            int index = sc.nextInt();
            for(int i=index ; i<(n-1) ; i++)
                arr[i] = arr[i+1];

            for(int i=0;i<n-1;i++)
                System.out.println(arr[i]);
            return arr;
        }
        public   int[] insert (){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of array : ");
            int n = sc.nextInt();
            System.out.println("Enter the elements in array  : ");
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Enter at which index you want to enter the element : ");
            int index = sc.nextInt();
            System.out.println("Enter the element you want to enter : ");
            int element = sc.nextInt();
            for(int i=(n-1) ; i>(index-1) ; i--)
                arr[i+1] = arr[i];
            arr[index] = element;

            for(int i=0;i<=n;i++)
                System.out.println(arr[i]);
            return arr;
        }

    }
// BY using another array
class usingArray{
    public int[] add (){
        int [] arr = {1,2,3,4,5};
        int index = 2 ;
        int element = 6;
        int [] newarr = new int[arr.length+1];
        int j = 0;
        for (int i=0; i< newarr.length; i++){
            if (i==index)
                newarr[i]=element;
            else {
                newarr[i] = arr[j];
                j++;
            }

        }
        return newarr;
    }
public int[] delete (){
        int [] arr ={1, 2 , 3, 4 , 5};
        int index = 2;
        int[] newarr = new int[arr.length-1];
        int k =0;
        for(int i = 0; i<arr.length; i++){
            if(i==index)
                continue;
            newarr[k++]=arr[i];
        }
        return newarr;
}

}