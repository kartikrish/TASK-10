// Custom checked exception
// We extend Exception (checked exception)
public class CustomAgeException extends Exception {

    // Constructor with error message
    public CustomAgeException(String message) {
        super(message);
    }
}

