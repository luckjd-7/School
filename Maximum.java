
public class Maximum
{ 
 public static void main(String[] args)
 {
  int[] fList = {1,5,3,4,2};
  int[] bList = {};
  int fMax = Maximum(0,0,fList); 
  int bMax = Maximum(0,0,bList); 
  System.out.println(fMax);
  System.out.println(bMax);
 }
 public static int Maximum(int counter,int max, int[] list)
 {
  if(list.length==0) 
  { 
   max = -2147483648;
  }
  if(list.length==(counter-1)) 
  {
      max = Math.max(max, list[counter]);
   return max;
  }
  if(list.length!=counter)
  {
      max = Math.max(max, list[counter]);
      counter++; 
      return Maximum(counter,max,list);
  }
  return max;
 }
}
