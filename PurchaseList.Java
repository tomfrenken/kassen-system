package SE;

import SE.PurchaseObject;
import java.util.ArrayList;

public class PurchaseList extends ArrayList<PurchaseObject>
{
    //subtotal of the Price all Objects in the list
    private float subtotal;
    //the PurchaseList
    
    //add a new PurchaseObject at the end of the list
    public void newPurchaseObject(String nameInit, int idInit, int amountInit)
    {
        PurchaseObject temp = new PurchaseObject(nameInit,idInit,amountInit);
        this.add(temp);
    }
    
    //remove PurchaseObject at the specified index
    public void removePurchaseObject(int index)
    {
        purchaseList.remove(index);
    }

    //set a new Amount for the PurchaseObject at the specified index 
    public void chageAmount(int index, int newAmount)
    {
        PurchaseObject temp = purchaseList.get(index);
        temp.setAmount(newAmount);
    }

    //destruct purchaseList and create a new one
    public void cancelPuchase()
    {

    }

    //finish old purchase and create new purchaseList
    public void finishPurchase()
    {

    }

    public void setSubtotal(float newSubtotal)
    {
        subtotal = newSubtotal;
    }

    public float getSubtotal()
    {
        return subtotal;
    }
}
