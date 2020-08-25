public class GreatestCommonDivisor {     
  public static int gcd(int p, int q)
  {    
    if (q == 0) 
    {        
      return p;    
    }        
    return gcd (q, p % q);   
  } 
     // Test enable assert check via -ea as a VM argument 
     public static void main(String[] args)
     {      
       System. out .println("The greatest common divisor of 16 and 4 is " + gcd (4, 16));   
       System. out .println("The greatest common divisor of 16 and 4 is " + gcd (16, 4)); 
       System. out .println("The greatest common divisor of 60 and 15 is " + gcd (60, 15));  
       System. out .println("The greatest common divisor of 65 and 15 is " + gcd (15, 65));   
       System. out .println("The greatest common divisor of 1052 and 52 is " + gcd (1052, 52));      
     } 
} 