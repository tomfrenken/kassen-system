package kassenSystem.controller;

import kassenSystem.model.AdminLogin;
import kassenSystem.view.AdminLoginView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginController implements ActionListener {
    private final AdminLoginView view;
    private final AdminLogin model;

    /**
     * The controller is initialized with the view and model.
     * @param view the adminView
     * @param model the adminModel
     */
    public AdminLoginController(AdminLoginView view, AdminLogin model) {
        this.view = view;
        this.model = model;
    }

    public void verifyLogin(String password) throws Exception {
        model.checkPassword(password);
    }

    /**
     * shows the view
     */
    public void showView(){
        this.view.setVisible(true);
    }

    /**
     * hides the view
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.loginButton) {
            try {
                this.verifyLogin(String.valueOf(this.view.passwordField.getPassword()));
                this.view.loginSuccessButton.doClick();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
    }
}
