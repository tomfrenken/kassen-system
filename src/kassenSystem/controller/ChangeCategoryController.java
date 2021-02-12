package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.view.CategoryListView;
import kassenSystem.view.ChangeCategoryView;

import java.awt.event.ActionListener;

public class ChangeCategoryController {
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
}
