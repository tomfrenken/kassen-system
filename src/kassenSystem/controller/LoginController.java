package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.view.LoginView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The controller to connect the loginView and the adminLoginModel.
 */
public class LoginController implements WindowListener {

    private final LoginView view;
    private final CategoryList categoryListModel = new CategoryList();
    private final ProductList productListModel = new ProductList();

    /**
     * The controller is initialized only with the LoginView.
     *
     * @param view the LoginView
     */
    public LoginController(LoginView view){
        this.view = view;
    }

    /**
     * The actionlisteners to add to the views for interaction.
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
        view.setVisible(true);
    }

    /**
     * Hides the view.
     */
    public void hideView(){
        view.setVisible(false);
    }

    /**
     * Loads the categories from the category database to the categoryList.
     */
    public void fillCategoryList() {
        try {
            categoryListModel.loadFromCategoryDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Loads the products from the product database to the productList.
     */
    public void fillProductList() {
        try {
            this.productListModel.loadFromProductDatabase();
            this.productListModel.sortById();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Invoked the first time a window is made visible.
     */
    @Override
    public void windowOpened(WindowEvent e) {
        this.fillCategoryList();
        this.fillProductList();
    }

    /**
     * Invoked when the user attempts to close the window from the window's system menu.
     */
    @Override
    public void windowClosing(WindowEvent e) {
        try {
            this.productListModel.saveToProductDatabase();
            this.categoryListModel.saveToCategoryDatabase();
        } catch(Exception exception){
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    /**
     * Invoked when a window has been closed as the result of calling dispose on the window.
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window
     * is displayed as the icon specified in the window's
     * iconImage property.
     *
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
