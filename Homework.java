public class Homework 
{
  private long n;
  private long m;
  
  
  public static void main(String[] args)
  {
    int a[]=new int[10];
    int b[]=new int[10];
    b=a;
    a[4]=550;
    for(int element : b) {
    //System.out.print(element);
    }
    isMultiple(3,9);
    System.out.println(divisor(150));
  }
  public static boolean isMultiple(long n, long m)
  {
    long i = m%n;
    boolean fuck=false;
    if(i==0) { fuck = true; ;}
    System.out.println(i);
    return fuck;
  }
  public static int summation(int n)
  {
    int i;
    int j=0;
    for(i=n;i>0;i--) {j=j+i;}
      System.out.println(j);
      return j;
  }
   public static double divisor(double x)
  {
    double o = 0;
    for(o=0;x>2;o++) {x=x/2;}
    /*if(x>2) {x=x/2; o++;}
    if(x>2) {x=x/2; o++;}
    if(x>2) {x=x/2; o++;}
    if(x>2) {x=x/2; o++;}
    if(x>2) {x=x/2; o++;}
    if(x>2) {x=x/2; o++;}
    if(x>2) {x=x/2; o++;}*/
      System.out.println(x);
      return o;
  }
}
