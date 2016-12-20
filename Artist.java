



/**
 * Represents an artist.
 * @author OOP teaching staff
 * @version 
 * @since
 */
public abstract class Artist {

	
// Counter of actors created in the system
	private static int          lastId = 0;
//The artist name
private String name;
//This artist identifier
private int                id;



/**
 * Constructor.<br />
  * @param name The name of the artist
 */
public Artist(String name) {
   
    this.name = name;
}


/**
 * Name getter.
 * @return the name
 */
public String getName() {
	return name;
}

/**
* Id setter.
* @param id - the id to set
*/
protected void setId(int id) {
   this.id= id;
}

/**
* Id getter.
* @return the internal identifier number of this artist
*/
public int getId() {
   return this.id;
}

/**
 * @return String that represents an Artist
 */
public String toString()
{
	return this.name;
}

/**
 * The global number of Artists
 * @return the number of Artists
 */
protected static int getLastId() {
    return Artist.lastId;
}
/**
 * Increases the internal identifier number of this actors 
 */
protected static void increasesLastId() {
	lastId= lastId+1;
}

/**
 * Indicates whether some other object is "equal to" this one.
 * @param obj - the reference object with which to compare. 
 * @return Returns true if this object is the same as the obj argument; false otherwise.
 *@Override 
 */
public boolean equals(Object obj) {
    if (obj == null)
        return false;
    if (this == obj)
        return true;
    if (!(obj instanceof Artist))
        return false;
    Artist other= (Artist) obj;
    if (getName() == null) {
        if (other.getName() != null)
            return false;
    } else if (!getName().equals(other.getName()))
        return false;
    return true;
}

}// Artist
