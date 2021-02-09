package kassenSystem.view;

import kassenSystem.controller.AddProductController;
import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The view to add products to the product list
 */
public class AddProductView extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField5;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton bestaetigenButton;
    private JPanel jp;

    public AddProductView(String name){
        super(name);
        add(jp);
        this.setSize(1200, 800);

        AddProductController addProductController = new AddProductController(this);

        bestaetigenButton.setActionCommand("bestaetigen");
    }

    /**
     * Adds actionlisteners to the buttons, so the controller can interact with the view.
     * @param actionListener the action listeners to use with the view
     */
    public void addActionListener(ActionListener actionListener){
        bestaetigenButton.addActionListener(actionListener);
    }
}
