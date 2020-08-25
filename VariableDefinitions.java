//****************************************************************************************
//
//  Lab Assignment 5
//
//****************************************************************************************

public class VariableDefinitions {
  
  // This is the private helper method that displays information about
  // programmer, this course, and the project
  
  private static void printHeading() {
    System.out.println("Daniel Spanos and Joey Luck");
    System.out.println("CSC 201 Spring 2017");
    System.out.println("Lab 5");
    System.out.println("Variable Definitions");
    System.out.println();
    
  }
  
  public static void main(String[] args) {
    
    printHeading(); // This statement calls the printHeading method
    
    // Declaration of variables
    
    byte numPeople = 3;
    double itemPrice = 32.32;
    boolean valid = false;
    char letter = 'a';
    int roomNumber = 207;
    double dinnerPrice = 30.0;
    int longNumber = 1903456789;
    int shortnumber = 177609;
    
    int count = 19;
    double total = 0.25;
    char stopKey = 's';
    boolean stopFlag = true;
    double temperatureReading = 67.5;
    byte numPets = 4;
    short littleNum = 3678;
    int reallyBigNumber = 186278924;
    
    // Outputs variable names and values
    
    System.out.println("the numPeople variable has a value of " + numPeople);
    System.out.println("the itemPrice variable has a value of " + itemPrice);
    System.out.println("the valid variable has a value of " + valid);
    System.out.println("the letter variable has a value of " + letter);
    System.out.println("the roomNumber variable has a value of " + roomNumber);
    System.out.println("the dinnerPrice variable has a value of " + dinnerPrice);
    System.out.println("the longNumber variable has a value of " + longNumber);
    System.out.println("the shortnumber variable has a value of " + shortnumber);
    System.out.println();
    System.out.println("the count variable has a value of " + count);
    System.out.println("the total variable has a value of " + total);
    System.out.println("the stopKey variable has a value of " + stopKey);
    System.out.println("the stopFlag variable has a value of " + stopFlag);
    System.out.println("the temperatureReading variable has a value of " + temperatureReading);
    System.out.println("the numPets variable has a value of " + numPets);
    System.out.println("the littleNum variable has a value of " + littleNum);
    System.out.println("the reallyBigNumber variable has a value of " + reallyBigNumber);
    System.out.println();
    
    // Reassignment of variables
    
    numPeople = 6;
    itemPrice = 33.30;
    valid = true;
    letter = 'b';
    roomNumber = 201;
    dinnerPrice = 37.0;
    longNumber = 1903456789;
    shortnumber = 177459;
    
    count = 14;
    total = 3.25;
    stopKey = 'd';
    stopFlag = false;
    temperatureReading = 70.5;
    numPets = 5;
    littleNum = 3667;
    reallyBigNumber = 187978924;
    
    // Outputs variable names and values
    
    System.out.println("the numPeople variable now has a value of " + numPeople);
    System.out.println("the itemPrice variable now has a value of " + itemPrice);
    System.out.println("the valid variable now has a value of " + valid);
    System.out.println("the letter variable now has a value of " + letter);
    System.out.println("the roomNumber variable now has a value of " + roomNumber);
    System.out.println("the dinnerPrice variable now has a value of " + dinnerPrice);
    System.out.println("the longNumber variable now has a value of " + longNumber);
    System.out.println("the shortnumber variable now has a value of " + shortnumber);
    System.out.println();
    System.out.println("the count variable now has a value of " + count);
    System.out.println("the total variable now has a value of " + total);
    System.out.println("the stopKey variable now has a value of " + stopKey);
    System.out.println("the stopFlag variable now has a value of " + stopFlag);
    System.out.println("the temperatureReading variable now has a value of " + temperatureReading);
    System.out.println("the numPets variable now has a value of " + numPets);
    System.out.println("the littleNum variable now has a value of " + littleNum);
    System.out.println("the reallyBigNumber variable now has a value of " + reallyBigNumber);
    System.out.println();
    
    //Declaration of constants
    
    final byte first = 7;
    final short second = 100;
    final int third = 756343;
    final long fourth = 64738292054678332l; 
    final float fifth = 5647.26f;
    final double sixth = .000045;
    final boolean seventh = true;
    final char eighth = 'z';
    
    // Outputs constants names and values
    
    System.out.println("the first constant now has a value of " + first);
    System.out.println("the second constant now has a value of " + second);
    System.out.println("the third constant now has a value of " + third);
    System.out.println("the fourth constant now has a value of " + fourth);
    System.out.println("the fifth constant now has a value of " + fifth);
    System.out.println("the sixth constant now has a value of " + sixth);
    System.out.println("the seventh constant now has a value of " + seventh);
    System.out.println("the eighth constant now has a value of " + eighth);
    
    //third = 812345; // Trying to reassign a constant
  }
  
}