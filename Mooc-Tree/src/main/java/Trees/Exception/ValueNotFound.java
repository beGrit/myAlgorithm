package Trees.Exception;

/**
 * Author: lsf Time: 5/22/20-3:56 PM
 */
public class ValueNotFound extends Throwable {

  @Override
  public void printStackTrace() {
    System.out.println("Value Not Found");
  }
}
