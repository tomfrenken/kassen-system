package kassenSystem.app;

import kassenSystem.controller.AdminViewController;
import kassenSystem.controller.ChangeProductViewController;
import kassenSystem.controller.LoginViewController;
import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import kassenSystem.view.ChangeProductView;
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
    private final ChangeProductView changeProductView = new ChangeProductView("Produkt ändern");

    LoginViewController loginViewController = new LoginViewController(loginView);
    AdminViewController adminViewController = new AdminViewController(adminView, productListModel);
    ChangeProductViewController changeProductViewController = new ChangeProductViewController(changeProductView, productListModel);

    Main(){
        loginViewController.addActionsListeners(this);
        adminViewController.addActionsListeners(this);
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
            case "changeProductView":
                adminViewController.hideView();
                changeProductViewController.showView();
            case "changeCategoryView":
            case "sellerView":
                System.out.println("Nothing to see here yet!");
        }
    }
}