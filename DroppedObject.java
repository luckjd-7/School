
public class DroppedObject 
{
//
// Description: This class keeps the state of a falling object. The state means the height above the ground, the current 
// vertical velocity, the gravity constant , and the time differential (delta t).
// This class will contain methods to update the state of the object, print and set the state variables of the falling object
//
// Written by George Cardwell 
// Written as an example for CSC-202 Class Fall 2017.
 
 
// Private state variables

 private double altitude;
 private double deltatime;
 private double velocity;
 private double gravityconst;
 private double TimeOfFlight = 0.0;
 
 
 
//  methods
 // consturctors
 
 public DroppedObject()
 {
  altitude = 0.0;
  deltatime = 0.0;
  velocity = 0.0;
  gravityconst = -32.2;
 }
 
 public DroppedObject(double h,double v, double dt, double g)
 {
  altitude = h;
  velocity = v;
  deltatime = dt;
  gravityconst = -g;
 }
 
//
// state Methods
//
 public void UpdateState()
 {
  velocity = velocity + Math.abs(gravityconst*deltatime);
  altitude = altitude - velocity*deltatime;
  TimeOfFlight = TimeOfFlight + deltatime;
 }
//
// Getters and setters
//
 public double getAltitude() {
  return altitude;
 }

 public void setAltitude(double altitude) {
  this.altitude = altitude;
 }

 public double getDeltatime() {
  return deltatime;
 }

 public void setDeltatime(double deltatime) {
  this.deltatime = deltatime;
 }

 public double getVelocity() {
  return velocity;
 }

 public double getVelocityMPH(){
  return velocity * (3600.00/5280.00);
 }
 public void setVelocity(double velocity) {
  this.velocity = velocity;
 }

 public double getGravityconst() {
  return gravityconst;
 }

 public void setGravityconst(double gravityconst) {
  this.gravityconst = gravityconst;
 }
 
 public double getTimeOfFlight()
 {
  return TimeOfFlight;
 }
 public DroppedObject Falling(DroppedObject ball)
 {
   for(double i = altitude; altitude>0; i--) { ball.UpdateState(); } 
   return ball;}

 @Override
 public String toString() {
  return "DroppedObject [altitude=" + altitude + ", deltatime=" + deltatime + ", velocity=" + velocity
    + ", gravityconst=" + gravityconst + ", TimeOfFlight=" + TimeOfFlight + "]";
 }
 public static void main(String[] args) // homework assignment 2, Joey Luck
 {
   DroppedObject ball = new DroppedObject(100,0,0.001,32.2);
   System.out.println("Program to calculate fall time and impact speed of");
   System.out.println("a falling object dropped from a specific height. ");
   System.out.println("Enter initial height in feet: " + ball.getAltitude());
   ball.Falling(ball);
   System.out.println("Falling time = " + ball.getTimeOfFlight() + " seconds");
   System.out.println("Impact Speed = " + ball.getVelocity() + " feet/sec");
   System.out.println("Impact Speed = " + ball.getVelocityMPH() + " mph");
 }
}
