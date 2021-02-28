package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The view where the purchase is payed or canceled.
 */
public class FinishPurchaseView extends JFrame {

    private JScrollPane scroll;
    private JList list;
    private JPanel Betrag;
    private JButton einkaufBezahltButton;
    private JButton einkaufStornierenButton;
    private JTextField textField1;
    private JPanel jp;

    /**
     * The view is constructed only with a name.
     *
     * @param name the name of the view
     */
    public FinishPurchaseView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);
    }

    /**
     * Adds action listeners to the buttons.
     *
     * @param actionListener the actionlistener to interact with the controller
     */
    public void addActionListener(ActionListener actionListener){
        einkaufBezahltButton.addActionListener(actionListener);
        einkaufStornierenButton.addActionListener(actionListener);
    }
}
