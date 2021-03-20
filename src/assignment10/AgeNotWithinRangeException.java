package assignment10;

public class AgeNotWithinRangeException extends RuntimeException {
    public AgeNotWithinRangeException() {
        super("Age is not valid. Should be between 15 and 21. Please reenter the age.");
    }
}
