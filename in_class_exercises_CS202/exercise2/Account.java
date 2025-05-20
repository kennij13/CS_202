package in_class_exercises_CS202.exercise2;

import java.sql.Date;

public class Account{
    //data fields
    private int id=0;
    private double balance=0.0;
    private double annualInterestRate=0.0;
    private Date dateCreated;

    //methods
    public Account()
    {
      id=0;
      balance=0.0;
      annualInterestRate=0.0;
      dateCreated= new Date(id);
    
    }

    public Account(int id, double balance)
    {
      this.id= id;
      this.balance= balance;
    }

    //mutator -  setter
    public void setId(int id)
    {
      this.id=id;
    }

    public void setBalance(double balance)
    {
      this.balance=balance;
    }

    public void setAnnualInterestRate(double annualInterestRate)
    {
      this.annualInterestRate=annualInterestRate;
    }

    //accessor- getter
    public int getId()
    {
      return id; 
    }

    public double getBalance()
    {
      return balance; 
    }

    public double getAnnualInterestRate()
    {
      return annualInterestRate; 
    }

    public Date getDateCreated()
    {
      return dateCreated; 
    }
    
    //general/utility methods

    public double getMonthlyInterestRate()
    {
      return annualInterestRate/12; 
    }

    public double getMonthlyInterest()
    {
      return balance*getMonthlyInterest(); 
    }

    public void withdraw(double amount)
    {
      balance= balance-amount;
    }

    public void deposit(double amount)
    {
      balance= balance+amount; 
    }

}

