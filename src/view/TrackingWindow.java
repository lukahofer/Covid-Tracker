package view;

import control.SendTrackerInputListener;
import model.WrongInputException;
import view.newComponents.PromptTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * opens Tracking window
 * infected customer can enter information and check for contact persons
 * @author Luka Hofer
 *
 */
public class TrackingWindow extends JDialog {
    private Container contentPane;

    //general structure
    private JPanel contactInformation;
    private JPanel textFieldsJPanel;

    //Fonts and Colors
    private final Font HEADER_FONT = new Font("Verdana", 1, 37);
    private final Font STANDARD_FONT = new Font("Arial", 1, 24);
    private final Font TEXTFIELD_FONT = new Font("Verdana", 0, 20);
    private final Font BUTTON_FONT = new Font("Verdana", 1, 20);

    private final Color HEADER_COLOR = new Color(22, 94, 175);
    private final Color BACKGROUND_COLOR = new Color(237, 247, 255);

    //upper part (title)
    private JTextField titleJTField;

    //middle part (contact info)
    private JTextArea textAreaJTArea;
    private PromptTextField nameJTField, surnameJTField, phoneNumJTField;

    //lower part (Button)
    private JPanel buttonJPanel;
    private JButton showPersonJButton;

    public TrackingWindow(){
        contentPane = getContentPane();
        ((JPanel) contentPane).setBorder(new EmptyBorder(25, 25, 25, 25));
        contentPane.setLayout(new BorderLayout(5,45));
        contentPane.setBackground(BACKGROUND_COLOR);

        //upper part (title)
        titleJTField = new JTextField("Risikoermittlung");
        titleJTField.setForeground(HEADER_COLOR);
        titleJTField.setHorizontalAlignment(SwingConstants.CENTER);
        titleJTField.setFont(HEADER_FONT);
        titleJTField.setEditable(false);
        titleJTField.setBackground(BACKGROUND_COLOR);
        contentPane.add(titleJTField, BorderLayout.NORTH);

        //general structure (middle)
        contactInformation = new JPanel();
        contactInformation.setLayout(new BoxLayout(contactInformation, BoxLayout.Y_AXIS));
        textFieldsJPanel = new JPanel(new GridLayout(1,3, 40,0));
        textFieldsJPanel.setBackground(BACKGROUND_COLOR);
        textFieldsJPanel.setPreferredSize(new Dimension(400, 50));

        //middle part (contact info)
        textAreaJTArea = new JTextArea("Bei Ihnen wurde eine Covid-Erkrankung nachgewiesen? " +
                "\n\nGeben Sie hier Ihre Daten an, um eine Kontaktpersonnachverfolgung durchzuführen.");
        textAreaJTArea.setEditable(false);
        textAreaJTArea.setLineWrap(true);
        textAreaJTArea.setWrapStyleWord(true);
        textAreaJTArea.setFont(STANDARD_FONT);
        textAreaJTArea.setBackground(BACKGROUND_COLOR);
        textAreaJTArea.setFocusable(false);

        nameJTField = new PromptTextField("Vorname");
        nameJTField.setFont(TEXTFIELD_FONT);
        surnameJTField = new PromptTextField("Nachname");
        surnameJTField.setFont(TEXTFIELD_FONT);
        phoneNumJTField = new PromptTextField("Tel. Nummer");
        phoneNumJTField.setFont(TEXTFIELD_FONT);

        textFieldsJPanel.add(nameJTField);
        textFieldsJPanel.add(surnameJTField);
        textFieldsJPanel.add(phoneNumJTField);
        contactInformation.add(textAreaJTArea);
        contactInformation.add(textFieldsJPanel);
        contentPane.add(contactInformation, BorderLayout.CENTER);

        //lower part (Button)
        showPersonJButton = new JButton("Gefährdete Personen anzeigen");
        showPersonJButton.setFont(BUTTON_FONT);
        showPersonJButton.setForeground(new Color(33, 146, 51));
        showPersonJButton.addActionListener(new SendTrackerInputListener(this));
        buttonJPanel = new JPanel(new FlowLayout());
        showPersonJButton.setPreferredSize(new Dimension(500, 60));
        buttonJPanel.add(showPersonJButton);
        buttonJPanel.setBackground(BACKGROUND_COLOR);
        contentPane.add(buttonJPanel, BorderLayout.SOUTH);

        //set Frame properties;
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(530, 220, 830, 500);
        setResizable(false);
        setModal(true);
        setTitle("CovidTracker - Kontaktnachverfolgung");
        setVisible(true);
    }

    //getter methods

    /**
     * getter method for first name
     * also checks input for illegal characters
     * @return first name of customer 
     * @throws WrongInputException exception for wrong input
     */
    public String getFirstName() throws WrongInputException{
        String input = nameJTField.getText();

        if(input.equals("Vorname"))
            throw new WrongInputException("Bitte geben Sie einen Vornamen ein.");
        else {
            for (char c : input.toCharArray()) {
                if (!Character.isLetter(c)) {
                    throw new WrongInputException("Bitte tragen Sie einen korrekten Vornamen ein. Sonderzeichen, Zahlen und Leerzeichen sind nicht erlaubt.");
                }
            }
        }

        return nameJTField.getText();
    }

    /**
     * getter method for last name
     * also checks input for illegal characters
     * @return surname of customer
     * @throws WrongInputException exception for wrong input
     */
    public String getSurName()throws WrongInputException{
        String input = surnameJTField.getText();

        if(input.equals("Nachname"))
            throw new WrongInputException("Bitte geben Sie einen Nachnamen ein.");
        else{
            for (char c: input.toCharArray()) {
                if (!Character.isLetter(c)) {
                    throw new WrongInputException("Bitte tragen Sie einen korrekten Nachnamen ein. Sonderzeichen, Zahlen und Leerzeichen sind nicht erlaubt.");
                }
            }
        }

        return surnameJTField.getText();
    }


    /**
     * getter method for phone number
     * also checks input for illegal characters
     * @return phone number of customer
     * @throws WrongInputException exception for wrong input
     */
    public String getPhoneNum()throws WrongInputException{
        String input = phoneNumJTField.getText();

        if(input.equals("Tel. Nummer"))
            throw new WrongInputException("Bitte geben Sie eine Telefonnummer ein.");
        else{
            for (char c: input.toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new WrongInputException("Bitte tragen Sie eine korrekte Telefonnummer ein. Es sind nur Zahlen zulässig.");
                }
            }
        }

        return phoneNumJTField.getText();
    }
}