package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import kassenSystem.view.LoginView;

import java.awt.event.ActionListener;

public class AdminViewController {
    private final AdminView view;
    private final ProductList model;

    public AdminViewController(AdminView view, ProductList model) {
        this.view = view;
        this.model = model;
    }

    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    public void showView(){
        view.setVisible(true);
    }

    public void hideView(){
        view.setVisible(false);
    }
}