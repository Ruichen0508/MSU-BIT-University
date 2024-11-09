package jms.listener;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

public class HelloConsumer implements Runnable, ExceptionListener {

    private final String url;
    public HelloConsumer(String url){
        this.url = url;
    }
    @Override
    public void run() {
        try {

            // Create a ConnectionFactory
            // 创建一个 ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            // 创建一个 Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            connection.setExceptionListener(this);

            // Create a Session
            // 创建一个 Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            // 创建目的地 (Topic 或 Queue)
            Destination destination = session.createQueue("CHAT");// 创建一个 Queue（队列）

            // Create a MessageConsumer from the Session to the Topic or Queue
            // 从 Session 创建一个 MessageConsumer 来订阅 Topic 或 Queue
           MessageConsumer consumer = session.createConsumer(destination);

            // Wait for a message
            HelloListener listener = new HelloListener();
            consumer.setMessageListener(listener);// 设置消息监听器
            connection.start();// 启动连接，开始接收消息

        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void onException(JMSException e) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}
