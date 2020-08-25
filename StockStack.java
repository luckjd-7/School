import java.util.*;
public class StockStack
{
  //variables
 public String TickerSymbol;    
 public String EquityName;   
 public double PricePerSharePaid; 
 public int    NumberOfSharesBought; 
 public double TotalPaid;   
 
 // Constructors
 
 public StockStack()
 {
  TickerSymbol = "";
  EquityName = "";
  PricePerSharePaid = 0.0;
  NumberOfSharesBought = 0; 
 }
   public StockStack(String TS, String EQNAME, double PPS, int NOS )
 {
  this.TickerSymbol=TS;
  this.EquityName=EQNAME;
  this.NumberOfSharesBought=NOS;
  this.PricePerSharePaid=PPS;
  this.TotalPaid=this.NumberOfSharesBought*this.PricePerSharePaid;
 }
   public void getTotal(StockStack stock, StockStack stack)
   {
     TotalPaid = stock.TotalPaid + stack.TotalPaid;
   }
// getters and setters
 public String getTickerSymbol() 
 {
  return TickerSymbol;
 }


 public void setTickerSymbol(String tickerSymbol) 
 {
  TickerSymbol = tickerSymbol;
 }


 public String getEquityName() 
 {
  return EquityName;
 }


 public void setEquityName(String equityName) 
 {
  EquityName = equityName;
 }


 public double getPricePerSharePaid() 
 {
  return PricePerSharePaid;
 }


 public void setPricePerSharePaid(double pricePerSharePaid) 
 {
  PricePerSharePaid = pricePerSharePaid;
 }


 public int getNumberOfSharesBought() 
 {
  return NumberOfSharesBought;
 }


 public void setNumberOfSharesBought(int numberOfSharesBought) 
 {
  NumberOfSharesBought = numberOfSharesBought;
 }


 public double getTotalPaid() 
 {
  return TotalPaid;
 }


