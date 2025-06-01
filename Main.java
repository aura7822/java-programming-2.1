import java.util.Scanner;
public class Main{
    double base, height, ans;
    void calculate(){
        Scanner aura = new Scanner(System.in);
        System.out.println("Enter Base : ");
        base = aura.nextDouble();
        System.out.println("Enter Height : ");
        height = aura.nextDouble();
        ans = 0.5*base*height;
        System.out.printf("Area = %.2f", ans);

    }
    public static void main(String[]args){
        Main shape = new Main();
        shape.calculate();
    }
}