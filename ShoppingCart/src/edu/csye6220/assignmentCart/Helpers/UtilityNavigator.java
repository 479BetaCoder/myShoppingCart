package edu.csye6220.assignmentCart.Helpers;

public class UtilityNavigator {
	public static String cssLink() {
		return ("<link rel='stylesheet' type='text/css' href='Cart.css'><link rel=\"shortcut icon\" href=\"Images/myIcon.JPG\"/>");
	}
	
	public static String cartName() {
		return("<div id=\"shpName\">RKART</div>");
	}

	public static String Navigator() {
		return ("<div><ul id=\"navBar\">\n"
				+"<li><a href=\"Store\">Home</a></li>\n"
				+ "<li><a href=\"Books\">Books</a></li>\n"
				+ "<li><a href=\"Music\">Music</a></li>\n"
				+ "<li><a href=\"Computers\">Computers</a>\n"
				+ "<li><a href=\"ViewCart\">View Cart</a></li></ul></div>\n");
	}
}
