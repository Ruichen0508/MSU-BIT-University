package udp;

import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String args[]) {
        // args give message contents and destination hostname
        try {
            String serverHost = args.length>0? args[0]: "localhost";
            int serverPort = args.length>1? Integer.parseInt(args[1]): 8080;
            String message = args.length>2? args[2]: "Hello UDP for java!";

            DatagramSocket aSocket = new DatagramSocket();      // create socket
            byte[] bmessage = message.getBytes();
            InetAddress aHost = InetAddress.getByName(serverHost); // DNS lookup

            DatagramPacket request =
                    new DatagramPacket(bmessage, bmessage.length, aHost, serverPort);
            //创建用于发送的 DatagramPacket
            System.out.println("new packet to "+aHost);
            aSocket.send(request);              //send message // 发送消息
            byte[] buffer = new byte[100];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);//准备用于接收的 DatagramPacket
            aSocket.receive(reply);              //wait for reply 等待回复
            System.out.println("Reply: " + new String(reply.getData()));
            aSocket.close();//关闭 DatagramSocket
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage()); // socket creation failed
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage()); // can be caused by send
        }
    }
}
