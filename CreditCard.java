public class CreditCard
{
  // Instance variables
  private String customer; // name of the customer( e.g.  "John Bowman")
  private String bank;     // name of bank (e.g "Bank of America")
  private String account;  //  Account identifier
  private int limit;       // credit limit in dollars
  protected double balance; // current balance in dollars
  
  //Constructors
  public CreditCard()
  {
    customer="";
    bank="";
    account="";
    limit=0;
    balance=0.0;
  }
  public CreditCard(String cust, String bk, String acnt, int lim, double initialBal)
  {
    customer=cust;
    bank = bk;
    account = acnt;
    limit = lim;
    balance = initialBal;
  }
  public CreditCard(String cust, String bk, String acnt, int lim)
  {
    this(cust,bk,acnt,lim,0.0);
  }
  // Accessor methods:
  public String getCustomer()
  {
    return customer;
  }
  public String getBank()
  {
    return bank;
  }
  public String getAccount()
  {
    return account;
  }
  public int getLimit()
  { 
    return limit;
  }
  public double getBalance()
  {
    return balance;
  }
  //Update methods
  public void setCustomer(String cust)
  {
    customer = cust;
  }
  public void setBank(String bk)
  {
    bank = bk;
  }
  public void setAccount(String acnt)
  {
    account = acnt;
  }
  public void setLimit(int lim)
  {
    limit = lim;
  }
  public void setBalance(double initialBalance)
  {
    balance = initialBalance;
  }
  public boolean change( double price)
  {
    if (price + balance > limit)
        return false;
    // at this point the charge is successful
    balance += price;
    return true;
  }
  public void makePayment(double amount)
  {
    balance -= amount;
  }
  
  // Utility method to print a card's information
  public static void printSummary(CreditCard card)
  {
    System.out.println("Customer = " + card.customer);
    System.out.println("Bank = " + card.bank);
    System.out.println("Account =  " + card.account);
    System.out.println("Balance = " + card.balance);
    System.out.println("Limit = " + card.limit);
  }
  public String toString()
  {
    return "Customer = " + this.customer + " " + "Bank = " + this.bank + " " + "Account =  " + this.account + " " + "Balance = " + this.balance + " " + "Limit = " + this.limit;
  }
// Main
public static void main(String[] args)
{
  CreditCard wallet1 = new CreditCard("John Bowman","Californiak Savings","5391 0375 9387 5309" , 5000,2000);
  CreditCard wallet2 = new CreditCard("John Bowman","Californiak Federal","3485 0399 3395 1954" , 3500,1500);
  CreditCard wallet3 = new CreditCard("John Bowman","Californiak Finance","5391 0375 9387 5309" , 300);
  
 wallet1.printSummary(wallet1);
 wallet2.printSummary(wallet2);
 wallet3.printSummary(wallet3);
 System.out.println();
 System.out.println(wallet1.toString());
 System.out.println(wallet2.toString());
 System.out.println(wallet3.toString());
 CreditCard wallet4 = new CreditCard();
 wallet4.setCustomer("John Bowman");
 wallet4.setBank("Wells Fargo");
 wallet4.setAccount("1111 2222 3333 4444");
 wallet4.setBalance(5000.00);
 wallet4.setLimit(10000);
 System.out.println(wallet4.toString());
 wallet4.printSummary(wallet4);
 wallet4.change(350.);
 wallet4.printSummary(wallet4);
 wallet4.makePayment(200);
 wallet4.printSummary(wallet4);
}
}