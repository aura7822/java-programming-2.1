import java.util.Scanner;
public class Main{
    double fee, units, total;
    public Main(double fee, double units){
        this.fee=fee;
        this.units=units;
    }
    void compute(){
        total = units*55+fee;
        System.out.printf("Standing charge is : %.2f", total);
    }

    public static void main(String[]args){
        Scanner aura = new Scanner(System.in);
        System.out.println("Enter units consumed : ");
        double units = aura.nextDouble();
        System.out.println("Enter standing charge : ");
        double fee = aura.nextDouble();

        Main client = new Main(fee, units);
        client.compute();
    }
}
