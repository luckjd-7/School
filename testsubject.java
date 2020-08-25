public class testsubject
{
  public static void main(String[] args)
  {
    String text = "Farm ";
    for (int i=0; i<15; i++)
    {
      text = text + "*";
    }
    String hope = String.format("Farm: %,.d", text);
    //System.out.print(hope);
  }}