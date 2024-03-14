//Heather Cunningham 10/24/2016 Adv Java Fall
//BankAccountv2 -- redo

import java.util.Calendar;
import java.util.Date;

public abstract class BankAccount
{
   private double balance, annualInterestRate, serviceCharges;
   private int monthlyDeposits, monthlyWithdrawals;
   private String accountType;
   public Date calendar = new Date();   
//---------------constr------------------   
   public BankAccount()
   {
      balance = 0.00;
      annualInterestRate = 0.00;
      serviceCharges = 0.00;
      monthlyDeposits = 0; 
      monthlyWithdrawals = 0;
      accountType = "";
   }//end default constr 
   
   public BankAccount(double balancePassed, double annualInterestRatePassed, String accountTypePassed)
   {
      balance = balancePassed;
      annualInterestRate = annualInterestRatePassed;
      //Note: These vars can be set to 0 because only would be instantiating brand new accounts.
      serviceCharges = 0;
      monthlyDeposits = 0; 
      monthlyWithdrawals = 0;
      accountType = accountTypePassed;
   }//end nondefault constr 
   
//--------------------setters----------------------
   public void setBalance(double balancePassed)
   {
      balance = balancePassed;   
   }//end setBalance
   
   public void setAnnualInterestRate(double annualInterestRatePassed)
   {
      annualInterestRate = annualInterestRatePassed;
   }//end setAnnualInterestRate
   
   public void setMonthlyDeposits(int monthlyDepositsPassed)
   {
      monthlyDeposits = monthlyDepositsPassed;   
   }//end setMonthlyDeposits  
   
   public void setMonthlyWithdrawals(int monthlyWithdrawalsPassed)
   {
      monthlyWithdrawals = monthlyWithdrawalsPassed;   
   }//end setMonthlyWithdrawals
   
   public void setServiceCharges(double serviceChargesPassed)
   {
      serviceCharges = serviceChargesPassed;
   }//end setServiceChargesPassed
   
   public void setAccountType(String accountTypePassed )
   {      
      accountType = accountTypePassed;
   }//end setAccountActive

//--------------------getters----------------------   
   public double getBalance()
   {
      return balance;
   }//end getBalance
   
   public double getAnnualInterestRate()
   {
      return annualInterestRate;
   }//end getAnnualInterestRate

   public int getMonthlyDeposits()
   {
      return monthlyDeposits;   
   }//end getMonthlyDeposits  
   
   public int getMonthlyWithdrawals()
   {
      return monthlyWithdrawals;   
   }//end getMonthlyWithdrawals
 
   public double getServiceCharges()
   {
      return serviceCharges;
   }//end getServiceChargesPassed
   
   public String getAccountType()
   {      
      return accountType;      
   }//end getAccountActive


//-----------------------meths---------------------
   public void deposit(double depositAmtPassed)
   {
      setBalance(getBalance() + depositAmtPassed);
      setMonthlyDeposits(++monthlyDeposits);
   }//end deposit
   
   public void withdraw(double withdrawalPassed)
   {
     setBalance(getBalance() - withdrawalPassed);
     setMonthlyWithdrawals(++monthlyWithdrawals);
   }//end withdraw
   
   public void calcInterest()
   {
      setBalance(getBalance() + (getBalance() * (annualInterestRate/12)) );
   }//end calcInterest
   
   public void monthlyProcess()
   {
      System.out.println("\nMonthly service charges and interest assessed on the 28th of each month."); 
      System.out.println("-----------------------");
      System.out.println();
      if (calendar.getDate() == 28 )
      {
         System.out.println("Beginning balance: $" + getBalance() );
         System.out.println("Service Charges : -$" + getServiceCharges() );
         setBalance(getBalance() - serviceCharges);
         calcInterest();
         System.out.println("Current balance in " + getAccountType() + " with interest: $" + getBalance() );
         System.out.println("Monthly deposits: " + getMonthlyDeposits() );
         System.out.println("Monthly withdrawals: " + getMonthlyWithdrawals() );
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
       
}//end class BankAccount