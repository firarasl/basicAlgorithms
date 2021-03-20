package assignment10;

public class NameNotValidException extends RuntimeException {
    public NameNotValidException() {
        super("Name is not valid. Do not use numbers or special symbols. Please reenter the name.");
    }
}