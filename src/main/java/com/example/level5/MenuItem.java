package com.example.level5;

public class MenuItem {
    private String name;
    private String category;
    private double price;
    private String desc;

    public MenuItem(String name, String category, double price, String desc) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.desc = desc;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }
}