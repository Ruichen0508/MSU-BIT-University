package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SerializeTCPServer {
    public static void main(String args[]) {
        try {
            int serverPort = 8083; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort); // new server port generated
            //创建 ServerSocket 对象来监听客户端的连接请求
            System.out.println("SerializeServer listen port: " + serverPort);

            while (true) {
                Socket clientSocket = listenSocket.accept(); // listen for new connection
                //接受新的客户端连接
                ObjectOutputStream ous = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                Object data = ois.readObject();//从客户端接收 Message 对象
                System.out.println("Received data: " + data);

                // Get the IP address and port of the client 获取客户端的 IP 地址和端口号
                InetAddress clientIP = clientSocket.getInetAddress();
                int clientPort = ((Message)data).portnum;

                // Send UDP delivery confirmation message to the client
                String confirmMessage = "reply";//准备要发送的 UDP 交付确认消息
                byte[] confirmBuffer = confirmMessage.getBytes();
                DatagramPacket reply = new DatagramPacket(confirmBuffer, confirmBuffer.length, clientIP, clientPort);
                //准备要发送的 UDP 交付确认消息
                DatagramSocket aSocket = new DatagramSocket();
                //创建 DatagramSocket 对象
                aSocket.send(reply);//发送 UDP 数据包
                
                aSocket.close();//关闭 DatagramSocket
            }
        } catch (IOException e) {
            System.out.println("Listen socket:" + e.getMessage());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
