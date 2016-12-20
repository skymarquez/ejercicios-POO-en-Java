


import java.util.Date;

/**
 * Represents the .
 * @author OOP teaching staff
 * @version 
 * @since 
 */
public class Showing implements Comparable<Showing>{


//The movie of the showing
private Movie      movie;
//The theatre of the showing 
private Theatre    theatre;
//The date start of the showing 
private Date       start;
//The date end of the showing
private Date       end;

/**
 * Date start getter.
 * @return the start
 */
public Date getStart() {
	return start;
}

/**
 * Date end getter.
 * @return the end
 */
public Date getEnd() {
	return end;
}

/**
 * Movie getter.
 * @return the movie
 */
public Movie getMovie() {
	return movie;
}

/**
 * Theatre getter.
 * @return the theatre
 */
public Theatre getTheatre() {
	return theatre;
}

/**
 * Constructor.
 *  @param m the movie to be added to this showing
 *   @param t the theatre to be added to this showing
 *    @param s the start date to be added to this showing
 *     @param e the end date to be added to this showing
 *     
 * @throws TheatreException with one of the following messages defined in poo.TheatreException may be thrown:<br />
 * 
 */
public Showing(Movie m, Theatre t, Date s, Date e) throws TheatreException {
    // Check that 's' is before 'e'
	
    this.movie= m;
    this.theatre= t;
    if (!s.before(e))
    	throw new TheatreException(TheatreException.SHOWING_DATES_NOT_CORRECT);
    this.start = s;
    this.end = e;
}


/**
 * @see java.lang.Comparable#compareTo(java.lang.Object)
 * @param object The object to compare with this one
 * @return 0 if they are equal,<br />
 *         a positive number if this object is greater i<br />
 *         a negative number if it is smaller
 */
public int compareTo(Showing object) {
    int returning= 0;

    if (object instanceof Showing) {
        returning= this.start.compareTo(((Showing) object).getStart());
    }
    return returning;
}


}//Showing
