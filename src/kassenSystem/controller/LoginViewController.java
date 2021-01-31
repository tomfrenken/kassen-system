package kassenSystem.controller;

import kassenSystem.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller to use the LoginView
 */
public class LoginViewController {
    private final LoginView view;

    /**
     * The controller is initialized with the view.
     * @param view the LoginView.
     */
    public LoginViewController(LoginView view){
        this.view = view;
    }

    /**
     * he actionlisteners to add to the views for interaction.
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    /**
     * shows the view
     */
    public void showView(){
        view.setVisible(true);
    }

    /**
     * hides the view
     */
    public void hideView(){
        view.setVisible(false);
    }
}
