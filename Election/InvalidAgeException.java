package Election;

//Checked exception for invalid voter age
public class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}
