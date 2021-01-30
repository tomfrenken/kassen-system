package model;

import java.util.ArrayList;

public class PurchaseList {
    //subtotal of the Price all Objects in the list
    private double subtotal = 0;
    private ArrayList<Item> purchaseList;

    PurchaseList() {
        this.purchaseList = new ArrayList<Item>();
    }

    // add a item to the list
    // adjust subtotal by change
    public void addItem(Product product, int amount) throws Exception {
        Item item;
        try {
            item = new Item(product, amount);
        } catch (Exception e) {
            throw e;
        }
        for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                item.changeAmount(amount);
                this.changeSubtotal(amount * product.getPrice());
                return;
            }
        }
        this.purchaseList.add(item);
        this.changeSubtotal(amount * product.getPrice());
    }

    //remove a Product from the purchaseList
    // adjust subtotal by change
    public void removeItem(Product product) {
        for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                double change = item.getAmount();
                double price = item.getProduct().getPrice();
                double changeSubtotal = -(change * price);
                this.purchaseList.remove(item);
                this.changeSubtotal(changeSubtotal);
            }
        }
    }

    // change the current amount of a item to a new one
    // adjust subtotal by change
    public void changeItemAmount(Product product, int amount) throws Exception {
        Item item;
        try {
            item = new Item(product, amount);
        } catch (Exception e) {
            throw e;
        }
        for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                if (amount == 0) {
                    this.removeItem(product);
                }
                int change = amount - item.getAmount();
                double price = item.getProduct().getPrice();
                double changeSubtotal = change * price;
                item.changeAmount(change);
                this.changeSubtotal(changeSubtotal);
                return;
            }
        }
        throw new Exception("Der Artikel " + product.getName() + " ist nicht in der Einkaufsliste.");
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

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    public void changeSubtotal(double change) {
        this.setSubtotal(this.getSubtotal() + change);
    }



}
