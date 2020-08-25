/** Joey Luck 02/09/2019
 * CMCS 355 
 * Created by debmduke on 2/7/19.
 */
public class FractionalNumber {
    private int numerator;
    private int denominator;

    /*
    *   Sets default values for numerator & denominator */
    public FractionalNumber(){
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

    }

    /*
    *   Adds the paramter to this fractional number
    *   Precondition: this and otherNum are valid FractionalNumbers
    *   Postcondition: this is the sum of the two fractions
    *   Class Invariant: otherNum is not changed
    *   @param  otherNum    a FractionalNumber*/
    public void add(final FractionalNumber otherNum){
//        a/b + c/d = (a*d + b*c) / b*d
     int a,b,c,d;
     this.numerator = a;
     otherNum.numerator = b;
     c = otherNum.numerator;
     d = otherNum.denominator;
     otherNum = (a*d + b*c)/b*d;
    }

    public void subtract(final FractionalNumber otherNum){

    }

    public void multiply(final FractionalNumber otherNum){

    }

    public void divide(final FractionalNumber otherNum){

    }

    public int getNumerator(){
        return 0;
    }

    public int getDenominator(){
        return 1;
    }

    public void setNumerator(int num){

    }

    public void setDenominator(int denom){

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
   /* public static void main(String[] args) { 
    FractionalNumber num1 = new FractionalNumber(1,2);
    FractionalNumber num2 = new FractionalNumber(1,4);
    num1.add(num2);
    System.out.println(num1);
  }*/
}
