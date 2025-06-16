//overriding in java
import java.util.Scanner;
public class Aura{
    void capture_details(int id, String name, double bill){
        System.out.println("===Base class output===");
        System.out.println("Patient ID : "+id);
        System.out.println("Patient Name : "+name);
        System.out.println("Payable amount : "+bill);
    }
}
class Patient extends Aura{
    void capture_details(int id, String name, double bill){
        System.out.println("===Derived class output===");
        System.out.println("Patient ID : "+id);
        System.out.println("Patient Name : "+name);
        System.out.println("Payable amount : "+bill);
    }
    public static void main(String[]args){
        Scanner BSE = new Scanner(System.in);
        Aura client = new Aura();
        System.out.println("Enter patient name :");
        String name = BSE.nextLine();
        System.out.println("Enter patient ID :");
        int id = BSE.nextInt();
        System.out.println("Enter patient bill :");
        double bill = BSE.nextDouble();
        client.capture_details(id, name, bill);
    }
}