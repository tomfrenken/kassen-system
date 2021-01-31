package kassenSystem.controller;

import kassenSystem.model.PurchaseList;
import kassenSystem.view.SellerView;

/**
 * The controller to connect the ChangeProductView and the ProductList.
 */
public class SellerViewController {
    private SellerView view;
    private PurchaseList model;

    /**
     * The controller is initialized with the view and model.
     * @param view the SellerView
     * @param model the PurchaseList
     */
    SellerViewController(SellerView view, PurchaseList model){
        this.view = view;
        this.model = model;
    }
}
