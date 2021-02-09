package kassenSystem.controller;

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
    private final ProductList productListModel = new ProductList();

    /**
     * The Admin controller
     * @param view the admin view
     */
    public AdminController(AdminView view) {
        this.view = view;
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

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("deleteProduct")) {
            this.productListModel.removeProduct(this.view.productListTable.getSelectedRow());
            this.productListModel.fireTableStructureChanged();
            try {
                this.productListModel.saveToProductDatabase();
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
                    this.productListModel.sortById();
                    this.productListModel.fireTableDataChanged();
                    break;
                case "Name":
                    this.productListModel.sortByName();
                    this.productListModel.fireTableDataChanged();
                    break;
                case "Preis":
                    this.productListModel.sortByPrice();
                    this.productListModel.fireTableDataChanged();
                    break;
                case "Bestand":
                    this.productListModel.sortByStock();
                    this.productListModel.fireTableDataChanged();
                    break;
                case "Kategorie":
                    this.productListModel.sortByCategory();
                    this.productListModel.fireTableDataChanged();
                    break;
                case "Grundpreis":
                    this.productListModel.sortByBasePrice();
                    this.productListModel.fireTableDataChanged();
                    break;
                case "Gewicht":
                    this.productListModel.sortByWeight();
                    this.productListModel.fireTableDataChanged();
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