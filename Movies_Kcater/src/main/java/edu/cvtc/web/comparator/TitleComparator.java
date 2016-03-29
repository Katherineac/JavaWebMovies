package edu.cvtc.web.comparator;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Katherine Cater
 *
 */
public class TitleComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getTitle().compareTo(m2.getTitle());
	}
	
}
