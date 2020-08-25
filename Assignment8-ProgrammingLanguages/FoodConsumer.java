

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class FoodConsumer extends Thread {

  FoodBank bank;


  public FoodConsumer(FoodBank bank) {
    this.bank = bank; 
  }

  public void run() {
    int amount;
    Random random = new Random();
    ReentrantLock lock = new ReentrantLock();
    while (true) {
      amount = random.nextInt(100) + 1;

      System.out.println("Waiting to take food");
      lock.lock();
      if (bank.food >= amount) {
        System.out.printf("Taking %d items of food, the balance is not %d items\n", amount, bank.food);
        bank.takeFood(amount);
      }
      lock.unlock();

      try {
        Thread.sleep(100);
      } 
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
