package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;

/**
 * @author Katherine Cater
 *
 */
public interface MovieSearch {
	
	 List<Movie> findMoviesByTitle(String title, String filePath) throws MovieSearchException;

}
