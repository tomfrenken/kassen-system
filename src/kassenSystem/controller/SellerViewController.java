package kassenSystem.controller;

import kassenSystem.model.PurchaseList;
import kassenSystem.view.SellerView;

public class SellerViewController {
    private SellerView view;
    private PurchaseList model;

    SellerViewController(SellerView view, PurchaseList model){
        this.view = view;
        this.model = model;
    }

    public void updateView(){
    }
}
