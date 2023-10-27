package utils.error;

public class MissingArgsError extends RuntimeException {

  public MissingArgsError(String message) {
    super(message);
  }
}
