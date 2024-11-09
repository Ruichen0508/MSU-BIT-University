package jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class HelloListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try {
                String msg = ((TextMessage) message).getText();
                System.out.println("Listener recieved:"+msg);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("recieved:"+message);
        }
    }
}
