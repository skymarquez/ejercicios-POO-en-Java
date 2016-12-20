




/**
 * Represents the coords of the Theatre.
 * @author OOP teaching staff
 * @version 
 * @since 
 */
public class Coords {
// The latitude of the coords
private String north;

//The longitude of the coords
private String east;

/**
 * Constructor.
 * @param n The latitude of the coords
 * @param e The longitude of the coords
 */
public Coords(String n, String e) {
    this.setNorth(n);
    this.setEast(e);
}

/**
 * North setter.
 * @param n - The latitude of the coords
 */
private void setNorth(String n) {
    this.north= n;
}

/**
 * East setter.
 * @param n - The longitude of the coords
 */
private void setEast(String e) {
    this.east= e;
}

/** 
 * String representation of these Coords
 * @return Returns a string representation of the coords.
*/
public String toString() {
    return  "("+this.north +"," +this.east +")";
}

/**
 * North getter.
 * @return the north
 */
public String getNorth() {
	return north;
}

/**
 * East getter.
 * @return the east
 */
public String getEast() {
	return east;
}
}//Coords
