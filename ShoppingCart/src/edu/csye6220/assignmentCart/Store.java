package edu.csye6220.assignmentCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csye6220.assignmentCart.Helpers.Products;


/**
 * Servlet implementation class Store
 */
@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pagetitle = "Welcome ! Thank you for visiting my cart";
	private ArrayList<Products> listProd;

	public String getPagetitle() {
		return pagetitle;
	}

	protected void setPagetitle(String pagetitle) {
		this.pagetitle = pagetitle;
	}

	public ArrayList<Products> getListProd() {
		return listProd;
	}

	protected void setListProd(ArrayList<Products> listProd) {
		this.listProd = listProd;
	}

	/**
	 * First display title,
	 * 
	 * /**
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter prStore = response.getWriter();
		String formURL = "AddCartView";
		formURL = response.encodeURL(formURL);

		String docType = "<!DOCTYPE HTML>\n";
		prStore.println(docType + "<html>\n" + "<head><title>My Store</title></head>\n" + "<body>\n"
				+ "<h1>Shop World</h1>" + "<hr></hr>" + "<h2 style=\"align:center\">" + getPagetitle() + "</h2>\n"
				+ "<div><a href=\"ViewCart\">View Cart</a></div>" + "<div id=\"menu\" >\n" + "<ul style=\"list-style:none;\">\n"
				+ "            <li id=\"menuli\"><a href=\"Books\">Books</a></li>\n"
				+ "            <li id=\"menuli\"><a href=\"Music\">Music</a></li>\n"
				+ "            <li id=\"menuli\"><a href=\"Computers\">Computers</a>\n</div>");

		prStore.println(
				"<form action=\"" + formURL + "\" method = \"post\" style=\"margin-top: 20px;margin-left: 15px;\">\n");
		if (!(getListProd() == null || getListProd().size() == 0 )) {
			for (Products pro : getListProd()) {
				prStore.println("<div style=\"height:50px;\"><input style=\"margin-right:10px;\" type=\"checkbox\""
						+ "name=\"item\" value=\"" + pro.getId() + "\">" + pro.getProductDesc()
						+ "&nbsp;&nbsp;" + "[$" + pro.getProductCost() + "]" + "</div>");

			}
			prStore.println("<input type=\"submit\" " + "value=\"Add to Cart\">\n" + "\n</form>");
		}
		prStore.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
