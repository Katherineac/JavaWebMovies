package edu.cvtc.web.servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.WorkbookUtility;
import edu.cvtc.web.view.MovieView;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/MovieList")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final PrintWriter out = response.getWriter();
		
		try {
			
			final List<Movie> movies = new ArrayList<>();
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			final File file = new File(filePath);
			movies.addAll(WorkbookUtility.retrieveMoviesFromWorkbook(file));
			
			out.append(MovieView.buildHTML(movies));
			
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
			out.println("Oops there was a problem retrieving the list of movies from the Workbook");
			
		} catch (FileNotFoundException e) {
			
			out.println("Oops! File not found.");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
