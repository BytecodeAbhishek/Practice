public class Recursion {
    public static void main(String[] args){
    // print(1);
//        int n =7;
//        for (int i =0; i<n; i++){
//            System.out.println(fibonacci(i));
//        }
//       int [] arr = {2,3,4,5,6,7,8};
//       int target = 5;
//        System.out.println(BinarySearch(arr,target,0,arr.length-1));
        int n = 12345;
        System.out.println(reverse(n));
    }
     static void print(int n){
        // It is known as base condition used to stop the function. , stack overflow error may come
         // without this
        if(n>5){
            return;
        }
        // function body
         // every call of the function takes some memory
         System.out.println(n);
        print(n+1);
     }
     static int fibonacci (int n){
        if (n < 2){
            return n;
        }
         return (fibonacci(n-1)+fibonacci(n-2));
     }
     static int BinarySearch(int [] arr , int target , int start , int end){
       if (start > end){
          return -1;
       }
       int mid = start + (end-start)/2;
       if (arr[mid] > target){
           // end = mid-1;
           return BinarySearch(arr,target,start,mid-1);
       }
       else if(arr[mid] < target){
           //start= mid+1;
           return BinarySearch(arr,target,mid+1,end);
       }
       else {
           return mid;
       }
       //BinarySearch(arr,target,start,end);
       //return -1;
     }
     static int factorial(int n){
        if (n  <= 1){
            return 1;
        }
        return (n*factorial(n-1));
     }
     static int reverse(int n){
        // Sometimes you might need some extra variables in the argument
         // In that case make another helper function
         int digit = (int)(Math.log10(n)+1);
         return helper(n , digit);
     }
     private static int helper(int n , int digit){
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        return rem*(int)(Math.pow(10,digit-1)) + helper(n/10, digit-1);
     }
     static boolean palindrome (int n){
        return (n == reverse(n));
     }
     static int count(int n){
        return helperCount(n,0);
     }
     private static int helperCount(int n , int c){
        if( n == 0){
            return c;
        }
        if (n%10 == 0){
            return helper(n/10 , c+1);
        }
        return helper(n/10 , c);
     }
}
