package kassenSystem.model;

import java.util.ArrayList;

public class PurchaseList {
    private double subtotal = 0;
    private final ArrayList<Item> purchaseList = new ArrayList<>();

    PurchaseList() {};

    /**
     * Add an item to the list or increment the amount of the item if the related item already exists.
     * Incrementation of 1 is meant for use with the product scanner.
     *
     * @param product The product that is used.
     * @param amount The amount you want to use.
     */
    public void addItem(Product product, int amount) throws Exception {
        if(purchaseList.size()>0) {
            for (Item item : this.purchaseList) {
                if (item.getProduct() == product) {
                    item.changeAmount(1);
                    this.changeSubtotal(product.getPrice() * amount);
                    break;
                } else {
                    this.purchaseList.add(new Item(product, amount));
                    this.changeSubtotal(product.getPrice() * amount);;
                    break;
                }
            }
        } else {
            this.purchaseList.add(new Item(product, amount));
            this.changeSubtotal(product.getPrice() * amount);
        }
    }

    /**
     * Removes an item from the purchaseList.
     *
     * @param product The product you want to remove from the purchaseList.
     */
    public void removeItem(Product product) {
       for (Item item : this.purchaseList) {
            if (item.getProduct() == product) {
                this.changeSubtotal(item.getAmount() * item.getProduct().getPrice());
                this.purchaseList.remove(item);
                break;
            }
        }
    }

    // change the current amount of a item to a new one
    // adjust subtotal by change
    /* public void changeItemAmount(Item item, int amount) throws Exception {
        Item test;
        try {
            test = new Item(product, amount);
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
    } */

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

    public double getSubtotal() {
        return this.subtotal;
    }

    public void changeSubtotal(double change){
        if(change>0){
            this.subtotal = this.getSubtotal() + change;
        } else {
            this.subtotal = this.getSubtotal() - change;
        }
    }

    public ArrayList<Item> getPurchaseList(){
        return this.purchaseList;
    }
}
