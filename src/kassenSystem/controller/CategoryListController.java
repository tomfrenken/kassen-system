package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.view.CategoryListView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * The controller to connect the categoryListView and the categoryListModel.
 */
public class CategoryListController implements ActionListener, WindowListener {

    private final CategoryListView view;
    private final CategoryList model;

    /**
     * The controller is initialized with the categoryListView and cateGoryListModel.
     *
     * @param view  the categoryListView
     * @param model the categoryListModel
     */
    public CategoryListController(CategoryListView view, CategoryList model){
        this.view = view;
        this.model = model;
    }

    /**
     * the actionlisteners to add to the views for interaction.
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
     * Refreshes the view.
     */
    public void refreshView() {
        this.view.searchField.setText("");
        this.view.searchButton.doClick();
    }

    /**
     * Hides the view.
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    /**
     * Fill the category list in categoryListView with all categories,
     * currently in the categoryList.
     */
    public void fillCategoryList(){
        this.view.categoryList.setListData(this.model.getCategoryList().toArray());
    }

    /**
     * Searches for a category in the category list.
     * The entered String can be a substring of the results or a specific name.
     *
     * @param searchPhrase the (sub)string to search for
     * @return             an array of all categories that contain the (sub)string
     */
    public ArrayList<String> searchForCategory(String searchPhrase) {
        return this.model.searchCategory(searchPhrase);
    }

    /**
     * Invoked when an action occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "searchCategory":
                this.view.categoryList.setListData(this.searchForCategory(this.view.searchField.getText()).toArray());
                break;
            case "addCategory":
                try {
                    this.model.addCategory(this.view.inputField.getText());
                    this.refreshView();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
                break;
            case "deleteCategory":
                try {
                    if(this.view.categoryList.getSelectedValue() != null){
                        this.model.removeCategory(this.view.categoryList.getSelectedValue().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Wähle eine Kategorie aus.");
                    }
                    this.refreshView();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
                break;
        }
    }

    /**
     * Invoked the first time a window is made visible.
     */
    @Override
    public void windowOpened(WindowEvent e) {
        this.fillCategoryList();
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

    }
}