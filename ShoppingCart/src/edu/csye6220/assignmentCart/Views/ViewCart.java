package edu.csye6220.assignmentCart.Views;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.csye6220.assignmentCart.Helpers.UtilityNavigator;
import edu.csye6220.assignmentCart.Helpers.OrderedProduct;
import edu.csye6220.assignmentCart.Helpers.ShoppingCartController;

/**
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double cartSum = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ShoppingCartController shpCart;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		synchronized (session) {
			shpCart = (ShoppingCartController) session.getAttribute("shpCart");
			String title = "Status of Your Order";
			out.println("<!DOCTYPE HTML>\n" + "<html>\n" + "<head><title>Cart Summary</title>"
					+ UtilityNavigator.cssLink() + "</head>\n" + "<body>\n" + UtilityNavigator.cartName()
					+ UtilityNavigator.Navigator() + "<p class=\"vCartTitle\">" + title + "</p>");
			if (shpCart == null) {
				out.println(
						"<p id=\"warInfo\">Hello! You have not yet started shopping. Please visit our <a href=\"Store\">store</a></p>");
			} else {
				cartSum = 0;
				ArrayList<OrderedProduct> itemsOrdered = shpCart.getItemsOrdered();
				if (request.getParameter("itemID") != null) {
					itemsOrdered = shpCart.removeOrder(request.getParameter("itemID"), itemsOrdered);
					response.sendRedirect("ViewCart");
				}
				OrderedProduct order;
				if (itemsOrdered.size() == 0) {
					out.println("<p id=\"warInfo\">OOPS! Your Cart is empty.. :( </p>");

				} else {

					out.println("<div id=\"summDiv\">" + "<table id=\"tblSumm\">\n" + "<tr>\n" + "<th>S.No\n"
							+ "<th>Description\n" + "<th>Quantity\n" + " <th>Unit Cost\n" + "<th>Total Cost\n"
							+ "<th>Action\n");
					for (int i = 0; i < itemsOrdered.size(); i++) {

						order = (OrderedProduct) itemsOrdered.get(i);
						cartSum += order.getTotalCost();
						out.println("<tr>\n" + " <td>" + (i + 1) + "." + "\n" + "<td>" + order.getDescription() + "\n"
								+ "<td>" + order.getNumItems() + " " + "<td>" + formatter.format(order.getUnitCost())
								+ "<td>" + formatter.format(order.getTotalCost()) + "<td>" + "<form method=\"get\">\n" 
								+ "<input type=\"hidden\" name=\"itemID\"\n" + " value=\"" + order.getItemID() + "\">\n"
								+ "<input id=\"imgDelete\" type=\"image\" name=\"submit\" src=\"Images/deleteItem.JPG\" alt=\"Remove\"/>"
								+ "</form>\n");
					}
					out.println("<tr id=\"lastRow\"><td>Cart Value : </td>" + "<td></td>" + "<td></td>" + "<td></td>"

							+ "<td>" + formatter.format(cartSum) + "</td><td></td>");

					out.println("</div>");

				}
				out.println("</body></html>");

			}

		}
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
