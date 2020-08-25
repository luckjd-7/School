import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Equity 
{
//  This class is used to track price, dividends, and other activity of stocks, mutual funds, and ETF's.
//
	Equity()
	{
		// default consturcter 
		
	}
	
	Equity(String sTickerSymbol) throws IOException
	{
		pullEquityData(sTickerSymbol) ;
	}
	
//  Public Methods
	// getters for price data
	
	public String getsTicker()
	{
		return sTicker;
	}
	
	public double getdAsk()
	{
		return dAsk;
	}
	
	public double getdBid()
	{
		return dBid;
	}
	
	public double getdAskRT()
	{
		return dAskRT;
	}
	
	public double getdOpen()
	{
		return dOpen;
	}
	
	public double getdPrevOpen()
	{
		return dPrevOpen;
	}
	
	// Getters for Dividend Data
	
	public double getdDividendYield()
	{
		return dDividendYield;
	}
	
	public double getdDividendPerShare()
	{
		return dDividendPerShare;
	}
	
	public String getdsDivPayDate()
	{
		return sDivPayDate;
	}
	
	public String getsExpPayDate()
	{
		return sExpPayDate;
	}
	
	// Getters for dates
	public String getsChange()
	{
		return sChange;
	}
	
	public String getsChgAndPctChg()
	{
		return sChgAndPctChg;
	}
	
	public String getsChangeRT()
	{
		return sChangeRT;
	}
	
	public double getdChangePCT()
	{
		return dChangePCT;
	}
	
	public double getdChgInPCT()
	{
		return dChgInPCT;
	}
	
	public String getsLastTradeDT()
	{
		return sLastTradeDT;
	}
	
	public String getsTradeDT()
	{
		return sTradeDT;
	}
	
	public String getsLastTradeTime()
	{
		return sLastTradeTime;
	}
	
	// Getters averages
	public double getdAfterHrsChg()
	{
		return dAfterHrsChg;
	}
	
	public double getdCommission()
	{
		return dCommission;
	}
	public double getdDaysLow()
	{
		return dDaysLow;
	}
	public double getdDaysHigh()
	{
		return dDaysHigh;
	}
	public String getsLastTradeRTTime()
	{
		return sLastTradeRTTime;
	}
	public String getsLastTradeTime1()
	{
		return sLastTradeTime1;
	}
	public double getdLastTradePrice()
	{
		return dLastTradePrice;
	}
	public double getdTargetPrice1YR()
	{
		return dTargetPrice1YR;
	}
	public double getdChgFrom200day()
	{
		return dChgFrom200day;
	}
	public double getdChgFrom50day()
	{
		return dChgFrom50day;
	}
	public double getdPctChgFrom50day()
	{
		return dPctChgFrom50day;
	}
	public double getdMovingavg50day()
	{
		return dMovingavg50day;
	}
	public double getdMovingavg200day()
	{
		return dMovingavg200day;
	}
	// Misc	
	public double getdDaysValChgRT()
	{
		return dDaysValChgRT;
	}
	public double getdPricePaid()
	{
		return dPricePaid;
	}
	public double getdDaysRange()
	{
		return dDaysRange;
	}
	public double getdDaysRangeRT()
	{
		return dDaysRangeRT;
	}
	public double getdHoldingGainPCT()
	{
		return dHoldingGainPCT;
	}
	public double getdAnnualGain()
	{
		return dAnnualGain;
	}
	public double getdHoldingGain()
	{
		return dHoldingGain;
	}
	public double getdHoldingGainPCTRT()
	{
		return dHoldingGainPCTRT;
	}
	public double getdHoldingGainRT()
	{
		return dHoldingGainRT;
	}
	public String getsTickerTrend()
	{
		return sTickerTrend;
	}
	public String getsTradeLinks()
	{
		return sTradeLinks;
	}
	public String getsOderBook()
	{
		return sOderBook;
	}
	public double getdHighLimit()
	{
		return dHighLimit;
	}
	public double getdLowLimit()
	{
		return dLowLimit;
	}
	public double getdHoldingsValue()
	{
		return dHoldingsValue;
	}
	public double getdHoldingsValueRT()
	{
		return dHoldingsValueRT;
	}
	public double getdrevenue()
	{
		return drevenue;
	}
	// getters 52 week.
	public double getdHigh52wk()
	{
		return dHigh52wk;
	}
	public double getdLow52wk()
	{
		return dLow52wk;
	}
	public double getdchgFrom52WKLow()
	{
		return dchgFrom52WKLow;
	}
	public double getdchgFrom52WKHigh()
	{
		return dchgFrom52WKHigh;
	}
	public double getdPctChgFrom52WKLow()
	{
		return dPctChgFrom52WKLow;
	}
	public double getdPctChgFrom52WKHigh()
	{
		return dPctChgFrom52WKHigh;
	}
	public double getdRange52Week()
	{
		return dRange52Week;
	}
	
	// Getters Symbol - Info
	
	private void pullEquityData(String sTickerSet) throws IOException
	{
        // Make a URL to the web page
    	String passURL = "http://finance.yahoo.com/d/quotes.csv?s=" + sTickerSet + "&f=sl1d1t1c1ohgvydr1q&e=.csv";
    	System.out.println(passURL);
        URL url = new URL(passURL);
        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;

        // read each line and write to System.out
        while ((line = br.readLine()) != null) 
        {
            System.out.println(line);
            int low = 1;
            int high = line.indexOf(',')-1;
            sTicker=line.substring(low,high);
            low=high+2;
            high = line.indexOf(',',low);
            dLastTradePrice = Double.parseDouble(line.substring(low,high));
            low=high+2;
            high = line.indexOf(',',low)-1;
            sLastTradeDT=line.substring(low,high);
            low=high+3;
            high=line.indexOf(',', low)-1;
            sLastTradeTime=line.substring(low,high);
            low=high+2;
            high=line.indexOf(',', low);
            sChange=line.substring(low,high);

        }
	}
	
 // Private varibles
	
	//Price data
	private String sTicker;		// Equity Ticker symbol
	private double dAsk;		// Equity Ask price.
	private double dBid; 		// Equity Bid price.
	private double dAskRT;		// Equity Ask price RT
	private double dBidRT;		// Equity Bid price RT.
	private double dOpen;		// Equity Open price.
	private double dPrevOpen;	// Equity previous open price.
	
	//Dividend data 
	private double dDividendYield;		// Dividiend Yield percent.
	private double dDividendPerShare;	// Dividend amount per share.
	private String sDivPayDate;			// Dividend pay date.
	private String sExpPayDate;			// Expected dividend pay date.
	
	
	// Dates
	private String sChange;				// Change date
	private String sChgAndPctChg;		// Change and percentage change.
	private String sChangeRT;			// Change real time
	private double dChangePCT;			// Change percent
	private double dChgInPCT;			// Change in percent.
	private String sLastTradeDT;		// Last trade date.
	private String sTradeDT;			// Last trade date.
	private String sLastTradeTime;		// Last trade time.
	
	// Averages
	private double dAfterHrsChg;		// After hours change.
	private double dCommission;			// Commission
	private double dDaysLow;			// Days Low.
	private double dDaysHigh;			// Days high.
	private String sLastTradeRTTime;	// Last trade real time with time.
	private String sLastTradeTime1;		// Last trade with time.
	private double dLastTradePrice;		// Last trade price only.
	private double dTargetPrice1YR;		// One year target price.
	private double dChgFrom200day;		// Change from 200 day moving average.
	private double dPctChgFrom200day;	// Percent change from 200 day moving average.
	private double dChgFrom50day;		// Change from 50 day moving average
	private double dPctChgFrom50day;	// Percent change from 50 day moving average.
	private double dMovingavg50day;		// 50 day moving average
	private double dMovingavg200day;	// 200 day moving average
	
	// Misc
	private double dDaysValChg;			// day’s value change
	private double dDaysValChgRT;		// Day's value change RT
	private double dPricePaid;			// Price paid.
	private double dDaysRange;			// day’s range
	private double dDaysRangeRT;		// day's range (realtime).
	private double dHoldingGainPCT;		// holding gain percent.
	private double dAnnualGain;			// annualized gain
	private double dHoldingGain;		// holdings gain
	private double dHoldingGainPCTRT;	// holdings gain percent (realtime)
	private double dHoldingGainRT;		// Holdings gain (real time).
	private String sTickerTrend;		// ticker trend
	private String sTradeLinks;			// trade links
	private String sOderBook;			// order book (real time)
	private double dHighLimit;			// high limit
	private double dLowLimit;			// Low Limit.
	private double dHoldingsValue;		// holdings value
	private double dHoldingsValueRT;	// holdings value (real time)
	private double drevenue;			// revenue.
	
	// 52 - week 
	private double dHigh52wk;			// 52 week high
	private double dLow52wk;			// 52 week low
	private double dchgFrom52WKLow;		// Change from 52 week low
	private double dchgFrom52WKHigh;	// Change from 52 week high
	private double dPctChgFrom52WKLow;	// percent change from 52 week low
	private double dPctChgFrom52WKHigh;	// percent change from 52 week High
	private double dRange52Week;		// 52 week range
	
	// Symbol- Info
	private String sMarketCap;			// market capitalization
	private String sMargetCapRT;		// market cap (real time)
	private String sFloatShares;		// float shares
	private String sName;				// Name
	private String sNotes;				// Notes
	private String sSymbol;				// Stock Symbol
	private double dSharesOwned;		// Shares owned by company.
	private String sExchange;			// Stock exchange the equity is traded on.
	private double dSahresOutstanding;   // Shares outstanding.
	
	// Volume
	private double dvolume;				// Trading volume.
	private double daskSize;			// Trading ask size.
	private double dbidSize;			// Trading bid size.
	private double dlastTradeSize;		// Last trade size.
	private double daverageDailyVol;	// Average daily volume;
	
	//Ratios
	private double dEPS;				// Earnings per Share. 
	private double dEPSEstimateCurYR;	// Earnings per share estimate current year;
	private double dEPSEstimateNextYR;	// Earnings per share estimate next year;
	private double dEPSEstimateNextQRT;	// Earnings per share estimate next Quarter;
	private double dBookValue;			// Book Value
	private double dEBITDA;				// Earnings before interest, tax, depreciation and amortization (EBITDA).
	private double dPriceSales;			// Price Sales
	private double dPriceBook;			// Price Book
	private double dPE;					// Price earnings ratio.
	private double dPERT;				// Price earnings ratio real time.
	private double dPEG;				// Price/earnings to growth ratio.
	private double dPriceEPSRatioCY;	// Price / EPS estimate current year
	private double dPriceEPSRatioNY; 	// Price / EPS estimate next year;
	private double dShortRatio;			// Short Ratio
}
