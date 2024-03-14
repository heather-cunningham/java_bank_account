import java.util.Scanner;

public class DemoBankAccount
{ 
   static Scanner keyboard = new Scanner(System.in); 
     
   public static void main(String [] args) throws Exception
   {
      BankAccount mySavings = new SavingsAccount(true, 500.00, .015, "Savings");
      BankAccount myChecking = new CheckingAccount(true, 11000.00, .01, "Checking");
      String accntSelected = "";
      
      do
      {
         System.out.println("\nHomescreen:");
         System.out.println("-------------");
         System.out.println("Access which account? (S for Savings; C for Checking; X to Exit)");
         accntSelected = keyboard.nextLine();
         switch(accntSelected)
         {
            case "S":
            case "s":
               menu();
               menuSelection(mySavings);
               break;
            case "C":
            case "c":
               menu();
               menuSelection(myChecking);
               break;
            case "X":
            case "x":
               System.out.println("Thank you for banking with us.");
               return;   
         }//end switch accountAccess
      }while(accntSelected != "S" || accntSelected != "s" || accntSelected != "C" || accntSelected != "c");//end do while
      keyboard.nextLine();//flush line
   }//end main
      
   public static void menu()
   {
      System.out.println("\nMenu");
      System.out.println("----");
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw/Write Check/Debit");
      System.out.println("3. Display Balance");
      System.out.println("4. Monthly Service Charges");
      System.out.println("M for Menu");
      System.out.println("R for Return to Homescreen");
      System.out.println("X for Exit");
    }//end menu
    
    public static void menuSelection(BankAccount accountPassed)
    {  
      String menuOption = ""; 
      System.out.println("\nMenu Selection: ");
      menuOption = keyboard.nextLine();
      switch(menuOption)
      {
         //deposit
         case "1":
            System.out.println("\nHow much is the deposit?" );
            System.out.print("$:");
            double depositAmt = keyboard.nextDouble();
            accountPassed.deposit(depositAmt);
               keyboard.nextLine();//flush line 
            System.out.println("\nThank you, $" + depositAmt + " deposited to " + accountPassed.getAccountType() );
            System.out.println(accountPassed.getAccountType() + " deposits this month: " +  accountPassed.getMonthlyDeposits() );
            menu();
            menuSelection(accountPassed);
            break;
         //Withdraw/Write Check/Debit
         case "2":
            System.out.println("\nHow much is the withdrawal/check/debit?" );
            System.out.print("$:");
            double withdrawAmt = keyboard.nextDouble();
            accountPassed.withdraw(withdrawAmt);
               keyboard.nextLine();//flush line 
            System.out.println("\nThank you, $" + withdrawAmt + " withdrawn from " + accountPassed.getAccountType() );
            if (accountPassed.getAccountType() == "Savings")
               System.out.println(accountPassed.getAccountType() + " withdrawals this month: " +  accountPassed.getMonthlyWithdrawals() );
            if (accountPassed.getAccountType() == "Checking")
               System.out.println(accountPassed.getAccountType() + " checks/debits this month: " +  accountPassed.getMonthlyWithdrawals() );
            menu();
            menuSelection(accountPassed);
            break;
         //Display Balance
         case "3":
            System.out.println("\nCurrent balance in " + accountPassed.getAccountType() + ": $" + accountPassed.getBalance() );
            System.out.println("*Current balance only reflects past monthly service charges and fees.");
            menu();
            menuSelection(accountPassed);
            break;
         //Monthly Balance
         case "4":
            accountPassed.monthlyProcess();
            menu();
            menuSelection(accountPassed);
            break;
         //Menu
         case "M":
         case "m":
            menu();
            menuSelection(accountPassed);
         //Return to Homescreen
         case "R":
         case "r":
            return;
         //Exit
         case "X":
         case "x":
            System.out.println("Thank you for banking with us.");
            System.exit(0);
            break;   
         default:
            System.out.println("\nMenu selection must be 1-6, M for menu, or R for return to Homescreen.");
            break;    
      }//end switch menuSelection
   }//end menuSelection
   

}//end class