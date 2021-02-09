package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Shows the category list and gives the possibility to change them
 */
public class CategoryListView extends JFrame {
    private JButton hinzufuegen;
    private JButton anpassenButton;
    private JButton loeschenButton;
    private JTextField suchfeldTextField;
    private JList list;
    private JScrollPane scroll;
    private JPanel jp;
    private JTextField eingabeTextField;
    private JButton button1;

    public CategoryListView(String name){
        super(name);
        add(jp);
        this.setSize(1200, 800);
        hinzufuegen.setActionCommand("addCategoryView");
        anpassenButton.setActionCommand("changeCategoryView");
    }

    /**
     * Adds action listeners to the buttons.
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        hinzufuegen.addActionListener(actionListener);
        anpassenButton.addActionListener(actionListener);
    }
}
