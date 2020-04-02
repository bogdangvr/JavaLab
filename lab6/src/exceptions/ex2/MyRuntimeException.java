package exceptions.ex2;

//unchecked exception

public class MyRuntimeException extends RuntimeException{

    public MyRuntimeException(String message) {
        super(message);
    }
}
