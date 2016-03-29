package edu.cvtc.web.view;

import java.util.List;

import edu.cvtc.web.model.Movie;

/**
 * @author Katherine Cater
 *
 */
public class MovieView {

public static String buildHTML(List<Movie> movies) {
		
		final StringBuilder out = new StringBuilder();
		
		out.append("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<title>Movies List</title>\n\t</head>\n\t<body>\n");
		out.append("\t\t<h1>Movies List</h1>\n");
		
		out.append("\n\t\t<p><a href=\"MoviesList\">Unsorted</a>"
				+ " - <a href=\"SortByTitle\">Sort By Title</a>"
				+ " - <a href=\"SortByDirector\">Sort By Director</a>"
				+ " - <a href=\"SortByLength\">Sort By Length</a></p>");
		
		for (final Movie movie : movies) {
			
			out.append("\t\t<div class=\"movie\">\n\t\t\t<h2>" + movie.getTitle() + "</h2>\n");
			out.append("\t\t\t<p>" + movie.getTitle() + " is directed by " + movie.getDirector() + ".");
			out.append(" " + movie.getTitle() + " is " + movie.getLengthInMinutes() + " minutes long.</p>\n\t\t</div>\n");
			
		}
		
		out.append("\t\t<p>&copy; Copyright 2016 Katherine Cater</p>\n\t</body>\n</html>");
		
		return out.toString();
		
	}
	
}
