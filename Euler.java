
public class Euler 
{
 public static double number = 0.0;
 public static double counter = 0.0;
 public static void main(String[] args)
 {
  System.out.println(Euler(2)); 
 }
 public static double factorial(double n)
 { 
  if(n==0||n==1)
  {
   return 1;
  }
  number = factorial(n-1) * n; 
  return number; 
 }
 public static double Euler(double number)
 {
  counter++; 
  if(counter == number + 20)
  {
   return 1;
  }
  number = (Math.pow(number, counter)/factorial(counter)) + Euler(number); 
  return number;
 }
}
