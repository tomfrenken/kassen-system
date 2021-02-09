package kassenSystem.app;

import kassenSystem.controller.*;
import kassenSystem.model.AdminLogin;
import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.model.PurchaseList;
import kassenSystem.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main application that connects all MVC parts together.
 */
public class Main extends JFrame implements ActionListener {
    ProductList productListModel = new ProductList();
    CategoryList categoryListModel = new CategoryList();
    AdminLogin adminLogin = new AdminLogin();
    PurchaseList purchaseListModel = new PurchaseList();

    private final LoginView loginView = new LoginView("Startmenü");
    private final AdminLoginView adminLoginView = new AdminLoginView("Administrator Login");
    private final AdminView adminView = new AdminView("Administratorenoberfläche");
    private final ChangeProductView changeProductView = new ChangeProductView("Produkt ändern");
    private final CategoryListView categoryListView = new CategoryListView("Kategorieliste");
    private final AddProductView addProductView = new AddProductView("Produkt hinzufügen");
    private final SellerView sellerView = new SellerView("Verkäuferoberfläche");
    private final FinishPurchaseView finishPurchaseView = new FinishPurchaseView("Einkauf abschließen");

    LoginController loginController = new LoginController(loginView);
    AdminLoginController adminLoginController = new AdminLoginController(adminLoginView, adminLogin);
    AdminController adminController = new AdminController(adminView, productListModel);
    ChangeProductController changeProductController = new ChangeProductController(changeProductView, productListModel);
    CategoryListController categoryListController = new CategoryListController(categoryListView, categoryListModel);
    AddProductController addProductController = new AddProductController(addProductView);
    SellerController sellerController = new SellerController(sellerView, purchaseListModel);
    FinishPurchaseController finishPurchaseController = new FinishPurchaseController(finishPurchaseView, purchaseListModel);

    /**
     * Main is only initialized with the eventlisteners to chain all other MVC parts together
     */
    Main(){
        loginController.addActionsListeners(this);
        adminController.addActionsListeners(this);
        adminLoginController.addActionsListeners(this);
        categoryListController.addActionsListeners(this);
        sellerController.addActionsListeners(this);
    }

    /**
     * initializes main and opens the login view
     * @param args have no purpose
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.loginController.fillCategoryList();
        main.loginController.fillProductList();
        main.addProductController.fillCategoryBox();

        main.addProductView.addWindowListener(main.adminView.adminController);
        main.changeProductView.addWindowListener(main.adminView.adminController);
        main.categoryListView.addWindowListener(main.adminView.adminController);

        main.loginController.showView();
    }

    /**
     * Reacts to the press of buttons that should open different views.
     * @param e is the next view to open
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "adminLoginView":
                adminLoginController.showView();
                break;
            case "adminView":
                adminController.showView();
                adminLoginController.hideView();
                break;
            case "addProductView":
                addProductController.showView();
                break;
            case "changeProductView":
                changeProductController.showView();
                break;
            case "categoryListView":
                categoryListController.showView();
                break;
            case "sellerView":
                sellerController.showView();
                break;
            case "finishPurchaseView":
                finishPurchaseController.showView();
                break;
        }
    }
}