package boot.bootdemo.exception;

public class FileReadException extends RuntimeException {
    public FileReadException(String message, Exception exception) {
        super(message, exception);
    }
}
