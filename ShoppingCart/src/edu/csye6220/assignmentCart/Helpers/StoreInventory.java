package edu.csye6220.assignmentCart.Helpers;

import java.util.ArrayList;

public class StoreInventory {

	private static Products[] prList = { new Products("bks01", "Books", "Java Servlet Programming", 29.95),
			new Products("bks02", "Books", "Oracle Database Programming", 48.95),
			new Products("bks03", "Books", "System Analysis and Design with UML", 14.95),
			new Products("bks04", "Books", "Object Oriented Software Engineering", 35.99),
			new Products("bks05", "Books", "Java Web Services", 27.99),

			new Products("mus01", "Music", "I'm Going to Tell You a Secret by Madonna", 26.99),
			new Products("mus02", "Music", "Baby one more time by Britney Spears", 10.95),
			new Products("mus03", "Music", "Justified by Justin Timberlake", 9.97),
			new Products("mus04", "Music", "Loose By Nelly Furtado", 13.98),
			new Products("mus05", "Music", "Gold Digger by Kanye West", 27.99),

			new Products("cmp01", "Computers", "Apple MacBook Pro with 13.3\" Display", 1299.99),
			new Products("cmp02", "Computers", "Asus Laptop With Centrino 2 Black", 949.95),
			new Products("cmp03", "Computers", "HP Pavilion Laptop with Centrino 2 DV7", 1199.95),
			new Products("cmp04", "Computers", "Toshiba Satellite Laptop with Centrino 2 - Copper", 899.99),
			new Products("cmp05", "Computers", "Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink", 779.99)

	};

	public static ArrayList<Products> getProductByCategory(String category) {
		ArrayList<Products> listProObj = new ArrayList<>();

		if (category != null && category.trim() != "") {

			for (Products product : prList) {
				if (category.equalsIgnoreCase(product.getProductCategory())) {
					listProObj.add(product);
				}
			}

		} else {
			return null;
		}
		return listProObj;
	}

	public static Products getProductById(String id) {

		if (id != null && id.trim() != "") {

			for (Products product : prList) {
				if (id.equalsIgnoreCase(product.getId())) {
					return (product);
				}

			}

		}

		return null;

	}
}
