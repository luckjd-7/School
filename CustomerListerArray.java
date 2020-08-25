public class CustomerListerArray 
{
  public static void main(String[] args)
  {
  //System.out.println(customerName());
    String page = customerName();
  }
  public static String customerName()
  {
    String str1,str2,str3,str4,str5,str6,str7;
    str1 = "Chris";
    str2 = "Lois";
    str3 = "Meg";
    str4 = "Meg";
    str5 = "Brian";
    str6 = "Pete";
    str7 = "Stewie";
    String[] names;
    names = new String[7];
    
    names[0] = str1;
    names[1] = str2;
    names[2] = str3;
    names[3] = str4;
    names[4] = str5;
    names[5] = str6;
    names[6] = str7;
    String list = new String();
    for(String element : names)
    {
      list = element;
      if (list=="Meg")
      {
       continue;
      }
      System.out.println(element);
      
    }
    return list;
  }
}
    
  
      