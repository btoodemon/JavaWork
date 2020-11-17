package exception;

public class SimlpeException2 extends Exception{
    public SimlpeException2() {
    }

    public SimlpeException2(String message) {
        super(message);
    }

    public SimlpeException2(String message, Throwable cause) {
        super(message, cause);
    }

    public SimlpeException2(Throwable cause) {
        super(cause);
    }

    public SimlpeException2(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
