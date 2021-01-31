package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;

import java.awt.event.ActionListener;

/**
 * The controller to connect the adminView and the adminModel
 */
public class AdminViewController {
    private final AdminView view;
    private final ProductList model;

    /**
     * The controller is initialized with the view and model.
     * @param view the adminView
     * @param model the adminModel
     */
    public AdminViewController(AdminView view, ProductList model) {
        this.view = view;
        this.model = model;
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
}