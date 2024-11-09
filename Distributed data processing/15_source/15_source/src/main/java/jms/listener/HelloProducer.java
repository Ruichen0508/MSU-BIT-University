package jms.listener;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class HelloProducer implements Runnable {
    private final String url;
    private final static int sleep = 1500;// 发送消息间隔时间（毫秒）

    public HelloProducer(String url){
        this.url = url;
    }

    @Override
    public void run() {
        int count = 0;// 计数器，用于记录发送的消息数量
        try {
            // Create a ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();// 启动连接

            // Create a Session// 创建一个 Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("CHAT");
            System.out.println("destination="+destination);

            // Create a MessageProducer from the Session to the Topic or Queue
            // 从 Session 创建一个 MessageProducer 来发送消息
            MessageProducer producer = session.createProducer(destination);
            //producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);// 设置消息传递模式为持久化模式


            while(true) {
                // Create a messages
                String text = "Hello world! From: " + Thread.currentThread().getName() + " count=" + count++;
                TextMessage message = session.createTextMessage(text);

                // Tell the producer to send the message
                // 告诉生产者发送消息
                System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
                producer.send(message); // 发送消息
                Thread.sleep(sleep);// 休眠一段时间后再发送下一条消息
            }

        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

}
