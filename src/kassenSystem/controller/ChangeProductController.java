package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import kassenSystem.view.ChangeProductView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The controller to connect the ChangeProductView and the ProductList.
 */
public class ChangeProductController implements ActionListener, WindowListener {
    private final AdminView adminView;
    private final ChangeProductView changeProductView;
    private final CategoryList categoryListModel;
    private final ProductList productListModel;

    /**
     * The controller is initialized with the view and model.
     * @param changeProductView ChangeProductView
     * @param categoryListModel ProductList
     */
    public ChangeProductController(ChangeProductView changeProductView, AdminView adminView, CategoryList categoryListModel, ProductList productListModel) {
        this.changeProductView = changeProductView;
        this.adminView = adminView;
        this.categoryListModel = categoryListModel;
        this.productListModel = productListModel;
    }

    /**
     * the actionlisteners to add to the views for interaction.
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.changeProductView.addActionListener(actionListener);
    }

    /**
     * shows the view
     */
    public void showView(){
        this.changeProductView.setVisible(true);
    }

    /**
     * hides the view
     */
    public void hideView(){
        this.changeProductView.setVisible(false);
    }

    public void fillCategoryBox() {
        this.changeProductView.categoryBox.removeAllItems();
        for(String category : this.categoryListModel.getCategoryList()) {
            this.changeProductView.categoryBox.addItem(category);
        }
    }

    public void fillAllFields() {
        if (this.adminView.productListTable.getSelectedRow() == -1) {
            Product selectedProduct = (Product) this.adminView.searchList.getSelectedValue();
            if (selectedProduct.getSpecialStock() == null) {
                this.changeProductView.nameField.setText(selectedProduct.getName());
                this.changeProductView.idField.setText(Long.toString(selectedProduct.getId()));
                this.changeProductView.stockField.setText(Integer.toString(selectedProduct.getStock()));
                this.changeProductView.weightField.setText(Double.toString(selectedProduct.getWeight()));
                this.changeProductView.weightUnitBox.setSelectedItem(selectedProduct.getWeightUnit());
                this.changeProductView.priceField.setText(Double.toString(selectedProduct.getPrice()));
                this.changeProductView.categoryBox.setSelectedItem(selectedProduct.getCategory());
            } else {
                this.changeProductView.nameField.setText(selectedProduct.getName());
                this.changeProductView.idField.setText(Long.toString(selectedProduct.getId()));
                this.changeProductView.stockField.setText(selectedProduct.getSpecialStock());
                this.changeProductView.weightField.setText(Double.toString(selectedProduct.getWeight()));
                this.changeProductView.weightUnitBox.setSelectedItem(selectedProduct.getWeightUnit());
                this.changeProductView.priceField.setText(Double.toString(selectedProduct.getBasePrice()));
                this.changeProductView.categoryBox.setSelectedItem(selectedProduct.getCategory());
            }
        } else {
            Product selectedProduct = this.productListModel
                    .getProduct(this.adminView.productListTable.getSelectedRow());
            if (selectedProduct.getSpecialStock() == null) {
                this.changeProductView.nameField.setText(selectedProduct.getName());
                this.changeProductView.idField.setText(Long.toString(selectedProduct.getId()));
                this.changeProductView.stockField.setText(Integer.toString(selectedProduct.getStock()));
                this.changeProductView.weightField.setText(Double.toString(selectedProduct.getWeight()));
                this.changeProductView.weightUnitBox.setSelectedItem(selectedProduct.getWeightUnit());
                this.changeProductView.priceField.setText(Double.toString(selectedProduct.getPrice()));
                this.changeProductView.categoryBox.setSelectedItem(selectedProduct.getCategory());
            } else {
                this.changeProductView.nameField.setText(selectedProduct.getName());
                this.changeProductView.idField.setText(Long.toString(selectedProduct.getId()));
                this.changeProductView.stockField.setText(selectedProduct.getSpecialStock());
                this.changeProductView.weightField.setText(Double.toString(selectedProduct.getWeight()));
                this.changeProductView.weightUnitBox.setSelectedItem(selectedProduct.getWeightUnit());
                this.changeProductView.priceField.setText(Double.toString(selectedProduct.getBasePrice()));
                this.changeProductView.categoryBox.setSelectedItem(selectedProduct.getCategory());
            }
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("changeProduct")){
            try{
                if(this.adminView.productListTable.getSelectedRow() == -1){
                    int productIndex = this.productListModel.getProductList()
                            .indexOf((Product)this.adminView.searchList.getSelectedValue());
                    if(this.changeProductView.stockField.getText().equals("n")){
                        this.productListModel.changeProduct(productIndex,
                                this.changeProductView.nameField.getText(),
                                Long.parseLong(this.changeProductView.idField.getText()),
                                this.changeProductView.stockField.getText(),
                                Double.parseDouble(this.changeProductView.weightField.getText()),
                                (String)this.changeProductView.weightUnitBox.getSelectedItem(),
                                Double.parseDouble(this.changeProductView.priceField.getText()),
                                (String)this.changeProductView.categoryBox.getSelectedItem());
                    } else {
                        this.productListModel.changeProduct(productIndex,
                                this.changeProductView.nameField.getText(),
                                Long.parseLong(this.changeProductView.idField.getText()),
                                Integer.parseInt(this.changeProductView.stockField.getText()),
                                Double.parseDouble(this.changeProductView.weightField.getText()),
                                (String)this.changeProductView.weightUnitBox.getSelectedItem(),
                                Double.parseDouble(this.changeProductView.priceField.getText()),
                                (String)this.changeProductView.categoryBox.getSelectedItem());
                    }
                } else {
                    int productIndex = this.adminView.productListTable.getSelectedRow();
                    if(this.changeProductView.stockField.getText().equals("n")){
                        this.productListModel.changeProduct(productIndex,
                                this.changeProductView.nameField.getText(),
                                Long.parseLong(this.changeProductView.idField.getText()),
                                this.changeProductView.stockField.getText(),
                                Double.parseDouble(this.changeProductView.weightField.getText()),
                                (String)this.changeProductView.weightUnitBox.getSelectedItem(),
                                Double.parseDouble(this.changeProductView.priceField.getText()),
                                (String)this.changeProductView.categoryBox.getSelectedItem());
                    } else {
                        this.productListModel.changeProduct(productIndex,
                                this.changeProductView.nameField.getText(),
                                Long.parseLong(this.changeProductView.idField.getText()),
                                Integer.parseInt(this.changeProductView.stockField.getText()),
                                Double.parseDouble(this.changeProductView.weightField.getText()),
                                (String)this.changeProductView.weightUnitBox.getSelectedItem(),
                                Double.parseDouble(this.changeProductView.priceField.getText()),
                                (String)this.changeProductView.categoryBox.getSelectedItem());
                    }
                }
            } catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
        this.adminView.searchButton.doClick();
        this.hideView();
    }

    /**
     * Invoked the first time a window is made visible.
     *
     * @param e
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param e
     */
    @Override
    public void windowClosing(WindowEvent e) {

    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     *
     * @param e
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
     * @param e
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     *
     * @param e
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
     *
     * @param e
     */
    @Override
    public void windowActivated(WindowEvent e) {
        try{
            this.fillCategoryBox();
            this.fillAllFields();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Es wurde kein Produkt ausgewählt");
            this.hideView();
        }
    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     *
     * @param e
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
