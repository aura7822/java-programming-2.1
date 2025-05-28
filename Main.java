public class Main{
    public static void main(String[]args){
        int arr[] = new int[3];
        System.out.println("Array before insertion : ");
        for(int i=0; i<3; i++)
            System.out.println("arr["+i+"] = "+ arr[i]);
                               // which index and pulling element at the index
        System.out.println("Inserting array elements...");
        for(int i=0; i<3; i++) {
            arr[i] = i + 3;
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}