package view;

import control.ChangeDateListener;
import control.SendTracerInputListener;
import model.DatePair;
import model.WrongInputException;
import view.newComponents.PromptTextField;
import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * opens Tracing Window
 * you can register with your contact information and details about the date and time of the visit
 * uses external library LGoodDatePicker for choosing a date and time manually: com.github.lgooddatepicker.components.DateTimePicker
 * @author Luka Hofer
 *
 */
public class TracingWindow extends JDialog{

    //ContentPane
    private Container contentPane;

    //Fonts and Colors
    private final Font HEADER_FONT = new Font("Verdana", 1, 37);
    private final Font STANDARD_FONT = new Font("Arial", 1, 24);
    private final Font TEXTFIELD_FONT = new Font("Verdana", 0, 20);
    private final Font BUTTON_FONT = new Font("Verdana", 1, 20);

    private final Color HEADER_COLOR = new Color(22, 94, 175);
    private final Color BACKGROUND_COLOR = new Color(237, 247, 255);


    //Title (North)
    private JTextField titleJTField;

    //General structure South
    private JPanel informationJPanel;
    private JPanel contactInfoJPanel;
    private JPanel timeInfoJPanel;

    //Textfields Contact Information
    private JLabel getContactInfoJLabel;
    private JPanel contactFieldJPanel;
    private PromptTextField nameJTField, surnameJTField, phoneNumJTField;

    //Textfields Time Information
    private JTextArea dateJTArea;
    private ButtonGroup buttonGroup;
    private JRadioButton visitNowRB, visitLaterRB;
    private JPanel buttonJPanel, timeJPanel;
    private String dateAndTime;
    private JPanel DateTimeJPanel;
    private DateTimePicker pickDateTime;
    private JTextField hoursJTField, minutesJTField;
    private JLabel hoursJLabel, minutesJLabel;
    private JButton sendJButton;


    public TracingWindow(){
        contentPane = getContentPane();
        ((JPanel) contentPane).setBorder(new EmptyBorder(25, 25, 25, 25));
        contentPane.setLayout(new BorderLayout());
        contentPane.setBackground(BACKGROUND_COLOR);

        //Title (North)
        titleJTField = new JTextField("Wilkommen bei uns im Restaurant!");
        titleJTField.setEditable(false);
        titleJTField.setHorizontalAlignment(SwingConstants.CENTER);
        titleJTField.setFont(HEADER_FONT);
        titleJTField.setForeground(HEADER_COLOR);
        titleJTField.setBackground(BACKGROUND_COLOR);
        contentPane.add(titleJTField, BorderLayout.NORTH);

        //General structure (Center)
        informationJPanel = new JPanel();
        informationJPanel.setLayout(new GridLayout(2,1, 0, 30));
        contactInfoJPanel = new JPanel();
        contactInfoJPanel.setLayout(new GridLayout(2,1));
        timeInfoJPanel = new JPanel();
        timeInfoJPanel.setLayout(new GridLayout(3,1, 0, 10));
        informationJPanel.setBackground(BACKGROUND_COLOR);
        contactInfoJPanel.setBackground(BACKGROUND_COLOR);
        timeInfoJPanel.setBackground(BACKGROUND_COLOR);

        informationJPanel.add(contactInfoJPanel);
        informationJPanel.add(timeInfoJPanel);
        contentPane.add(informationJPanel, BorderLayout.CENTER);

        //Textfields Contact Information
        getContactInfoJLabel = createStandardLabel("Bitte tragen Sie Ihren Namen und Ihre Tel. Nummer ein.");
        contactFieldJPanel = new JPanel();
        contactFieldJPanel.setLayout(new GridLayout(1,3, 10, 0));
        contactFieldJPanel.setBorder(new EmptyBorder(5,0,30,0));
        contactFieldJPanel.setBackground(BACKGROUND_COLOR);

        nameJTField = new PromptTextField("Vorname");
        surnameJTField = new PromptTextField("Nachname");
        phoneNumJTField = new PromptTextField("Tel. Nummer");

        nameJTField.setFont(TEXTFIELD_FONT);
        surnameJTField.setFont(TEXTFIELD_FONT);
        phoneNumJTField.setFont(TEXTFIELD_FONT);

        contactFieldJPanel.add(nameJTField);
        contactFieldJPanel.add(surnameJTField);
        contactFieldJPanel.add(phoneNumJTField);
        contactInfoJPanel.add(getContactInfoJLabel);
        contactInfoJPanel.add(contactFieldJPanel);

        //Textfields Time Information
        dateAndTime = new SimpleDateFormat("'Es ist 'EEEE', der 'dd. MMMM yyyy, HH:mm' Uhr'.").format(Calendar.getInstance().getTime());
        dateJTArea = new JTextArea(dateAndTime + "\nMöchten Sie uns jetzt besuchen? Wie lange möchten Sie bleiben?");
        dateJTArea.setBackground(BACKGROUND_COLOR);
        dateJTArea.setFont(STANDARD_FONT);
        dateJTArea.setLineWrap(true);
        dateJTArea.setWrapStyleWord(true);
        dateJTArea.setEditable(false);
        dateJTArea.setFocusable(false);
        timeInfoJPanel.add(dateJTArea);

        buttonGroup = new ButtonGroup();
        visitNowRB = new JRadioButton("Jetzt besuchen");
        visitNowRB.setSelected(true);
        visitNowRB.setFont(TEXTFIELD_FONT);
        visitNowRB.setBackground(BACKGROUND_COLOR);
        visitNowRB.addActionListener(new ChangeDateListener(false, this));
        visitLaterRB = new JRadioButton("Später besuchen");
        visitLaterRB.setFont(TEXTFIELD_FONT);
        visitLaterRB.setBackground(BACKGROUND_COLOR);
        visitLaterRB.addActionListener(new ChangeDateListener(true, this));

        DateTimeJPanel = new JPanel(new BorderLayout());
        DateTimeJPanel.setBorder(new EmptyBorder(8,0,8,0));
        DateTimeJPanel.setBackground(BACKGROUND_COLOR);
        pickDateTime = new DateTimePicker();
        pickDateTime.setFont(STANDARD_FONT);
        pickDateTime.setEnabled(false);
        DateTimeJPanel.add(pickDateTime, BorderLayout.CENTER);

        buttonGroup.add(visitNowRB);
        buttonGroup.add(visitLaterRB);
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(1,4));
        buttonJPanel.setBackground(BACKGROUND_COLOR);
        buttonJPanel.add(visitNowRB);
        buttonJPanel.add(visitLaterRB);
        buttonJPanel.add(DateTimeJPanel);
        timeInfoJPanel.add(buttonJPanel);

