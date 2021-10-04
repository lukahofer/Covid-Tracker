package main;

import model.CustomerInfos;
import view.MainFrame;


import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Main class that contains main method and creates MainFrame
 * also stores static HashMap called database
 * 
 * @author Luka Hofer
 *
 */
public class Main {

    private static HashMap<String, CustomerInfos> database = new HashMap();

    public static void main(String[] args){

        MainFrame frame1 = new MainFrame();

    }

    public static HashMap<String, CustomerInfos> getDatabase(){
        return database;
    }
}