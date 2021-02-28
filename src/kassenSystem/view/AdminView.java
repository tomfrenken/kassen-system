package kassenSystem.view;

import kassenSystem.controller.AdminController;
import kassenSystem.model.ProductList;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Contains the adminView, from which you can change the products and product categories.
 */
public class AdminView extends JFrame {

    private JButton newProductButton;
    private JButton changeProductButton;
    private JButton deleteProductButton;
    private JButton categoryListButton;
    private JScrollPane scrollPane;
    private ProductList productListModel;
    public JList<Object> searchList;
    public JPanel jp;
    public JTable productListTable;
    public JTextField searchField;
    public JButton searchButton;
    public AdminController adminController;

    /**
     * The view is constructed with a name and the productList.
     *
     * @param name             the name of the frame
     * @param productListModel the productList
     */
    public AdminView(String name, ProductList productListModel) {
        super(name);
        add(jp);
        this.setSize(1920, 800);

        this.productListModel = productListModel;
        adminController = new AdminController(this, productListModel);

        productListTable.setModel(productListModel);
        productListTable.getTableHeader().addMouseListener(adminController);

        searchButton.setActionCommand("searchProduct");
        searchButton.addActionListener(adminController);
        newProductButton.setActionCommand("addProductView");
        changeProductButton.setActionCommand("changeProductView");
        deleteProductButton.setActionCommand("deleteProduct");
        deleteProductButton.addActionListener(adminController);

        categoryListButton.setActionCommand("categoryListView");
    }

    /**
     * Adds actionListeners to the buttons, so the controller can interact with the view.
     *
     * @param actionListener the action listeners to use with the view
     */
    public void addActionListener(ActionListener actionListener){
        newProductButton.addActionListener(actionListener);
        changeProductButton.addActionListener(actionListener);
        categoryListButton.addActionListener(actionListener);
    }
}