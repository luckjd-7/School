import java.util.*;
import java.io.*;
public class SimpleDateTester
 {
   public static void main(String[] args)
   {
   ArrayList<SimpleDate> dates = new ArrayList<SimpleDate>();
   SimpleDate date1 = new SimpleDate(1,1,2000);  
   SimpleDate date2 = new SimpleDate(6,26,1989);
   SimpleDate date3 = new SimpleDate(4,20,2025);
   SimpleDate date4 = new SimpleDate(8,2,2001);
   SimpleDate date5 = new SimpleDate(12,25,1999);
   try{
   dates.add(date1);
   dates.add(date2);
   dates.add(date3);
   dates.add(date4);
   dates.add(date5);
   }
   catch(IllegalArgumentException e)
   {}
   
//   SimpleDate birthday = new SimpleDate(3,14,1999);
   
   for(int i =0; i < 5; i++)
   {
     dates.get(i).setYear(dates.get(i).getYear()++);
//     System.out.println(dates.get(i).getYear());
//     birthday.setYear(birthday.getYear()++);
     System.out.println(dates.get(i));
   }
 }
 }
   