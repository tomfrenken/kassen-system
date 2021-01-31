package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.view.CategoryListView;

/**
 * The controller to connect the categoryListView and the cateGoryListModel.
 */
public class CategoryListController {
    private CategoryListView view;
    private CategoryList model;

    /**
     * The controller is initialized with the view and model.
     * @param view categoryListView
     * @param model cateGoryListModel
     */
    CategoryListController(CategoryListView view, CategoryList model){
        this.view = view;
        this.model = model;
    }
}