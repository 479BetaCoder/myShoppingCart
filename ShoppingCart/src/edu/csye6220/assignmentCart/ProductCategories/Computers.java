package edu.csye6220.assignmentCart.ProductCategories;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import edu.csye6220.assignmentCart.Helpers.Products;
import edu.csye6220.assignmentCart.Model.StoreInventory;
import edu.csye6220.assignmentCart.Views.Store;

/**
 * Servlet implementation class Computers
 */
@WebServlet("/Computers")
public class Computers extends Store {
	private static final long serialVersionUID = 1L;
	ArrayList<Products> prObj = StoreInventory.getProductByCategory("Computers");

	public void init() {

		setListProd(prObj);
		setPagetitle("Shop for Computers");
	}

}
