package kassenSystem.model;

/**
 * This is a Product.
 */

// Preis muss noch errechnet werden.
public class Product {
    private String name;
    private long id;
    private int stock;
    private double weight;
    private double price;
    private double basePrice;
    private String category;
    private CategoryList categoryList = new CategoryList();

    /**
     * Creates a new Product and initializes the attributes name, id, stock, weight, basePrice
     * and category.
     * It will also check if the parameters have correct values.
     *
     * @param name the name of the product
     * @param id the identification number of the product
     * @param stock the stock of the product
     * @param weight the weight of one unit of the product
     * @param basePrice the base price for a fixed amount of the product
     * @param category the category the product has been assigned to
     *
     * @throws Exception specified at each check
     */
    public Product(String name, long id, int stock, double weight, double basePrice,
                   String category) throws Exception {

        /**
         * Checks if the name is 2 to 32 symbols long.
         * Throws an exception if the name does not meet these requirements.
         *
         * @throws Exception if the name is shorter then 2 or longer then 32 Symbols
         */
        if(name.length() >= 2 && name.length() <= 32) {
            this.name = name;
        }else {
            throw new Exception("Der Name muss zwischen 2 und 32 zeichen lang sein " +
                    " Ihre Eingabe " + name + " war fehlerhaft.");
        }

        /**
         * Checks if the id is 13 digits or 4 digits or 5 digits long.
         * If it is 5 digits long it checks if the first digit is a 9.
         * Throws an exception if the id does not meet these requirements.
         *
         * @throws Exception if the id is not 13 or 4 digits long or 5 digits long and of the
         *                   scheme 9XXXX
         */
        String number = String.valueOf(id);
        if (number.length() == 13 || number.length() == 4 || (number.length() == 5 &&
                number.regionMatches(0,((Integer) 90000).toString(),0,1))) {
            this.id = id;
        } else {
            throw new Exception("Die ID muss eines der folgenden Formate erfuellen: " +
                    "1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9." +
                    " Ihre Eingabe " + id + " war fehlerhaft.");
        }

        /**
         * Checks if the Stock is between 0 and 1000 units.
         * Throws an exception if the stock does not meet these requirements.
         *
         * @throws Exception if the stock is smaller then 0 or greater then 1000
         */
        if (stock >= 0 && stock <= 1000) {
            this.stock = stock;
        } else {
            throw new Exception("Der Bestand muss zwischen 0 und 1000 liegen." +
                    " Ihre eingabe " + stock + " war fehlerhaft.");
        }

        /**
         * Checks if the weight is between XXXXXXXXX.
         * Throws an exception if the weight does not meet these requirements.
         *
         * @throws Exception if the weight is XXXXXXXXXXX
         */
        if (weight >= 0.01 && weight <= 100) {
            this.weight = weight;
        } else {
            throw new Exception(" Das Gewicht muss im Bereich XXXXXX liegen." +
                    " Ihre eingabe " + weight + " war fehlerhaft.");
        }

        /**
         * Checks if the basePrice is between 0.01 and 100000.
         * Throws an exception if the basePrice does not meet these requirements.
         *
         * @throws Exception if the basePrice is less then 0.01 or greater then 100000
         */
        if(basePrice >= 0.01 && basePrice <= 100000) {
            this.basePrice = basePrice;
        } else {
            throw new Exception("Der Grundpreis muss zwischen 0.01 und 100000 liegen." +
                    " Ihre eingabe " + basePrice + " war fehlerhaft.");
        }

        /**
         * Checks if the category already exits
         * Throws an exception if the category does not meet these requirements.
         *
         * @throws Exception if the category does not already exists in categoryList
         */
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
     * Throws an exception if the name does not meet these requirements.
     *
     * @param name the name of the product
     * @throws Exception if the name is shorter then 2 or longer then 32 Symbols
     */
    public void setName(String name) throws Exception {
        if(name.length() >= 2 && name.length() <= 32) {
            this.name = name;
        }else {
            throw new Exception("Der Name muss zwischen 2 und 32 zeichen lang sein " +
                    " Ihre Eingabe " + name + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the identification number of the product which is the EAN or PLU.
     * The id must be 13 digits long if it is an EAN.
     * If it is a PLU it must be 4 or 5 digits long.
     * If it is 5 digits long, the first digit must be a 9
     * For example an EAN looks like this 1234567890123, a PLU like this 1234 or 91234.
     * Throws an exception if the id does not meet these requirements.
     *
     * @param id the number used to identify each unique product
     * @throws Exception if the id is not 13 or 4 digits long or 5 digits long and of the
     *                   scheme 9XXXX
     */
    public void setId(long id) throws Exception {
        String number = String.valueOf(id);
        if (number.length() == 13 || number.length() == 4 || (number.length() == 5 &&
                number.regionMatches(0,((Integer) 90000).toString(),0,1))) {
            this.id = id;
        } else {
            throw new Exception("Die ID muss eines der folgenden Formate erfuellen: " +
                    "1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9." +
                    " Ihre Eingabe " + id + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the stock of the product.
     * The stock must be an integer between 0 and 1000
     * Throws an exception if the stock does not meet these requirements.
     *
     * @param stock the amount of units stored of this product
     * @throws Exception if the stock is smaller then 0 or greater then 1000
     */
    public void setStock(int stock) throws Exception {
        if (stock >= 0 && stock <= 1000) {
            this.stock = stock;
        } else {
            throw new Exception("Der Bestand muss zwischen 0 und 1000 liegen." +
                    " Ihre eingabe " + stock + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the weight of the product.
     * The weight must be XXXXX
     * Throws an exception if the stock does not meet these requirements.
     *
     * @param weight the weight of one unit of this product
     * @throws Exception if the weight is XXXXXXXXXXX
     */
    public void setWeight(double weight) throws Exception {
        if (weight >= 0.01 && weight <= 100) {
            this.weight = weight;
        } else {
            throw new Exception(" Das Gewicht muss im Bereich XXXXXX liegen." +
                    " Ihre eingabe " + weight + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the price of the product.
     * The price must be a double between 0.01 and 100000
     * Throws an exception if the price does not meet these requirements.
     *
     * @param price the price charged for one unit of this product
     * @throws Exception if price is less then 0.01 or greater then 100000
     */
    //was passiert hiermit
    public void setPrice(double price) throws Exception {
        if (price >= 0.01 && price <= 100000) {
            this.price = price;
        } else {
            throw new Exception("Der Preis muss im Bereich zwischen 0.01 und 100000 liegen." +
                    " Ihre eingabe " + price + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the base price of the product.
     * The base price must be a double 0.01 100000
     * Throws an exception if the basePrice does not meet these requirements.
     *
     * @param basePrice the price charged for a fixed amount of this product
     * @throws Exception if the basePrice is less then 0.01 or greater then 100000
     */
    public void setBasePrice(double basePrice) throws Exception {
        if(basePrice >= 0.01 && basePrice <= 100000) {
            this.basePrice = basePrice;
        } else {
            throw new Exception("Der Grundpreis muss zwischen 0.01 und 100000 liegen." +
                    " Ihre eingabe " + basePrice + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the category of the product.
     * Checks if the category already exits
     * Throws an exception if the category does not meet these requirements.
     *
     * @param category the category this product has be assigned to
     * @throws Exception if the category does not already exists in categoryList
     */
    public void setCategory(String category) throws Exception {
        if (categoryList.categoryInList(category)) {
            this.category = category;
        } else {
            throw new Exception("Die Kategorie " + category + " existiert nicht.");
        }
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