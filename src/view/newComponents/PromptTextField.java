package view.newComponents;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * class creates specialized JTextField that display a default text in the textfield
 * default text disappears if new text is added
 * @author Luka Hofer
 *
 */
public class PromptTextField extends JTextField {

    /**
     * FocusListener makes default text disappear when text field is in focus
     * @param text default text that should be displayed initially
     */
    public PromptTextField(String text){
        super(text);

        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()) {
                    setText(text);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(text)) {
                    setText("");
                }
            }
        });
    }
}