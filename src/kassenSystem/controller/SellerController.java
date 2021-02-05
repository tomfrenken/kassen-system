package kassenSystem.controller;

import kassenSystem.model.PurchaseList;
import kassenSystem.view.SellerView;

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
    SellerController(SellerView view, PurchaseList model){
        this.view = view;
        this.model = model;
    }
}
