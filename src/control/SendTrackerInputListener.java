package control;

import main.Main;
import model.CustomerInfos;
import model.DatePair;
import model.WrongInputException;
import view.ContactPersonWindow;
import view.ExceptionWindow;
import view.TrackingWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Listener class that checks for all contact persons after button click
 * @author Luka Hofer
 *
 */
public class SendTrackerInputListener implements ActionListener {

    private TrackingWindow window;
    private LinkedList<CustomerInfos> contactPersons;
    private LinkedList<DatePair> visits;

    public SendTrackerInputListener(TrackingWindow window){
        this.window = window;
    }

    

    /**
     *saves input from TextFields of the TrackingWindow in local variables
     *saves customers with overlapping visits in LinkedList contactPersons by calling the addContactPersons() function
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String name = window.getFirstName();
            String surname = window.getSurName();
            String phoneNumber = window.getPhoneNum();

            if(!Main.getDatabase().containsKey(phoneNumber))
                throw new WrongInputException("Zu den angegebenen Kontaktdaten konnte kein Eintrag gefunden werden. \nÜberprüfen Sie die Telefonnummer.");
            else{
                visits = Main.getDatabase().get(phoneNumber).getVisits();
                contactPersons = new LinkedList<>();
                addContactPersons(contactPersons);

                window.dispose();
                ContactPersonWindow contactPersonWindow = new ContactPersonWindow(createOutputString());
            }
        }catch (WrongInputException exception){
            System.out.println(exception.getMessage());
        }catch (Exception exc){
            ExceptionWindow exceptionWindow = new ExceptionWindow("Bitte geben Sie an, wie lange Ihr Besuch dauern soll.");
        }


    }


    /**
     * creates output String for ContactPersonWindow to display with the information of all contact persons
     * @return String with all information
     */
    public String createOutputString(){
        String result = "";
        for(int i=0; i<contactPersons.size(); i++) {
            result += contactPersons.get(i).getName() + "   " + contactPersons.get(i).getSurname() + "   " + contactPersons.get(i).getPhoneNumber() + "\n";
        }
        return result;
    }
    

    /**
     * checks for each saved customer in database if their visit overlaps with current customer 
     * if so, the other customer is added to the LikedList contactPersons
     * 
     * @param contactPersons LinkedList of all the customers that have an overlapping visit with the current customer
     */
    private void addContactPersons(LinkedList<CustomerInfos> contactPersons){

        //iterate over every other customer in database
        for (CustomerInfos customer : Main.getDatabase().values()) {
            //save visit DatePairs of current customer in LinkedList
            LinkedList<DatePair> otherCustomerVisits = customer.getVisits();

            //check if visits of current customer overlap ==> add customer to contactPerson-LinkedList
            if (dateOverlap(visits, otherCustomerVisits))
                contactPersons.add(Main.getDatabase().get(customer.getPhoneNumber()));
        }
    }

    
    /**
     * function that checks if two customers have overlapping visits
     * therefore two LinkedLists with the visits of both customers are being checked
     * 
     * @param visits list with visits of current customer
     * @param otherCustomerVisits list with visits of other customer from the database
     * @return return is true if visits of the customers overlap, false otherwise
     */
    private boolean dateOverlap (LinkedList<DatePair> visits, LinkedList<DatePair> otherCustomerVisits){

        //iterate over all saved visits of infected person and save current DatePair in pair1
        for(int i=0; i<visits.size(); i++) {
            DatePair pair1 = visits.get(i);

            //iterate over all saved visits of other customer and save current DatePair in pair2
            for (int j = 0; j < otherCustomerVisits.size(); j++) {
                DatePair pair2 = otherCustomerVisits.get(j);

                //check all possibilities of time overlap
                if (pair1.getStart().isBefore(pair2.getStart()) && !pair1.getEnd().isBefore(pair2.getStart())) {
                    return true;
                } else if (pair1.getStart().isAfter((pair2.getStart())) && pair1.getStart().isBefore(pair2.getEnd())) {
                    return true;
                } else if (pair1.getStart().isEqual(pair2.getStart()) || pair1.getEnd().isEqual(pair2.getEnd())){
                    return true;
                }
            }
        }
        return false;
    }


}