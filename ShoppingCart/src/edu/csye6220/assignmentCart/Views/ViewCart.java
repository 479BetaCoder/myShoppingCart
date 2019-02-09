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

import edu.csye6220.assignmentCart.Helpers.NavigationUtility;
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
			if (shpCart == null) {
				out.println(
						"<h2><I>Hello! You have not yet started shopping. Please visit our <a href=\"Store\">store</a></I></h2>");
			} else {
				cartSum = 0;
				
				
				ArrayList<OrderedProduct> itemsOrdered = shpCart.getItemsOrdered();
				if(request.getParameter("itemID")!=null)
				{
				  itemsOrdered	= shpCart.removeOrder(request.getParameter("itemID"),itemsOrdered);
				}
				OrderedProduct order;
				String title = "Status of Your Order";
				out.println("<!DOCTYPE HTML>\n" + "<html>\n" + "<head><title>Cart Summary</title></head>\n"
						+ "<body>\n" + "<h1 style=\"align:\"center\">" + title + "</h1>");
				if (itemsOrdered.size() == 0) {
					out.println("<h2><I>No items in your cart...</I></h2>");
					
				} else {
					
					out.println("<div>"
							+ "<table ALIGN=\"CENTER\">\n" + "<TR BGCOLOR=\"#FFAD00\">\n" + "<TH>S.No\n"
							+ "<TH>Description\n" + "<TH>Quantity\n" + " <TH>Unit Cost\n" + "<TH>Total Cost\n"
							+ "<TH>Action\n");
					for (int i = 0; i < itemsOrdered.size(); i++) {

						order = (OrderedProduct) itemsOrdered.get(i);
						cartSum += order.getTotalCost();
						out.println("<TR>\n" + " <TD>" + (i + 1) + "." + "\n" + " <TD>" + order.getDescription() + "\n"
								+ " <TD>" + order.getNumItems() + " <TD>" + formatter.format(order.getUnitCost())
								+ "<TD>" + formatter.format(order.getTotalCost()) + "<TD>"
								+ "<form method=\"POST\">\n"  // Submit to current URL
								+"<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n" 
								+" VALUE=\""+i+"\">\n"
								+"<INPUT TYPE=\"SUBMIT\"\n "
								+" VALUE=\"Remove from Cart\">\n" 
								+"</SMALL>\n" 
								+"</FORM>\n");
					}
					out.println("<tr style=\"outline:thin solid\"><td>Cart Value : </td>" + "<td></td>" + "<td></td>" + "<td></td>"

							+ "<td>" + formatter.format(cartSum) + "</td>");

					out.println("</div>");
							

				}
				out.println(NavigationUtility.Navigator()
				+ "</body></html>");
				
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
