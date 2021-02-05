package kassenSystem.view;

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

    private JList list1;
    private JComboBox comboBox1;

    public JPanel jp;
    private JTextArea ta;
    private JScrollPane sp;

    /**
     * The constructor to intialize the view
     * @param name the name of the view
     */
    public AdminView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

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