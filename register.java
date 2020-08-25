public class register
{
  private double total;
  private double itemAmount;
  private int itemCount;
  public double getItemAmount()
  {
    return itemAmount;
  }
  public void addItem(double price)
  {
    itemCount++;
    total += price;
  }
}