/**
 * Auto Generated Java Class.
 */
class Grade
{
  private String name;
  private int lowerBound;
  //------------------------------------------------------------------------
  // Constructor:Sets up this grade object with the specified 
  // grade name and the numeric lower bound.
  //------------------------------------------------------------------------
  public Grade(String grade, int cutoff)
  {
    name = grade;
    lowerBound = cutoff;
  }
  
  //------------------------------------------------------------------------
  //  Returns a string representation of this grade.
  //-------------------------------------------------------------------------
  public String toString()
  {
    return name + "\t" + lowerBound;
  }
  
  //-----------------------------------------------------------
  // Name setter.
  //-----------------------------------------------------------
  public void SetName(String grade)
  {
    name = grade;
  }
  
  //-----------------------------------------------------------
  //  Lower Bound Setter
  //-----------------------------------------------------------
  public void setLowerBound(int cutoff)
  {
    lowerBound = cutoff;
  }
  
  //-----------------------------------------------------------
  // Name getter
  //-----------------------------------------------------------
  public String getName()
  {
    return name;
  }
  
  //-----------------------------------------------------------
  // Lower bound getter.
  //-----------------------------------------------------------
  public int getLowerBound()
  {
    return lowerBound;
  }

}
