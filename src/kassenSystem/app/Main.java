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

/**
 * The main application that connects all MVC parts together.
 */
public class Main extends JFrame implements ActionListener {
    JButton testButton;

    ProductList productListModel = new ProductList();

    private final LoginView loginView = new LoginView("Startmenü");
    private final AdminView adminView = new AdminView("AdministratorenAnsicht");
    private final ChangeProductView changeProductView = new ChangeProductView("Produkt ändern");

    LoginViewController loginViewController = new LoginViewController(loginView);
    AdminViewController adminViewController = new AdminViewController(adminView, productListModel);
    ChangeProductViewController changeProductViewController = new ChangeProductViewController(changeProductView, productListModel);

    /**
     * Main is only initialized with the eventlisteners to chain all other MVC parts together
     */
    Main(){
        loginViewController.addActionsListeners(this);
        adminViewController.addActionsListeners(this);
    }

    /**
     * initalizees main and opens the login view
     * @param args have no purpose
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.loginViewController.showView();
    }

    /**
     * Reacts to the press of buttons that should open different views.
     *
     * @param e is the next view to open
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "adminView":
                loginViewController.hideView();
                adminViewController.showView();
            case "changeProductView":
                changeProductViewController.showView();
            case "changeCategoryView":
            case "sellerView":
                System.out.println("Nothing to see here yet!");
        }
    }
}