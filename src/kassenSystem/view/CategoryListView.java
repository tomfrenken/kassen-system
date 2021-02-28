package kassenSystem.view;

import kassenSystem.controller.CategoryListController;
import kassenSystem.model.CategoryList;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Shows the category list and gives the possibility to change them.
 */
public class CategoryListView extends JFrame {

    private JButton addButton;
    private JButton changeButton;
    private JButton deleteButton;
    private JScrollPane scroll;
    private JPanel jp;
    public JList<Object> categoryList;
    public JTextField inputField;
    public JTextField searchField;
    public JButton searchButton;

    /**
     * The view is constructed only with a name.
     *
     * @param name the name of the view
     */
    public CategoryListView(String name){
        super(name);
        add(jp);
        this.setSize(1200, 800);

        CategoryList categoryListModel = new CategoryList();
        CategoryListController categoryListController = new CategoryListController(
                this, categoryListModel);

        searchButton.setActionCommand("searchCategory");
        searchButton.addActionListener(categoryListController);
        addButton.setActionCommand("addCategory");
        addButton.addActionListener(categoryListController);
        changeButton.setActionCommand("changeCategory");
        deleteButton.setActionCommand("deleteCategory");
        deleteButton.addActionListener(categoryListController);
    }

    /**
     * Adds action listeners to the buttons.
     *
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        changeButton.addActionListener(actionListener);
    }
}
