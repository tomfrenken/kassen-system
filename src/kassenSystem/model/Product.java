package kassenSystem.model;

import java.util.Objects;

/**
 * This is a Product.
 */
public class Product {

    /**
     * The name attribute is the name of the product.
     * The id attribute is the id of the product.
     * The stock attribute is the stock of the product.
     * The specialStock attribute is the specialStock if used by the product else it is null.
     * The weight attribute is the weight of the product.
     * The weightUnit attribute is the weightUnit used for this product.
     * The price attribute is the price of the product.
     * The basePrice attribute is the basePrice of the product.
     * The category attribute is the category of the product.
     * The categoryList is the same categoryList that is created in CategoryList
     */
    private String name;
    private long id;
    private int stock;
    private String specialStock;
    private double weight;
    private final String weightUnit;
    private double price;
    private double basePrice;
    private String category;
    private final CategoryList categoryList = new CategoryList();

    /**
     * Creates a new Product and initializes the attributes name, id, stock, weight, weightUnit,
     * basePrice, category and price.
     * It will also check if the parameters have correct values.
     *
     * @param name the name of the product, must be between 2 and 32 characters
     * @param id the identification number of the product, has to be either 13 digits long,
     *              4 digits long, or 5 digits with a leading 9
     * @param stock the stock of the product, has to be between 0 and 1000
     * @param weight the weight of a unit of the product has to be between 1 and 100.000 for gramm
     *               and ml, between 0,01 and 100 for l and kg and between 1 and 1000 for stück
     * @param weightUnit the unit of the given weight e.g. g,kg,ml,l,stück
     * @param price the  price for a given amount of the product, between 0.01 and 100.000
     * @param category the category the product has been assigned to, has to be part of the
     *               category list
     *
     * @throws Exception specified at each check
     */
    public Product(String name, long id, int stock, double weight, String weightUnit,
                   double price, String category)
            throws Exception {
        if(name.matches("[-&'äÄöÖüÜßa-zA-Z\\d](" +
                        "[-&'äÄöÖüÜßa-zA-Z\\d\\s]{0,30})[-&'äÄöÖüÜßa-zA-Z\\d]")) {
            this.name = name;
        }else {
            throw new Exception("Der Name muss 2 bis 32 Zeichen lang sein." +
                    " Ihre Eingabe " + name + " war fehlerhaft.");
        }

        String number = String.valueOf(id);
        if (number.length() == 13  || number.length() == 8
                || number.length() == 4 || (number.length() == 5
                && number.regionMatches(0,((Integer) 90000).toString(),0,1))) {
            this.id = id;
        } else {
            throw new Exception("Die ID muss eines der folgenden Formate erfuellen: " +
                    "1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9 4) 8 Stellen" +
                    " Ihre Eingabe " + id + " war fehlerhaft.");
        }

        if (stock >= 0 && stock <= 1000) {
            this.stock = stock;
        } else {
            throw new Exception("Der Bestand muss im Bereich von einschließlich 0 bis " +
                    "einschließlich 1000 liegen. Ihre Eingabe " + stock + " war fehlerhaft.");
        }

        if(price <= 100000 && price >= 0.01){
            this.price = price;
        } else {
            throw new Exception("Der Preis muss im Bereich von einschließlich 0.01 bis" +
                    " einschließlich 100000 liegen.");
        }

        this.weightUnit = weightUnit;

        switch(weightUnit){
            case "g":
            case "ml":
                if (weight >=1 && weight <= 100000){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + weightUnit + " muss im Bereich von " +
                            "einschließlich 1 bis einschließlich 100.000 liegen." +
                            " Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                if(price / weight * 100 <= 100000 && price / weight * 100 >= 0.01) {
                    this.basePrice = price / weight * 100;
                } else {
                    throw new Exception("Der Grundpreis muss im Bereich von einschließlich 0,01 " +
                            "bis einschließlich 100.000 liegen," +
                            " Ihr aktueller Grundpreis lautet: " + price / weight * 100);
                }
                break;

            case "kg":
            case "l":
                if (weight >= 0.1 && weight <= 100){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + weightUnit + " muss im Bereich von " +
                            "einschließlich 0,1 bis einschließlich 100 liegen." +
                            " Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                if(price / weight <= 100000 && price / weight >= 0.01) {
                    this.basePrice = price / weight;
                } else {
                    throw new Exception("Der Grundpreis muss im Bereich von einschließlich 0,01 " +
                            "bis einschließlich 100.000 liegen," +
                            " Ihr aktueller Grundpreis lautet: " + price / weight * 1);
                }
                break;
            case "stück":
                if(weight >= 1 && weight <= 1000){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + weightUnit + "  muss im Bereich von" +
                            " einschließlich 1 bis einschließlich 1000 liegen." +
                            " Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                if(price / weight * 1 <= 100000 && price / weight * 1 >= 0.01) {
                    this.basePrice = price / weight * 1;
                } else {
                    throw new Exception("Der Grundpreis muss im Bereich von einschließlich 0,01 " +
                            "bis einschließlich 100.000 liegen," +
                            " Ihr aktueller Grundpreis lautet: " + price / weight * 1);
                }
        }

        if (categoryList.categoryInList(category)) {
            this.category = category;
        } else {
            throw new Exception("Die Kategorie " + category + " existiert nicht.");
        }
    }

