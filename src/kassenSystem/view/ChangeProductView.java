package kassenSystem.view;

import kassenSystem.controller.ChangeProductController;
import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Contains the view to change a product.
 */
public class ChangeProductView extends JFrame {

    private JButton changeButton;
    private JPanel jp;
    public JTextField idField;
    public JTextField nameField;
    public JTextField priceField;
    public JTextField stockField;
    public JTextField weightField;
    public JComboBox<String> weightUnitBox;
    public AdminView adminView;
    public JComboBox<String> categoryBox;

    /**
     * The view is constructed with a name, the adminView and the productList.
     *
     * @param name             the name of the frame
     * @param adminView        the adminView
     * @param productListModel the productList
     */
    public ChangeProductView(String name, AdminView adminView, ProductList productListModel) {
        super(name);
        this.adminView = adminView;
        add(jp);
        this.setSize(1200, 800);

        CategoryList categoryListModel = new CategoryList();
        ChangeProductController changeProductController = new ChangeProductController(
                this, adminView, categoryListModel, productListModel);

        changeButton.setActionCommand("changeProduct");
        changeButton.addActionListener(changeProductController);
    }

    /**
     * Adds action listeners to the buttons.
     *
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        changeButton.addActionListener(actionListener);
    }
}
