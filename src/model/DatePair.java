package model;

import java.time.LocalDateTime;

/**
 * class that stores a pair of LocalDateTime for each customer
 * one for arrival and one for departure
 * @author Luka Hofer
 *
 */
public class DatePair {

    private LocalDateTime start, end;

    public void setStart(LocalDateTime start){
        this.start = start;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    public LocalDateTime getStart(){
        return start;
    }
    public LocalDateTime getEnd(){
        return end;
    }

    @Override
    public String toString(){
        return start.toString() + " " + end.toString();
    }
}
