public class Main{
    public static void main(String[]args){
        int arr[] = new int[3];
        int n = arr.length;
        System.out.println("Arrays before deletion : ");
        for(int i=0; i<3; i++){
            arr[i]= i+3;
            System.out.println("Arr["+i+"] ="+arr[i]);
        }
        System.out.println("Deleting...");
        for(int i=1; i<n; i++){
            arr[i]=i+1;
            n=n-1;
        }
        System.out.println("Arrays after deletion : ");
        for(int i=0; i<3; i++){
            System.out.println("arr["+i+"] ="+arr[i]);
        }

    }
}