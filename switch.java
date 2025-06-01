import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner aura = new Scanner(System.in);
        System.out.println("Enter rank : ");
        int rank;
        rank =  aura.nextInt();
        switch (rank){
            case 1:
                System.out.println("Amount is 1000000");
                break;
            case 2:
                System.out.println("Amount is 500000");
                break;
            case 3:
                System.out.println("Amount is 250000");
            default:
                System.out.print("Amount is 0");
        }
    }
}