package kassenSystem.controller;

import kassenSystem.model.ProductList;
import kassenSystem.view.AdminView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The controller to connect the adminView and the adminModel
 */
public class AdminController implements ActionListener, MouseListener, WindowListener {
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
            try {
                this.model.removeProduct(this.view.productListTable.getSelectedRow());
            } catch(Exception exception) {
                JOptionPane.showMessageDialog(null, "Wähle ein Produkt aus.");
            }
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
        this.model.fireTableDataChanged();
    }
}