package edu.cvtc.web.view;

/**
 * @author Katherine Cater
 *
 */
public class ErrorView {
	
	public static String buildHTML(final String errorMessage){
		final StringBuilder out = new StringBuilder();
		
		out.append("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<title>Movies List</title>\n\t\t<style>");
		out.append("\n\t\t\tbody{\n\t\t\t\twidth 750px; \n\t\t\t\theight: 100%; \n\t\t\t\tbackground-color: #8ab4e3;"); 
		out.append("\n\t\t\t\tmargin: 0; \n\t\t\t\tpadding: 0; \n\t\t\t\ttext-align: center;\n\t\t\t}\n");
		out.append("\n\t\t\t.movie{\n\t\t\t\tbackground-color: #1569C7; \n\t\t\t\theight: 200px \n\t\t\t\tposition: relative;"); 
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
		out.append("\n\t\t<div id='wrapper'>\n\t\t\t<h1>Movies List</h1>\n");
		
		out.append(NavView.buildNavigation());
		out.append("<p>" + errorMessage + "</p>");
		out.append("\n\t\t\t<p>&copy; Copyright 2016 Katherine Cater</p>\n\t\t</body>\n\t</html>");
		
		return out.toString();
	}

}
