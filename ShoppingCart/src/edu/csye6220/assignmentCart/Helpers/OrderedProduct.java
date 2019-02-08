package edu.csye6220.assignmentCart.Helpers;

public class OrderedProduct {

	private Products product;
	private int numItems;

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public int getNumItems() {
		return (numItems);
	}

	public void setNumItems(int n) {
		this.numItems = n;
	}

	public OrderedProduct(Products pro) {
		setProduct(pro);
		setNumItems(1);
	}

	public String getItemID() {
		return (getProduct().getId());
	}

	public String getDescription() {
		return (getProduct().getProductDesc());
	}

	public double getUnitCost() {
		return (getProduct().getProductCost());
	}

	public void incrementNumItems() {
		setNumItems(getNumItems() + 1);
	}

	public void cancelOrder() {
		setNumItems(0);
	}

	public double getTotalCost() {
		return (getNumItems() * getUnitCost());
	}

}
