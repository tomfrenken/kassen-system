package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    public static void main(String[] args) {
        JFrame jframe= new JFrame("Kassensystem");
        final JTextField textField = new JTextField();
        textField.setBounds(50,50,150,20);
        JButton adminViewButton = new JButton("Adminansicht");
        JButton sellerViewButton = new JButton("Verkäuferansicht");
        adminViewButton.setBounds(50,100,95,30);
        jframe.add(adminViewButton);
        jframe.setSize(1920,1080);
        jframe.setLayout(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // loginViewController
            }
        });
        jframe.add(adminViewButton);
        jframe.add(textField);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
}
