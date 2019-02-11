package edu.csye6220.assignmentCart.Views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.csye6220.assignmentCart.Helpers.UtilityNavigator;
import edu.csye6220.assignmentCart.Model.StoreInventory;
import edu.csye6220.assignmentCart.Helpers.ShoppingCartController;

/**
 * Servlet implementation class AddCartView
 */
@WebServlet("/AddCartView")
public class AddCartView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCartView() {
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

		String[] selectedItemIds = request.getParameterValues("item");
		PrintWriter prStore = response.getWriter();
		String docType = "<!DOCTYPE HTML>\n";
		prStore.println(docType + "<html>\n" + "<head><title>AddCart View</title>" + UtilityNavigator.cssLink()
				+ "</head>\n" + "<body>\n" + UtilityNavigator.cartName() + UtilityNavigator.Navigator());
		if (selectedItemIds == null || selectedItemIds.length == 0) {
			prStore.println("<p id=\"curTitle\">You have not selected any items to add to the cart</p>\n");
		} else {

			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(900);
			ShoppingCartController cart;
			synchronized (session) {
				cart = (ShoppingCartController) session.getAttribute("shpCart");
				// New visitors get a fresh shopping cart.
				// Previous visitors keep using their existing cart.
				if (cart == null) {
					cart = new ShoppingCartController();
					session.setAttribute("shpCart", cart);
				}
				if (selectedItemIds.length != 0) {
					cart.addOrder(selectedItemIds);
					
				}

			}
			prStore.println(
					"<p id=\"curTitle\">The following item(s) has been added to your Shopping Cart successfully</p>\n"
							+ "<div id=\"menu\" >\n" + "<ul id=\"lsAddItems\">\n");
			prStore.println("<form>\n");
			for (String itemId : selectedItemIds) {
				prStore.println("<li>" + (StoreInventory.getProductById(itemId)).getProductDesc() + "</li>\n");
			}
		}

		prStore.println("</ul></div>");
		prStore.println("</form></body></html>");

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
