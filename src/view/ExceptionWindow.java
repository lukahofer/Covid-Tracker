package view;

import javax.swing.*;
import java.awt.*;

/**
 * creates Window with Exception message
 * message parameter in Constructor contains the error message
 * @author Luka Hofer
 *
 */
public class ExceptionWindow extends JDialog {

    private Container contentPane;
    private JTextArea textArea;

    public ExceptionWindow(String message){
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //exception message
        textArea = new JTextArea("Es ist ein Fehler aufgetreten!\n\n" + message);
        textArea.setFont(new Font("Arial", 1, 25));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        contentPane.add(textArea, BorderLayout.CENTER);

        //frame properties
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500, 200, 700, 300);
        setModal(true);
        setTitle("CovidTracker - Fehlermeldung");
        setVisible(true);
    }
}