package jms.hello;

public class MainSync {
    public static final String url = "tcp://10.21.17.227:61616"; //localhost:8080
    public static void main(String[] args) {
        new Thread(new HelloProducer(url,"3-Qu Ruichen")).start();
        new Thread(new HelloConsumer(url,"3-Qu Ruichen")).start();

    }
}
