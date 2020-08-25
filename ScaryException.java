public class ScaryException extends RuntimeException {
  
  public ScaryException(){
    super("Be very afraid");
  }
  
  public ScaryException(String scaryMessage){
    super(scaryMessage);
  }
}