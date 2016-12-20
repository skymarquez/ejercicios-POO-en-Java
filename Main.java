import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.Arrays;



/**
 * Main program, used to read and execute commands.<br />
 * ******************** DO NOT MODIFY THIS FILE ********************<br />
 * **************** DO NOT INCLUDE THIS FILE WITH THE DELIVERY ****************
 * 
 * @author OOP teaching staff
 * @version
 * @since
 * 
 * 
 * 
 *  
 */
public class Main {
	private static final String COMMENT_LINE = "#";
	private static final String NL = System.getProperty("line.separator");
	private static final String SCREEN = "SCREEN";
	private static final String KEYBOARD = "KEYBOARD";
	private static final String WRONG_COMMAND = "WRONG_COMMAND" + NL;
	// Commands:
	private static final String SET_DIRECTOR_TO_MOVIE = "setDirector";
	private static final String ADD_THEATRE = "addTheatre";
	private static final String ADD_MOVIE = "addMovie";
	private static final String ADD_ACTOR_TO_MOVIE = "addActorToMovie";


	private static final String ADD_SHOW = "addShow";
	private static final String LIST_MOVIES = "listMovies";
	private static final String LIST_SHOWING_BY_MOVIE = "listShowingByMovie";
	private static final String LIST_SHOWING_BY_THEATRE = "listShowingByTheatre";
	private static final String LIST_MOVIES_OF_ACTOR = "listMoviesOfActor";
	private static final String LIST_MOVIES_OF_DIRECTOR = "listMoviesOfDirector";

	private static final String ADD_USER = "addUser";
	private static final String ADD_USER_FAVORITE_ARTIST = "addUserFavoriteArtist";
	private static final String REMOVE_USER_FAVORITE_ARTIST = "removeUserFavoriteArtist";
	private static final String LIST_FAVORITES_OF_USER = "listFavoritesOfUser";

	private BufferedReader in;
	private PrintWriter out;

	/**
	 * Constructor.
	 */
	public Main() {
		// not necessary if extending Object.
		super();
		this.setOut((PrintWriter) null);
		this.setIn((BufferedReader) null);
	}

	/**
	 * @param in
	 *            the BufferedReader to set
	 */
	private void setIn(BufferedReader in) {
		this.in = in;
	}

	/**
	 * @param in
	 *            the BufferedReader to set
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private void setIn(String in) throws UnsupportedEncodingException,
			FileNotFoundException {
		this.setIn(this.buildReader(in));
	}

	/**
	 * @param out
	 *            the PrintWriter to set
	 */
	private void setOut(PrintWriter out) {
		this.out = out;
	}

	/**
	 * @param out
	 *            the PrintWriter to set
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private void setOut(String out) throws UnsupportedEncodingException,
			FileNotFoundException {
		this.setOut(this.buildWriter(out));
	}

	/**
	 * Builds the output stream.
	 * 
	 * @param fileName
	 *            the output filename or 'SCREEN'
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private PrintWriter buildWriter(String fileName)
			throws UnsupportedEncodingException, FileNotFoundException {
		PrintWriter out = null;
		if (fileName.equals(SCREEN)) {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					System.out, "UTF-8")), true);
		} else {
			File f;
			f = new File(fileName);
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(f.getAbsolutePath(), false), "UTF-8")));
		}
		return out;
	}

	/**
	 * Builds the input stream.
	 * 
	 * @param fileName
	 *            the input stream filename or "KEYBOARD"
	 * @return BufferedReader the in stream
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	private BufferedReader buildReader(String fileName)
			throws UnsupportedEncodingException, FileNotFoundException {
		BufferedReader in = null;
		if (fileName.equals(KEYBOARD)) {
			in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		} else {
			File f = new File(fileName);
			in = new BufferedReader(new InputStreamReader(
					new FileInputStream(f), "UTF-8"));
		}
		return in;
	}

	/**
	 * Finalize. Let's ensure the streams have been closed
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// finalization: ensure the streams are closed
		if (this.getOut() != null) {
			this.getOut().close(); // not exception
		}
		if (this.getIn() != null) {
			this.getIn().close(); // ioexception
		}
		// not necessary if extending Object.
		super.finalize();
	}

	/**
	 * Input stream getter.
	 * 
	 * @return the input stream
	 */
	private BufferedReader getIn() {
		return (this.in);
	}

	/**
	 * Output stream getter.
	 * 
	 * @return the output stream
	 */
	private PrintWriter getOut() {
		return (this.out);
	}

	/**
	 * Program entry point.
	 * 
	 * @param args
	 *            arguments to the program
	 */
	public static void main(String[] args) {
		Main p = null;
		TheatreManager th = new TheatreManager();

		if (args.length == 2) {
			p = new Main();
			try {
				p.setOut(args[1]);
				p.setIn(args[0]);
				p.treatInput(th);
			} catch (Exception e) {
				e.printStackTrace(System.err);
				// System.err.println(e.getMessage());
			} finally {
				if (p.getOut() != null) {
					p.getOut().close(); // not exception
				}
				if (p.getIn() != null) {
					try {
						p.getIn().close(); // ioexception
					} catch (IOException e) {
						e.printStackTrace(System.err);
						// System.err.println(e.getMessage());
					}
				}
			}
		} else {
			System.err.println("Number of parameters incorrect, syntax is:"
					+ NL + "\t>java Main in out");
			System.err.println("where \tin  is " + KEYBOARD + " or InputFile");
			System.err.println("and \tout is " + SCREEN + "   or OutputFile");
			System.exit(-1);
		}
	}

