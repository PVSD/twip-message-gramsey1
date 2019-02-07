package com.company;
import java.util.*;
import java.text.*;
public class Main {
    public static ArrayList<MessageList> m1List = new ArrayList<MessageList>();
    public static void main(String[] args) {
        Message m;
        MessageList m1;
	Scanner message = new Scanner(System.in);
        System.out.println("Would you like to 1. Send a message 2. Delete Message 3. Move Message 4. Display Messages ");
        int answer = message.nextInt();
        message.nextLine();

        if (answer == 1){
            System.out.println("Who do you want to text?");
            String person = message.nextLine();
            System.out.println("What do you want to say?");
            String text = message.nextLine();
            m = new Message (person, text);
            addToList(m);
            System.out.println("Your message has sent.");
        }
    }

    private static void addToList(Message text) {
        if(m1List.isEmpty()){
            m1List.add(new MessageList(text.getNumber()));
            m1List.get(0).add(text);
        }
    }
}
