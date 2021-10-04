package model;


import java.util.LinkedList;

/**
 * class that stores information about each customer in database
 * @author Luka Hofer
 *
 */
public class CustomerInfos {
    private String name;
    private String surname;
    private String phoneNumber;

    private LinkedList<DatePair> visits;


    public CustomerInfos(String name, String surname, String phoneNumber, DatePair datePair){
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;

        visits = new LinkedList<>();
        visits.add(datePair);
    }

    public void addVisit(DatePair datePair){
        visits.add(datePair);
    }

    public LinkedList<DatePair> getVisits(){
        return this.visits;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getName(){ return this.name; }
    public String getSurname(){ return this.surname; }
}