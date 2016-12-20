




/**
 * Represents an artist of type 'Director'.
 * @author OOP teaching staff
 * @version 
 * @since 9.19
 */
public class Director extends Artist{

	// This artist identifier
	
/**
 * Constructor.
 *
 */
public Director(String name) {
    super(name);
    super.setId(Artist.getLastId());
    Artist.increasesLastId();
 }


/**
 * Returns 'Director' plus the content returned by Artist .
 * @param Returns a string representation of the artist.
 */
public String toString(){
	return super.toString();
}



}//Director
