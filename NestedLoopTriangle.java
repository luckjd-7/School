public class NestedLoopTriangle
{
  public static void main(String[] args)
  {
    int i = 0;
    int n = 0;
    String a = "*";
    String b = "**";
     for (i = 0; i <= 9; i++)
     {
       n=n+1;
       //a = a + b;
      for(n = 0; n <= 1; n++)
       {
        System.out.println(a);
        n++;
        a = a + b;
       }
      // System.out.println(a); 
     }
     }
     //System.out.println("*");
  }
      
  