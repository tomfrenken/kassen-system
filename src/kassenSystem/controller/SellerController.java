package kassenSystem.controller;

import kassenSystem.model.PurchaseList;
import kassenSystem.view.SellerView;

import java.awt.event.ActionListener;

/**
 * The controller to connect the SellerView and the PurchaseList.
 */
public class SellerController {
    private final SellerView view;
    private final PurchaseList model;

    /**
     * The controller is initialized with the view and model.
     * @param view the SellerView
     * @param model the PurchaseList
     */
    public SellerController(SellerView view, PurchaseList model){
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
