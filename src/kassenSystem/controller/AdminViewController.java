package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;

public class AdminViewController {
    private AdminView view;
    private ProductList model;
    AdminViewController(AdminView view, ProductList model){
        this.view = view;
        this.model = model;
    }
    // hier kommen funktionen
}
