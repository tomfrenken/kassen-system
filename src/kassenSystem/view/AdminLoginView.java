package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminLoginView extends JFrame {
    private JPasswordField passwordField1;
    private JPanel jp;
    private JButton loginButton;

    public AdminLoginView(String name) {
        super(name);
        add(jp);
        loginButton.setActionCommand("adminView");
    }

    /**
     * Adds action listeners to the buttons.
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        loginButton.addActionListener(actionListener);
    }
}
