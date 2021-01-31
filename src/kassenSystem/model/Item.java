package kassenSystem.model;

public class Item {
    private final Product product;
    private int amount;

    /**
     * Creates a new item from a given product and amount.
     *
     * @param product The product to buy.
     * @param amount The amount of the product to buy.
     * @throws Exception If the stock is too low for this operation.
     */
    Item(Product product, int amount) throws Exception {
        if(product.getStock() - amount >=0) {
            this.product = product;
            this.amount = amount;
        } else {
            throw new Exception("Der Bestand des Artikels " + product.getName() + " ist zu gering für diese Operation.");
        }
    }

    /**
     * Sets a new value for the amount of this item.
     *
     * @param amount the amount of this item.
     * @throws Exception If the stock is too low for this operation.
     */
    public void setAmount(int amount) throws Exception {
        if(product.getStock() - amount >=0) {
            this.amount = amount;
        } else {
            throw new Exception("Der Bestand des Artikels " + product.getName() + " ist zu gering für diese Operation.");
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
     * @return the amount of this item
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Changes the amount of this item by the difference specified by the change parameter.
     * This value can be a positive and negative integer.
     *
     * @param change specifies the difference of the old and new value for the amount attribute.
     * @throws Exception If the stock is too low for this operation.
     */
    public void changeAmount(int change) throws Exception {
        this.setAmount(this.amount + change);
    }

    public String toString() {
        return product.getName();
    }
}
