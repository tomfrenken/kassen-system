package kassenSystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChangeProductView extends JFrame {
    private JTextField textField1;
    private JButton aktualisierenButton;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox2;
    private JTextField textField5;

    public ChangeProductView(String name) {
        super(name);

        setLayout(new GridLayout(3, 1));
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button1.setActionCommand("changeProduct");
    }

    public void addActionListener(ActionListener actionListener){
        button1.addActionListener(actionListener);
    }
}
