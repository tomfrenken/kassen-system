package kassenSystem.controller;

import kassenSystem.model.AdminLogin;
import kassenSystem.view.AdminLoginView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller to connect the AdminLoginView and the AdminLoginModel.
 */
public class AdminLoginController implements ActionListener {

    private final AdminLoginView view;
    private final AdminLogin model;

    /**
     * The controller is initialized with the adminLoginView and adminLoginModel.
     *
     * @param view  the adminLoginView
     * @param model the adminLoginModel
     */
    public AdminLoginController(AdminLoginView view, AdminLogin model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Checks if the entered password is correct.
     * Throws Exception if a wrong password was entered.
     *
     * @param password   the password that is being checked
     * @throws Exception if the password was wrong
     */
    public void verifyLogin(String password) throws Exception {
        model.checkPassword(password);
    }

    /**
     * Shows the view.
     */
    public void showView(){
        this.view.setVisible(true);
    }

    /**
     * Hides the view.
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    /**
     * The actionListeners to add to the views for interaction.
     *
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            try {
                this.verifyLogin(String.valueOf(this.view.passwordField.getPassword()));
                this.view.loginButton.setActionCommand("adminView");
                this.view.loginButton.doClick();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
    }
}
