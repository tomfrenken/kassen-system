package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.AddProductView;

import java.awt.event.ActionListener;

public class AddProductController {
    private final AddProductView view;
    private final ProductList model;

    /**
     * The controller is initialized with the view and model.
     * @param view the adminView
     * @param model the adminModel
     */
    public AddProductController(AddProductView view, ProductList model) {
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
