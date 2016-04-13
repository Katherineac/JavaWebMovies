package edu.cvtc.web.search.impl;

import java.io.File;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.predicates.TitlePredicate;
import edu.cvtc.web.search.MovieSearch;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author Katherine Cater
 *
 */
public class MovieSearchImpl implements MovieSearch {
	public List<Movie> findMoviesByTitle(final String title, final String filePath) throws MovieSearchException {
		try {
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			return Lists.newArrayList(Collections2.filter(movies, new TitlePredicate(title)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("List of movies could not be retrieved from the worksheet.");
		}
	}
}
