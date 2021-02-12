package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.view.CategoryListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The controller to connect the categoryListView and the cateGoryListModel.
 */
public class CategoryListController implements ActionListener {
    private final CategoryListView view;
    private final CategoryList model;

    /**
     * The controller is initialized with the view and model.
     * @param view categoryListView
     * @param model cateGoryListModel
     */
    public CategoryListController(CategoryListView view, CategoryList model){
        this.view = view;
        this.model = model;
    }

    /**
     * the actionlisteners to add to the views for interaction.
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

    public void refreshView() {
        this.view.searchField.setText("");
        this.view.searchButton.doClick();
    }

    /**
     * hides the view
     */
    public void hideView(){
        this.view.setVisible(false);
    }

    public void fillCategoryList(){
        this.view.categoryList.setListData(this.model.getCategoryList().toArray());
    }

    public ArrayList<String> searchForCategory(String searchPhrase) {
        return this.model.searchCategory(searchPhrase);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
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
                    this.model.removeCategory(this.view.categoryList.getSelectedValue().toString());
                    this.refreshView();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Wähle eine Kategorie aus.");
                }
                break;
        }
    }
}