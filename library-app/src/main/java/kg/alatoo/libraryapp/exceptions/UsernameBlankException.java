package kg.alatoo.libraryapp.exceptions;

public class UsernameBlankException extends RuntimeException {

    public UsernameBlankException() {
    }

    public UsernameBlankException(String message) {
        super(message);
    }
}
