import java.util.*;
public class CustomerListerArrayList
{
  public static void main (String[] args)
  {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Chris");
    names.add("Lois");
    names.add("Meg");
    names.add("Peter");
    names.add("Stewie");
    for(String element : names)
    {
      System.out.println(element);
    }
      names.add(3, "Brian");
      names.add(2, "Meg");
      for(String name : names)
      {
      System.out.println(name);
      }
      for(int i=4; i < names.size(); i++) 
      { 
          names.remove("Meg");
        for(String j : names)
        {
          System.out.println(j);
        }
      }
      
  }
  }
    
    