 public void setTotalPaid(double totalPaid) 
 {
  TotalPaid = totalPaid;
 }

// to string method
 @Override
 public String toString() {
  return "StockStack [ TickerSymbol= " + TickerSymbol + "\n" + "EquityName = " + EquityName + "\n" + "PricePerSharePaid="
    + PricePerSharePaid + "\n" + "NumberOfSharesBought = " + NumberOfSharesBought + "\n" +  "TotalPaid = " + TotalPaid
    + " ] \n";
 }
  public static void main(String[] args) {
    //new data for program
    int numberOfSharesSold = 0;
    Stack stack = new Stack();
    StockStack xom1 = new StockStack("XOM","Exon Mobile",82.65,100);
    StockStack xom2 = new StockStack("XOM","Exon Mobile",87.23,50);
    StockStack xom3 = new StockStack("XOM","Exon Mobile",74.50,200);
    StockStack xom4 = new StockStack("XOM","Exon Mobile",66.58,100);
    StockStack d1 = new StockStack("D","Dominion Resources",74.98,350);
    StockStack d2 = new StockStack("D","Dominion Resources",76.72,200);
    StockStack d3 = new StockStack("D","Dominion Resources",79.00,100);
    StockStack d4 = new StockStack("D","Dominion Resources",77.90,180);
    //adds new data to stacks
    Stack stackXOM = new Stack();
    stackXOM.push(xom1);
    stackXOM.push(xom2);
    stackXOM.push(xom3);
    stackXOM.push(xom4);
    Stack stackD = new Stack();
    stackD.push(d1);
    stackD.push(d2);
    stackD.push(d3);
    stackD.push(d4);
    //adds the data to lists
    LinkedList listXOM = new LinkedList();
    listXOM.addLast(xom1);
    listXOM.addLast(xom2);
    listXOM.addLast(xom3);
    listXOM.addLast(xom4);
    LinkedList listD = new LinkedList();
    listD.addLast(d1);
    listD.addLast(d2);
    listD.addLast(d3);
    listD.addLast(d4);
    //user input
    System.out.println("Joey Luck CSC 202 fall 2017");
    System.out.println("press 1 to enter a new stock");
    System.out.print("Press 2 to find the LIFO and FIFO dollar cost average for the number of shares sold.");
    System.out.println();
    Scanner sc = new Scanner(System.in);//asks for user input
    Scanner scan = new Scanner(System.in);
    switch (sc.nextInt())
    {
      case 1: 
      System.out.print("please enter a new stock as listed: stock symbol,Stock name, the price per share when purchased, and the number of shares bought");
      System.out.println();
      if(scan.hasNext("XOM")) //searches for XOM to add to XOM stack
      { 
        StockStack newStock = new StockStack(scan.next(),scan.next() + " " + scan.next(),scan.nextDouble(),scan.nextInt());
        stackXOM.push(newStock);
        listXOM.addLast(newStock);
      }
      else if(scan.hasNext("D")) //searches for D to add to D stack
      { 
        StockStack newStock = new StockStack(scan.next(),scan.next() + " " + scan.next(),scan.nextDouble(),scan.nextInt());
        stackD.push(newStock);
        listD.addLast(newStock);
      }
      break;
      case 2:
      System.out.print("please enter Stock Symbol you wish to sell and how many shares");
      System.out.println();
      if(scan.hasNext("XOM")) //calculate worth of the amount sold of exon
      {
        int subtract = 0;
        double total = 0.0;
        double total2 = 0.0;
        String e = scan.next();
        numberOfSharesSold = scan.nextInt();
        if(numberOfSharesSold <= xom4.NumberOfSharesBought) 
        {
          subtract = xom4.NumberOfSharesBought - numberOfSharesSold;
          total = (xom4.NumberOfSharesBought - subtract)*xom4.PricePerSharePaid;
        }
        if(numberOfSharesSold <= xom4.NumberOfSharesBought + xom3.NumberOfSharesBought) 
        {
          subtract =  (xom4.NumberOfSharesBought + xom3.NumberOfSharesBought) - numberOfSharesSold;
          total = xom4.TotalPaid + xom3.TotalPaid - (subtract*((xom4.PricePerSharePaid + xom3.PricePerSharePaid)/2));
        }
        if(numberOfSharesSold <= xom1.NumberOfSharesBought) 
        {
          subtract = xom1.NumberOfSharesBought - numberOfSharesSold;
          total2 = (xom1.NumberOfSharesBought - subtract)*xom1.PricePerSharePaid;
        }
        if(numberOfSharesSold <= xom1.NumberOfSharesBought + xom2.NumberOfSharesBought) 
        {
          subtract =  (xom1.NumberOfSharesBought + xom2.NumberOfSharesBought) - numberOfSharesSold;
          total2 = xom1.TotalPaid + xom2.TotalPaid - (subtract*((xom1.PricePerSharePaid + xom2.PricePerSharePaid)/2));
        }
        if(numberOfSharesSold <= xom1.NumberOfSharesBought + xom2.NumberOfSharesBought + xom3.NumberOfSharesBought) 
        {
          subtract =  (xom1.NumberOfSharesBought + xom2.NumberOfSharesBought + xom3.NumberOfSharesBought) - numberOfSharesSold;
          total2 = xom1.TotalPaid + xom2.TotalPaid + xom3.TotalPaid - (subtract*((xom1.PricePerSharePaid + xom2.PricePerSharePaid + xom3.PricePerSharePaid)/3));
        }
        System.out.println("LIFO = " + Math.round(total));
        System.out.println("FIFO = " + Math.round(total2));
      }
      else if(scan.hasNext("D")) //calculate worth of the amount sold of dominion
      {
        int subtract = 0;
        double total = 0.0;
        double total2 = 0.0;
        String e = scan.next();
        numberOfSharesSold = scan.nextInt();
        if(numberOfSharesSold <= d4.NumberOfSharesBought) //calculate worth of the amount sold 
        {
          subtract = d4.NumberOfSharesBought - numberOfSharesSold;
          total = (d4.NumberOfSharesBought - subtract)*d4.PricePerSharePaid;
        }
        if(numberOfSharesSold <= d4.NumberOfSharesBought + d3.NumberOfSharesBought) 
        {
          subtract =  (d4.NumberOfSharesBought + d3.NumberOfSharesBought) - numberOfSharesSold;
          total = d4.TotalPaid + d3.TotalPaid - (subtract*((d4.PricePerSharePaid + d3.PricePerSharePaid)/2));
        }
        if(numberOfSharesSold <= d4.NumberOfSharesBought + d3.NumberOfSharesBought + d2.NumberOfSharesBought) 
        {
          subtract =  (d4.NumberOfSharesBought + d3.NumberOfSharesBought + d2.NumberOfSharesBought) - numberOfSharesSold;
          total = d4.TotalPaid + d3.TotalPaid + d2.TotalPaid - (subtract*((d4.PricePerSharePaid + d3.PricePerSharePaid + d2.PricePerSharePaid)/3));
        }
        if(numberOfSharesSold <= d1.NumberOfSharesBought) 
        {
          subtract = d1.NumberOfSharesBought - numberOfSharesSold;
          total2 = (d1.NumberOfSharesBought - subtract)*d1.PricePerSharePaid;
        }
        if(numberOfSharesSold <= d1.NumberOfSharesBought + d2.NumberOfSharesBought) 
        {
          subtract =  (d1.NumberOfSharesBought + d2.NumberOfSharesBought) - numberOfSharesSold;
          total2 = d1.TotalPaid + d2.TotalPaid - (subtract*((d1.PricePerSharePaid + d2.PricePerSharePaid)/2));
        }
        if(numberOfSharesSold <= d1.NumberOfSharesBought + d2.NumberOfSharesBought + d3.NumberOfSharesBought) 
        {
          subtract =  (d1.NumberOfSharesBought + d2.NumberOfSharesBought + d3.NumberOfSharesBought) - numberOfSharesSold;
          total2 = d1.TotalPaid + d2.TotalPaid + d3.TotalPaid - (subtract*((d1.PricePerSharePaid + d2.PricePerSharePaid + d3.PricePerSharePaid)/3));
        }
        System.out.println("LIFO = " + Math.round(total));
        System.out.println("FIFO = " + Math.round(total2));
      }
      break;
      default: System.out.print("Error");
        break;
    }
    // hw 3 also a quick way to check the stacks
//    while(!stackXOM.empty()) //empties and prints the stack
//    {
//      System.out.print(stackXOM.pop());
//      System.out.println();
//    }
//    
//    while(!stackD.empty())
//    {
//      System.out.print(stackD.pop());
//      System.out.println();
//    }
//    
//    for(int i = (-3); i <= listXOM.size(); i++) //empties and prints the list
//    {
//      System.out.print(listXOM.pop());
//      System.out.println();
//    }
//    
//    for(int i = (-3); i <= listD.size(); i++)
//    {
//      System.out.print(listD.pop());
//      System.out.println();
//    }
  }
}