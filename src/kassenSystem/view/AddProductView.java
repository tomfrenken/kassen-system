package kassenSystem.view;

import kassenSystem.controller.AddProductController;
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

    public AddProductView(String name){
        super(name);
        add(jp);
        this.setSize(1200, 800);

        AddProductController addProductController = new AddProductController(this);

        confirmButton.addActionListener(addProductController);
    }
}
