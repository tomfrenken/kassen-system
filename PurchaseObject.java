public class PurchaseObject extends PurchaseList
{
    private String name;
    private int id;
    private int amount;
    
    //create new PurchaseObject
    PurchaseObject(String nameInit, int idInit, int amountInit)
    {
        this.name = nameInit;
        this.id = idInit;
        this.amount = amountInit;
    }

    //calculate new value for Subtotal from class purchaseList when adding an object from the list  ______!!!!!!!______
    public float changeSubtotalADD(float oldSubtotal)
    {
        float subtotal = oldSubtotal;
        subtotal = subtotal + (/*price **/ amount);
        return subtotal;
    }

    //calculate new value for Subtotal from class purchaseList when removing an object from the list  ______!!!!!!!______
    public float changeSubtotalREM(float oldSubtotal)
    {
        float subtotal = oldSubtotal;
        subtotal = subtotal - (/*price **/ amount);
        return subtotal;
    }

    //set new value for Amount
    public void setAmount(int newAmount)
    {
        this.amount = newAmount;
    }

    //set new value for Id
    public void setId(int newId)
    {
        this.id = newId;
    }

    //request the current value for Name
    public String getName()
    {
        return name;
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
}
