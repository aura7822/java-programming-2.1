//A java program for a simple login page
/*
NAME : Joshua Aura
ADM NO: BSE-05-0180/2024
GROUP : Group 3
 */
import java.util.Scanner;
public class Main{
    private static final String CORRECT_USERNAME = "aura";
    private static final String CORRECT_PASSWORD = "7822";
    private static final int MAX_ATTEMPTS = 3;
    public static void main(String[]args){
        Scanner aura = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;
        while(attempts<MAX_ATTEMPTS && !loggedIn){
            System.out.println("Attempt"+(attempts + 1)+"of"+MAX_ATTEMPTS);
            System.out.println("Enter your username : ");
            String username = aura.nextLine();
            System.out.println("Enter your password : ");
            String password = aura.nextLine();
            if(username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)){
                System.out.println("Log in successfull");
            }else{
                System.out.println("Incorrect username or password! try again");
                attempts++;
            }
if(!loggedIn){
    System.out.println("Maximum login attempts reached");
}
        }
    }
}