//Heather Cunningham 10/24/2016 Adv Java Fall
//BankAccountv2: SavingsAccountv2 -- redo

public class SavingsAccount extends BankAccount
{
   private boolean accountActive;

//-----------------------constrs-----------------------   
   SavingsAccount()
   {
      super();
      accountActive = false;
   }//end default constr
   
   SavingsAccount(boolean accountActivePassed, double balancePassed, double annualInterestRatePassed, 
   String accountTypePassed)
   {
      super(balancePassed,annualInterestRatePassed, accountTypePassed);
      accountActive = accountActivePassed;
   }//end nondefault constr
      
//-----------------------setters----------------------- 

   public void setAccountActive(boolean accountActivePassed)
   {
      accountActive = accountActivePassed;
   }//end setAccountActive
  
//-----------------------getters-----------------------
   public boolean getAccountActive()
   {      
      return accountActive;      
   }//end getAccountActive
   

//-----------------------other meths-------------------

   private boolean isActiveAccount()
   {
      if(getBalance() < 25 )
         accountActive = false;
      else if (getBalance() >= 25 )
         accountActive = true;
      else
         System.out.println("\nError: void account");
      
      return accountActive;      
   }//end isActiveAccount
      
   @Override
   public void deposit(double depositAmtPassed)
   {  
      setBalance(getBalance() + depositAmtPassed);
      setMonthlyDeposits(getMonthlyDeposits() + 1);
      isActiveAccount();   
   }//end deposit
   
   @Override
   public void withdraw(double withdrawalPassed)
   {      
      if(isActiveAccount() )
         setBalance(getBalance() - withdrawalPassed);
      else
      {
         System.out.println("\nWithdrawals can't be made against this account at this time because the balance is below $25.");
         System.out.println("Please, deposit $" + (25 - getBalance() ) + "to make the account active and withdraw funds.");  
      }//end if else
      setMonthlyWithdrawals(getMonthlyWithdrawals() + 1);
      isActiveAccount();        
   }//end withdraw   
   
   @Override
   public void monthlyProcess()
   {
      System.out.println("\nMonthly service charges and interest assessed on the 28th of each month."); 
      System.out.println("-----------------------");
      System.out.println();
      if (calendar.getDate() == 28 )
      {
         System.out.println(getAccountType() + "beginning balance: $" + getBalance() );
         if (getMonthlyWithdrawals() > 4)
            setServiceCharges(getMonthlyWithdrawals() - 4);
         System.out.println("Service Charges : -$" + getServiceCharges() );
         setBalance(getBalance() - getServiceCharges() );
         System.out.println(getAccountType() + " annual interest rate: %" + (getAnnualInterestRate() * 100) ); 
         calcInterest();
         System.out.println("Current balance in " + getAccountType() + " with interest: $" + getBalance() );
         System.out.println("Monthly deposits: " + getMonthlyDeposits() );
         System.out.println("Monthly withdrawals: " + getMonthlyWithdrawals() );
         isActiveAccount();
         System.out.println(getAccountType() + " acount is active: " + getAccountActive() ); 
         setMonthlyDeposits(0);
         setMonthlyWithdrawals(0);
         setServiceCharges(0);
      }                  
      else
      {
         System.out.println("Current balance in " + getAccountType() + " without monthly services: $" + getBalance() );
         System.out.println("Monthly deposits: " + getMonthlyDeposits() );
         System.out.println("Monthly withdrawals: " + getMonthlyWithdrawals() );
      }//end if else the 28th 
      System.out.println();
   }//end monthlyProcess

}//end class SavingsAccount