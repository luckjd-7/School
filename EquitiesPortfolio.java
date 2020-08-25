import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class EquitiesPortfolio
{
  //instaniating variables 
  private String tickerSymbol; //Equity ticker symbol
  private String equityName; 
  private int numberOfShares;
  private String equityType;
  private String exchange;
  private double currentPrice;
  private double estimatedYearlyPriceIncrease;
  private double dividendYield;
  private int dividendPaymentCycle;
  private double dividendAmount; //calculated dividend amount
  private double valueOfEquity; //current value
  private double valueOfEquityAfterNYears; //Calculated value of equity after n years
  private double openMarket;
  private double previousClosePrice;
  private double currentValueOfSharesHeld;
  private double fiftyTwoWeekHigh;
  private double fiftyTwoWeekLow;
  private String lastTradeDate;
  private String dividendPayDate;
    //instantiating variables
  public EquitiesPortfolio()
  {
   tickerSymbol ="";
   equityName ="";
   numberOfShares =0;
   equityType ="";
   exchange ="";
   currentPrice =0.0;
   estimatedYearlyPriceIncrease =0.0;
   dividendYield =0.0;
   dividendPaymentCycle =0;
   valueOfEquity =0.0;
   dividendAmount =0.0;
   valueOfEquityAfterNYears =0.0;
   openMarket = 0.0;
   previousClosePrice = 0.0;
   currentValueOfSharesHeld = 0.0;
   fiftyTwoWeekHigh = 0.0;
   fiftyTwoWeekLow = 0.0;
   lastTradeDate = "";
   dividendPayDate = "";
  }
  public EquitiesPortfolio(String ts, String en, int ns, int et, String ex,double cp, double eypi, double dy, int dpc)
  {
  tickerSymbol=ts;
  equityName=en;
  numberOfShares=ns;
  switch(et){
    case 0: equityType = "Stock";
    break;
    case 1: equityType = "ETF";
    break;
    case 2: equityType = "REIT";
    break; }
  exchange=ex;
  currentPrice=cp;
  estimatedYearlyPriceIncrease=eypi;
  dividendYield=dy;
  dividendPaymentCycle=dpc;
  }
        // to string constructor
  public EquitiesPortfolio(String ts, String en, int ns, int et, String ex, int dpc) 
  { this(ts,en,ns,et,ex,0.0,0.0,0.0,dpc); }
  EquitiesPortfolio(String ts, int et, int ns) throws IOException { pullInfo(ts,et,ns); }
    
        //constructors
  public String getTickerSymbol() { return tickerSymbol; } 
  public String getEquityName() { return equityName; }
  public int getNumberOfShares() { return numberOfShares; }
  public String getEquityType() { return equityType; }
  public String getExchange() { return exchange; }
  public double getCurrentPrice() { return currentPrice; }
  public double getEstimatedYearlyPriceIncrease() { return estimatedYearlyPriceIncrease; }
  public double getDividendYield() { return dividendYield; }
  public int getDividendPaymentCycle() { return dividendPaymentCycle; }
  public double getDividendAmount() { return dividendAmount; }
  public double getValueOfEquity() { return valueOfEquity; }
  public double getValueOfEquityAfterNYears() { return valueOfEquityAfterNYears; }
  public double getOpenMarket() { return openMarket; }
  public double getPreviousClosePrice() { return previousClosePrice; }
  public double getCurrentValueOfSharesHeld() { return currentValueOfSharesHeld = currentPrice*numberOfShares; }
  public double getFiftyTwoWeekHigh() { return fiftyTwoWeekHigh; }
  public double getFiftyTwoWeekLow() { return fiftyTwoWeekLow; }
  public String getLastTradeDate() { return lastTradeDate; }
  public String getDividendPayDate() { return dividendPayDate; }
        //methods to set
  public void setTickerSymbol(String ts) { tickerSymbol=ts; }
  public void setEquityName(String en) { equityName=en; }
  public void setNumberOfShares(int ns) { numberOfShares=ns; }
  public void setEquityType(int et) { equityType=Integer.toString(et); }
  public void setExchange(String ex) { exchange=ex; }
  public void setCurrentPrice(double cp) { currentPrice=cp; }
  public void setEstimatedYearlyPriceIncrease(double eypi) { estimatedYearlyPriceIncrease=eypi; }
  public void setDividendYield(double dy) { dividendYield=dy; }
  public void setDividendPaymentCycle(int dpc) { dividendPaymentCycle=dpc; }
  public void setDividendAmount(double da) { dividendAmount=da; }
  public void setValueOfEquity(double ve) { valueOfEquity=ve; }
  public void setValueOfEquityAfterNYears(double veany) { valueOfEquityAfterNYears=veany; }
        
  private void pullInfo(String ts, int et, int ns ) throws IOException
 {
    tickerSymbol = ts;
    switch(et){
    case 0: equityType = "Stock";
    break;
    case 1: equityType = "ETF";
    break;
    case 2: equityType = "REIT";
    break; }
    numberOfShares = ns;
   String url = "http://download.finance.yahoo.com/d/quotes.csv?s=" + tickerSymbol + "&f=nxb3opydr1d1kjw&e=.csv";
      URL info = new URL(url);
      URLConnection connect = info.openConnection();
      InputStream stream =connect.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(stream));
      String line = null;
      while ((line = br.readLine()) != null) 
      {
        //System.out.println(line);
        int low = 1;
        int high = line.indexOf(',')-1;
        equityName = line.substring(low,high);
        low = high + 2;
        high = line.indexOf(',',low);
        exchange = line.substring(low,high);
        low = high + 1;
        high = line.indexOf(',',low);
        if(line.substring(low,high).equals("N/A")) { currentPrice = -1; }      //sets current price equal to -1 when market is closed
        else { currentPrice = Double.parseDouble(line.substring(low,high)); }  //goes normally when market is open
        low = high + 1;
        high = line.indexOf(',', low);
        openMarket = Double.parseDouble(line.substring(low,high));
        low = high + 1;
        high = line.indexOf(',', low);
        previousClosePrice = Double.parseDouble(line.substring(low,high));
        low = high + 1;
        high = line.indexOf(',', low);
        dividendYield = Double.parseDouble(line.substring(low,high));
        low = high + 1;
        high = line.indexOf(',', low);
        dividendAmount = Double.parseDouble(line.substring(low,high));
        low = high + 1;
        high = line.indexOf(',', low);
        dividendPayDate = line.substring(low,high); // I couldn"t find dividend pay rate the r1 was the pay date
        low = high + 1;
        high = line.indexOf(',', low);
        lastTradeDate = line.substring(low,high);
        low = high + 1;
        high = line.indexOf(',', low);
        fiftyTwoWeekHigh = Double.parseDouble(line.substring(low,high));
        low = high + 1;
        high = line.indexOf(',', low);
        fiftyTwoWeekLow = Double.parseDouble(line.substring(low,high));
              }
      br.close();
      stream.close();
 }
  //calculations
  private double DividendAmount() { return dividendAmount = (currentPrice*dividendYield)/dividendPaymentCycle; }
  //calculate dividend amount
  private double ValueOfEquity() { return valueOfEquity = currentPrice*numberOfShares; }
  //calculate value of equity
  public double ValueOfEquityAfterNYears(double n)
   {//calculate value of equity after a certain amount of years
     double i;
     valueOfEquityAfterNYears = currentPrice;
     for (i=1; i<=n;i++)
     {
     valueOfEquityAfterNYears =DividendAmount() + valueOfEquityAfterNYears + (valueOfEquityAfterNYears*(estimatedYearlyPriceIncrease/100));
     }
     return valueOfEquityAfterNYears;
   }
  public static void printSummary(EquitiesPortfolio portfolio)
  {//what will be printed out for each portfolio
    System.out.println();
    System.out.println("Ticker Symbol = " + portfolio.tickerSymbol);
    System.out.println("Equity Name = " + portfolio.equityName);
    System.out.println("Exchange = " + portfolio.exchange);
    System.out.println("Equity Type = " + portfolio.equityType);
    System.out.println("Current Price = $" + portfolio.currentPrice);
    System.out.println("Number of Shares = " + portfolio.numberOfShares);
    System.out.println("Current Value Of Equity = $" + portfolio.ValueOfEquity());
    System.out.println("Estimated Yearly Price Increase = %" + portfolio.estimatedYearlyPriceIncrease);
    System.out.println("Value Of Equity After 5 Years = $" + Math.round(portfolio.ValueOfEquityAfterNYears(5)));
    System.out.println("Value Of Equity After 10 Years = $" + Math.round(portfolio.ValueOfEquityAfterNYears(10)));
  }
  public static void printSummaryURL(EquitiesPortfolio portfolio)
  {//what will be printed out for each portfolio
    System.out.println();
    System.out.println("Ticker Symbol = " + portfolio.tickerSymbol);
    System.out.println("Equity Name = " + portfolio.equityName);
    System.out.println("Exchange = " + portfolio.exchange);
    System.out.println("Equity Type = " + portfolio.equityType);
    System.out.println("Current Value Of Equity = $" + portfolio.currentPrice);
    System.out.println("Value Of Equity At Open = $" + portfolio.openMarket);
    System.out.println("Previous Close Price = $" + portfolio.previousClosePrice);
    System.out.println("Fifty Two Week Range = $" + portfolio.fiftyTwoWeekHigh + " - " + portfolio.fiftyTwoWeekLow);
    System.out.println("Dividend Yield = %" + portfolio.dividendYield);
    System.out.println("Dividend Amount = $" + portfolio.dividendAmount);
    System.out.println("Dividend Payment Date = " + portfolio.dividendPayDate);
    System.out.println("Last Trade Date = " + portfolio.lastTradeDate);
    System.out.println("Number of Shares = " + portfolio.numberOfShares);
    System.out.println("Current Value Of Shares Held = $" + portfolio.getCurrentValueOfSharesHeld());
  }
  public String toString()
  {
    return "Ticker Symbol = " + this.tickerSymbol + ", " + "Equity Name = " + this.equityName + ", " + "Number of Shares = " + this.numberOfShares + ", " + "Current Price = $" + this.currentPrice + ", " + "Current value of equity = $" + this.valueOfEquity;  
  }
  public static void Portfolio() 
  {
    EquitiesPortfolio portfolio1 = new EquitiesPortfolio("XOM","Exon Mobil Co",200,0,"NYSE",76.34,4,3.35,4);
    EquitiesPortfolio portfolio2 = new EquitiesPortfolio("D","Dominion Resources Inc",50,0,"NYSE",76.41,2,3.58,4);
    EquitiesPortfolio portfolio3 = new EquitiesPortfolio("O","Realty Income Corp.",100,2,"NYSE",55.66,3.5,4.78,12);
    EquitiesPortfolio portfolio4 = new EquitiesPortfolio("XLU","Utilities Select Sector SPDR Fund",250,1,"AMEX",52.87,1.5,3.13,4);
    EquitiesPortfolio portfolio5 = new EquitiesPortfolio("AAPL","Apple Inc",100,0,"NASD",112.66,5,1.59,4);
    portfolio1.printSummary(portfolio1);
    portfolio2.printSummary(portfolio2);
    portfolio3.printSummary(portfolio3);
    portfolio4.printSummary(portfolio4);
    portfolio5.printSummary(portfolio5);
    int totalNS = portfolio1.numberOfShares+portfolio2.numberOfShares+portfolio3.numberOfShares+portfolio4.numberOfShares+portfolio5.numberOfShares;
    double summary = portfolio1.ValueOfEquity()+portfolio2.ValueOfEquity()+portfolio3.ValueOfEquity()+portfolio4.ValueOfEquity()+portfolio5.ValueOfEquity();
    double summary2 = totalNS*(portfolio1.ValueOfEquityAfterNYears(5)+portfolio2.ValueOfEquityAfterNYears(5)+portfolio3.ValueOfEquityAfterNYears(5)+portfolio4.ValueOfEquityAfterNYears(5)+portfolio5.ValueOfEquityAfterNYears(5));
    double summary3 = totalNS*(portfolio1.ValueOfEquityAfterNYears(10)+portfolio2.ValueOfEquityAfterNYears(10)+portfolio3.ValueOfEquityAfterNYears(10)+portfolio4.ValueOfEquityAfterNYears(10)+portfolio5.ValueOfEquityAfterNYears(10));
    System.out.println();
    System.out.println("Total value of current Shares = $"+Math.round(summary));
    System.out.println("Total estimated value of current shares after 5 years = $"+Math.round(summary2));
    System.out.println("Total estimated value of current shares after 10 years = $"+Math.round(summary3));
  }
  public static void main(String[] args)
  {
    System.out.println("CSC-202 Fall 2017 Joey Luck");
    System.out.println();
    System.out.println("Equity report");
    try
    {
    EquitiesPortfolio xom = new EquitiesPortfolio("XOM",0,25);
    xom.printSummaryURL(xom);
    EquitiesPortfolio goog = new EquitiesPortfolio("MSFT",0,10);
    goog.printSummaryURL(goog);
    EquitiesPortfolio o = new EquitiesPortfolio("O",2,25);
    o.printSummaryURL(o);
    EquitiesPortfolio aapl = new EquitiesPortfolio("AAPL",0,10);
    aapl.printSummaryURL(aapl);
    //aapl.Portfolio();
    }
    catch (IOException e) 
  {
     e.printStackTrace();
   }
  }
}