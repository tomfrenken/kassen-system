package kassenSystem.app;

import kassenSystem.view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        LoginViewController loginViewController = new LoginViewController(loginView);
    }
}