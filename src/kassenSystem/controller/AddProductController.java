package kassenSystem.controller;

import kassenSystem.model.CategoryList;
import kassenSystem.model.ProductList;
import kassenSystem.view.AddProductView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductController implements ActionListener {
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

    // check this one out, once add category works, maybe new categories won't be shown.
    public void fillCategoryBox() {
        for(String category : this.categoryListModel.getCategoryList()) {
            this.view.categoryBox.addItem(category);
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.view.confirmButton){
            try{
                if(this.view.stockField.getText().equals("n")){
                    this.productListModel.addProduct(this.view.nameField.getText(),
                            Long.parseLong(this.view.idField.getText()),
                            this.view.stockField.getText(),
                            Double.parseDouble(this.view.weightField.getText()),
                            (String)this.view.weightUnitBox.getSelectedItem(),
                            Double.parseDouble(this.view.priceField.getText()),
                            (String)this.view.categoryBox.getSelectedItem());
                } else {
                    this.productListModel.addProduct(this.view.nameField.getText(),
                            Long.parseLong(this.view.idField.getText()),
                            Integer.parseInt(this.view.stockField.getText()),
                            Double.parseDouble(this.view.weightField.getText()),
                            (String)this.view.weightUnitBox.getSelectedItem(),
                            Double.parseDouble(this.view.priceField.getText()),
                            (String)this.view.categoryBox.getSelectedItem());
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }
        try {
            this.productListModel.saveToProductDatabase();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
        this.hideView();
    }
}