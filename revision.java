import java.util.Scanner;
public  class  revision{
    public static void main(String[] args){
        Scanner aura = new Scanner(System.in);
        System.output.println("Enter rank : ");
        int rank;
        rank = aura.nextInt();
        if(rank==1)
            System.out.println("Amount is 1000000");
        else if(rank == 2)
            System.out.println("Amount is 500000");
        else if(rank == 3)
            System.out.println("Amount is 250000");
        else System.out.println("Amount is 0");
    }
}