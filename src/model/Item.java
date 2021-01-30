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
            throw new Exception("Der Bestand des Artikels " + product.getName() + " ist zu gering für diese Operation");
        }
    }

    /**
     * Sets a new value for the amount of this item.
     *
     * @param amount the amount of this item
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the product this item is representing in purchaseList.
     *
     * @return the product this item is representing in purchaseList
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Returns the current value for the amount of this item.
     *
     * @return the amount of this item
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Changes the amount of this item by the difference specified by the change parameter.
     * This value can be a positive and negative integer.
     *
     * @param change specifies the difference of the old and new value for the amount attribute
     */
    public void changeAmount(int change) {
        this.setAmount(this.amount + change);
    }
}