        timeJPanel = new JPanel(new GridLayout(1,5));
        timeJPanel.setBackground(BACKGROUND_COLOR);
        timeInfoJPanel.add(timeJPanel);

        hoursJTField = new JTextField();
        hoursJTField.setHorizontalAlignment(SwingConstants.CENTER);
        hoursJTField.setFont(TEXTFIELD_FONT);
        timeJPanel.add(hoursJTField);

        hoursJLabel = createStandardLabel("Stunden");
        timeJPanel.add(hoursJLabel);

        minutesJTField = new JTextField();
        minutesJTField.setHorizontalAlignment(SwingConstants.CENTER);
        minutesJTField.setFont(TEXTFIELD_FONT);
        timeJPanel.add(minutesJTField);

        minutesJLabel = createStandardLabel("Minuten");
        timeJPanel.add(minutesJLabel);

        sendJButton = new JButton("Senden");
        sendJButton.setFont(BUTTON_FONT);
        sendJButton.setForeground(new Color(33, 146, 51));
        sendJButton.addActionListener(new SendTracerInputListener(this));
        timeJPanel.add(sendJButton);

        //set Frame properties;
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500, 200, 900, 550);
        setResizable(false);
        setModal(true);
        setTitle("CovidTracker - Personenaufnahme");
        setVisible(true);
    }

    
    /**
     * creates standarized JLabel
     * @param text text displayed on label
     * @return JLabel label
     */
    private JLabel createStandardLabel(String text){
        JLabel label = new JLabel(text);
        label.setFont(STANDARD_FONT);
        return label;
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

        return input;
    }


    /**
     * getter method for last name
     * also checks input for illegal characters
     * @return surname of customer
     * @throws WrongInputException exception for wrong input
     */
    public String getSurName() throws WrongInputException{
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

        return input;
    }


    /**
     * getter method for phone number
     * also checks input for illegal characters
     * @return phone number of customer
     * @throws WrongInputException exception for wrong input
     */
    public String getPhoneNum() throws WrongInputException{
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

        return input;
    }

    
    /**
     * getter method for DatePair of visits
     * also checks if date is picked manually
     * @return DatePair of visit
     * @throws WrongInputException throws exception if getStayDuration() throws exception
     */
    public DatePair getDateTimePair()throws WrongInputException{
        DatePair pair = new DatePair();
            if(pickDateTime.isEnabled()){
                pair.setStart(pickDateTime.getDateTimeStrict());
                pair.setEnd((pickDateTime.getDateTimeStrict().plusMinutes(getStayDuration())));
            }else{
                pair.setStart(LocalDateTime.now());
                pair.setEnd(LocalDateTime.now().plusMinutes(getStayDuration()));
            }
            return pair;
    }


    /**
     * gets duration of visit in minutes
     * @return duration in minutes
     * @throws WrongInputException throws exception if input in not valid
     */
    public int getStayDuration() throws WrongInputException {
        String input = hoursJTField.getText() + minutesJTField.getText();

        if (hoursJTField.getText().isEmpty() || minutesJTField.getText().isEmpty())
            throw new WrongInputException("Sie haben keine Aufenthaltsdauer angegeben. Bitte machen Sie hierzu eine Angabe!");
        else {
            for (char c : input.toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new WrongInputException("Bitte verwenden Sie für Angabe der Aufenthaltsdauer nur Zahlen.");
                }
            }
            return Integer.parseInt(hoursJTField.getText()) * 60 + Integer.parseInt(minutesJTField.getText());
        }
    }


    //set pickDateTime editable
    /**
     * sets DateTimePicker editable or not
     * @param editable true if date should be picked manually
     */
    public void setEnabledPickDateTime(boolean editable){
        pickDateTime.setEnabled(editable);
    }
}