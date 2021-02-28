package kassenSystem.view;

import javax.swing.*;
import kassenSystem.controller.AdminLoginController;
import kassenSystem.model.AdminLogin;
import java.awt.event.ActionListener;

/**
 * The view where you enter the password to access the adminView.
 */
public class AdminLoginView extends JFrame {

    private JPanel jp;
    public JPasswordField passwordField;
    public JButton loginButton;

    /**
     * The view is constructed only with a name.
     *
     * @param name the name of the view
     */
    public AdminLoginView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

        AdminLogin adminLoginModel = new AdminLogin();
        AdminLoginController adminLoginController = new AdminLoginController(
                this, adminLoginModel);

        loginButton.addActionListener(adminLoginController);
        loginButton.setActionCommand("login");
    }

    /**
     * The actionListeners to interact with the controller.
     *
     * @param actionListener adds actionListeners for the interaction with the controller
     */
    public void addActionListener(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
    }
}
