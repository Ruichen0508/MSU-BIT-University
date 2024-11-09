package tcp;

import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

/*
在SerializeTCPClient类中实现UDP端口监听
将客户端监听的UDP端口的号码添加到发送的Message类中
在收到数据包后，SerializeTCPServer应该向客户端发送一个UDP交付确认消息
在收到服务器的交付确认后，客户端应该在控制台中显示一个消息。
---------------------------------------------------------------
要在SerializeCPClient类中实现UDP端口侦听，可以执行以下步骤：
1.创建DatagramSocket对象以侦听特定端口上的传入UDP数据包。
2.修改Message类以在消息中包含UDP端口号。
3.通过TCP套接字将Message对象发送到包含UDP端口号的服务器。
4.从客户端接收到Message对象后，SerializeTPServer应从消息中提取UDP端口号，并使用它创建DatagramPacket对象，以将传递确认消息发送回客户端。
5.SerializeTCP客户端应在指定的UDP端口上侦听传递确认消息，并在收到消息时在控制台中显示消息。
 */
public class SerializeTCPClient {
    public static void main(String args[]) {
        // arguments supply message and hostname
        int serverPort = 8083;
        String serverHost = "localhost";//args[1]; 设置 TCP 服务器的地址（这里为本地主机）
        String message = "Hello world";//args[6];设置要发送的消息
        int portnum = 5000; // port to listen for UDP delivery confirmation
        System.out.print("Connecting to "+serverHost+":"+serverPort+"...");
        try (Socket s = new Socket(serverHost, serverPort)) {
            System.out.println("Connected!");
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());//创建输入和输出流
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            Message msg = new Message(9, "HELP!!!", portnum);
            out.writeObject(msg);//向服务器发送 Message 对象
            System.out.println("Data sent: " + msg);

            DatagramSocket aSocket = new DatagramSocket(portnum);//创建 DatagramSocket 对象用于监听 UDP 数据包
            //并指定要监听的端口**（portnum）**
            byte[] buffer = new byte[100];
            //创建一个字节数组来存储接收到的数据包：
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            //创建 DatagramPacket 对象来接收数据包：

            aSocket.receive(reply);//接收 UDP 数据包
            String confirmationMessage = new String(reply.getData(), 0, reply.getLength());
            System.out.println("reply: " + confirmationMessage);
            //将接收到的数据包转换为字符串，并打印确认消息

        } catch (
                UnknownHostException e) {
            System.out.println("Socket:" + e.getMessage()); // host cannot be resolved
        } catch (
                EOFException e) {
            System.out.println("EOF:" + e.getMessage()); // end of stream reached
        } catch (
                IOException e) {
            System.out.println("Readline:" + e.getMessage()); // error in reading the stream
        }
    }
}
