package exception;

public class SimlpeException1 extends Exception{
    public SimlpeException1() {
    }

    public SimlpeException1(String message) {
        super(message);
    }

    public SimlpeException1(String message, Throwable cause) {
        super(message, cause);
    }

    public SimlpeException1(Throwable cause) {
        super(cause);
    }

    public SimlpeException1(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
