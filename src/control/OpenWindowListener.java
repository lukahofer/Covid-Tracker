package control;

import view.TracingWindow;
import view.TrackingWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class: opens new Window on Button click
 * @author Luka Hofer
 *
 */
public class OpenWindowListener implements ActionListener {

    private String whatToCreate;
    private TrackingWindow track;
    private TracingWindow trace;

    /**
     * Constructor
     * @param s determines which window to create: either Track or Trace => save in whatToCreate
     */
    public OpenWindowListener(String s){
        this.whatToCreate = s;
    }
    
    /**
     *creates Tracer Window if whatToCreate equals Trace
     *creates Tracker Window if whatToCreate equals Track
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(whatToCreate.equals("Track"))
            track = new TrackingWindow();
        else if(whatToCreate.equals("Trace"))
            trace = new TracingWindow();

    }
}