	/**
	 * Treats the input and outputs the results.
	 * 
	 * @param theatremanager
	 *            the Theatre Manager instance on which to delegate
	 * @throws Exception
	 *             In case of non I/O error
	 */
	public void treatInput(TheatreManager theatremanager) throws Exception {
		String currentLine;
		int line = 0;
		boolean end = false;
		while (!end) {
			try {
				currentLine = in.readLine();
				line++;
				if ((currentLine != null)) {
					processCommand(theatremanager, currentLine);
				} else {
					end = true;
				}
			} catch (IOException ex) {
				ex.printStackTrace(System.err);
			}
		}
	}

	/**
	 * Processes the line command, delegating on 'tm'.
	 * 
	 * @param tm
	 *            Theatre Manager The instance on which to delegate
	 * @param currentLine
	 *            the current line to process
	 * @throws Exception
	 */
	private void processCommand(TheatreManager tm, String currentLine)
			throws Exception {
		// String[] st= currentLine.trim().split(",|\\(|\\)"); doesn't work with
		// the last empty argument
		String line = currentLine.trim();
		if (line.length() == 0) {
			line = line + ",PHANTOM";
		} else if ("(,)".indexOf(line.charAt(line.length() - 1)) == -1) {
			line = line + ",PHANTOM";
		} else {
			line = line + "PHANTOM";
		}
		String[] st = line.split("\\(|,|\\)", -1);
		st = Arrays.copyOf(st, st.length - 1);

		for (int i = 0; i < st.length; i++) {
			st[i] = st[i].trim();
		}
		if (st[0].startsWith(COMMENT_LINE) || st[0].trim().equals("")) {
			this.getOut().println(currentLine);
		} else {
			this.getOut().println("## COMMAND ##: " + currentLine);
			try {
				if (st[0].equalsIgnoreCase(Main.ADD_THEATRE)) {
					if (st.length == 5) {
						String n = st[1];
						String p = st[2];
						String north = st[3];
						String east = st[4];
						Coords coords = new Coords(north, east);
						tm.addTheatre(n, p, coords);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}

				} else if (st[0].equalsIgnoreCase(Main.ADD_MOVIE)) {
					if (st.length == 4) {
						String t = st[1];
						String d = st[2];
						String c = st[3];
						
						tm.addMovie(t,d,c);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.ADD_ACTOR_TO_MOVIE)) {
					if (st.length == 3) {
						String m = st[1];
						String a = st[2];
						
						tm.addActorToMovie(a,m);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
			} else if (st[0].equalsIgnoreCase(Main.SET_DIRECTOR_TO_MOVIE)) {
				if (st.length == 3) {
					String m = st[1];
					String a = st[2];
					tm.setDirectorToMovie(a,m);
				} else {
					this.getOut().println(Main.WRONG_COMMAND);
				}
			
				} else if (st[0].equalsIgnoreCase(Main.ADD_SHOW)) {
					if (st.length == 5) {
						String t = st[1];
						String m = st[2];
						String start = st[3];
						String end = st[4];
						tm.addShow(t, m, start,end);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.LIST_MOVIES)) {
					if (st.length > 1) {
						this.getOut().println(tm.listMovies());
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.LIST_SHOWING_BY_MOVIE)) {
					if (st.length == 2) {
						String date = st[1];
						this.getOut().println(tm.listShowing(date,"movie"));
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.LIST_SHOWING_BY_THEATRE)) {
					if (st.length == 2) {
						String date = st[1];
						this.getOut().println(tm.listShowing(date,"theatre"));
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.LIST_MOVIES_OF_ACTOR)) {
					if (st.length == 2) {
						String n = st[1];
						this.getOut().println(tm.listMoviesOfArtist(n,"actor"));
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.LIST_MOVIES_OF_DIRECTOR)) {
					if (st.length == 2) {
						String n = st[1];
						this.getOut().println(tm.listMoviesOfArtist(n,"director"));
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
					
				} else if (st[0].equalsIgnoreCase(Main.ADD_USER)) {
					if (st.length == 3) {
						String i = st[1];
						
						String n = st[2];

						tm.addUser(i,n);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.ADD_USER_FAVORITE_ARTIST)) {
					if (st.length == 3) {
						String id = st[1];
						String n = st[2];
						tm.addUserFavoriteArtist(id,n);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.REMOVE_USER_FAVORITE_ARTIST)) {
					if (st.length == 3) {
						String id = st[1];
						String n = st[2];
						tm.removeUserFavoriteArtist (id,n);
					} else {
						this.getOut().println(Main.WRONG_COMMAND);
					}
				} else if (st[0].equalsIgnoreCase(Main.LIST_FAVORITES_OF_USER)) {
					if (st.length == 2) {
						String id = st[1];
						this.getOut().println(tm.listFavoritesOfUser(id));
						
					} else {
						this.getOut().println(Main.WRONG_COMMAND);

					}
					
				} else {
					this.getOut().println(WRONG_COMMAND);
				}
			} catch (TheatreException tme) {
				this.getOut().println(tme.getMessage());
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}

		}
	} // processCommand

} // Main
