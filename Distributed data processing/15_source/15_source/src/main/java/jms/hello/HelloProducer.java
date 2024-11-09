package jms.hello;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class HelloProducer implements Runnable {
    private final String url;
    private final String queueName;

    public HelloProducer(String url,String queueName){
        this.url = url;
        this.queueName = queueName;
    }

    @Override
    public void run() {
        try {
            // Create a ConnectionFactory
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            //创建一个 Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            // 创建目的地 (Topic 或 Queue)
            Destination destination = session.createQueue(queueName);
            System.out.println("destination="+destination);

            // Create a MessageProducer from the Session to the Topic or Queue
            // 从 Session 创建一个 MessageConsumer 来订阅 Topic 或 Queue
            MessageProducer producer = session.createProducer(destination);
            // 设置消息传递模式为非持久化模式（可以注释掉该行，因为后面设置了持久化模式，两者只需设置其中一个）
            //producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            // 设置消息传递模式为持久化模式


            // Create a messages
            // 等待消息到达
            String text = "Hello world! From: " + Thread.currentThread().getName();
            TextMessage message = session.createTextMessage(text);

            // Tell the producer to send the message
            // 告诉生产者发送消息
            System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);// 发送消息

            // Clean up
            session.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

}
