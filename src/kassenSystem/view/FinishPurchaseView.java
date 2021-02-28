package kassenSystem.view;

import kassenSystem.controller.FinishPurchaseController;
import kassenSystem.model.PurchaseList;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The view where the purchase is payed or canceled.
 */
public class FinishPurchaseView extends JFrame {

    private JScrollPane scroll;
    public JList<Object> purchaseList;
    private JPanel dueMoney;
    private JButton finishPurchaseButton;
    private JButton cancelPurchaseButton;
    public JTextField moneyField;
    private JPanel jp;
    public JLabel moneyToPay;

    /**
     * The view is constructed only with a name.
     *
     * @param name the name of the view
     */
    public FinishPurchaseView(String name, SellerView sellerView, PurchaseList purchaseListModel) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

        FinishPurchaseController finishPurchaseController = new FinishPurchaseController(this,
                sellerView, purchaseListModel);

        cancelPurchaseButton.setActionCommand("cancelPurchase");
        cancelPurchaseButton.addActionListener(finishPurchaseController);

        finishPurchaseButton.setActionCommand("finishPurchase");
        finishPurchaseButton.addActionListener(finishPurchaseController);
    }

    /**
     * Adds action listeners to the buttons.
     *
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        finishPurchaseButton.addActionListener(actionListener);
        cancelPurchaseButton.addActionListener(actionListener);
    }
}
