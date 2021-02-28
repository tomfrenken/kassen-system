package kassenSystem.controller;

import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import kassenSystem.model.PurchaseList;
import kassenSystem.view.SellerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The controller to connect the SellerView and the PurchaseListModel.
 */
public class SellerController implements ActionListener {

    private final SellerView view;
    private final PurchaseList model;

    /**
     * The controller is initialized with the SellerView and PurchaseListModel.
     *
     * @param view  the SellerView
     * @param model the PurchaseListModel
     */
    public SellerController(SellerView view, PurchaseList model){
        this.view = view;
        this.model = model;
    }

    /**
     * The actionlisteners to add to the views for interaction.
     *
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    /**
     * Shows the view.
     */
    public void showView(){
        this.view.setVisible(true);
    }

    /**
     * Hides the view.
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    /**
     * Searches the productList for a product with this name.
     * The search phrase can be a specific name of the results or it can be part of one.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of product with the same name regarding what was searched
     *                     for, or where the search phrase is part of
     */
    public ArrayList<Product> searchProductByName(String searchPhrase) {
        return this.model.searchProductByName(searchPhrase);
    }

    /**
     * Searches the productList for a product with this name or id.
     * The search phrase can be a specific name or id of the results or it can be part of one.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of product with the same name or id regarding what was searched
     *                     for, or where the search phrase is part of
     */
    public ArrayList<Product> searchProduct(String searchPhrase) {
        return this.model.searchProduct(searchPhrase);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
