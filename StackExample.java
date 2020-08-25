import java.util.*;

public class StackExample
{

  public static void main(String[]args) 
  {
    Stack st = new Stack();
   // used for testing the Stock Class 
  //  Stock EQ = new Stock("XOM","Exon Mobil Corporation", 200, 88.75);
  //  System.out.print(EQ.toString());
  //
  //Push equities onto the stack. 
  //
    st.push(new Stock("XOM","Exon Mobil Corporation", 200, 88.75));
    st.push(new Stock("BP","British Petroleum Corporation", 110, 31.24));
    st.push(new Stock("D","Dominion", 400, 73.44));
    st.push(new Stock("XLU","Spider Utility ETF", 300, 48.75));
    //
    // If stack is not empty then use peek to view the contecnts of the stack.
    //
    
    if( !st.empty())
    {
       Stock EQTop = (Stock)st.peek();
       System.out.print(EQTop.toString());
    }
    else
       System.out.println("Stack is empty");
    //
    // Now pope each object off the stack and display the objects contents.
    //
     System.out.println("Pop the stock objects off the stack and display the contents of the objects");
      
      while( !st.empty() )
      {
         Stock EQpop = (Stock)st.pop();
         System.out.print(EQpop.toString());
      }
  }
}    