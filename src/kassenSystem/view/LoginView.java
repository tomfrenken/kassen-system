package kassenSystem.view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    JButton adminViewButton;
    JButton sellerViewButton;
    JLabel welcomeText;
    public LoginView(String name){
        super(name);

        setLayout(new GridLayout(3, 1));
        this.setSize(800,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adminViewButton = new JButton("Administrator");
        sellerViewButton = new JButton("Verkaeufer");
        welcomeText = new JLabel("Willkommen im Kassen System 1.0.0");

        add(welcomeText);
        add(adminViewButton);
        add(sellerViewButton);
        }
}
