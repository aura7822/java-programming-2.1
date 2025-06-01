//calling by method
import java.util.Scanner;
public class Main{
   double units, fee, charge;

   void compute(){
       Scanner aura = new Scanner(System.in);
       System.out.println("Enter units consumed : ");
       units = aura.nextDouble();
       System.out.println("Enter Standing charge : ");
       charge = aura.nextDouble();
       fee = units*55+charge;
       System.out.printf("Total charge is : %.2f", fee);
   }
   public static void main(String[]args){
       Main client = new Main();
       client.compute();
   }
}
/*when we want to call by variable the void function
wont be available instea dwe will use the main function directly and
the variables must have client.variable_name
 */