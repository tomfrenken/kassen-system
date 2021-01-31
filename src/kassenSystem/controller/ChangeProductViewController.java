package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import kassenSystem.view.ChangeProductView;

import java.awt.event.ActionListener;

public class ChangeProductViewController {
    private final ChangeProductView view;
    private final ProductList model;

    public ChangeProductViewController(ChangeProductView view, ProductList model) {
        this.view = view;
        this.model = model;
    }

    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    public void showView(){
        this.view.setVisible(true);
    }

    public void hideView(){
        this.view.setVisible(false);
    }
}
