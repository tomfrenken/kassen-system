package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.Product;
import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The controller to connect the adminView and the adminModel
 */
public class AdminController implements ActionListener, MouseListener {
    private final AdminView view;
    private final ProductList productModel;
    private final CategoryList categoryModel;

    /**
     * The Admin controller
     * @param view the admin view
     * @param productModel the productList model
     * @param categoryModel the categoryList model
     */
    public AdminController(AdminView view, ProductList productModel, CategoryList categoryModel) {
        this.view = view;
        this.categoryModel = categoryModel;
        this.productModel = productModel;
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

    public void fillCategoryList() {
        try {
            categoryModel.loadFromCategoryDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void fillProductList() {
        try {
            this.productModel.loadFromProductDatabase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("deleteProduct")) {
            this.productModel.removeProduct(this.view.productListTable.getSelectedRow());
            this.productModel.fireTableStructureChanged();
            try {
                this.productModel.saveToProductDatabase();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.productListTable.getTableHeader()){
            int col = this.view.productListTable.columnAtPoint(e.getPoint());
            String columnName = this.view.productListTable.getColumnName(col);
            switch(columnName){
                case "EAN":
                    this.productModel.sortById();
                    this.productModel.fireTableDataChanged();
                    break;
                case "Name":
                    this.productModel.sortByName();
                    this.productModel.fireTableDataChanged();
                    break;
                case "Preis":
                    this.productModel.sortByPrice();
                    this.productModel.fireTableDataChanged();
                    break;
                case "Bestand":
                    this.productModel.sortByStock();
                    this.productModel.fireTableDataChanged();
                    break;
                case "Kategorie":
                    this.productModel.sortByCategory();
                    this.productModel.fireTableDataChanged();
                    break;
                case "Grundpreis":
                    this.productModel.sortByBasePrice();
                    this.productModel.fireTableDataChanged();
                    break;
                case "Gewicht":
                    this.productModel.sortByWeight();
                    this.productModel.fireTableDataChanged();
                    break;
            }
        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}