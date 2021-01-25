package src.model;

public class Item {
    private Product product;
    private int amount;
    
    // Create a new PurchaseObject
    Item(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    // Set a new value for amount
    public void setAmount(int amount)
    {
        this.amount = amount;
    }


    // Request the current value for name
    public String getProduct()
    {
        return this.product;
    }

    // Request the current value for amount
    public int getAmount()
    {
        return this.amount;
    }

    // Request the current value for id
    public int getId()
    {
        return id;
    }
}
