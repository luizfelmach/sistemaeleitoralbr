package util.exceptions;

public class IllegalArgumentException extends RuntimeException {

  public IllegalArgumentException(String message) {
    super(String.format("%s is not a valid argument.", message));
  }
}
