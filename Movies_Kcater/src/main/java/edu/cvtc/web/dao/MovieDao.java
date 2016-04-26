package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.model.Movie;

/**
 * @author Katherine Cater
 *
 */
public interface MovieDao {
	
	void populate(String filePath) throws Exception;
	
	List<Movie> retrieveMovies() throws Exception;

}
