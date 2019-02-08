package edu.csye6220.assignmentCart.ProductCategories;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import edu.csye6220.assignmentCart.Store;
import edu.csye6220.assignmentCart.Helpers.Products;
import edu.csye6220.assignmentCart.Helpers.StoreInventory;

/**
 * Servlet implementation class Music
 */
@WebServlet("/Music")
public class Music extends Store {
	private static final long serialVersionUID = 1L;
	ArrayList<Products> prObj = StoreInventory.getProductByCategory("Music");

	public void init() {

		setListProd(prObj);
		setPagetitle("Shop for CDs");
	}

}
