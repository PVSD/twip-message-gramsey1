package com.company;
import java.text.*;
import java.util.*;

public class Main {

    public static ArrayList<MessageList> mlList = new ArrayList<MessageList>();

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        Message m;
        MessageList ml;

        while(true){ //why do you need a while(true) loop?
            System.out.println("What would you like to do?: 1. Send Message 2. Delete Message 3. Move Message 4.Display Messages");
            int answer = input.nextInt();
            input.nextLine();

            if(answer == 1){

                System.out.println("Enter person you want to message:");
                String person = input.nextLine();
                System.out.println("Type a message to send:");
                String text = input.nextLine();
                m = new Message(person, text);
                addToList(m);
                System.out.println("Message has sent.");
            }
            else if(answer == 2){
                System.out.print("Enter the person this text is from: ");
                String n = input.nextLine();
                System.out.println("Delete one(1) Delete all(2)");
                answer = input.nextInt();

                if(answer == 1){
                    System.out.print("Enter the position this text is(from oldest(1) to newest): ");
                   int pos = input.nextInt() - 1;

                    boolean found = false;
                    while(true){
                        ml = findList(n);
                        if(ml == null){
                            System.out.println("The number you entered is not in your contacts. Type another one: ");
                            n = input.next();
                        }
                        else{
                            ml.remove(pos);
                            System.out.println("Message deleted.");
                            break;
                        }
                    }
                }
                else{
                    ml = findList(n);
                    ml.clear();
                    System.out.println("Messages deleted.");
                }
            }
            else  if(answer == 3){
                String number = "";
                int p = 0;
                System.out.println("Enter the phone number of the message you would like to move: ");
                number = input.next();
                System.out.println("Enter the position that message is in the stream(oldest is 1): ");
                p = input.nextInt() - 1;
                MessageList from = null;
                for(MessageList mli: mlList){
                    if(mli.getNum().equals(number)){
                        m = new Message(number, mli.get(p).getMessage());
                        from = mli;
                    }
                }
                System.out.println("What number do you want to forward this to? ");
                number = input.next();
                ml = findList(number);
                if(ml == null){
                    System.out.println("This number is not in your contacts");
                }
                else{
                    from.move(p, ml, from);
                    System.out.println("Message forwarded.");
                }
            }
            else if(answer == 4){
                String numb = "";
                System.out.println("Display messages from which number?");
                numb = input.next();
                findList(numb).displayMsgs();
            }

        }
    }

    public static void addToList(Message msg){
        if(mlList.isEmpty()){
            mlList.add(new MessageList(msg.getNumber()));
            mlList.get(0).add(msg);
        }
        else{
            boolean flag = false;
            for(MessageList ml: mlList){
                if(ml.getNum().equals(msg.getNumber())){
                    ml.add(msg);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                mlList.add(new MessageList(msg.getNumber()));
                mlList.get(mlList.size() - 1).add(msg);
            }
        }
    }

    public static MessageList findList(String pNum){
        for(MessageList ml: mlList){
            if(ml.getNum().equals(pNum)){
                return ml;
            }
        }
        return null;
    }
}
