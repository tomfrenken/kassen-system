package src.model;

class Product {
    String name;
    int id;
    int stock;
    float weight;
    float price;
    float baseprice;

    //create new product
    Product(String name, int id, int stock, float weight, float price, float baseprice)
    {
        this.name = name;
        this.id = id;
        this.stock = stock;
        this.weight = weight;
        this.price = price;
        this.baseprice = baseprice;
    }
}