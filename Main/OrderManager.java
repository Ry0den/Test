package Kofi_Co;

import java.util.ArrayList;

public class OrderManager {
    public static OrderManager instance;
    public ArrayList<OrderItem> currentOrder;
    
    private OrderManager() {
        currentOrder = new ArrayList<>();
    }
    
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    
    public void addToOrder(String name, String price) {
        OrderItem newItem = new OrderItem(name, price);
        currentOrder.add(newItem);
        System.out.println("Added to order: " + name + " - " + price);
    }
    
    public ArrayList<OrderItem> getCurrentOrder() {
        return currentOrder;
    }
    
    public void clearOrder() {
        currentOrder.clear();
    }

    public static void resetInstance() {
        instance = null;
    }
} 