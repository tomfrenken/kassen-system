package kassenSystem.controller;

import kassenSystem.view.LoginView;
import java.awt.event.ActionListener;

/**
 * The controller to use the LoginView
 */
public class LoginController {
    private final LoginView view;

    /**
     * The controller is initialized with the view.
     * @param view the LoginView.
     */
    public LoginController(LoginView view){
        this.view = view;
    }

    /**
     * he actionlisteners to add to the views for interaction.
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.view.addActionListener(actionListener);
    }

    /**
     * shows the view
     */
    public void showView(){
        view.setVisible(true);
    }

    /**
     * hides the view
     */
    public void hideView(){
        view.setVisible(false);
    }
}
