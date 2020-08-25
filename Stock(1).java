//
// This class stores information about one stock or ther equity type.
//
//  Created for CSC-202 Fall 2017  by George Cardwell
//  date: 14 October 2017.
//
public class Stock 
{
	//  Privage variables used by  class Stock.
	//
	String TickerSymbol;  			// Exchange Ticker symbol example BP
	String EquityName;				// Full company name;
	double PricePerSharePaid;		// Prie pershare paid for this equity in dollars and cents.
	int	   NumberOfSharesBought;	//
	double TotalPaid;				// Total paid including $6.99 comission.
	
	// Constructors
	
	// Default constructor.
	public Stock()
	{
		TickerSymbol = "";
		EquityName = "";
		PricePerSharePaid = 0.0;
		NumberOfSharesBought = 0;	
	}
	
	
	public Stock(String TS, String EQNAME, double PPS, int NOS )
	{
		// Assign passed in values.
		
		this.TickerSymbol=TS;
		this.EquityName=EQNAME;
		this.NumberOfSharesBought=NOS;
		this.PricePerSharePaid=PPS;
		this.TotalPaid=this.NumberOfSharesBought*this.PricePerSharePaid;
	}


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


	@Override
	public String toString() {
		return "Stock [TickerSymbol=" + TickerSymbol + "\n" + "EquityName=" + EquityName + "\n" + "PricePerSharePaid="
				+ PricePerSharePaid + "\n" + "NumberOfSharesBought=" + NumberOfSharesBought + "\n" +  "TotalPaid=" + TotalPaid
				+ "] \n";
	}
}
