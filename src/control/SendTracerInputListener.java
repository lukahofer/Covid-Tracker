package control;

import main.Main;
import model.CustomerInfos;
import model.DatePair;
import model.WrongInputException;
import view.ExceptionWindow;
import view.TracingWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class that saves input of Tracing Window in database
 * @author Luka Hofer
 *
 */
public class SendTracerInputListener implements ActionListener {
    private TracingWindow window;

    public SendTracerInputListener(TracingWindow window){
        this.window = window;
    }


    /**
     *saves all the input of the Tracing Window in local variables
     *checks if Customer entry already exists => save additional visit
     *else add new customer to database
     *
     *also check for exceptions thrown if input is not valid
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            String name = window.getFirstName();
            String surname = window.getSurName();
            String phoneNumber = window.getPhoneNum();
            DatePair datePair = window.getDateTimePair();

            System.out.println(name + " " + surname + " " + phoneNumber + " " + datePair.toString());

            if(Main.getDatabase().containsKey(phoneNumber)){
                Main.getDatabase().get(phoneNumber).addVisit(datePair);
            }else{
                CustomerInfos newCustomer = new CustomerInfos(name, surname, phoneNumber, datePair);
                Main.getDatabase().put(phoneNumber, newCustomer);
            }
            window.dispose();

        }catch (WrongInputException exception){
            System.out.println(exception.getMessage());
        }catch (Exception exc){
            ExceptionWindow exceptionWindow = new ExceptionWindow("Bitte geben Sie an, wann ihr Besuch geplant ist und wie lange Ihr Besuch dauern soll.");
        }
    }
}