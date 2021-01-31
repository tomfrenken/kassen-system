package kassenSystem.controller;

import kassenSystem.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewController {
    private final LoginView view;

    public LoginViewController(LoginView view){
        this.view = view;
    }

    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    public void showView(){
        view.setVisible(true);
    }

    public void hideView(){
        view.setVisible(false);
    }
}
