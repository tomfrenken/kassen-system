package kassenSystem.controller;

import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * The controller to connect the adminView and the adminModel
 */
public class AdminController implements ActionListener, MouseListener, WindowListener {

    private final AdminView view;
    private final ProductList model;

    /**
     * The controller is initialized with the adminView and the productListModel.
     *
     * @param view  the adminView
     * @param model the productListModel
     */
    public AdminController(AdminView view, ProductList model) {
        this.view = view;
        this.model = model;
    }

    /**
     * The actionListeners to add to the views for interaction.
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
        this.view.setVisible(true);
    }

    /**
     * Hides the view.
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    /**
     * Searches the productList for a product with this name or id.
     * The search phrase can be a specific name or id of the results or it can be part of one.
     *
     * @param searchPhrase the search phrase that is looked for in the productList
     * @return             a list of product with the same name or id regarding what was searched
     *                     for, or where the search phrase is part of
     */
    public ArrayList<Product> searchProduct(String searchPhrase) {
        return this.model.searchProduct(searchPhrase);
    }

    /**
     * Refreshes the searchList.
     */
    public void refreshSearchList() {
        this.view.searchField.setText("");
        this.view.searchButton.doClick();
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("deleteProduct")) {
            try {
                if(this.view.productListTable.getSelectedRow() != -1) {
                    this.model.removeProductByIndex(this.view.productListTable.getSelectedRow());
                    this.refreshSearchList();
                } else if(this.view.searchList.getSelectedValue() != null) {
                    this.model.removeProduct((Product)this.view.searchList.getSelectedValue());
                    this.refreshSearchList();
                } else {
                    throw new Exception("Nothing was selected");
                }
            } catch(Exception exception) {
                JOptionPane.showMessageDialog(null, "Wähle ein Produkt aus.");
            }
        } else if(e.getActionCommand().equals("searchProduct")) {
            ArrayList<Product> searchListData = this.searchProduct(this.view.searchField.getText());
            this.view.searchList.setListData(searchListData.toArray());
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.productListTable.getTableHeader()){
            int col = this.view.productListTable.columnAtPoint(e.getPoint());
            String columnName = this.view.productListTable.getColumnName(col);
            switch(columnName){
                case "EAN":
                    this.model.sortById();
                    break;
                case "Name":
                    this.model.sortByName();
                    break;
                case "Preis":
                    this.model.sortByPrice();
                    break;
                case "Bestand":
                    this.model.sortByStock();
                    break;
                case "Kategorie":
                    this.model.sortByCategory();
                    break;
                case "Grundpreis":
                    this.model.sortByBasePrice();
                    break;
                case "Gewicht":
                    this.model.sortByWeight();
                    break;
            }
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     */
    @Override
    public void mouseExited(MouseEvent e) {

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
        this.model.fireTableDataChanged();
    }
}