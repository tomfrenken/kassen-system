package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.model.PurchaseList;
import kassenSystem.view.FinishPurchaseView;
import java.awt.event.ActionListener;

/**
 * The controller to connect the finishPurchaseView and the finishPurchaseModel
 */
public class FinishPurchaseController {

    private final FinishPurchaseView view;
    private final PurchaseList model;

    /**
     * The controller is initialized with the finishPurchaseView and purchaseListModel.
     *
     * @param view  the finishPurchaseView
     * @param model the purchaseListModel
     */
    public FinishPurchaseController(FinishPurchaseView view, PurchaseList model) {
        this.view = view;
        this.model = model;
    }

    /**
     * The actionListeners to add to the views for interaction.
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
}
