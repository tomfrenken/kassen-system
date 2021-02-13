package kassenSystem.view;

import kassenSystem.controller.AddProductController;
import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;

import javax.swing.*;

/**
 * The view to add products to the product list
 */
public class AddProductView extends JFrame {
    public JTextField nameField;
    public JTextField idField;
    public JTextField stockField;
    public JTextField weightField;
    public JComboBox<String> weightUnitBox;
    public JTextField priceField;
    public JComboBox<String> categoryBox;
    public JButton confirmButton;
    private JPanel jp;

    public AddProductView(String name, ProductList productListModel){
        super(name);
        add(jp);
        this.setSize(1200, 800);

        CategoryList categoryListModel = new CategoryList();
        AddProductController addProductController = new AddProductController(this, categoryListModel, productListModel);

        confirmButton.addActionListener(addProductController);
    }
}
