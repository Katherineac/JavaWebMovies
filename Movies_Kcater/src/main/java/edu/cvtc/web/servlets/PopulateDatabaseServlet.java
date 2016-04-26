package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.util.WorkbookUtility;
import edu.cvtc.web.view.ErrorView;
import edu.cvtc.web.view.NavView;

/**
 * Servlet implementation class PopulateDatabaseServlet
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final PrintWriter out = response.getWriter();
		try {
			final MovieDao movieDao = new MovieDaoImpl();
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			movieDao.populate(filePath);
			
			out.append("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<title>Populate Database</title>\n\t\t<style>");
			out.append("\n\t\t\tbody{\n\t\t\t\twidth 750px; \n\t\t\t\theight: 100%; \n\t\t\t\tbackground-color: #8ab4e3;"); 
			out.append("\n\t\t\t\tmargin: 0; \n\t\t\t\tpadding: 0; \n\t\t\t\ttext-align: center;\n\t\t\t}\n");
			out.append("\n\t\t\t.main{\n\t\t\t\tbackground-color: #1569C7; \n\t\t\t\theight: 200px \n\t\t\t\tposition: relative;"); 
			out.append("\n\t\t\t\twidth: 500px; \n\t\t\t\tpadding: 10px 0; \n\t\t\t\tborder: 1px solid #10549f; \n\t\t\t\tmargin: 10px auto;\n\t\t\t}\n");
			out.append("\n\t\t\th1{\n\t\t\t\tbackground-color: #1569C7; \n\t\t\t\twidth: 500px; \n\t\t\t\tposition: relative;"); 
			out.append("\n\t\t\t\theight: 50px; \n\t\t\t\tpadding-top: 20px; \n\t\t\t\tmargin: 10px auto; \n\t\t\t\tborder: 1px solid #10549f;\n\t\t\t}\n");
			out.append("\n\t\t\tfooter{\n\t\t\t\tbackground-color: #1569C7; \n\t\t\t\theight: 50px; \n\t\t\t\tposition: relative;"); 
			out.append("\n\t\t\t\twidth: 500px; \n\t\t\t\tborder: 1px solid #10549f; \n\t\t\t\tmargin: 10px auto;\n\t\t\t}\n");
			out.append("\n\t\t\t#wrapper{\n\t\t\t\tbackground-color: #5b96d7; \n\t\t\t\tborder: 1px solid #4387d2;"); 
			out.append("\n\t\t\t\tposition: relative; \n\t\t\t\tmargin: 10px auto; \n\t\t\t\twidth: 75%;\n\t\t\t}\n");
			out.append("\n\t\t\tnav{\n\t\t\t\tbackground-color: #1569C7; \n\t\t\t\twidth: 500px; \n\t\t\t\tmargin: 10px auto; "); 
			out.append("\n\t\t\t\tposition: relative; \n\t\t\t\tborder: 1px solid #10549f; \n\t\t\t\theight: 50px; \n\t\t\t\tpadding-top: 25px;\n\t\t\t}\n");
			out.append("\n\t\t\tnav a{\n\t\t\t\ttext-decoration: none; \n\t\t\t\tcolor: #000;\n\t\t\t}\n\t\t");
			out.append("\n\t\t\tnav a:hover{\n\t\t\t\tcolor:#fff;\n\t\t\t}");
			out.append("\n\t\t</style>\n\t</head>\n\t<body>");
			out.append("\n\t\t<div id='wrapper'>\n\t\t\t<h1>Populate Database</h1>\n");
			out.append(NavView.buildNavigation());
			out.append("\n\t<div class=\"main\"><p>Database was populated!</p></div>");
			out.append("\n\t\t\t<footer>\n\t\t\t\t<p>&copy; Copyright 2016 Katherine Cater</p>\n\t\t\t</footer>\n\t\t</div>\n\t</body>\n</html>");
			
		} catch (Exception e) {
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
