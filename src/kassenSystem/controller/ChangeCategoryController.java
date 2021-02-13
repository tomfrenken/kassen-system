package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.view.CategoryListView;
import kassenSystem.view.ChangeCategoryView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ChangeCategoryController implements ActionListener, WindowListener {
    private final CategoryListView categoryListView;
    private final ChangeCategoryView changeCategoryView;
    private final CategoryList model;

    /**
     * The controller is initialized with the view and model.
     * @param changeCategoryView categoryListView
     * @param model categoryListModel
     */
    public ChangeCategoryController(ChangeCategoryView changeCategoryView,
                                  CategoryListView categoryListView, CategoryList model){

        this.changeCategoryView = changeCategoryView;
        this.categoryListView = categoryListView;
        this.model = model;
    }

    /**
     * shows the view
     */
    public void showView(){
        this.changeCategoryView.setVisible(true);
    }

    /**
     * hides the view
     */
    public void hideView(){
        this.changeCategoryView.setVisible(false);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("changeCategory")){
            String oldCategory = this.categoryListView.categoryList.getSelectedValue().toString();
            try {
                this.model.changeCategory(oldCategory, this.changeCategoryView.categoryField.getText());
                this.categoryListView.searchField.setText("");
                this.categoryListView.searchButton.doClick();
                this.hideView();
            } catch(Exception exception) {
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
        if(this.categoryListView.categoryList.getSelectedValue() != null){
            String selectedCategory = this.categoryListView.categoryList.getSelectedValue().toString();
            this.changeCategoryView.categoryField.setText(selectedCategory);
        } else {
            JOptionPane.showMessageDialog(null, "Wähle eine Kategorie aus.");
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
