package kassenSystem.controller;

import kassenSystem.model.AdminLogin;
import kassenSystem.view.AdminLoginView;

import java.awt.event.ActionListener;

public class AdminLoginController {
    private final AdminLoginView view;
    private final AdminLogin model;

    /**
     * The controller is initialized with the view and model.
     * @param view the adminView
     * @param model the adminModel
     */
    public AdminLoginController(AdminLoginView view, AdminLogin model) {
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
