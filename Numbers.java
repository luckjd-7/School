import java.util.Scanner;

//  This class creates an objet that holds an array of variable size double array.  The array size is passed into the constructor
//  from the calling object.  This class contains methods that allow input of numbers into the array, comput the sum of all numbers 
//  in the array, and compute the product of all numbers in the array.
//
//  Written by George Cardwell
//  CSC-202 Fall2016
public class Numbers 
{   
  private double[] dNum;
  private double sum;
  private double product;
  private int ArraySize;
  Scanner scan = new Scanner(System.in);         //  This class accepts a list of numbers and computes the sum and product of the numbers.//
  Numbers( int isize )   
  {     
    this.ArraySize=isize;     
    dNum = new double[this.ArraySize];
  }     
  public void inputNums()
  {     
    for ( int i = 0; i < dNum.length; ++i )
    {       
      System.out.print("Enter Number" + (i+1) + ": " );
      dNum[i] = scan.nextDouble();
    }
  }
  public double sumNumbers()
  {     
    sum = 0;
    for ( int i = 0; i < dNum.length; ++i )
    {       
      sum = sum + dNum[i];
    }
    return sum;
  }
  public double multiplyNumbers()
  {
    product = 1;
    for ( int i = 0; i < dNum.length; ++i )
    {
      product = product * dNum[i];
    }
    return product;
  }
}
