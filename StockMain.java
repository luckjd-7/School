/* For this homework study and understand the attached Stock class. 
 * Then study the below information for the Stack and link list classes supplied under java.util.*.  
 * Write a main program that pushes 4 Stock objects onto a stack using Stack class stored in java.util.stack.  
 * Once all objects are on the stack write a loop that will pop all objects off of the stack displaying
 * the contents of the objects as they are removed from the stack.   
 * The next thing the main program should do is to use the LinkList class to build a queue of four Stock objects.  
 * Add each Stock object to the end of the queue. 
 * Once four stock objects are on the queue the main program should run a loop pulling objects off 
 * of the front of the queue and displaying the contents of the objects as they are pulled off.
 */
import java.util.*;
public class StockMain {
  public static void main(String[] args) {
  Stock stock1 = new Stock("xom","oil",12.35,150);
  Stock stock2 = new Stock("APPL","Apple",76.42,200);
  Stock stock3 = new Stock("MRST","Microsoft",125.35,300);
  Stock stock4 = new Stock("JSP","Joey's Solar Power",1234.35,600);
  Stack stack = new Stack();
  stack.push(stock1);
  stack.push(stock2);
  stack.push(stock3);
  stack.push(stock4);
  while(!stack.empty())
  {
    System.out.print(stack.pop());
    System.out.println();
  }
  LinkedList list = new LinkedList();
  list.addLast(stock1);
  list.addLast(stock2);
  list.addLast(stock3);
  list.addLast(stock4);
  for(int i = (-3); i <= list.size(); i++)
  {
    System.out.print(list.pop());
    System.out.println();
  }
  }
}
  