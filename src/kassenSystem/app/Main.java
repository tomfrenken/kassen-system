package kassenSystem.app;

import kassenSystem.controller.AdminViewController;
import kassenSystem.controller.LoginViewController;
import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import kassenSystem.view.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JButton testButton;

    ProductList productListModel = new ProductList();

    private final LoginView loginView = new LoginView("Startmenü");
    private final AdminView adminView = new AdminView("AdministratorenAnsicht");

    LoginViewController loginViewController = new LoginViewController(loginView);
    AdminViewController adminViewController = new AdminViewController(adminView, productListModel);

    Main(){
        testButton = new JButton("Test");
        setLayout(new GridLayout(1,1));
        this.setSize(800, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginViewController.addActionsListeners(this);
    }

    public static void main(String[] args) {
        // hier allgemeine übersicht erstellen von der man die anderen sichten auswählen kann
        Main main = new Main();
        main.loginViewController.showView();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "adminView":
                loginViewController.hideView();
                adminViewController.showView();
            case "sellerView":
                System.out.println("Nothing to see here yet!");
        }
    }
}