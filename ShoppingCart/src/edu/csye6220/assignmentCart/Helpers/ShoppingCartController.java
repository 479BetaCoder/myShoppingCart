package edu.csye6220.assignmentCart.Helpers;

import java.util.ArrayList;
import java.util.Iterator;

import edu.csye6220.assignmentCart.Model.StoreInventory;

public class ShoppingCartController {

	private ArrayList<OrderedProduct> itemsOrdered;

	public ShoppingCartController() {
		itemsOrdered = new ArrayList<>();
	}

	public ArrayList<OrderedProduct> getItemsOrdered() {
		return (itemsOrdered);
	}

	public synchronized void addOrder(String[] itemIds) {

		int currentOrdersSize = 0;

		OrderedProduct order;
		if (itemsOrdered.size() == 0) {
			for (String itemId : itemIds) {
				OrderedProduct newOrder = new OrderedProduct(StoreInventory.getProductById(itemId));
				itemsOrdered.add(newOrder);
			}

		} else {
			currentOrdersSize = itemsOrdered.size();

			for (String itemId : itemIds) {
				boolean found = false;
				for (int i = 0; i < currentOrdersSize; i++) {
					order = (OrderedProduct) itemsOrdered.get(i);
					if (itemId.equalsIgnoreCase(order.getItemID())) {
						order.incrementNumItems();
						found = true;
					}
				}

				if (!found) {

					OrderedProduct newOrder = new OrderedProduct(StoreInventory.getProductById(itemId));
					itemsOrdered.add(newOrder);
				}
			}

		}

	}

	public synchronized ArrayList<OrderedProduct> removeOrder(String itemId, ArrayList<OrderedProduct> itemsInList) {

		ArrayList<OrderedProduct> list = itemsInList;

		for (Iterator<OrderedProduct> iterator = list.iterator(); iterator.hasNext();) {
			OrderedProduct orPro = iterator.next();
			if (orPro.getItemID().equalsIgnoreCase(itemId)) {
				int numItems = orPro.getNumItems();
				if (numItems == 1) {
					iterator.remove();
				} else {
					orPro.setNumItems(numItems - 1);
				}
			}
		}

		return itemsInList;
	}
}
