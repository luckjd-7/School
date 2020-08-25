
public class Reverse 
{
 public static String reverse = "";
   public static void main(String[] args)
 {
  System.out.println(Reverse("abcde"));
 }
public static String Reverse(int a, int size, String b, String string)
{
 char[] array;
 array = string.toCharArray();
 if(a<string.length()) { 
  reverse = b + String.valueOf(array[size-1]); 
  size--;
  a++;
  Reverse(a,size,reverse,string);
 }
 return reverse;
}
public static String Reverse(String string)
{
  String reverse = "";
  int a = 0;
  int size = string.length();
  reverse = Reverse(0,size,"", string);
  return reverse;
}
}
