

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class FoodProducer extends Thread {
  
  private FoodBank bank;

  public FoodProducer(FoodBank bank) {
    this.bank = bank; 
  }

  public void run() {
    int amount;
    Random random = new Random();
    ReentrantLock lock = new ReentrantLock();
    while (true) {

      amount = random.nextInt(100) + 1;

      System.out.println("Waiting to get food");
      lock.lock();
      System.out.printf("Giving %d items of food, the balance is now %d items\n", amount, bank.food);
      bank.giveFood(amount);
      lock.unlock();

      try {
        Thread.sleep(100);
      } 
      catch(InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
