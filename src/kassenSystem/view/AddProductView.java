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
    private CategoryList categoryListModel;
    private ProductList productListModel;

    public AddProductView(String name, CategoryList categoryListModel, ProductList productListModel){
        super(name);
        add(jp);
        this.setSize(1200, 800);

        this.categoryListModel = categoryListModel;
        this.productListModel = productListModel;
        AddProductController addProductController = new AddProductController(this, categoryListModel, productListModel);

        confirmButton.addActionListener(addProductController);
    }
}
