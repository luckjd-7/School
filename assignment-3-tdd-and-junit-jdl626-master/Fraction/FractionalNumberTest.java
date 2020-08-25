/**Joey Luck Spring 2019
 * CMCS 355 Fractional Number Test
 *  
 */

import org.junit.*;

import static org.junit.Assert.*;

/**
* Created by debmduke on 2/7/19.
*/
public class FractionalNumberTest {
  FractionalNumber num1;
  FractionalNumber num2;

  @org.junit.Before
  public void setUp() throws Exception {
      num1 = new FractionalNumber(1, 2);
      num2 = new FractionalNumber(1, 4);
  }
//test to make sure there is a value
  @org.junit.Test
  public void NotNull() throws Exception {
	  assertNotNull(num1);
  }
  //test to make sure instance variables aren't null
  @org.junit.Test
  public void Null() throws Exception {
	  FractionalNumber num3 = new FractionalNumber(1, 2);
	  assertNotNull(num3);
  }
  //checking to make sure the two numbers are different
  @org.junit.Test
  public void NotSame() throws Exception {
	  assertNotSame(num1, num2);
  }
//testing add method
  @org.junit.Test
  public void add() throws Exception {
      num1.add(num2);
      FractionalNumber num3 = new FractionalNumber(3, 4);
      assertEquals(num1, num3);
  }
  //testing adding null
  @org.junit.Test(expected = NullPointerException.class)
  public void add1() throws Exception {
      num1.add(null);
      assertNull(num1);
  }
//testing subtract method
  @org.junit.Test
  public void subtract() throws Exception {
	  num1.subtract(num2);
	  FractionalNumber num3 = new FractionalNumber(1, 4);
	  assertEquals(num1, num3);
  }
  //testing subtracting by 0
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void subtract0() throws Exception {
	  FractionalNumber num3 = new FractionalNumber(0,0);
	  num1.subtract(num3);
  }
//testing multiplication method
  @org.junit.Test
  public void multiply() throws Exception {
	  num1.multiply(num2);
	  FractionalNumber num3 = new FractionalNumber(1, 8);
	  assertTrue(num1.equals(num3));
  }
  //testing multiply by 0
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void multiply0() throws Exception {
	  FractionalNumber num3 = new FractionalNumber(0,5);
	  num1.multiply(num3);
	  assertTrue(num1.equals(num3));
  }
//testing divide method
  @org.junit.Test
  public void divide() throws Exception {
	  FractionalNumber num3 = new FractionalNumber(2, 1);
	  num1.divide(num2);
	  assertEquals(num1, num3);
  }
  //testing divide by 0
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void divide0() throws Exception {
	  FractionalNumber num3 = new FractionalNumber(0, 0);
	  num1.divide(num3);
	  assertEquals(num1, num3);
  }
//testing the set denominator to make sure no denominators equal 0
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void setDenominator() throws Exception {
	  num1.setDenominator(0);
  }
//testing equals method false
  @org.junit.Test
  public void testEquals1() throws Exception {

	  assertFalse(num1.equals(num2));

  }

//testing equals method true
@Test
public void testEquals2() {
	  
	  FractionalNumber num3 = new FractionalNumber(1, 2);
	  assertTrue(num1.equals(num3));
	  
	
}
}
