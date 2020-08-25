
public class Collatz 
{
 public static int size = 0;
  public static void main(String[] args) 
 {
 System.out.println(Collatz(3)); 
 }
 public static int getSize() 
 {
 return size;
}
 public static void setSize(int size) 
 {
 Collatz.size = size;
}
  public static int Collatz(int n) 
  {
   int result; 
   if(n==1) { 
    size++;
    return size;
   }
   else if(n%2 == 0) 
   {  
    size++; 
    result = Collatz(n/2); 
   }
   else if(n%2!=0)
   {
    size++;
    result = Collatz((3*n)+1);
   }
   return size; 
 }
}