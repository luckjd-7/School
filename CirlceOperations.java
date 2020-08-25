//
//I originally started just by making a program that would calculate the units of a cirlce by inputing a radius
//once i realized there was a set radius it through me off, i tried a few different ways and went with a switch
//statement. i couldnt figure out how to get the scanner to read letters at first. 
//it also wouldnt let me use float it continued to say it can't convert a double to float
//also i get a warning that the value of local variable circle not used idk why.
import java.util.*;

 public class CirlceOperations {
 {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    //Static int d;
  }
    
    
   public static void main(String[] args) 
   {
           //input();
           //output();
     char letter;
     String circle = null;
  
   //public static void input(){
           Scanner kb = new Scanner(System.in);
           double radius, area, circumference, diameter;
           System.out.print("To calculate Diameter, Circumference, or Area, enter D, C, or A: ");
           letter = kb.next().charAt(0);
           radius = 6.75;
           //radius = in.nextDouble();
           //float C = circumference;
           //float A = area;
           //float D = diameter;
           //char c = reader.next(".").charat(0);
           circumference = 2 * Math.PI * radius;
           area = Math.PI * Math.pow(radius, 2);
           diameter = 2 * radius;
            switch(letter)
                    {
             case 'A':
               circle = "area";
               System.out.println(" The Area of a circle with a Radius of " + radius + " is " + area);
               break;
                case 'a':
               circle = "area";
               System.out.println(" The Area of a circle with a Radius of " + radius + " is " + area);
               break;
               case 'C':
               circle = "circumference";
               System.out.println(" The Circumference of a circle with a Radius of " + radius + " is " + circumference);
               break;
                case 'c':
               circle = "circumference";
               System.out.println(" The Circumference of a circle with a Radius of " + radius + " is " + circumference);
               break;
               case 'D':
               circle = "diameter";
               System.out.println(" The Diameter of a circle with a Radius of " + radius + " is " + diameter);
               break;
               case 'd':
               circle = "diameter";
               System.out.println(" The Diameter of a circle with a Radius of " + radius + " is " + diameter);
               break;
           }
           //public static void output() {
           
           
           
           kb.close();
           //}
      

     

   }
     
      
  }
  