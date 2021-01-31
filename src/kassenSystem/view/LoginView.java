package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private JButton verkäuferButton;
    private JButton adminButton;
    private JPanel jp;

    public LoginView() {
        JFrame frame = new JFrame("Kassensystem");
        frame.setContentPane(new LoginView().jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        adminButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new AdminView().jp);
                frame.invalidate();
                frame.validate();
            }
        });
        verkäuferButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new AdminView().jp);
                frame.invalidate();
                frame.validate();
            }
        });
    }
}
