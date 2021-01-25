package src.model;

public class Item {
    private Product product;
    private int amount;
    
    // Create a new PurchaseObject
    PurchaseObject(String name, int id, int amount)
    {
        this.name = name;
        this.id = id;
        this.amount = amount;
    }
    // Set a new value for amount
    public void setAmount(int newAmount)
    {
        this.amount = newAmount;
    }

    // Set a new value for id
    public void setId(int newId)
    {
        this.id = newId;
    }

    // Request the current value for name
    public String getName()
    {
        return name;
    }

    // Request the current value for amount
    public int getAmount()
    {
        return amount;
    }

    // Request the current value for id
    public int getId()
    {
        return id;
    }
}
