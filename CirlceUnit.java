//
//
//
//
//
import java.util.*;

 public class CirlceUnit {
 {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
  }
    
    
   public static void main(String[] args) 
   {
           Scanner in = new Scanner(System.in);
           double radius, area, circumference, diameter;
           System.out.print("Enter a Radius: ");
           radius = in.nextDouble();
           circumference = 2 * Math.PI * radius;
           area = Math.PI * Math.pow(radius, 2);
           diameter = 2 * radius;
           System.out.println(" The Diameter of a circle with a Radius of " + radius + " is " + diameter);
           System.out.println(" The Circumference of a circle with a Radius of " + radius + " is " + circumference);
           System.out.println(" The Area of a circle with a Radius of " + radius + " is " + area);
           in.close();
          
      

     

   }
     
      
  }
  