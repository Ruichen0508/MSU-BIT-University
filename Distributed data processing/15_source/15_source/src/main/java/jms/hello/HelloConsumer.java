package jms.hello;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class HelloConsumer implements Runnable, ExceptionListener {

    private final String url;
    private final String queueName;
    // 构造函数，接收 ActiveMQ 服务器的 URL 和队列名称
    public HelloConsumer(String url,String queueName){
        this.url = url;
        this.queueName = queueName;
    }


    @Override
    public void run() {
        try {

            // Create a ConnectionFactory
            // 创建一个 ConnectionFactory，用于创建 Connection
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

            // Create a Connection
            // 创建一个 Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();// 启动连接

            connection.setExceptionListener(this);// 设置异常监听器

            // Create a Session
            // 创建一个 Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(queueName);// 创建一个 Queue（队列）

            // Create a MessageConsumer from the Session to the Topic or Queue
            // 从 Session 创建一个 MessageConsumer 来消费消息
            MessageConsumer consumer = session.createConsumer(destination);

            // Wait for a message
            // 等待消息到达
            Message message = consumer.receive(10000);// 等待消息的最长时间为 10 秒（10000 毫秒）

            if (message instanceof TextMessage) {// 如果接收到的消息是文本消息
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();// 获取文本消息内容
                System.out.println("Received: " + text); // 打印接收到的文本消息内容
            } else {// 如果接收到的消息不是文本消息
                System.out.println("Received: " + message);// 直接打印接收到的消息内容
            }

            consumer.close();// 关闭消息消费者
            session.close();// 关闭会话
            connection.close(); // 关闭连接
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
