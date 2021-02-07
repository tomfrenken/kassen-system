package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FinishPurchaseView extends JFrame {
    private JScrollPane scroll;
    private JList list;
    private JPanel Betrag;
    private JButton einkaufBezahltButton;
    private JButton einkaufStornierenButton;
    private JTextField textField1;
    private JPanel jp;

    public FinishPurchaseView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);
    }

    /**
     * Adds action listeners to the buttons.
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        einkaufBezahltButton.addActionListener(actionListener);
        einkaufStornierenButton.addActionListener(actionListener);
    }
}
