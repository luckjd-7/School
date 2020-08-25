//
//
//
//
//
import java.util.*;

 public class Circle {
   private static void printHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();
    
  }
    private double pi = 3.14159;
    private double radius;

    public Circle() 
    {
        radius = 1.0;
    }

    public Circle(double r) {
        if(r<0){
          r=0;
        }
        else 
          radius = r;
    }

    public void setRadius(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return pi * radius * radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getCircumference() {
        return 2 * pi * radius;
    }
    
    public String toString() {
      String radius1 = String.valueOf(radius);
      //System.out.println(radius);
      return radius1;
    }
 }
/*
    
    public static void main(String[] args) {

    // Create a Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);

    // Ask user to input circle radius
    System.out.print("Enter the radius of a circle: ");
    double radius = keyboard.nextDouble();

    // close keyboard
    keyboard.close();
    public static void CirlceClass()// = new CicleClass();
    {
    
    }
    
    // Create a Circle object passing in user input
    CircleClass circleClass()= new CircleClass();
    Circle circle = circleClass.new Circle(radius);
    
    // Display circle information
    System.out.println("Area is " + circle.getArea());
    System.out.println("Diameter is " + circle.getDiameter());
    System.out.println("Circumference is " + circle.getCircumference());

}
*/
//}