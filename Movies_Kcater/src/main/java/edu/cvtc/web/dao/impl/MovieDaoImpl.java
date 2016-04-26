package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author Katherine Cater
 *
 */
public class MovieDaoImpl implements MovieDao {
	private static final String DROP_TABLE_MOVIE = "drop table if exists movie";
	private static final String CREATE_TABLE_MOVIE = "create table movie(id integer primary key autoincrement, title text, director text, lengthInMinutes integer)";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie";
	
	@Override
	public void populate(String filePath) throws Exception {
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try {
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			
			for (Movie movie: movies){
				String insertValues = "insert into movie(title, director, lengthInMinutes) values ('"
						+ movie.getTitle() + "', '"
								+ movie.getDirector() + "', "
												+ movie.getLengthInMinutes() + ");";
				System.out.println(insertValues); //NOTES: log a message to the console so we can see the data being added to the database
				statement.executeUpdate(insertValues);
			}
			
		} finally {
			DBUtility.closeConnection(connection, statement);
		}

	}

	
	@Override
	public List<Movie> retrieveMovies() throws Exception {
		final List<Movie> movies = new ArrayList<>();
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try {
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while (resultSet.next()){
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int lengthInMinutes = resultSet.getInt("lengthInMinutes");
				
				final Movie movie = new Movie(title, director, lengthInMinutes);
				movies.add(movie);
			}
			
			resultSet.close();
			
		} finally {
			DBUtility.closeConnection(connection, statement);
		}
		
		return movies;
	}

}
