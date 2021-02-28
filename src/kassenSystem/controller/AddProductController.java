package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.view.AddProductView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The controller to connect the AddProductView and the ProductListModel.
 */
public class AddProductController implements ActionListener, WindowListener {

    private final AddProductView view;
    private final CategoryList categoryListModel;
    private final ProductList productListModel;


    /**
     * The controller is initialized with the categoryListModel and the productListModel,
     * as well as the addProductView.
     *
     * @param view              the addProductView
     * @param categoryListModel the categoryListModel
     * @param productListModel  the productListModel
     */
    public AddProductController(AddProductView view, CategoryList categoryListModel,
                                ProductList productListModel) {
        this.view = view;
        this.categoryListModel = categoryListModel;
        this.productListModel = productListModel;
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

    /**
     * Fill the Dropdown menu in changeProductView with all categories,
     * currently in the categoryList.
     */
    public void fillCategoryBox() {
        this.view.categoryBox.removeAllItems();
        for(String category : this.categoryListModel.getCategoryList()) {
            this.view.categoryBox.addItem(category);
        }
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.view.confirmButton){
            try{
                if(this.view.stockField.getText().equals("n")){
                    this.productListModel.addProduct(this.view.nameField.getText(),
                            Long.parseLong(this.view.idField.getText()),
                            this.view.stockField.getText(),
                            Double.parseDouble(this.view.weightField.getText()),
                            (String)this.view.weightUnitBox.getSelectedItem(),
                            Double.parseDouble(this.view.priceField.getText()),
                            (String)this.view.categoryBox.getSelectedItem());
                } else {
                    this.productListModel.addProduct(this.view.nameField.getText(),
                            Long.parseLong(this.view.idField.getText()),
                            Integer.parseInt(this.view.stockField.getText()),
                            Double.parseDouble(this.view.weightField.getText()),
                            (String)this.view.weightUnitBox.getSelectedItem(),
                            Double.parseDouble(this.view.priceField.getText()),
                            (String)this.view.categoryBox.getSelectedItem());
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
        this.hideView();
    }

    /**
     * Invoked the first time a window is made visible.
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     */
    @Override
    public void windowClosing(WindowEvent e) {

    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
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
        this.fillCategoryBox();
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