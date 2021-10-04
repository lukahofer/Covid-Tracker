package view;

import javax.swing.*;
import java.awt.*;

/**
 * class that creates Window with information about contact persons 
 * output parameter in the Constructor contains the output String
 * @author Luka Hofer
 *
 */
public class ContactPersonWindow extends JDialog {
    Container contentPane;
    private JLabel titleJLabel;
    private JTextArea contactPersonsJTArea;

    public ContactPersonWindow(String output){
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        //JTextArea with all the info about contact persons
        titleJLabel = new JLabel("Folgende Personen waren mit der infizierten Person im Kontakt:");
        titleJLabel.setFont(new Font("Verdana", 0, 20));
        contentPane.add(titleJLabel, BorderLayout.NORTH);
        contactPersonsJTArea = new JTextArea();
        contactPersonsJTArea.setEditable(false);
        contactPersonsJTArea.setText("\n" + output);
        contactPersonsJTArea.setFont(new Font("Arial", 1, 24));
        contentPane.add(contactPersonsJTArea, BorderLayout.CENTER);


        //set Frame properties;
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500, 200, 800, 550);
        //setResizable(false);
        setModal(true);
        setTitle("CovidTracker - Kontaktpersonen");
        setVisible(true);
    }
}
