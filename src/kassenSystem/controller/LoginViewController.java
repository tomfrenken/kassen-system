package kassenSystem.controller;

import kassenSystem.view.LoginView;

public class LoginViewController {
    private LoginView view;

    public LoginViewController(LoginView view){
        this.view = view;
    }

    public void showView(){
        view.setVisible(true);
    }

    public void hideView(){
        view.setVisible(false);
    }
}
