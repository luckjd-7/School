
public class SArray { 
 public static int result = 0;
 

 public static void main(String[] args) {
  int[] numbers = { 23, 17, 5, 90, 12, 44, 38, 84, 77, 3, 66, 55, 1, 19, 37, 88, 8, 97, 25, 50, 75, 61, 49};
  System.out.println("The unsorted array is ");
  toString(numbers); 
  result = 0;
  System.out.println("the position of 25 is " + sSearch(numbers,25));
  System.out.println("the position of 30 is " + sSearch(numbers,30));
  System.out.println("the position of 50 is " + sSearch(numbers,50));
  System.out.println("the position of 75 is " + sSearch(numbers,75));
  System.out.println("the position of 92 is " + sSearch(numbers,92));
  System.out.println("Total number of searches for the sequential search are " + result);
  result = 0;
  sort(numbers); // sort array
  System.out.print("The sorted array is ");
  toString(numbers); // print after sorted
  result = 0;
  System.out.println("the position of 25 is " + binarySearch(numbers,25)); //binary search call
  System.out.println("the position of 30 is " + binarySearch(numbers,30));
  System.out.println("the position of 50 is " + binarySearch(numbers,50));
  System.out.println("the position of 75 is " + binarySearch(numbers,75));
  System.out.println("the position of 92 is " + binarySearch(numbers,92));
  System.out.println("The total number of searches for Binary search are " + result);
 }
  public static int sSearch(int[] numbers, int a)
 {
  boolean found = false; 
  int position = 0, searches = 0;
  for(int i = 0; i < numbers.length && !found; i++) 
  {
   result = result + 1; //total searches through multiple calls
   searches = searches + 1; //total searches for one call
   if(numbers[i]==a)
   { 
    found = true; //boolean found/exit loop
    position = i + 1; //position of number in array
    System.out.println("the number of searches for " + a + " is " + searches); //prints number of searches
   }
  }
  if(found)
  {
   return position;
  }
  else
  {
     System.out.println("the number of searches for " + a + " is " + searches); // prints number of searches through array same as arrays length
     return -1;
  }
 }
 public static void sort(int[] numbers) {
  int temp = 0;
  int searchResult = 0; 
   for(int j = 0;j < numbers.length && j+1 < numbers.length; j++ ) 
   {
    searchResult = searchResult + 1; // search number during each method call
          result = result + 1; // search number for all method calls
          if(numbers[j]>numbers[j + 1]) 
          {
              temp = numbers[j + 1]; // temporary spot to hold smaller variable
              numbers[j + 1] = numbers[j]; // switch variables
              numbers[j] = temp; // place lower variable in spot
              sort(numbers); // recursive call
          }
   }
  }

 public static int binarySearch(int[] numbers, int a) {
  int searches = 0, first = 0, mid = 0, last = numbers.length - 1; 
  boolean found = false;
  while (first <= last && !found) { //loop to binary search
   result = result + 1; // total searches for multiple calls
   searches = searches + 1; //total searches per call
   mid = (first + last)/2; // mid point of array
   if(numbers[mid]==a) // found
    found = true; //exit
   else // if not
    if(numbers[mid]>a) // if number is less than midpoint
     last = mid - 1; // try again with number before midpoint as last
    else // if number is larger than midpoint
     first = mid + 1; // try again with number after midpoint as first
  }
  if(found) { //when found
   System.out.println("the number of searches for " + a + " is " + searches); //print number of searches
   return mid; // return position
  }
  else { //didnt find
    System.out.println("the number of searches for " + a + " is " + searches); // print number of searches
   return -1; // return - 1 if not found
  }
 }
  public static int getResult() {
  return result;
 }

 public static void setResult(int result) { // reset total
  SArray.result = result;
 }

 public static void toString(int[] numbers) { //print to string method
  for(int i = 0; i < numbers.length; i++) { //run through array loop
   System.out.print(numbers[i]); //print each value in array
   System.out.print(",");
  }
  System.out.println();
 }
}
