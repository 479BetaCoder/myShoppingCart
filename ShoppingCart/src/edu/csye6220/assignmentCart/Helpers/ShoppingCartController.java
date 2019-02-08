package edu.csye6220.assignmentCart.Helpers;

import java.util.ArrayList;

public class ShoppingCartController {

	private ArrayList<OrderedProduct> itemsOrdered;

	public ShoppingCartController() {
		itemsOrdered = new ArrayList<>();
	}

	public ArrayList<OrderedProduct> getItemsOrdered() {
		return (itemsOrdered);
	}

	public synchronized void addOrder(String[] itemIds) {
		OrderedProduct order;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			order = itemsOrdered.get(i);
			for (String itemId : itemIds) {
				if (order.getItemID().equals(itemId)) {
					order.incrementNumItems();
					return;
				}
			}
		}

		for (String itemId : itemIds) {
			OrderedProduct newOrder = new OrderedProduct(StoreInventory.getProductById(itemId));
			itemsOrdered.add(newOrder);
		}
	}
}
