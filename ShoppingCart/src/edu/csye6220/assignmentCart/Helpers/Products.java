package edu.csye6220.assignmentCart.Helpers;

public class Products {

	private String Id;
	private String productCategory;
	private String productDesc;
	private double productCost;

	public Products(String id, String productCategory, String productDesc, double productCost) {
		setId(id);
		setProductCategory(productCategory);
		setProductDesc(productDesc);
		setProductCost(productCost);
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

}
