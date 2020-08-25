import java.util.*;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Date;
  public class MemoPadCreator
{
  public static void main(String[] args) throws FileNotFoundException
  {
    Date dateStamp;
    Scanner console = new Scanner(System.in);
    System.out.print("Enter the  name of the output file: ");
    String fileName = console.nextLine();
    
    PrintWriter out = new PrintWriter(fileName);
    
    boolean done = false;
    while(!done)
    {
      System.out.println("Memo topic (enter -1 to end) :");
      String topic = console.nextLine();
      if (topic.equals("-1"))
      {
        done = true;
      }
      else 
      {
        System.out.println("Memo text: ");
        String message = console.nextLine();
        
        // Instantiate the Date object (dateStamp) here
        // using the new operator
        dateStamp = new Date();
        //dateStamp = Date.toString("yyyy-MM-DD HH:mm:ss");
        
        out.println(topic + "\n" + dateStamp.toString() + "\n" + message);
      }
    }
    console.close();
    out.close(); // Close the output file
  }
}
        
      