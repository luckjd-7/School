/** Joey Luck 02/09/2019
 * CMCS 355 
 * Created by debmduke on 2/7/19.
 */
public class FractionalNumber {
    private int numerator;
    private int denominator;

    /*
    *   Sets default values for numerator & denominator */
    public FractionalNumber() {
        numerator = 1;
        denominator = 1;
    }

    /*
        Precondition: denominator cannot be 0
        @param num      the numerator of the fraction
        @param denom    the denominator of the fraction, may not be 0 */
    public FractionalNumber(int num, int denom){
        numerator = num;
        if(denom != 0)
            denominator = denom;
        else
            throw new IllegalArgumentException("Denominator cannot be 0.");
    }

    /*
    *   Adjusts the sign of the numerator and denominator so the
    *   denominator is positive, if necessary */
    private void normalize(){
    	if(numerator<0||denominator<0) //checks for negative value
    		numerator = -(Math.abs(numerator)); 
    		denominator = Math.abs(denominator);
    	

    }

    /*
    *   Adds the paramter to this fractional number
    *   Precondition: this and otherNum are valid FractionalNumbers
    *   Postcondition: this is the sum of the two fractions
    *   Class Invariant: otherNum is not changed
    *   @param  otherNum    a FractionalNumber*/
    public void add(final FractionalNumber otherNum){
//        a/b + c/d = (a*d + b*c) / b*d
    	//calculates addition between two fractions
     this.numerator = (this.numerator*otherNum.denominator + this.denominator*otherNum.numerator);
     this.denominator = this.denominator*otherNum.denominator;
     this.simplify();
    }

    public void subtract(final FractionalNumber otherNum) {
    	//a/b – c/d = (a*d – b*c) / b*d 
    	//calculates subtraction between two fractions
    	this.numerator = (this.numerator*otherNum.denominator - this.denominator*otherNum.numerator);
        this.denominator = this.denominator*otherNum.denominator;
        this.simplify();
    }

    public void multiply(final FractionalNumber otherNum){
    	//a/b * c/d = a*c / d*b
    	//calculates multiplication between two fractions
    	if(otherNum.denominator!=0 && otherNum.numerator!=0) {
    	this.numerator = (this.numerator*otherNum.numerator);
        this.denominator = this.denominator*otherNum.denominator;
        this.simplify();
    	}
    	else //invalid number
            throw new IllegalArgumentException("Second Number cannot be 0.");
    }

    public void divide(final FractionalNumber otherNum){
    	//(a/b) / (c/d) = a*d / b*c, where c/d ≠ 0 
    	//calculates division between two fractions
    	if(otherNum.denominator!=0 && otherNum.numerator!=0) { //makes sure no zeros in otherNum
    	    this.numerator = (this.numerator*otherNum.denominator);
            this.denominator = this.denominator*otherNum.numerator;
            this.simplify();
    	}
        else //invalid number
                throw new IllegalArgumentException("Second Number cannot be 0.");

    }

    public int getNumerator(){
        return 0;
    }

    public int getDenominator(){
        return 1;
    }

    public void setNumerator(int num){
    	numerator = num;
    }

    public void setDenominator(int denom){
    	if(denom != 0)
    		denominator = denom;
    	else
    		throw new IllegalArgumentException("Denominator cannot be 0.");
    }
    
    public int GCD(int i) { //Recursive method to find GCD
    	//if both are divisible it returns the value of i
    		if((this.numerator % i == 0)&&(this.denominator % i == 0)) return i;
    		return GCD(i-1); //returns i-1 if both numbers aren't divisible by i
    }
    public void simplify() { //simplify fraction
    	this.normalize();
    	//finds minimum between numerator and denominator and absolute value 
    	//then places value in GCD
    	int gcd = GCD(Math.min(Math.abs(this.numerator), Math.abs(this.denominator)));
    	if(gcd>1) {  //divides numerator and denominator by GCD
    		this.numerator = this.numerator/gcd;
		    this.denominator = this.denominator/gcd;
    	}
    }
    

    /*
    *   @return     true if this fraction and other would reduce to the
    *               same numerator and denominator, false otherwise
    *   @param      other       a FractionalNumber  */
    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if (other == null) return false;
        if(!(other instanceof FractionalNumber)) return false;
        FractionalNumber otherNum = (FractionalNumber) other;
        return numerator * otherNum.getDenominator() == otherNum.getNumerator()
* denominator;    }

    @Override
    public String toString(){
        return null;
    }
    /*public static void main(String[] args) { 
    FractionalNumber num1 = new FractionalNumber(1,2);
    FractionalNumber num2 = new FractionalNumber(1,4);
    FractionalNumber num3 = new FractionalNumber(1,2);
    FractionalNumber num4 = new FractionalNumber(1,-4);
    FractionalNumber num5 = new FractionalNumber(2,-4);
    FractionalNumber num6 = new FractionalNumber(1,2);
    FractionalNumber num7 = new FractionalNumber(1,2);
    //num1.setDenominator(0);
    System.out.println(num1.numerator + "/" + num1.denominator);
    num1.add(num2);
    num6.divide(num2);
    num7.subtract(num2);
    num3.multiply(num2);
    num4.normalize();
    num5.simplify();
    System.out.println(num5.numerator + "/" + num5.denominator);
    System.out.println(num1.numerator + "/" + num1.denominator);
    System.out.println(num7.numerator + "/" + num7.denominator);
    System.out.println(num6.numerator + "/" + num6.denominator);
    System.out.println(num3.numerator + "/" + num3.denominator);
  }*/ 
}
