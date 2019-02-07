package com.company;
import java.util.ArrayList;
/**
 * Created by gr236 on 2/4/19.
 */
public class MessageList {
    public ArrayList<Message> messages = new ArrayList<Message>();
    public String title = "";
    public MessageList(String p){
        title = p;
    }
    public void add(Message m){
        int count = 0;
        long time = m.getRecievedTime().getTime();
        for(Message msg: messages){
            if(time > msg.getRecievedTime().getTime()){
                count++;
            }
            messages.add(count, m);
        }
    }
}
