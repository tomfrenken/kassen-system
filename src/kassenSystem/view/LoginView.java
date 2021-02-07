package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The view from which you can choose either adminView or sellerView
 */
public class LoginView extends JFrame {
    private JButton adminLoginViewButton;
    private JButton sellerViewButton;
    private JPanel jp;

    /**
     * The view is constructed only with a name
     * @param name the name to initialize the view with
     */
    public LoginView(String name) {
        super(name);
        add(jp);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adminLoginViewButton.setActionCommand("adminLoginView");
        sellerViewButton.setActionCommand("sellerView");
    }

    /**
     * The actionListeners to interact with the controller
     * @param actionListener adds actionListeners for the interaction with the controller
     */
    public void addActionListener(ActionListener actionListener){
        adminLoginViewButton.addActionListener(actionListener);
        sellerViewButton.addActionListener(actionListener);
    }
}
