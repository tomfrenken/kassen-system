package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.ChangeProductView;

import java.awt.event.ActionListener;

/**
 * The controller to connect the ChangeProductView and the ProductList.
 */
public class ChangeProductViewController {
    private final ChangeProductView view;
    private final ProductList model;

    /**
     * The controller is initialized with the view and model.
     * @param view ChangeProductView
     * @param model ProductList
     */
    public ChangeProductViewController(ChangeProductView view, ProductList model) {
        this.view = view;
        this.model = model;
    }

    /**
     * the actionlisteners to add to the views for interaction.
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
}
