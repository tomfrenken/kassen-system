package kassenSystem.view;

import kassenSystem.controller.SellerController;
import kassenSystem.model.Item;
import kassenSystem.model.Product;
import kassenSystem.model.PurchaseList;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The view which the seller uses to sell the goods.
 */
public class SellerView extends JFrame {

    public JList<Object> purchaseList;
    private JScrollPane scroll;
    public JTextField searchProductField;
    private JButton addItemButton;
    public JList<Object> searchProductList;
    private JScrollPane scroll2;
    public JTextField amountField;
    public JTextField customerSearchField;
    public JList<Object> customerSearchList;
    private JScrollPane scroll3;
    private JButton cancelPurchaseButton;
    private JButton finishPurchaseButton;
    private JPanel sbTotal;
    private JButton cancelItemButton;
    private JButton changeAmountButton;
    private JPanel jp;
    public JButton searchProductButton;
    private JButton customerSearchButton;
    public JTextField changeAmountField;
    public JLabel subtotalValue;
    public SellerController sellerController;

    /**
     * The view is constructed with a name and the purchaseListModel.
     *
     * @param name the name of the view
     */
    public SellerView(String name, PurchaseList purchaseListModel) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

        sellerController = new SellerController(this, purchaseListModel);

        cancelItemButton.setActionCommand("cancelItem");
        cancelItemButton.addActionListener(sellerController);

        changeAmountButton.setActionCommand("changeAmount");
        changeAmountButton.addActionListener(sellerController);

        searchProductButton.setActionCommand("searchProduct");
        searchProductButton.addActionListener(sellerController);

        addItemButton.setActionCommand("addItem");
        addItemButton.addActionListener(sellerController);

        customerSearchButton.setActionCommand("customerSearch");
        customerSearchButton.addActionListener(sellerController);

        cancelPurchaseButton.setActionCommand("cancelPurchase");
        cancelPurchaseButton.addActionListener(sellerController);

        finishPurchaseButton.setActionCommand("finishPurchaseView");

        subtotalValue.setText("00,00€");
    }

    /**
     * The actionListeners to interact with the controller.
     *
     * @param actionListener adds actionListeners for the interaction with the controller
     */
    public void addActionListener(ActionListener actionListener){
        finishPurchaseButton.addActionListener(actionListener);
    }
}
