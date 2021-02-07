package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.model.PurchaseList;
import kassenSystem.view.AddProductView;
import kassenSystem.view.FinishPurchaseView;

import java.awt.event.ActionListener;

public class FinishPurchaseController {
    private final FinishPurchaseView view;
    private final PurchaseList model;

    /**
     * The controller is initialized with the view and model.
     * @param view the adminView
     * @param model the adminModel
     */
    public FinishPurchaseController(FinishPurchaseView view, PurchaseList model) {
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
