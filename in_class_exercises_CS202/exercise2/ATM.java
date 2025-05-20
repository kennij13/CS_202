package in_class_exercises_CS202.exercise2;
import java.util.*;

public class ATM {
    
    public static void main(String[] args) {
        //create accounts
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i]= new Account(i, 100.0);
            
        }

        Scanner keyboard= new Scanner(System.in);
        //start ATM
        while (true) //keep ATM running 
        {
            //serving a customer 
            System.out.print("Enter an id:");
            int id = keyboard.nextInt(); 
            while (id < 0 || id > 9) 
            {
             System.out.println("Invalid Id");   
             System.out.print("Enter an id:");
             id = keyboard.nextInt(); 
            }
            //user is legit, print menu
            while (true) //keep serving the same customer
            {
              int choice= menu();
              while (choice < 0 && choice > 4) 
              {
                System.out.println("Invalid Option");
                menu(); 
              }

              if (choice==4) 
              {
                System.out.println("Goodbye!");
                break;
              }
              
              if (choice ==1) //check balancce 
              {
                System.out.println("The balance is: $" + accounts[id].getBalance());
              } 
              
              if(choice ==2)// withdraw
              {
                System.out.print("Enter an amount to withdraw:");
                double withdrawAmount= keyboard.nextDouble();
                accounts[id].withdraw(withdrawAmount); 
              }
             
              if (choice==3) //deposit
              {
                System.out.print("Enter an amount to deposit:");
                double depositAmount= keyboard.nextDouble();
                accounts[id].deposit(depositAmount);   
              }
                 
            }
           
        }
        
    }

    public static int menu()
    {
        System.out.println("Main Menu:");
        System.out.println("1: Check balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
        System.out.print("Enter a choice:");
        Scanner keyboard= new Scanner(System.in);
        int choice= keyboard.nextInt(); 
        return choice;
        
    }
   
}

