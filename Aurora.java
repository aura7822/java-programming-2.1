//overloading in java
import java.util.Scanner;
public class Aurora{
    void registration(String uc1, int cw1, int es1){
        System.out.println("Unit one code : "+uc1);
        if(cw1 < 0 || cw1 > 30){
            System.out.println("Error ! Enter the correct score!");
        }else{
            System.out.println("Unit one course work : "+cw1+"out of 30");
        }
        if(es1 < 0 || es1 > 70){
            System.out.println("Error ! Enter the correct exam score!");
        }else {
            System.out.println("Unit one exam score : " + es1 + "out of 70");
        }
        System.out.println("Total score : "+(cw1+es1)+"out of 100");
    }
    void registration(String uc2, String cw2, int es2){
        System.out.println("Unit two code : "+uc2);
        float cw2 = Float.parseFloat(cw2String);
        if(cw2 < 0 || cw2 > 30){
            System.out.println("Error ! Enter the correct score!");
        }else{
            System.out.println("Unit two course work : "+cw2+"out of 30");
        }
        if(es2 < 0 || es2 > 70){
            System.out.println("Error ! Enter the correct exam score!");
        }else {
            System.out.println("Unit two exam score : " + es2 + "out of 70");
        }
        System.out.println("Total score : "+(cw2+es2)+"out of 100");

    }
    public static void main(String[]args){
        Scanner aura = new Scanner(System.in);
        Aurora student = new Aurora();
        System.out.println("Enter unit one code : ");
        String uc1 = aura.nextLine();
        System.out.println("Enter unit two code : ");
        String uc2 = aura.nextLine();
        System.out.println("Enter unit one course work : ");
        int cw1 = aura.nextInt();
        System.out.println("Enter unit two course work : ");
        String cw2 = aura.nextLine();
        System.out.println("Enter unit one exam score : ");
        int es1 = aura.nextInt();
        System.out.println("Enter unit two exam score : ");
        int es2 = aura.nextInt();
        student.registration(uc1,cw1, es1);
        student.registration(uc2,cw2, es2);
    }
}