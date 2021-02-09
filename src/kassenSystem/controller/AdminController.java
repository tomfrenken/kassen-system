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
    private final ProductList model;

    /**
     * The Admin controller
     * @param view the admin view
     */
    public AdminController(AdminView view, ProductList model) {
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

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("deleteProduct")) {
            this.model.removeProduct(this.view.productListTable.getSelectedRow());
            this.model.fireTableStructureChanged();
            try {
                this.model.saveToProductDatabase();
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
                    this.model.sortById();
                    this.model.fireTableDataChanged();
                    break;
                case "Name":
                    this.model.sortByName();
                    this.model.fireTableDataChanged();
                    break;
                case "Preis":
                    this.model.sortByPrice();
                    this.model.fireTableDataChanged();
                    break;
                case "Bestand":
                    this.model.sortByStock();
                    this.model.fireTableDataChanged();
                    break;
                case "Kategorie":
                    this.model.sortByCategory();
                    this.model.fireTableDataChanged();
                    break;
                case "Grundpreis":
                    this.model.sortByBasePrice();
                    this.model.fireTableDataChanged();
                    break;
                case "Gewicht":
                    this.model.sortByWeight();
                    this.model.fireTableDataChanged();
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