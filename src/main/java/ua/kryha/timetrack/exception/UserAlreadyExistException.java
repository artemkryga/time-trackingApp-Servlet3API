package ua.kryha.timetrack.exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
