package kassenSystem.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The view which the seller uses to sell the goods
 */
public class SellerView extends JFrame {
    private JList list;
    private JScrollPane scroll;
    private JTextField suchfeldTextField;
    private JButton hinzufuegenButton;
    private JList list2;
    private JScrollPane scroll2;
    private JTextField anzahlTextField;
    private JTextField suchfeldTextField1;
    private JList list3;
    private JScrollPane scroll3;
    private JButton einkaufStornierenButton;
    private JButton einkaufAbschließenButton;
    private JPanel Zwischensumme;
    private JButton artikelStornierenButton;
    private JButton anpassenButton;
    private JPanel jp;

    public SellerView(String name) {
        super(name);
        add(jp);
        this.setSize(1200, 800);
        einkaufAbschließenButton.setActionCommand("finishPurchaseView");
    }

    /**
     * The actionListeners to interact with the controller
     * @param actionListener adds actionListeners for the interaction with the controller
     */
    public void addActionListener(ActionListener actionListener){
        einkaufAbschließenButton.addActionListener(actionListener);
    }
}
