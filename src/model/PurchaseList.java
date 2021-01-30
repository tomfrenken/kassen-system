package model;

import java.util.ArrayList;

public class PurchaseList {
    //subtotal of the Price all Objects in the list
    private float subtotal = 0;
    private ArrayList<Item> purchaseList;

    PurchaseList() {
        this.purchaseList = new ArrayList<Item>();
    }

    // add a item to the list
    // adjust subtotal by change
    public void addItem(Product product, int amount) throws Exception {
        //
        for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                item.changeAmount(amount);
                this.changeSubtotal(amount * product.getPrice());
                return;
            }
        }
        Item item;
        try {
            item = new Item(product, amount);
        } catch (Exception e) {
            throw e;
        }
        this.purchaseList.add(item);
        this.changeSubtotal(amount * product.getPrice());
    }

    //remove a Product from the purchaseList
    // adjust subtotal by change
    public void removeItem(Product product) {
        for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                float change = item.getAmount();
                float price = item.getProduct().getPrice();
                float changeSubtotal = -(change * price);
                this.purchaseList.remove(item);
                this.changeSubtotal(changeSubtotal);
            }
        }
    }

    // change the current amount of a item to a new one
    // adjust subtotal by change
    public void changeItemAmount(Product product, int amount) {
        for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                int change = amount - item.getAmount();
                float price = item.getProduct().getPrice();
                float changeSubtotal = change * price;
                item.changeAmount(change);
                this.changeSubtotal(changeSubtotal);
            }
        }
    }

    //clear purchaseList
    public void cancelPurchase() {
        purchaseList.clear();
    }

    //finish old purchase and clear purchaseList ______!!!!!!!______
    public void finishPurchase() {
        //return subtotal to UI
        //reduce Stock by amount
        purchaseList.clear();
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getSubtotal() {
        return this.subtotal;
    }

    public void changeSubtotal(float change) {
        this.setSubtotal(this.getSubtotal() + change);
    }



}
