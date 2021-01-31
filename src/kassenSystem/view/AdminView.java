package kassenSystem.view;

import javafx.scene.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {
    private JButton newProductButton;
    private JButton changeProductButton;
    private JButton deleteProductButton;
    private JButton categoryListButton;

    private JList list1;
    private JComboBox comboBox1;

    public JPanel jp;
    private JTextArea ta;
    private JScrollPane sp;

    public AdminView(String name) {
        super(name);
        add(jp);

        setLayout(new GridLayout(3, 1));
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newProductButton.setActionCommand("newProductView");
        changeProductButton.setActionCommand("changeProductView");
        deleteProductButton.setActionCommand("deleteProductView");
        categoryListButton.setActionCommand("categoryListView");
    }

    public void addActionListener(ActionListener actionListener){
        newProductButton.addActionListener(actionListener);
        changeProductButton.addActionListener(actionListener);
        deleteProductButton.addActionListener(actionListener);
        categoryListButton.addActionListener(actionListener);
    }
}