import java.io.IOException;
public class Equitymain {

	public static void main(String[] args) {
		try
		{
		   Equity EQ1 = new Equity ("XOM");
		   System.out.println(EQ1.getsTicker());
		   System.out.println(EQ1.getdLastTradePrice());
		   System.out.println(EQ1.getsLastTradeDT());
		   System.out.println(EQ1.getsLastTradeTime());
		   System.out.println(EQ1.getsChange());
	    } 
		catch (IOException e) 
		{
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		 }
		// TODO Auto-generated method stub

	}

}
