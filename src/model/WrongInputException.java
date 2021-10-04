package model;

import view.ExceptionWindow;

/**
 * Exception class for wrong inputs in JTextFields
 * creates an exceptionWindow with Error message (String s) in Constructor
 * @author Luka Hofer
 *
 */
public class WrongInputException extends Exception {

    public WrongInputException(String s){
        super(s);
        ExceptionWindow exceptionWindow = new ExceptionWindow(s);
    }
}
