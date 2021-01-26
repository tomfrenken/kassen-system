package src.model;

import src.model.Item;
import java.util.ArrayList;

public class PurchaseList {
    //subtotal of the Price all Objects in the list
    private float subtotal = 0;
    private ArrayList<Item> purchaseList;

    PurchaseList() {
        this.purchaseList = new ArrayList<Item>();
    }

    //add a Product to the list
    public void addProduct(Product product, int amount) {
        //
        this.purchaseList.forEach(item -> {
            if (item.getProduct() == product) {
                item.changeAmount(amount);
                changeSubtotal(amount * item.getProduct().getPrice());
            }
        });
    }

    //remove PurchaseObject at the specified index
    public void removeProduct(Product product) {
        this.purchaseList.forEach(item -> {
            if (item.getProduct() == product) {
                float change = item.getAmount();
                float price = item.getProduct().getPrice();
                float changeSubtotal = -(change * price);
                this.purchaseList.remove(item);
                changeSubtotal(changeSubtotal);
            }
        });
    }

    //set a new Amount for the PurchaseObject at the specified index 
    public void changeAmount(Product product, int amount) {
        this.purchaseList.forEach(item -> {
            if (item.getProduct() == product) {
                int change = amount - item.getAmount();
                float price = item.getProduct().getPrice();
                float changeSubtotal = change * price;
                item.changeAmount(change);
                changeSubtotal(changeSubtotal);
            }
        });
    }

    //clear purchaseList
    public void cancelPuchase() {
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
