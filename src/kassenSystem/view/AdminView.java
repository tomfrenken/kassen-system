package kassenSystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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

        setLayout(new GridLayout(3, 1));
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newProductButton.setActionCommand("newProductView");
        changeProductButton.setActionCommand("changeProductView");
        deleteProductButton.setActionCommand("deleteProductView");
        categoryListButton.setActionCommand("categoryListView");
    }

    /**
     * Adds actionlisteners to the buttons, so the controller can interact with the view.
     * @param actionListener the actionlisteners to use with the view
     */
    public void addActionListener(ActionListener actionListener){
        newProductButton.addActionListener(actionListener);
        changeProductButton.addActionListener(actionListener);
        deleteProductButton.addActionListener(actionListener);
        categoryListButton.addActionListener(actionListener);
    }
}