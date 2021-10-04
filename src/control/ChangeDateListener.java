package control;

import view.TracingWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class that determines whether Date should be picked manually
 * @author Luka Hofer
 *
 */
public class ChangeDateListener implements ActionListener {

    //should date and time be picked manually?
    private boolean pickDateManually = false;
    private TracingWindow window;

    /**
     * Constructor: initialize variables
     * @param pickDateManually should date be picked manually?
     * @param window reference to TracingWindow
     */
    public ChangeDateListener(boolean pickDateManually, TracingWindow window){
        this.pickDateManually = pickDateManually;
        this.window = window;
    }
    
    /**
     *enables DateTimerPicker if wanted
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        window.setEnabledPickDateTime(pickDateManually);
    }
}
