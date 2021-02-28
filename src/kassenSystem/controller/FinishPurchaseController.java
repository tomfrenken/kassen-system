package kassenSystem.controller;

import kassenSystem.model.Item;
import kassenSystem.model.ProductList;
import kassenSystem.model.PurchaseList;
import kassenSystem.view.FinishPurchaseView;
import kassenSystem.view.SellerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * The controller to connect the finishPurchaseView and the finishPurchaseModel
 */
public class FinishPurchaseController implements ActionListener, WindowListener {

    private final FinishPurchaseView finishPurchaseView;
    private final PurchaseList model;
    private final SellerView sellerView;

    /**
     * The controller is initialized with the finishPurchaseView and purchaseListModel.
     *
     * @param finishPurchaseView  the finishPurchaseView
     * @param model the purchaseListModel
     */
    public FinishPurchaseController(FinishPurchaseView finishPurchaseView, SellerView sellerView, PurchaseList model) {
        this.finishPurchaseView = finishPurchaseView;
        this.sellerView = sellerView;
        this.model = model;
    }

    /**
     * The actionListeners to add to the views for interaction.
     *
     * @param actionListener generic actionListener
     */
    public void addActionsListeners(ActionListener actionListener){
        this.finishPurchaseView.addActionListener(actionListener);
    }

    /**
     * Shows the view.
     */
    public void showView(){
        this.finishPurchaseView.setVisible(true);
    }

    /**
     * Hides the view.
     */
    public void hideView(){
        this.finishPurchaseView.setVisible(false);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cancelPurchase")){
            this.model.cancelPurchase();
            this.sellerView.purchaseList.setListData(this.model.getPurchaseList().toArray());
            this.hideView();
        } else if (e.getActionCommand().equals("finishPurchase")){
            try {
                if(this.model.getSubtotal() <= Double.parseDouble(this.finishPurchaseView.moneyField.getText())) {
                    JOptionPane.showMessageDialog(null, "Ihr Rückgeld beträgt " +
                            (Double.parseDouble(this.finishPurchaseView.moneyField.getText()) - this.model.getSubtotal()));
                    this.model.finishPurchase();
                    this.sellerView.subtotalValue.setText(Double.toString(this.model.getSubtotal()));
                    this.sellerView.searchProductButton.doClick();
                    this.hideView();
                } else {
                    JOptionPane.showMessageDialog(null, "Der Betrag den Sie Zahlen wollen ist zu gering.");
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
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
        this.finishPurchaseView.purchaseList.setListData(this.model.getPurchaseList().toArray());
        this.finishPurchaseView.moneyToPay.setText(Double.toString(this.model.getSubtotal()));
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
