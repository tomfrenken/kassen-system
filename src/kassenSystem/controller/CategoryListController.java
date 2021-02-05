package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.view.CategoryListView;

import java.awt.event.ActionListener;

/**
 * The controller to connect the categoryListView and the cateGoryListModel.
 */
public class CategoryListController {
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

    /**
     * hides the view
     */
    public void hideView(){
        this.view.setVisible(false);
    }
}