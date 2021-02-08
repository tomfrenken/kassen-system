package kassenSystem.view;

import javax.swing.*;
import kassenSystem.controller.AdminLoginController;
import kassenSystem.model.AdminLogin;

import java.awt.event.ActionListener;

public class AdminLoginView extends JFrame {
    private JPanel jp;
    public JPasswordField passwordField;
    public JButton loginButton;
    public JButton loginSuccessButton = new JButton();

    public AdminLoginView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);

        AdminLogin adminLoginModel = new AdminLogin();
        AdminLoginController adminLoginController = new AdminLoginController(this, adminLoginModel);

        loginButton.addActionListener(adminLoginController);
        loginSuccessButton.setActionCommand("adminView");
    }

    public void addActionListener(ActionListener actionListener) {
        loginSuccessButton.addActionListener(actionListener);
    }
}
