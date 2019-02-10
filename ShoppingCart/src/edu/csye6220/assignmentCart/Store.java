package edu.csye6220.assignmentCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.csye6220.assignmentCart.Helpers.NavigationUtility;
import edu.csye6220.assignmentCart.Helpers.Products;

/**
 * Servlet implementation class Store
 */
@WebServlet("/Store")
public class Store extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pagetitle = "Welcome ! Thank you for visiting RKART. We hope you will have an awesome experience :) ";
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
		prStore.println(docType + "<html>\n" + "<head><title>Home</title>" + NavigationUtility.cssLink() + "</head>\n"
				+ "<body>\n" + NavigationUtility.cartName());
		prStore.println(NavigationUtility.Navigator());
		prStore.println("<p id=\"curTitle\">" + getPagetitle() + "</p>\n");
		prStore.println(
				"<form id=\"frmCollection\" action=\"" + formURL + "\" method = \"post\">\n");
		if (!(getListProd() == null || getListProd().size() == 0)) {
			for (Products pro : getListProd()) {
				prStore.println(
						
						"<label class=\"container\">"
						+ pro.getProductDesc() + "&nbsp;&nbsp;" + 
						"[$" + pro.getProductCost() + "]"
						+ "<input type=\"checkbox\" name=\"item\" value=\""+ pro.getId() +"\">"
						+ "<span class=\"checkmark\"></span></label>"
						);

			}
			prStore.println("<input id=\"btnAddCart\" type=\"submit\" " + "value=\"Add to Cart\">\n" + "\n</form>");
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
