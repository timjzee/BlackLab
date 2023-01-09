package nl.inl.blacklab.exceptions;

/**
 * A RuntimeException generated by BlackLab.
 *
 * This will be the base class of all BlackLab-thrown RuntimeExceptions. More
 * specific subclasses can be caught to handle specific situations.
 */
public class BlackLabRuntimeException extends RuntimeException {
    
    public static BlackLabRuntimeException wrap(Throwable e) {
        if (e == null)
            return new BlackLabRuntimeException("Tried to wrap a null exception");
        if (e instanceof BlackLabRuntimeException)
            return (BlackLabRuntimeException) e;
        return new BlackLabRuntimeException(e);
    }

    public BlackLabRuntimeException() {
        super();
    }

    public BlackLabRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlackLabRuntimeException(String message) {
        super(message);
    }

    public BlackLabRuntimeException(Throwable cause) {
        super(cause);
    }

}