package model;

import model.Product;

public class Item {
    private Product product;
    private int amount;
    
    // Create a new PurchaseObject
    Item(Product product, int amount) throws Exception {
        if(product.getStock() - amount >=0) {
            this.product = product;
            this.amount = amount;
        } else {
            throw new Exception("The item " + product.getName() + " is out of stock.");
        }
    }

    // Set a new value for amount
    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Get the product
    public Product getProduct() {
        return this.product;
    }

    // Get the amount
    public int getAmount() {
        return this.amount;
    }

    // Change the amount
    public void changeAmount(int change) {
        this.setAmount(this.amount + change);
    }
}
