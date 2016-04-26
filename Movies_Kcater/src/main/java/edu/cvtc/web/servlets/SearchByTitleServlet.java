package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.search.MovieSearch;
import edu.cvtc.web.search.impl.MovieSearchImpl;
import edu.cvtc.web.util.WorkbookUtility;
import edu.cvtc.web.view.ErrorView;
import edu.cvtc.web.view.MovieView;

/**
 * Servlet implementation class SearchByTitleServlet
 */
@WebServlet("/SearchByTitle")
public class SearchByTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final PrintWriter out = response.getWriter();
		
		try {
			
			final String title = request.getParameter("title");
			
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			
			final MovieSearch movieSearch = new MovieSearchImpl();
			final List<Movie> movies = movieSearch.findMoviesByTitle(title, filePath);
			
			final String htmlOutput = MovieView.buildHTML(movies);
			
			out.append(htmlOutput);
			
		} catch (MovieSearchException e) {
			e.printStackTrace();
			out.append(ErrorView.buildHTML(e.getMessage()));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
