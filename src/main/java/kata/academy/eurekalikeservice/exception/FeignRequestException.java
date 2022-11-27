package kata.academy.eurekalikeservice.exception;

public class FeignRequestException extends RuntimeException {

    public FeignRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
