//java program to demo method overloading
public class addition{
    void sum(int a, int b){
        int c = a+b;
        System.out.println("Addition of two numbers : "+c);
    }
    void sum(int a, int b, int d){
        int c = a+b+d;
        System.out.println("Addition of three numbers : "+c);
    }
    public static void main(String[]args){
        addition obj = new addition();
        obj.sum(40, 50);
        obj.sum(10, 20, 30);
    }
}