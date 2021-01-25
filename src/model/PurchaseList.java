package src.model;

import java.util.ArrayList;

public class PurchaseList {
    //subtotal of the Price all Objects in the list
    private float subtotal = 0;
    private ArrayList<Item> purchaseList;

    PurchaseList() {
        this.purchaseList = new ArrayList<Item>();
    }

    //add a new PurchaseObject at the end of the list
    public void newItem(Product product, int amount) {
        for (Item item : ArrayList<Item>) {
            if (this[item].getProduct() == product) {
                this[item].changeAmount(amount);
                changeSubtotal(amount);
            }
        }
    }
    
    //remove PurchaseObject at the specified index
    public void removePurchaseObject(int index)
    {
        PurchaseObject temp = purchaseList.get(index);
        this.subtotal = temp.changeSubtotalREM(subtotal);
        purchaseList.remove(temp);
    }

    //set a new Amount for the PurchaseObject at the specified index 
    public void changeAmount(int index, int newAmount) {
        PurchaseObject temp = purchaseList.get(index);
        temp.setAmount(newAmount);
        this.subtotal = temp.changeSubtotalADD(subtotal);
    }

    //clear purchaseList
    public void cancelPuchase()
    {
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

    public void changeSubtotal(int change) {
        this.setSubtotal(this.subtotal + change);
    }


    public float getSubtotal()
    {
        return subtotal;
    }
}
