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
                for (Product product : getProductList()) {
                    if (item.getProduct().equals(product)) {
                        productList.changeProduct(productList.getProductList().indexOf(product), product.getName(),
                                product.getId(), product.getStock(), product.getWeight(), product.getWeightUnit(),
                                product.getPrice(), product.getCategory());
                        break;
                    }
                }
            } else {
                for (Product product : getProductList()) {
                    if (item.getProduct().equals(product)) {
                        productList.changeProduct(productList.getProductList().indexOf(product), product.getName(),
                                product.getId(), product.getSpecialStock(), product.getWeight(), product.getWeightUnit(),
                                product.getBasePrice(), product.getCategory());
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

    /**
     * Returns the productList.
     *
     * @return the productList
     */
    public ArrayList<Product> getProductList() {
        return productList.getProductList();
    }

    /**
     * Searches the productList for a product with this name.
     * The entered search phrase can be a substring of the results or a specific name.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of products with the same name as the search phrase,
     *                     or where the given search phrase is part of the name
     */
    public ArrayList<Product> searchProductByName(String searchPhrase) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : getProductList()) {
            if(product.getName().contains(searchPhrase)){
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Searches the productList for a product with this id.
     * The entered search phrase can be a partial id of the results or a specific id.
     *
     * @param id the id of a product
     * @return   a list of products with the same id as the search phrase,
     *           or where the given search phrase is part of the id
     */
    public ArrayList<Product> searchProductById(Long id) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : getProductList()) {
            if(Long.toString(product.getId()).contains(Long.toString(id))) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Searches the productList for a product with this name or id.
     * The search phrase can be a specific name or id of the results or it can be part of them.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of product with the same name or id regarding what was searched
     *                     for, or where the search phrase is part of the name or id
     */
    public ArrayList<Product> searchProduct(String searchPhrase) {
        ArrayList<Product> productList;
        try{
            productList = this.searchProductById(Long.parseLong(searchPhrase));
        } catch(Exception e){
            productList = this.searchProductByName(searchPhrase);
        }
        return productList;
    }
}
