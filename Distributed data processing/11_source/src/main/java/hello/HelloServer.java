package hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server {
    public static final String address = "http://10.22.10.176:8080/";
    public static final String wsdl = "http://10.22.10.176:8080/?wsdl";
    public static final String implementationClass = "ws.Server";

    public String sayHello() {
        return "Hello!";
    }

    public String sendMessage(Message msg) {
        String address = msg.getAddress();
        String wsdl = msg.getWsdl();
        String implementationClass = msg.getImplementationClass();
        System.out.println("Sending Message:");
        System.out.println("Address: " + address);
        System.out.println("Wsdl: " + wsdl);
        System.out.println("ImplementationClass: " + implementationClass);

        return "Sending Message: " + address + " " + wsdl + " " + implementationClass;
    }

    public static void main(String[] args) {
        Server server = new Server();
        Endpoint.publish(address, server);
        System.out.println("WebService started");
    }
}
