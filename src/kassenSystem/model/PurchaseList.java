package kassenSystem.model;

import java.util.ArrayList;

/**
 * This is the purchaseList.
 */
public class PurchaseList {

    /**
     * The subtotal attribute is the subtotal of prices of all items in the purchaseList.
     * The purchaseList attribute is the purchaseList.
     */
    private double subtotal = 0;
    private final ArrayList<Item> purchaseList = new ArrayList<>();
    private final ProductList productList = new ProductList();

    /**
     * PurchaseList constructor.
     */
    public PurchaseList() {}

    /**
     * Add an item to the list or increment the amount of the item if the related item already
     * exists.
     * The incrementation of 1 is meant for use with the product scanner.
     * Throws Exception if amount of this item is bigger then the stock of the product it
     * represents.
     *
     * @param product    the product that is used
     * @param amount     the amount you want to use
     * @throws Exception if amount of this item is bigger then the stock of the product it
     *                   represents
     */
    public void addItem(Product product, double amount) throws Exception {
        if (product.getSpecialStock() == null) {
            if (this.purchaseList.size() > 0) {
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
        } else {
            if (this.purchaseList.size() > 0) {
                for (Item item : this.purchaseList) {
                    if (item.getProduct() == product) {
                        item.changeAmount(amount);
                        switch(product.getWeightUnit()) {
                            case "g":
                            case "ml":
                                this.addSubtotal(amount/100 * product.getBasePrice());
                                break;

                            case "kg":
                            case "l":
                            case "stück":
                                this.addSubtotal(amount * product.getBasePrice());
                        }
                        return;
                    }
                }
            }
            this.purchaseList.add(new Item(product, amount));
            switch(product.getWeightUnit()) {
                case "g":
                case "ml":
                    this.addSubtotal(amount/100 * product.getBasePrice());
                    break;

                case "kg":
                case "l":
                case "stück":
                    this.addSubtotal(amount * product.getBasePrice());
            }
        }
    }


    /**
     * Removes an item from the purchaseList and subtracts the amount from the subtotal.
     *
     * @param item the item you want to remove from the purchaseList
     */
    public void removeItem(Item item) {
        if (item.getProduct().getSpecialStock() == null) {
            this.subtractSubtotal(item.getProduct().getPrice() * item.getAmount());
        } else {
            switch(item.getProduct().getWeightUnit()) {
                case "g":
                case "ml":
                    this.subtractSubtotal(item.getAmount()/100 * item.getProduct().getBasePrice());
                    break;

                case "kg":
                case "l":
                case "stück":
                    this.subtractSubtotal((item.getAmount()) * item.getProduct().getBasePrice());
            }
        }
        this.purchaseList.remove(item);
    }

    /**
     * Sets the item amount to a new value, the subtotal will be updated for the amount changed.
     *
     * @param item       the item to be changed
     * @param amount     the new amount
     * @throws Exception when the new item amount isn't left in stock
     */
    public void setItemAmount(Item item, double amount) throws Exception {
        if (this.purchaseList.contains(item)) {
            if (item.getProduct().getSpecialStock() == null) {
                if (item.getAmount() - amount == 0) {
                    this.removeItem(item);
                } else if (item.getAmount() < amount) {
                    item.setAmount(amount);
                    this.addSubtotal((amount - item.getAmount()) * item.getProduct()
                            .getPrice());
                } else {
                    item.setAmount(amount);
                    this.subtractSubtotal((item.getAmount() - amount) * item.getProduct()
                            .getPrice());
                }
            } else {
                if (item.getProduct().getWeight() - amount == 0) {
                    this.removeItem(item);
                } else if (item.getAmount() < amount) {
                    switch(item.getProduct().getWeightUnit()) {
                        case "g":
                        case "ml":
                            this.subtractSubtotal((amount - item.getAmount())/100  * item.getProduct().getBasePrice());
                            break;

                        case "kg":
                        case "l":
                        case "stück":
                            this.subtractSubtotal((amount - item.getAmount()) * item.getProduct().getBasePrice());
                    }
                    item.setAmount(amount);
                } else {
                    switch(item.getProduct().getWeightUnit()) {
                        case "g":
                        case "ml":
                            this.subtractSubtotal((item.getAmount() - amount)/100  * item.getProduct().getBasePrice());
                            break;

                        case "kg":
                        case "l":
                        case "stück":
                            this.subtractSubtotal((item.getAmount() - amount) * item.getProduct().getBasePrice());
                    }
                    item.setAmount(amount);
                }
            }
        } else {
            throw new Exception("Der Artikel " + item.getProduct().getName() +
                    " ist nicht in der Einkaufsliste.");
        }
    }

    /**
     * Clears the purchaseList to cancel the purchase.
     */
    public void cancelPurchase() {
        this.purchaseList.clear();
    }

    /**
     * Finishes the purchase, reduces the stock returns the subtotal and clears the purchaseList.
     */
    public double finishPurchase() throws Exception {
        for (Item item : this.purchaseList) {
            if (item.getProduct().getSpecialStock() == null) {
                for (Product product : productList.getProductList()) {
                    if (item.getProduct().equals(product)) {
                        product.setStock((int) item.getAmount());
                        break;
                    }
                }
            } else {
                for (Product product : productList.getProductList()) {
                    if (item.getProduct().equals(product)) {
                        product.setWeight(item.getAmount());
                        break;
                    }
                }
            }
        }
        this.purchaseList.clear();
        return getSubtotal();
    }

    /**
     * Returns the subtotal of the purchaseList.
     *
     * @return the subtotal of the purchaseList
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     * Subtracts the value from the subtotal.
     *
     * @param subtractValue the value to subtract from the subtotal
     */
    public void subtractSubtotal(double subtractValue){
        this.subtotal = this.getSubtotal() - subtractValue;
    }

    /**
     * Adds the value to the subtotal.
     *
     * @param addValue the value to add to the subtotal
     */
    public void addSubtotal(double addValue){
        this.subtotal = this.getSubtotal() + addValue;
    }

    /**
     * Returns the purchaseList.
     *
     * @return the purchaseList
     */
    public ArrayList<Item> getPurchaseList(){
        return this.purchaseList;
    }
}
