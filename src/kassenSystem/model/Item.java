package kassenSystem.model;

/**
 * This is an Item used in the PurchaseList.
 */
public class Item {

    /**
     *  The product attribute is the product of which an amount is added to the purchaseList.
     *  The amount attribute is the amount of the specified product that is added to the
     *  purchaseList.
     */
    private final Product product;
    private double amount;

    /**
     * Creates a new item from a given product and amount.
     * Throws Exception if the stock is smaller then the amount.
     *
     * @param product    the product to buy
     * @param amount     the amount of the product to buy
     * @throws Exception if the stock is smaller then the amount
     */
    public Item(Product product, double amount) throws Exception {
        if(amount > 0) {
            if (product.getSpecialStock() == null) {
                if(product.getStock() - amount >=0) {
                    this.product = product;
                    this.amount = amount;
                } else {
                    throw new Exception("Der Bestand des Artikels " + product.getName() +
                            " ist zu gering für diese Operation.");
                }
            } else {
                if (product.getWeight() - amount >= 0) {
                    this.product = product;
                    this.amount = amount;
                } else {
                    throw new Exception("Der Bestand des Artikels " + product.getName() +
                            " ist zu gering für diese Operation.");
                }
            }
        } else {
            throw new Exception("Die Anzahl muss >0 sein!");
        }
    }

    /**
     * Sets a new value for the amount of this item.
     * Throws Exception if the stock/weight is smaller then the amount.
     *
     * @param amount     the amount of this item
     * @throws Exception If the stock is smaller then the amount
     */
    public void setAmount(double amount) throws Exception {
        if (amount >= 0) {
            if (product.getSpecialStock() == null) {
                if (product.getStock() - amount >= 0) {
                    this.amount = amount;
                } else {
                    throw new Exception("Der Bestand des Artikels " + product.getName() +
                            " ist zu gering für diese Operation.");
                }
            } else {
                if (product.getWeight() - amount >= 0) {
                    this.amount = amount;
                } else {
                    throw new Exception("Der Bestand des Artikels " + product.getName() +
                            " ist zu gering für diese Operation.");
                }
            }
        } else {
            throw new Exception("Die Anzahl darf nicht muss >=0 sein.");
        }
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
     * @return the current amount of this item
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Changes the amount of this item by the difference specified by the change parameter.
     * This value can be a positive or negative double.
     * Throws Exception if the stock of this item is too low for this operation.
     *
     * @param change     specifies the difference of the old and new value for the amount attribute
     * @throws Exception if the stock of this item is too low for this operation
     */
    public void changeAmount(double change) throws Exception {
        this.setAmount(this.amount + change);
    }

    /**
     * Returns the name of the item as a String.
     *
     * @return the name of the item as a string
     */
    public String toString() {
        return this.getProduct().getName() + " - " + this.getAmount();
    }
}
