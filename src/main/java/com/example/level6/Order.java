package com.example.level6;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<String, Integer> orderItems = new HashMap<>();
    private double total;

    public Order (){}

    public Map<String, Integer> getOrderItems() { return orderItems; }

    public void setOrderItems(Map<String, Integer> orderItems) { this.orderItems = orderItems; }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total; }

    public void addOrderItem(String name, Double price){
        orderItems.put(name, orderItems.getOrDefault(name, 0)+1);
        total += price;
    }

    public void removeOrder(){
        orderItems.clear();
    }
}
