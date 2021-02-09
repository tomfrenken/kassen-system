package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.view.AddProductView;

import java.awt.event.ActionListener;

public class AddProductController {
    private final AddProductView view;
    private final CategoryList categoryListModel = new CategoryList();
    private final ProductList productListModel = new ProductList();


    /**
     * The controller is initialized with the categoryListModel and the productListModel, as well as the addProductView
     * @param view the addProductView
     */
    public AddProductController(AddProductView view) {
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
}
