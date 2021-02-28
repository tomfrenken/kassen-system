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

    private JList<Item> purchaseList;
    private JScrollPane scroll;
    public JTextField searchProductField;
    private JButton addItemButton;
    public JList<Product> searchProductList;
    private JScrollPane scroll2;
    private JTextField amountField;
    private JTextField customerSearchField;
    private JList<Item> customerSearchList;
    private JScrollPane scroll3;
    private JButton cancelPurchaseButton;
    private JButton finishPurchaseButton;
    private JPanel zwischensumme;
    private JButton cancelItemButton;
    private JButton changeAmountButton;
    private JPanel jp;
    private JButton searchProductButton;
    private JButton customerSearchButton;
    private JTextField changeAmountField;
    private JLabel subtotal;
    public SellerController sellerController;

    /**
     * The view is constructed only with a name.
     *
     * @param name the name of the view
     */
    public SellerView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

        PurchaseList purchaseListModel = new PurchaseList();
        sellerController = new SellerController(this, purchaseListModel);

        cancelItemButton.setActionCommand("cancelItem");
        cancelItemButton.addActionListener(sellerController);

        changeAmountButton.setActionCommand("changeAmount");
        changeAmountButton.addActionListener(sellerController);

        searchProductButton.setActionCommand("searchProduct");
        searchProductButton.addActionListener(sellerController);


        customerSearchButton.setActionCommand("customerSearch");
        customerSearchButton.addActionListener(sellerController);


        finishPurchaseButton.setActionCommand("finishPurchaseView");
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
