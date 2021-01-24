package SE;

public class PurchaseObject
{
    String name;
    int id;
    int amount;
    
    //create new PurchaseObject
    PurchaseObject(String nameInit, int idInit, int amountInit)
    {
        this.name = nameInit;
        this.id = idInit;
        this.amount = amountInit;
    }

    //set new value for Amount
    public void setAmount(int newAmount)
    {
        amount = newAmount;
    }

    //set new value for Id
    public void setId(int newId)
    {
        id = newId;
    }

    //request the current value for Amount
    public int getAmount()
    {
        return amount;
    }

    //request the current value for Id
    public int getId()
    {
        return id;
    }

    //set new value for Subtotal from class Grocerylist
    public void changeSubtotal(float newSubtotal)
    {
        subtotal = newSubtotal;
    }
}