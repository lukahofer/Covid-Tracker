package view;
import control.OpenWindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * creates MainFrame that lets you choose which functionality of the software you want to use
 * either opens tracing or tracking window
 * @author Luka Hofer
 *
 */
public class MainFrame extends JFrame{
	
	//ContentPane
    private Container contentPane;

    //Grid One (Title)
    private JTextField welcomeJTField;

    //Grid Two
    private JLabel questionJLabel;

    //Grid Three (Buttons)
    private JPanel buttonsJPanel;
    private JButton trackingFrameJB, tracingFrameJB;

    //Fonts, Colors and general Settings
    private final Font HEADER_FONT = new Font("Verdana",Font.BOLD, 42);
    private final Color STANDARD_COLOR = new Color(237, 247, 255);
    private final Font BUTTON_FONT = new Font("Verdana", 1, 13);

    public MainFrame(){

        //Content Pane
        contentPane = getContentPane();
        ((JPanel) contentPane).setBorder(new EmptyBorder(25, 25, 25, 25));
        contentPane.setLayout(new GridLayout(3,1));
        contentPane.setBackground(STANDARD_COLOR);

        //Grid One
        welcomeJTField = new JTextField("Wilkommen bei CovidTracker");
        welcomeJTField.setEditable(false);
        welcomeJTField.setFont(HEADER_FONT);
        welcomeJTField.setBackground(STANDARD_COLOR);
        welcomeJTField.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeJTField.setForeground(new Color(170, 36, 24));
        contentPane.add(welcomeJTField);

        //Grid Two
        questionJLabel = new JLabel("Welche Aktion möchten Sie ausführen?...");
        questionJLabel.setFont(new Font("Arial", 0, 30));
        questionJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(questionJLabel);

        //Grid Three
        buttonsJPanel = new JPanel();
        buttonsJPanel.setLayout(new GridLayout(1,2, 50, 10));
        tracingFrameJB = new JButton("... Ich möchte das Restaurant besuchen");
        tracingFrameJB.setFont(BUTTON_FONT);
        tracingFrameJB.addActionListener(new OpenWindowListener("Trace"));
        trackingFrameJB = new JButton("... Ich möchte eine Covid-Erkrankung melden");
        trackingFrameJB.setFont(BUTTON_FONT);
        trackingFrameJB.addActionListener(new OpenWindowListener("Track"));

        buttonsJPanel.add(tracingFrameJB);
        buttonsJPanel.add(trackingFrameJB);
        buttonsJPanel.setBackground(STANDARD_COLOR);
        contentPane.add(buttonsJPanel);

        //set Frame properties;
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(500, 200, 850, 500);
        setTitle("CovidTracker");
        setVisible(true);
    }
}