import java.util.*;
import java.io.*;
public class MemoPadReader {
  public static void main(String[] args) throws IOException {
    Scanner console = new Scanner(System.in);
    System.out.print("Input file: ");
    String inputFileName = console.nextLine();
    
    File inFile = new File (inputFileName);
    Scanner in = new Scanner(inFile);
    
    Boolean done = false;
    
    while (in.hasNextLine() && !done) {
      String topic = in.nextLine();
      String dateStamp = in.next();
      String message = in.nextLine();
      System.out.println(topic + "\n" + dateStamp + "\n" + message);
      
      // prompt to display the next memo if 
      // there are more memos in the file
      if(in.hasNext()) {
        System.out.println("Do you want to read the next memo?");
        String ans = console.nextLine();
        if(ans.equalsIgnoreCase("n")) {
          done = true;
        }
      }
    }
  }
}