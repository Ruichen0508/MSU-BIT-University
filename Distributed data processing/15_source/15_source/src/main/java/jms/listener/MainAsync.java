package jms.listener;

public class MainAsync {
    public static final String url = "tcp://10.21.17.227:61616"; //localhost:8080
    public static void main(String[] args) {
        new Thread(new HelloProducer(url)).start();
        new Thread(new HelloConsumer(url)).start();
    }
}
