package kassenSystem.view;

import javax.swing.*;

public class ChangeCategoryView extends JFrame {
    private JButton ändernButton;
    private JTextField textField1;
    private JPanel jp;

    public ChangeCategoryView(String name){
        super(name);
        add(jp);
        this.setSize(1200, 800);
    }
}
