package src.model;

class Product {
    String name;
    int id;
    int stock;
    float weight;
    float price;
    float basePrice;

    //create new product
    Product(String name, int id, int stock, float weight, float price, float basePrice) {
        this.name = name;
        this.id = id;
        this.stock = stock;
        this.weight = weight;
        this.price = price;
        this.basePrice = basePrice;
    }

    // Request the current value for id
    public String getName() {
        return this.name;
    }

    // Request the current value for id
    public int getId() {
        return this.id;
    }

    // Request the current value for id
    public int getStock() {
        return this.stock;
    }

    // Request the current value for id
    public float getWeight() {
        return this.weight;
    }

    // Request the current value for id
    public float getPrice() {
        return this.price;
    }

    // Request the current value for id
    public float getBasePrice() {
        return this.basePrice;
    }
}