package kassenSystem.model;

import java.util.ArrayList;

public class PurchaseList {
    private double subtotal = 0;
    private final ArrayList<Item> purchaseList = new ArrayList<>();

    public PurchaseList() {
    }

    ;

    /**
     * Add an item to the list or increment the amount of the item if the related item already exists.
     * Incrementation of 1 is meant for use with the product scanner.
     *
     * @param product The product that is used.
     * @param amount  The amount you want to use.
     */
    public void addItem(Product product, int amount) throws Exception {
        if (purchaseList.size() > 0) {
            for (Item item : this.purchaseList) {
                if (item.getProduct() == product) {
                    item.changeAmount(amount);
                    this.addSubtotal(product.getPrice() * amount);
                    return;
                }
            }
        }
        this.purchaseList.add(new Item(product, amount));
        this.addSubtotal(product.getPrice() * amount);
    }


    /**
     * Removes an item from the purchaseList and subtracts the amount from the subtotal.
     *
     * @param item The item you want to remove from the purchaseList.
     */
    public void removeItem(Item item) {
        this.subtractSubtotal(item.getProduct().getPrice() * item.getAmount());
        purchaseList.remove(item);
    }

    /**
     * Sets the item amount to a new value, the subtotal will be updated for the amount changed.
     *
     * @param item The item to be changed.
     * @param amount The new amount.
     * @throws Exception When the new item amount isn't left in stock.
     */
    // muss noch mit getBasePrice funktionieren
    public void setItemAmount(Item item, int amount) throws Exception {
        if (purchaseList.contains(item)) {
            if (item.getAmount() - amount == 0) {
                this.subtractSubtotal(item.getAmount() * item.getProduct().getPrice());
                purchaseList.remove(item);
            } else if (item.getAmount() < amount) {
                this.subtractSubtotal((item.getAmount() - amount) * item.getProduct().getPrice());
                item.setAmount(amount);
            } else {
                this.addSubtotal((amount - item.getAmount()) * item.getProduct().getPrice());
                item.setAmount(amount);
            }
        } else {
            throw new Exception("Der Artikel " + item.getProduct().getName() + " ist nicht in der Einkaufsliste.");
        }
    }

    /**
     * Clears the purchaseList to cancel the purchase.
     */
    public void cancelPurchase() {
        purchaseList.clear();
    }

    /**
     * Finishes the purchase, reduces the stock and returns the subtotal
     */
    // finish this after productlist functions such as changeStock / removeProduct work
    public void finishPurchase() {
        //return subtotal to UI
        //reduce Stock by amount
        purchaseList.clear();
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     * Subtracts the value from the subtotal.
     *
     * @param subtractValue The value to subtract from the subtotal.
     */
    public void subtractSubtotal(double subtractValue){
        this.subtotal = this.getSubtotal() - subtractValue;
    }

    /**
     * Adds the value to the subtotal.
     *
     * @param addValue The value to add to the subtotal.
     */
    public void addSubtotal(double addValue){
        this.subtotal = this.getSubtotal() + addValue;
    }

    public ArrayList<Item> getPurchaseList(){
        return this.purchaseList;
    }
}
