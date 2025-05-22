package Kofi_Co;

import java.util.ArrayList;

public class OrderManager {
	private static OrderManager instance;
	private ArrayList<OrderItem> currentOrder;
	private int currentReceiptNumber;

	private OrderManager() {
		currentOrder = new ArrayList<>();
		currentReceiptNumber = 1;
	}

	public static OrderManager getInstance() {
		if (instance == null) {
			instance = new OrderManager();
		}
		return instance;
	}

	public void addToOrder(OrderItem item) {
		for (OrderItem existingItem : currentOrder) {
			if (existingItem.name.equals(item.name)) {
				existingItem.quantity += item.quantity;
				return;
			}
		}
		currentOrder.add(item);
	}

	public ArrayList<OrderItem> getCurrentOrder() {
		return currentOrder;
	}

	public void clearOrder() {
		currentOrder.clear();
	}

	public void removeFromOrder(String itemName) {
		currentOrder.removeIf(item -> item.name.equals(itemName));
	}

	public void updateQuantity(String itemName, int newQuantity) {
		for (OrderItem item : currentOrder) {
			if (item.name.equals(itemName)) {
				item.quantity = newQuantity;
				if (newQuantity <= 0) {
					currentOrder.remove(item);
				}
				break;
			}
		}
	}

	public int getCurrentReceiptNumber() {
		return currentReceiptNumber;
	}

	public void incrementReceiptNumber() {
		currentReceiptNumber++;
	}

	public static void resetInstance() {
		instance = null;
	}
}