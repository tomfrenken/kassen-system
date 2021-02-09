package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller to connect the adminView and the adminModel
 */
public class AdminController implements ActionListener {
    private final AdminView view;
    private final ProductList productModel;
    private final CategoryList categoryModel;

    /**
     * The Admin controller
     * @param view the admin view
     * @param productModel the productList model
     * @param categoryModel the categoryList model
     */
    public AdminController(AdminView view, ProductList productModel, CategoryList categoryModel) {
        this.view = view;
        this.categoryModel = categoryModel;
        this.productModel = productModel;
    }

    /**
     * The actionlisteners to add to the views for interaction.
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    /**
     * shows the view
     */
    public void showView(){
        this.view.setVisible(true);
    }

    /**
     * hides the view
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    public void fillCategoryList() {
        try {
            categoryModel.loadFromCategoryDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillProductList() {
        try {
            this.productModel.loadFromProductDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("deleteProduct")) {
            this.productModel.removeProduct(this.view.productListTable.getSelectedRow());
            this.productModel.fireTableStructureChanged();
        }
    }
}