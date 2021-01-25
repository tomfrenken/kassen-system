import java.util.ArrayList;

public class PurchaseList
{
    //subtotal of the Price all Objects in the list
    private float subtotal;
    //the PurchaseList
    private ArrayList<PurchaseObject> purchaseList; 

    //create new purchaseList
    PurchaseList()
    {
        this.purchaseList = new ArrayList<PurchaseObject>();
    }

    //add a new PurchaseObject at the end of the list
    public void newPurchaseObject(String name, int id, int amount)
    {
        if idInPurchaseList(int id) {

        }
        PurchaseObject temp = new PurchaseObject(name,idInit,amountInit);
        purchaseList.add(temp);
        this.subtotal = temp.changeSubtotalADD(subtotal);
    }
    
    //remove PurchaseObject at the specified index
    public void removePurchaseObject(int index)
    {
        PurchaseObject temp = purchaseList.get(index);
        this.subtotal = temp.changeSubtotalREM(subtotal);
        purchaseList.remove(temp);
    }

    //set a new Amount for the PurchaseObject at the specified index 
    public void chageAmount(int index, int newAmount)
    {
        PurchaseObject temp = purchaseList.get(index);
        temp.setAmount(newAmount);
        this.subtotal = temp.changeSubtotalADD(subtotal);
    }

    //clear purchaseList
    public void cancelPuchase()
    {
        purchaseList.clear();
    }

    //finish old purchase and clear purchaseList ______!!!!!!!______
    public void finishPurchase()
    {
        //return subtotal to UI
        //reduce Stock by amount
        purchaseList.clear();

    }

    public void setSubtotal(float newSubtotal)
    {
        this.subtotal = newSubtotal;
    }

    public float getSubtotal()
    {
        return subtotal;
    }
}
