public class CountLoop
{
  public static void main(String[] args)
  {
    int i = 1;
    int total = 0;
   /* while (i <= 100)
   {
      total = total + i;
      i++; 
    }
      System.out.println(total); */
      
    /*for(int i = 1; i <= 100; i++)
    {
      total = total + i;
    }
      
    System.out.println(total); */
    do
    {
      total = total + i;
      i++;
    } while(i <= 100);
    System.out.println(total);
     
     
      
    
  }
}
