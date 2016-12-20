/**
 * Exceptions concernig the Exercise 3 
 * 
 */
public class Ex3Exception extends Exception {
	
	public static final String OBJECT_ALREADY_EXISTS =
		"Trying to register an already existing object";
		
	public static final String OBJECT_DOES_NOT_EXISTS =
		"The object does not exists";

		
	public Ex3Exception(String m) {
		super(m);
	}

	public String toString() {
		return this.getMessage();
	}

}
