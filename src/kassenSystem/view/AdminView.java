package kassenSystem.view;

import jdk.jfr.Category;
import kassenSystem.controller.AdminController;
import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Contains the admin view, from which you can change the products and product categories
 */
public class AdminView extends JFrame {
    private JButton newProductButton;
    private JButton changeProductButton;
    private JButton deleteProductButton;
    private JButton categoryListButton;

    private JList<Object> searchList;
    private JComboBox<String> searchSelectBox;

    public JPanel jp;
    private JList<Object> productJList;
    private JScrollPane scrollPane;

    /**
     * The constructor to intialize the view
     * @param name the name of the view
     */
    public AdminView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

        ProductList productList = new ProductList();
        CategoryList categoryList = new CategoryList();
        AdminController adminController = new AdminController(this, productList, categoryList);
        adminController.fillCategoryList();
        adminController.fillProductList();



        productJList.setListData(adminController.getProductListAsArray());

        newProductButton.setActionCommand("addProductView");
        changeProductButton.setActionCommand("changeProductView");
        deleteProductButton.setActionCommand("deleteProductView");
        categoryListButton.setActionCommand("categoryListView");
    }

    /**
     * Adds actionlisteners to the buttons, so the controller can interact with the view.
     * @param actionListener the action listeners to use with the view
     */
    public void addActionListener(ActionListener actionListener){
        newProductButton.addActionListener(actionListener);
        changeProductButton.addActionListener(actionListener);
        deleteProductButton.addActionListener(actionListener);
        categoryListButton.addActionListener(actionListener);
    }
}