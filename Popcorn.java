import java.util.*;
import java.io.*;
public class Popcorn
{
   private static void ProjectHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();
   }
  public static void main(String[] args) throws IOException
  {
    System.out.print("Please enter a file name");
    Scanner scan = new Scanner(System.in);
    File fileName = new File(scan.nextLine());
    FileReader newFile = new FileReader(fileName);
    Scanner in = new Scanner(fileName);
        String heading = "Popcorn Co-op";
        String heading2 = "Production in Hundreds";
        String heading3 = "of Pint Jars per Acre";
        String fn = "Farm Name";
        String sl = "   1   2   3   4   5   6";
        String sy = "---|---|---|---|---|---|";
        System.out.printf("%26s%n", heading);
        System.out.printf("%60s%n%60s%n", heading2, heading3);
        System.out.printf("%-10s%40s%n", fn, sl);
        System.out.printf("%50s%n", sy);
     for(int count = 1; in.hasNextLine(); count++)
    {
       String line = in.nextLine();
       if(line.equals(""))
       {
         count--;
       }
       else
       {
        int comma  = line.indexOf(',');
        String farm = line.substring(0, comma);
        String jarsAcres = line.substring(comma + 1).trim();                         
        String[] split = jarsAcres.split(" ", 2);
        double acres = Double.parseDouble(split[0]);
        double jars = Double.parseDouble(split[1]);
        /*ArrayList<String> farmName = new ArrayList<String>();
        ArrayList<Double> acresJars = new ArrayList<Double>();
        farmName.add(farm);
        acresJars.add(jars/acres);*/
        int i = 0;
        int n = 0;
        String a = "";
        String b = "****";
        for(i = 0; i < (jars/acres)/100; i++){
         n=n+1;
      for(n = 0; n <= 1; n++)
       {
        n++;
        a = a + b;
       }
       }
        System.out.printf("%-2d%-24s%-24s%n", count, farm, a);
       }
    }
     scan.close();
     in.close();
     newFile.close();
  }
}
        
      