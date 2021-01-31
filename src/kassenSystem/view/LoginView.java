package kassenSystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    JButton adminViewButton;
    JButton sellerViewButton;
    JLabel welcomeText;
    private JButton adminButton;
    private JButton verkäuferButton;

    public LoginView(String name) {
        super(name);

        setLayout(new GridLayout(3, 1));
        this.setSize(800, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adminViewButton = new JButton("Administrator");
        adminViewButton.setActionCommand("adminView");
        sellerViewButton = new JButton("Verkaeufer");
        sellerViewButton.setActionCommand("sellerView");
        welcomeText = new JLabel("Willkommen im Kassen System 1.0.0");

        add(welcomeText);
        add(adminViewButton);
        add(sellerViewButton);
    }

    public void addActionListener(ActionListener actionListener){
        adminViewButton.addActionListener(actionListener);
        sellerViewButton.addActionListener(actionListener);
    }
}
