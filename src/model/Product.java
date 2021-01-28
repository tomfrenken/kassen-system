package model;

import src.model.Category;

public class Product {
    private String name;
    private int id;
    private int stock;
    private float weight;
    private float price;
    private float basePrice;
    private Category category;

    //create new product
    public Product(String name, int id, int stock, float weight, float price, float basePrice) {
        this.name = name;
        this.id = id;
        this.stock = stock;
        this.weight = weight;
        this.price = price;
        this.basePrice = basePrice;
    }

    // Set a new value for amount
    public void setName(String name) {
        this.name = name;
    }

    // Set a new value for amount
    public void setId(int id) {
        this.id = id;
    }

    // Set a new value for amount
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Set a new value for amount
    public void setWeight(float weight) {
        this.weight = weight;
    }

    // Set a new value for amount
    public void setPrice(float price) {
        this.price = price;
    }

    // Set a new value for amount
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    // Set a new value for amount
    public void setCategory(String name) {
        this.category.setName(name);
    }

    // Request the current value for id
    public String getName() {
        return this.name;
    }

    // Request the current value for id
    public int getId() {
        return this.id;
    }

    // Request the current value for id
    public int getStock() {
        return this.stock;
    }

    // Request the current value for id
    public float getWeight() {
        return this.weight;
    }

    // Request the current value for id
    public float getPrice() {
        return this.price;
    }

    // Request the current value for id
    public float getBasePrice() {
        return this.basePrice;
    }

    // Request the current value for id
    public String getCategory() {
        return category.getName();
    }
}