package edu.cvtc.web.view;

/**
 * @author Katherine Cater
 *
 */
public class NavView {
	public static String buildNavigation() {
		final StringBuilder out = new StringBuilder();
		
		out.append("\n\t\t\t<nav>\n\t\t\t\t<a href=\"MovieList\">Unsorted</a>"
				+ " - <a href=\"SortByTitle\">Sort By Title</a>\n\t\t\t\t"
				+ " - <a href=\"SortByDirector\">Sort By Director</a>"
				+ " - <a href=\"SortByLength\">Sort By Length</a>\n\t\t\t"
				+ "- <a href=\"Search\">Search</a>\n\t\t\t"
				+ " - <a href=\"PopulateDatabase\">Populate Database</a></nav>\n\t\t");
		
		return out.toString();
				
	}
}
