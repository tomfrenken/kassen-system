package model;

public class Product {
    private String name;
    private long id;
    private int stock;
    private double weight;
    private double price;
    private double basePrice;
    private String category;

    //create new product
    public Product(String name, long id, int stock, double weight, double basePrice, String category) throws Exception {

            if(name.length() > 2 && name.length() < 32) {
                this.name = name;
            }else {
                throw new Exception("Der Name" + name + "ist nicht von zulässiger Länge");
            }
            if () {
                this.id = id;
            } else {
                throw new Exception("Der Name" + name);
            }
            this.stock = stock;
            this.weight = weight;
            this.basePrice = basePrice;
        if (categoryList.categoryInList(category)) {
            this.category = category;
        } else {
            throw new Exception("Die Kategorie " + category + " existiert nicht.");
        }
    }

    /**
     * Sets a new value for the name of the product.
     * The name must be at least 2 and at most 32 symbols long.
     * The name can consist of any symbol on a standard keyboard (DIN 2137-1:2018-12)
     *
     * @param name the name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets a new value for the identification number of the product which is the EAN or PLU.
     * The id must be 13 digits long if it is an EAN.
     * If it is a PLU it must be 4 or 5 digits long.
     * If it is 5 digits long the first one must be a 9
     * For example an EAN looks like this 1234567890123, a PLU like this 1234 or 91234.
     *
     * @param id the number used to identify each unique product
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets a new value for the stock of the product.
     * The stock must be an integer between 0 and 1.000
     *
     * @param stock the amount of units stored of this product
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Sets a new value for the weight of the product.
     * The weight must be
     *
     * @param weight the weight of one unit of this product
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Sets a new value for the price of the product.
     * The price must be a floating point number between 0.01 and 100,000
     *
     * @param price the price charged for one unit of this product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets a new value for the base price of the product.
     * The base price must be a floating point number 0.01 100,000
     *
     * @param basePrice the price charged for a fixed amount of this product
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Sets a new value for the category of the product.
     *
     * @param category the category this product has be assigned to
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns the current value for the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the current value for the identification number of the product.
     *
     * @return the number used to identify each unique product
     */
    public long getId() {
        return this.id;
    }

    /**
     * Returns the current value for the stock of the product.
     *
     * @return the amount of units stored of this product
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Returns the current value for the weight of the product.
     *
     * @return the weight of one unit of this product
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Returns the current value for the price of the product.
     * This value is determined by setting the price in proportion to the actual weight.
     * of a packed amount of this Product.
     * For example if the base price of a Product is 1€/100g and a package of this product
     * weighs 150g, then the actual price of the 150g package will be 1,50€
     *
     * @return the price charged for one unit of this product
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the current value for the base price of the product.
     * This value is determined by setting the price in proportion to a fix weight of this Product.
     * For example how much do 100g of this product cost.
     *
     * @return the price charged for a fixed amount of this product
     */
    public double getBasePrice() {
        return this.basePrice;
    }

    /**
     * Returns the current value for the category of the product.
     *
     * @return the category this product has be assigned to
     */
    public String getCategory() {
        return this.category;
    }
}