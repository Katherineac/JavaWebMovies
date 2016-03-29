package edu.cvtc.web.comparator;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Katherine Cater
 *
 */
public class LengthComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getLengthInMinutes().compareTo(m2.getLengthInMinutes());
	}

}
