//*************************************************************************
// GradeRange.java
//
//  Deomnstrates the use of an array of objects. Also demonstrates the use
//  of two for loop types.
//
// Written by George Cardwell
// CS-202 Fall 2016
//*************************************************************************

public class GradeRange
{
     //---------------------------------------------------------------------------------
     // Create an array of grade objects and print them.  
     //---------------------------------------------------------------------------------
  public static void main(String[] args)
  {  
    // Instanciate an array of Grade objects. 
    Grade[] grades = 
    { new Grade("A" , 95), new Grade("A-",90),   
      new Grade("B+" , 87) , new Grade("B" , 85) , new Grade("B-" , 80 ) , 
      new Grade("C+" , 77) , new Grade("C" , 75) , new Grade("C-" , 70 ) ,
      new Grade("D+" , 67) , new Grade("D" , 75) , new Grade("D-" , 70 ) ,
      new Grade("F" , 0) 
    };
  //
  // Print out the grades twice.  
  //
    for ( Grade letterGrade : grades)
    {
      System.out.println(letterGrade);
    }
    System.out.println("---------------------------------------------------");
    for ( int i = 0; i < grades.length ; i++)
    {
         System.out.println(grades[i].toString());
    }    
  }
}