//
//
//
//
//

public class pairProgramming
{
    
  // This is the privte helper method that displays information about
  // programmer, the course, and the project.
  private static void printHeading () {
    System.out.println("Joey Luck & James van Emmerik");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();
    
  }
  
  public static void main (String[] args){
    
    printHeading();        // this statement calls the printHeading method
      
     int carPrice1 = 34000;
     int carPrice2 = 26000;
     int mpg1 = 40;
     int mpg2 = 26;
     int GAS = 3;
     int TOTALMILES = 120000;
     int totalCost1 = carPrice1 + TOTALMILES / mpg1 * GAS;  // This calculates the total cost of purchasing and operating car 1 for ten years
     int totalCost2 = carPrice2 + TOTALMILES / mpg2 * GAS;  // This calculates the total cost of purchasing and operating car 2 for ten years
     System.out.println("The total cost of operating car 1 is $" + totalCost1);
     //System.out.println(totalCost1);
     System.out.print("The total cost of operating car 2 is $" + totalCost2);
     //System.out.print(totalCost2);
      
  }
}
  