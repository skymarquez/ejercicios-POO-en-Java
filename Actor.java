




/**
 * Represents an artist of type 'Actor'.
 * @author OOP teaching staff
 * @version 
 * @since 9.19
 */
public class Actor extends Artist {

/**
* Constructor.
*/
public Actor(String name) {
    super(name);
    super.setId(Artist.getLastId());
    Artist.increasesLastId();
}


/**
 * Returns 'Actor' plus the content returned by Artist .
 * @param Returns a string representation of the artist.
 */
public String toString(){
	return super.toString();
}


}//Actor
