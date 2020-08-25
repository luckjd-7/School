
import java.util.*;
import java.io.*;
public class Trajectory
{
  /* 
   * 
   * 
   * 
   */
  private double initialSpeed;
  private double angle;
  private double gravityConstant;
  private Integer time;
  private double xy[][];
  private double[] aX,aY;
  private double maximumHeight;
  private double totalTimeofFlight;
  private double distanceTraveled;
  
  public Trajectory() {
   initialSpeed = 0.0;
   angle = getAngle();
   gravityConstant = 0.0;
   aX = new double[16];
   aY = new double[16];
   xy = new double[16][3];
   maximumHeight = 0.0; 
   totalTimeofFlight = 0.0;
   distanceTraveled = 0.0; 
   time = 0;
  }
  public Trajectory(double i, double a, double g) {
    initialSpeed = i;
    angle = a;
    gravityConstant = g;
  }
  public void UpdateState() {
    /* attempts at for loop were unsucsessful
    for(int k=0;k<aX.length;k++) {
      aX[k] = Math.round(initialSpeed*Math.cos(getAngle())*time);
      aY[k] = Math.round((initialSpeed*Math.sin(getAngle())*time)-(0.5*gravityConstant*time*time));
      time = k + 10;
      }*/
    aX = new double[] {initialSpeed*Math.cos(getAngle())*0,initialSpeed*Math.cos(getAngle())*10,initialSpeed*Math.cos(getAngle())*20,
      initialSpeed*Math.cos(getAngle())*30,initialSpeed*Math.cos(getAngle())*40,initialSpeed*Math.cos(getAngle())*50,
      initialSpeed*Math.cos(getAngle())*60,initialSpeed*Math.cos(getAngle())*70,initialSpeed*Math.cos(getAngle())*80,
      initialSpeed*Math.cos(getAngle())*90,initialSpeed*Math.cos(getAngle())*100,initialSpeed*Math.cos(getAngle())*110,
      initialSpeed*Math.cos(getAngle())*120,initialSpeed*Math.cos(getAngle())*130,initialSpeed*Math.cos(getAngle())*140,
      initialSpeed*Math.cos(getAngle())*150,};
    aY = new double[] {(initialSpeed*Math.sin(getAngle())*0)-(0.5*gravityConstant*0*0),
      (initialSpeed*Math.sin(getAngle())*10)-(0.5*gravityConstant*10*10),(initialSpeed*Math.sin(getAngle())*20)-(0.5*gravityConstant*20*20),
      (initialSpeed*Math.sin(getAngle())*30)-(0.5*gravityConstant*30*30),(initialSpeed*Math.sin(getAngle())*40)-(0.5*gravityConstant*40*40),
      (initialSpeed*Math.sin(getAngle())*50)-(0.5*gravityConstant*50*50),(initialSpeed*Math.sin(getAngle())*60)-(0.5*gravityConstant*60*60),
      (initialSpeed*Math.sin(getAngle())*70)-(0.5*gravityConstant*70*70),(initialSpeed*Math.sin(getAngle())*80)-(0.5*gravityConstant*80*80),
      (initialSpeed*Math.sin(getAngle())*90)-(0.5*gravityConstant*90*90),(initialSpeed*Math.sin(getAngle())*100)-(0.5*gravityConstant*100*100),
      (initialSpeed*Math.sin(getAngle())*110)-(0.5*gravityConstant*110*110),(initialSpeed*Math.sin(getAngle())*120)-(0.5*gravityConstant*120*120),
      (initialSpeed*Math.sin(getAngle())*130)-(0.5*gravityConstant*130*130),(initialSpeed*Math.sin(getAngle())*140)-(0.5*gravityConstant*140*140),
      (initialSpeed*Math.sin(getAngle())*150)-(0.5*gravityConstant*150*150)};
    for(int j = 0; j < aX.length; j++) {
      aX[j] = Math.round(aX[j]);
      aY[j] = Math.round(aY[j]);
    }
    xy = new double[][] {{0.0,aX[0],aY[0]},{10.0,aX[1],aY[1]},{20.0,aX[2],aY[2]},{30.0,aX[3],aY[3]},{40.0,aX[4],aY[4]},
   {50.0,aX[5],aY[5]},{60.0,aX[6],aY[6]},{70.0,aX[7],aY[7]},{80.0,aX[8],aY[8]},{90.0,aX[9],aY[9]},{100.0,aX[10],aY[10]},
   {110.0,aX[11],aY[11]},{120.0,aX[12],aY[12]},{130.0,aX[13],aY[13]},{140.0,aX[14],aY[14]},{150.0,aX[15],aY[15]}};
  }
  public double[] getAY() { 
    for(int w=0;w<16;w++) {
     aY[w] = (initialSpeed*Math.sin(getAngle())*time)-(0.5*gravityConstant*time*time);
     time = w + 10;
      }
    return aY;}
  public double[] getAX() {
    for(int w=0;w<16;w++) {
     aX[w] = initialSpeed*Math.cos(getAngle())*time;
     time = w + 10;
      }
    return aX;}
  public double getInitialSpeed() { return initialSpeed; }
  public double getAngle() {
    double theta = Math.toRadians(angle);
    return theta; }
  public double getGravityConstant() { return gravityConstant; }
  public double getMaximumHeight() { 
    maximumHeight = ((initialSpeed*Math.sin(getAngle())*(initialSpeed*Math.sin(getAngle())))/(2*gravityConstant));
    return maximumHeight; }
  public double getTotalTimeofFlight() { 
    totalTimeofFlight = ((2*initialSpeed*Math.sin(getAngle())))/(gravityConstant);
    return totalTimeofFlight; }
  public double getDistanceTraveled() {
   distanceTraveled = Math.pow(initialSpeed,2)/gravityConstant*Math.sin(2*getAngle());
    return distanceTraveled; }
  //setters
  public void setInitialSpeed(double initialSpeed) { this.initialSpeed = initialSpeed; }
  public void setAngle(double angle) { this.angle = angle; }
  public void setGravityConstant(double gravityConstant) { this.gravityConstant = gravityConstant; }
  public void setTime() { this.time = time; }
  public void setMaximumHeight(double maximumHeight) { this.maximumHeight = maximumHeight; }
  public void setTotalTimeofFlight(double totalTimeofFlight) { this.totalTimeofFlight = totalTimeofFlight; }
  public void setDistanceTraveled(double distanceTraveled) { this.distanceTraveled = distanceTraveled; }
  @Override
 public String toString() {
    return "Trajectory [initial speed = " + initialSpeed + " angle = " + angle + " gravity constant = " + gravityConstant
      + " time = " + time + " maximum height = " + maximumHeight + " total time of flight = " + totalTimeofFlight
      + " distance traveled = " + distanceTraveled + " (x,y) = (" + getAX() + "," + getAY() + ")"  +  ")"  +
      /*Arrays.toString(aTime) +*/ "]";
  }
  public void PrintArray() {
    System.out.print(Arrays.deepToString(xy).replace("], ", "]\n").replace("[[", "[").replace("]]","]"));
  }
  public Trajectory Flying(Trajectory thing) { 
    UpdateState();
    thing.PrintArray();
    return null; 
  }
  public static void printSummary(Trajectory item) {
    System.out.println("Maximum height = " + item.getMaximumHeight());
    System.out.println("Flight Time = " + item.getTotalTimeofFlight());
    System.out.println("Range = " + item.getDistanceTraveled());
    System.out.printf("  (time) %5s: ","(x,y)\n");
    System.out.println(item.Flying(item));
    System.out.println();
  }
  public static void main(String[] args) {
    System.out.println("Joey Luck");
    System.out.println("CSC-202 Programming Assignment-2");
    System.out.println("Ideal Projectile Motion");
    System.out.println();
    Trajectory bullet = new Trajectory(840,60,9.8);
    Trajectory rock = new Trajectory(500,45,9.8);
    Trajectory ball = new Trajectory(300,30,32);
    printSummary(bullet);
    printSummary(rock);
    printSummary(ball);
  }
}