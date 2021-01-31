package kassenSystem.app;

import kassenSystem.controller.LoginViewController;
import kassenSystem.view.LoginView;

public class Main {
    public static void main(String[] args) {
        // hier allgemeine übersicht erstellen von der man die anderen sichten auswählen kann
        LoginView loginView = new LoginView("LoginView");
        LoginViewController loginViewController = new LoginViewController(loginView);
        loginViewController.showView();
    }
}