/** 
 * A class to represent a date.
*/
public class SimpleDate {
      private int month;     //instance variables
      private int day;
      private int year;

 /** 
  * Default constructor for a SimpleDate that sets the date to 1/1/2000
  */
 public SimpleDate(){        
  month = getMonth();
  day = getDay();
  year = getYear();
 }

 /** 
  * Parameterized constructor for a SimpleDate 
  * @param aMonth month 
  * @param aDay   day
  * @param yr   year 
  */                     
 public SimpleDate(int aMonth, int aDay, int yr){
   month = aMonth;
   year = yr;
   day = aDay;
 }

 //accessor methods
    /**
  * Returns the month of this SimpleDate
 * @return int
  */
 public int getMonth(){
  return month;
 }
 /**
  * Returns the day for this SimpleDate
  * @return int
  */
 public int getDay(){
  return day;
 }

 /**
  * Returns the year of this SimpleDate
  * @return int
  */
 public int getYear(){
  return year;
 }

 //mutator methods
   /**
  * Sets the month of the SimpleDate
  * @param aMonth  a SimpleDate month
  * @throws IllegalArgumentException invalid month arguments
  */
 public void setMonth(int aMonth){
  if(aMonth < 1 || aMonth > 12){
   throw new IllegalArgumentException("Invalid month");
  }
 month = aMonth;
}

 /**
  * Sets the day of the SimpleDate
  * @param aDay  an day name
  * @throws IllegalArgumentException invalid day arguments
  */
 public void setDay(int aDay){
  if(aDay < 1 || aDay > 31){
   throw new IllegalArgumentException("Invalid day");
  }
  day = aDay;
 }

 /**
  * Sets the year of the SimpleDate
  * @param newYear  an year name
  * @throws IllegalArgumentException year arguments less than 1
  */
 public void setYear(int aYear){
  if(aYear < 1){
   throw new IllegalArgumentException("Invalid year");
  }
  year = aYear;
 }

 /* 
  * @return The month, day, and year information for this SimpleDate
  */
 public String toString() {  
 String output;
  output = "\nSimpleDate: " + month + "\\"+ day;
  output = output + "\\"+ year + "\n";
  return output;
 }
}
