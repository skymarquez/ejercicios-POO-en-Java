


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.util.List;


/**
 * Represents a Movie 
 * @author OOP teaching staff
 * @version 
 * @since 
 */
public class Movie implements Comparable<Movie> {

	
/** The title (display name) of the movie */
private String      title =null;
//The date of the movie
private Date      date = null;

//The country of the movie
private Country country = null;

///** The list of actors that has a Movie */
private List<Actor> actors = null;
///** The list of showing that has a Movie */
private List<Showing> showings = null;


//
private Director director = null;
private int year;



/**
 * Constructor.
 * @param title - Title of the Movie
 * @param date - Date of the Movie
 * @param country - Country of the Movie
 * 
 */
public Movie(String title, Date date, Country country) {
  
	  this.title= title;
    this.date= date;
    this.country= country;
    this.actors = new ArrayList<Actor>();
    this.showings = new ArrayList <Showing>();
    GregorianCalendar g =  new GregorianCalendar();
    g.setTime(date);
    this.year = g.get(Calendar.YEAR);

    
}

/**
 * Gets the showing of this movie.
 * @return the showings
 */
public List<Showing> getShowings() {
	return showings;
}

/**
* Constructor.

* @param title - Title of the Movie
* 
*/
public Movie(String title) {
 
  this.title= title;   
}

/**
 * Director setter.
 * @param d the director to be added to this movie
 */
public void setDirector(Director d) throws TheatreException {
	if (director == null) {
		director = d;
    }
	else 
		
		throw new TheatreException(TheatreException.DIRECTOR_ALREADY_ASSIGNED);

    
}/**
 * Adds an actor to the movie
* @param a the actor to be added to this movie
 */
public void addActor(Actor a) throws TheatreException {
	if (this.actors.contains(a))
	{
		throw new TheatreException(TheatreException.ACTOR_ALREADY_ASSIGNED);
	}
	else {
		actors.add(a);
	}
}

/**
 * 
 * @param s the showing to be added to this movie
 */
public void addShowing(Showing s){
	showings.add(s);
}

/**
 * Actors getter.
 * @return the list of the actors that has a movie
 */
public List<Actor> getActors() {
    return actors;
}

/*
 * Director getter.
 * @return the director that has a movie
 */
public Director getDirector() {
    return director;
}
/**
 *  The description (display name) of the Actor
 * @return The description (display name) of the actor in a String
 */
public String getTitle() {
    return title;
}

/**
 * Date getter.
 * @return the date
 */
public Date getDate() {
	return date;
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
    if (!(obj instanceof Movie))
        return false;
    Movie other= (Movie) obj;
    if (getTitle() == null) {
        if (other.getTitle() != null)
            return false;
    } else if (!getTitle().equals(other.getTitle()))
        return false;
    return true;
}

/**
 * String representation of this Movie
 * @return the actor description
 */
public String toString() {
	StringBuffer acts= new StringBuffer();
	for (Actor a: this.actors) {
		acts.append(", ");
		acts.append(a);
	}
	StringBuffer str = new StringBuffer();
	str.append(this.title);
	str.append(" ("+ this.year+ "),");
	if (director != null){
		str.append(" directed by "+this.director+";");
	}
	if (acts.length() > 0)
			str.append(" cast: "+acts.substring(2));
	return str.toString();
}

/**
 * @see java.lang.Comparable#compareTo(java.lang.Object)
 * @param object The object to compare with this one
 * @return 0 if they are equal,<br />
 *         a positive number if this object is greater i<br />
 *         a negative number if it is smaller
 */
public int compareTo(Movie object) {
    int returning= 0;

    if (object instanceof Movie) {
        returning= this.getDate().compareTo(((Movie) object).getDate());
        if (returning == 0)
        	{
        		returning = this.getTitle().compareTo(object.getTitle());
        	}
    } 
    return returning;
}

}//Movie
