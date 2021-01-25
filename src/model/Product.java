package src.model;

class Product {
    String name;
    int id;
    int stock;
    float weight;
    float price;
    float baseprice;

    //create new product
    Product(String nameInit, int idInit, int stockInit, float weightInit, float priceInit, float basepriceInit)
    {
        name = nameInit;
        id = idInit;
        stock = stockInit;
        weight = weightInit;
        price = priceInit;
        baseprice = basepriceInit;
    }
}