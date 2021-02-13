package kassenSystem.view;

import kassenSystem.controller.ChangeCategoryController;
import kassenSystem.model.CategoryList;

import javax.swing.*;

public class ChangeCategoryView extends JFrame {
    private JButton changeButton;
    private JPanel jp;
    public JTextField categoryField;

    public ChangeCategoryView(String name, CategoryListView categoryListView){
        super(name);
        add(jp);
        this.setSize(1200, 800);

        CategoryList categoryListModel = new CategoryList();
        ChangeCategoryController changeCategoryController =
                new ChangeCategoryController(this, categoryListView, categoryListModel);
        changeButton.setActionCommand("changeCategory");
        changeButton.addActionListener(changeCategoryController);
    }
}
