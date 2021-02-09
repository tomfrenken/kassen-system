package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The controller to use the LoginView
 */
public class LoginController {
    private final LoginView view;
    private final CategoryList categoryListModel = new CategoryList();
    private final ProductList productListModel = new ProductList();
    /**
     * The controller is initialized with the view.
     * @param view the LoginView.
     */
    public LoginController(LoginView view){
        this.view = view;
        this.fillCategoryList();
        this.fillProductList();
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

    public void fillCategoryList() {
        try {
            categoryListModel.loadFromCategoryDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillProductList() {
        try {
            this.productListModel.loadFromProductDatabase();
            this.productListModel.sortById();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
