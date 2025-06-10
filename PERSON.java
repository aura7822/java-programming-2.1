import java.util.Scanner;
public class PERSON{
    Scanner aura = new Scanner(System.in);
    String Name;
    int Age;
    void Change_Addres(){
        System.out.println("Enter your Name : ");
        Name = aura.nextLine();
        System.out.println("Enter your age : ");
        Age = aura.nextInt();
    }
}
class TEACHER extends PERSON{
    double Basic_pay, House_Allowance, Tax, rate_of_taxation, Gross_pay, np;


    void Compute_netsal(){
        System.out.println("Enter basic pay : ");
        Basic_pay = aura.nextDouble();
        System.out.println("Enter house allowance : ");
        House_Allowance = aura.nextDouble();
        Gross_pay = Basic_pay+House_Allowance;
        System.out.println("Enter taxation rate in % : ");
        rate_of_taxation = aura.nextDouble();
        Tax = Basic_pay*rate_of_taxation*0.01;
        np = Gross_pay-Tax;
System.out.println("==OUTPUT==");
System.out.println("Name : "+Name);
        System.out.println("Age : "+Age);
        System.out.println("Gross pay : "+Gross_pay);
        System.out.println("Tax payable : "+Tax);
        System.out.println("Net pay : "+np);
    }
    public static void main(String[]args){
        TEACHER employee = new TEACHER();
        employee.Compute_netsal();
    }

}