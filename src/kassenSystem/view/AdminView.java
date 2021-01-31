package kassenSystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {
    private JButton neuesProduktButton;
    private JButton produktÄndernButton;
    private JButton produktLöschenButton;
    private JButton kategorielisteButton;

    private JList list1;
    private JComboBox comboBox1;
    
    private JPanel jp;

    public AdminView(String name) {
        super(name);

        setLayout(new GridLayout(3, 1));
        this.setSize(800, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        neuesProduktButton.setActionCommand("newProductView");
        produktÄndernButton.setActionCommand("changeProductView");
        produktLöschenButton.setActionCommand("deleteProductView");
        kategorielisteButton.setActionCommand("categoryListView");
    }

    public void addActionListener(ActionListener actionListener){
        neuesProduktButton.addActionListener(actionListener);
        produktÄndernButton.addActionListener(actionListener);
        produktLöschenButton.addActionListener(actionListener);
        kategorielisteButton.addActionListener(actionListener);
    }
}