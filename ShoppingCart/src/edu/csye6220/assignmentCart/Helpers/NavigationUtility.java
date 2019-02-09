package edu.csye6220.assignmentCart.Helpers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class NavigationUtility
 */
@WebServlet("/NavigationUtility")
public class NavigationUtility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationUtility() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static String Navigator() {
    	return("<div id=\"menu\" >\n" + "<ul style=\"list-style:none;\">\n"
				+ "<li style=\"display:inline;padding:5px\"><a href=\"ViewCart\">[View Cart]</a></li>"
				+ "<li style=\"display:inline;padding:5px\"><a href=\"Books\">[Go to Books Page]</a></li>\n"
				+ "<li style=\"display:inline;padding:5px\"><a href=\"Music\">[Go to Music Page]</a></li>\n"
				+ "<li style=\"display:inline;padding:5px\"><a href=\"Computers\">[Go to Computers Page]</a>\n</div>");

}
}
