package t01.exception;

/**
 * Created on 19.02.2017.
 */
public class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Incorrect entrance of command";
    }
}
