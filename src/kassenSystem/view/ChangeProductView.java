package kassenSystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Contains the view to change the product
 */
public class ChangeProductView extends JFrame {
    private JTextField textField1;
    private JButton aktualisierenButton;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox2;
    private JTextField textField5;

    /**
     * The constructor to initialize the view
     * @param name the name to initialize the view with
     */
    public ChangeProductView(String name) {
        super(name);

        setLayout(new GridLayout(3, 1));
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        aktualisierenButton.setActionCommand("changeProduct");
    }

    /**
     * Adds action listeners to the buttons.
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        aktualisierenButton.addActionListener(actionListener);
    }
}
