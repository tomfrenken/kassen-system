package kassenSystem.app;

import kassenSystem.controller.*;
import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main application that connects all MVC parts together.
 */
public class Main extends JFrame implements ActionListener {
    JButton testButton;

    ProductList productListModel = new ProductList();
    CategoryList categoryListModel = new CategoryList();

    private final LoginView loginView = new LoginView("Startmenü");
    private final AdminView adminView = new AdminView("Administratorenoberfläche");
    private final ChangeProductView changeProductView = new ChangeProductView("Produkt ändern");
    private final CategoryListView categoryListView = new CategoryListView("Kategorieliste");
    private final AddProductView addProductView = new AddProductView("Produkt hinzufügen");

    LoginController loginViewController = new LoginController(loginView);
    AdminController adminViewController = new AdminController(adminView, productListModel);
    ChangeProductController changeProductViewController = new ChangeProductController(changeProductView, productListModel);
    CategoryListController categoryListController = new CategoryListController(categoryListView, categoryListModel);
    AddProductController addProductController = new AddProductController(addProductView, productListModel);


    /**
     * Main is only initialized with the eventlisteners to chain all other MVC parts together
     */
    Main(){
        loginViewController.addActionsListeners(this);
        adminViewController.addActionsListeners(this);
        changeProductViewController.addActionsListeners(this);
        categoryListController.addActionsListeners(this);
    }

    /**
     * initializes main and opens the login view
     * @param args have no purpose
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.loginViewController.showView();
    }

    /**
     * Reacts to the press of buttons that should open different views.
     * @param e is the next view to open
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "adminView":
                adminViewController.showView();
                break;
            case "addProductView":
                addProductController.showView();
                break;
            case "changeProductView":
                changeProductViewController.showView();
                break;
            case "categoryListView":
                categoryListController.showView();
                break;
            case "sellerView":
                System.out.println("Nothing to see here yet!");
                break;
        }
    }
}