    /**
     * Creates a new Product and initializes the attributes name, id, specialStock, weight,
     * basePrice and category.
     * It will also check if the parameters have correct values.
     *
     * @param name the name of the product, must be between 2 and 32 characters
     * @param id the identification number of the product, has to be either 13 digits long,
     *          4 digits long, or 5 digits with a leading 9
     * @param specialStock The special case where a product can not be counted,
     *                    has to be either n or N
     * @param weight the weight of a unit of the product has to be between 1 and 100.000 for
     *              gramm and ml,between 0,01 and 100 for l and kg and between 1 and 1000 for stück
     * @param weightUnit the unit of the given weight e.g. g,kg,ml,l,stück
     * @param basePrice the price for a given unit of the product,
     *                 between 0.01 and 100.000, eg. €/100g
     * @param category the category the product has been assigned to,
     *                has to be part of the category list
     *
     * @throws Exception specified at each check
     */
    public Product(String name, long id, String specialStock, double weight, String weightUnit,
                   double basePrice, String category)
            throws Exception {
        if (name.matches("[-&'äÄöÖüÜßa-zA-Z\\d](" +
                        "[-&'äÄöÖüÜßa-zA-Z\\d\\s]{0,30})[-&'äÄöÖüÜßa-zA-Z\\d]")) {
            this.name = name;
        }else {
            throw new Exception("Der Name muss 2 bis 32 Zeichen lang sein." +
                    " Ihre Eingabe " + name + " war fehlerhaft.");
        }

        String number = String.valueOf(id);
        if (number.length() == 13 || number.length() == 8
                || number.length() == 4 || (number.length() == 5
                && number.regionMatches(0,((Integer) 90000).toString(),0,1))) {
            this.id = id;
        } else {
            throw new Exception("Die ID muss eines der folgenden Formate erfuellen: " +
                    "1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9 4) 8 Stellen" +
                    " Ihre Eingabe " + id + " war fehlerhaft.");
        }

        if (specialStock.equals("n") || specialStock.equals("N")) {
            this.specialStock = specialStock;
        } else {
            throw new Exception("Der Spezialfall wird mit n oder N aufgerufen." +
                    " Ihre Eingabe " + stock + " war fehlerhaft.");
        }

        if(basePrice<=100000 && basePrice>=0.01){
            this.basePrice = basePrice;
        } else {
            throw new Exception("Der Grundpreis muss im Bereich von einschließlich 0.01 bis" +
                    " einschließlich 100.000 liegen." +
                    " Ihr aktueller Grundpreis lautet: " + basePrice);
        }

        this.weightUnit = weightUnit;

        switch(weightUnit){
            case "g":
            case "ml":
                if (weight >=1 && weight <= 100000){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + weightUnit + " muss im Bereich von" +
                            " einschließlich 1 bis einschließlich 100.000 liegen." +
                            " Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                break;

            case "kg":
            case "l":
                if (weight >= 0.1 && weight <= 100){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + weightUnit + " muss im Bereich von" +
                            " einschließlich 0,1 bis einschließlich 100 liegen." +
                            " Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                if(basePrice <= 100000 && basePrice >= 0.01) {
                    this.basePrice = basePrice;
                } else {
                    throw new Exception("Der Grundpreis muss im Bereich von einschließlich 0,01" +
                            " bis einschließlich 100.000 liegen, " +
                            "Ihr aktueller Grundpreis lautet: " + price / weight * 1);
                }
        }
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
        if(name.matches("[-&'äÄöÖüÜßa-zA-Z\\d](" +
                "[-&'äÄöÖüÜßa-zA-Z\\d\\s]{0,30})[-&'äÄöÖüÜßa-zA-Z\\d]")) {
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
        if (number.length() == 13 || number.length() == 8
                || number.length() == 4 || (number.length() == 5
                && number.regionMatches(0,((Integer) 90000).toString(),0,1))) {
            this.id = id;
        } else {
            throw new Exception("Die ID muss eines der folgenden Formate erfuellen: " +
                    "1) 13 Stellen oder 2) 4 Stellen oder 3) 5 Stellen mit führender 9." +
                    " Ihre Eingabe " + id + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the stock of the product.
     * The stock must be a int, has to be between 0 and 1000
     * Throws an exception if the stock does not meet these requirements or the special case is
     * activated for that product.
     *
     * @param stock the stock of the product, has to be between 0 and 1000
     * @throws Exception if the stock is smaller then 0 or greater then 1000 or special case is
     *                   activated
     */
    public void setStock(int stock) throws Exception {
        if (this.getSpecialStock() != null) {
            throw new Exception("Der Spezialfall ist aktiviert." +
                    " Diese Operation ist nicht möglich.");
        } else if (stock >= 0 && stock <= 1000) {
            this.stock = stock;
        } else {
            throw new Exception("Der Bestand muss im Bereich von einschließlich 0 bis" +
                    " einschließlich 1000 liegen." +
                    " Ihre Eingabe " + stock + " war fehlerhaft.");
        }
    }

    /**
     * Sets a new value for the weight of the product.
     * the weight of a unit of the product has to be between 1 and 100.000 for gramm and ml,
     * between 0,01 and 100 for l and kg and between 1 and 1.000 for stück
     *
     * @param weight the weight of one unit of this product
     * @throws Exception if the weight is exceeds the respective weightUnit
     */
    public void setWeight(double weight) throws Exception {
        switch(this.weightUnit){
            case "g":
            case "ml":
                if (weight >= 1 && weight <= 100000){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + this.weightUnit + " muss im Bereich" +
                            " 1 bis 100.000 liegen." +
                            " Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                break;

            case "kg":
            case "l":
                if (weight >= 0.1 && weight <= 100){
                    this.weight = weight;
                } else {
                    throw new Exception("Das Gewicht in " + this.weightUnit + " muss im Bereich" +
                            " 0,1 bis 100 liegen. Ihre Eingabe " + weight + " war fehlerhaft.");
                }
                break;
            case "stück":
                if(weight >= 1 && weight <= 1000){
                    this.weight = weight;
                }
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
    public void setPrice(double price) throws Exception {
            if (price >= 0.01 && price <= 100000) {
                this.price = price;
            } else {
                throw new Exception("Der Preis muss im Bereich zwischen 0.01 und 100.000 liegen." +
                        " Ihre Eingabe " + price + " war fehlerhaft.");
            }
    }

    /**
     * Sets a new value for the base price of the product.
     * The base price must be a double 0.01 - 100.000
     * Throws an exception if the basePrice does not meet these requirements.
     *
     * @param basePrice the price charged for a fixed amount of this product
     * @throws Exception if the basePrice is less then 0.01 or greater then 100000 or special case
     *                   is not activated
     */
    public void setBasePrice(double basePrice) throws Exception {
        if (this.getSpecialStock() == null) {
            throw new Exception("Der Spezialfall ist nicht aktiviert." +
                    " Diese Operation ist nicht möglich.");
        } else if (basePrice<=100000 && basePrice>=0.01) {
            this.basePrice = basePrice;
        } else {
            throw new Exception("Der Grundpreis muss zwischen 0.01 und 100.000 liegen." +
                    "Ihre Eingabe " + basePrice + " war fehlerhaft.");
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

    /**
     * Returns the used weight unit, e.g. g/kg/ml/l/stück
     *
     * @return the weight unit by which the product is measured
     */
    public String getWeightUnit() {
        return this.weightUnit;
    }

    /**
     * Returns the specialStock, has to be n or N
     *
     * @return the value n or N that indicates that the special case ist activated
     */
    public String getSpecialStock() {
        return this.specialStock;
    }

    /**
     * Returns a string of all product attributes.
     *
     * @return a concatenation of all product attributes as a string
     */
    public String toString() {
        if (this.getSpecialStock() == null) {
            return this.getId() + " " + this.getName() + " " + this.getPrice() + " " +  this.getStock()
                    + " " + this.getCategory() + " " +  this.getBasePrice() + "€ " + this.getWeight()
                    + "" + this.getWeightUnit();
        } else {
            return this.getId() + " " + this.getName() + " " + this.getPrice() + " " +  this.getSpecialStock()
                    + " " + this.getCategory() + " " +  this.getBasePrice() + "€ " + this.getWeight()
                    + "" + this.getWeightUnit();
        }
    }

    /**
     * Compares two products with another
     *
     * @param o an object to compare with a given product object
     * @return true if the object is the same as the product
     */
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        // field comparison
        return Objects.equals(this.getName(), product.getName())
                && Objects.equals(this.getId(), product.getId())
                && Objects.equals(this.getStock(), product.getStock())
                && Objects.equals(this.getWeight(), product.getWeight())
                && Objects.equals(this.getBasePrice(), product.getBasePrice())
                && Objects.equals(this.getSpecialStock(), product.getSpecialStock())
                && Objects.equals(this.getPrice(), product.getPrice())
                && Objects.equals(this.getWeightUnit(), product.getWeightUnit())
                && Objects.equals(this.getCategory(), product.getCategory());
    }
}