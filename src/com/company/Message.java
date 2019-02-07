package com.company;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Created by gr236 on 2/4/19.
 */
public class Message {
    public String personTexting;
    public String texting;
    public Date recieved;
    public Message (String person, String text){
        personTexting = person;
        texting = text;

    }
    public Date getRecievedTime(){
        return recieved;
    }

    public String getNumber(){
        return personTexting;
    }

}
