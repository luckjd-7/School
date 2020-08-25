
public class Stock 
{
  // Private variables	
	private int inumshares;
	private double dPrice;
	private String sTicker;
	private String sCompanyName;
	private double dValueofheldshares;
	
  // Consturctors
	
	Stock()
	{
		inumshares=0;
		dPrice=0.0;
	    sTicker="";
	    sCompanyName="";
	    dValueofheldshares=0.0;
	}
	
	Stock(String TickerSymbol, String Tickername, int Sharesheld, double Price)
	{
		sTicker=TickerSymbol;
		sCompanyName=Tickername;
		inumshares=Sharesheld;
		dPrice=Price;
		dValueofheldshares = inumshares * dPrice;
	}
	
//  Public getters
	public int getinumshares()
	{
		return inumshares;
	}
	
	public double getdPrice()
	{
		return dPrice;
	}
	
	public String getsTicker()
	{
		return sTicker;
	}
	
    public String getsCompanyName()
    {
    	return sCompanyName;
    }
    
    public double getdValueofheldshares()
    {
    	return dValueofheldshares;
    }
    
  // purblic setters 
    
    void setinumshares(int numsharesheld)
    {
    	inumshares = numsharesheld;
    }
    
    void setdPrice(double Price)
    {
    	dPrice=Price;
    }
    
    void setsTicker(String Ticker)
    {
    	sTicker=Ticker;
    }
    
    void setsCompanyName(String CompanyName)
    {
    	sCompanyName=CompanyName;
    }
    
    // Public updaters
    
    void UpdateValueofShares()
    {
    	dValueofheldshares = inumshares * dPrice;
    }
    
    // Public toString.
    
    public String toString()
    {
    	String RetString="Ticker: ";
    	RetString=RetString.concat(sTicker);
    	RetString=RetString.concat("\n Company: ");
    	RetString=RetString.concat(sCompanyName);
    	RetString=RetString.concat("\n Number of Shares: ");
    	RetString=RetString.concat(String.valueOf(inumshares));
    	RetString=RetString.concat(" \n Price Per Share: ");
        RetString=RetString.concat(String.valueOf(dPrice));
        RetString=RetString.concat("\n Total value: ");
    	RetString=RetString.concat(String.valueOf(dValueofheldshares));
    	RetString=RetString.concat("\n\n");
    		
    	
    	return RetString;
    }
}
