package net.server;

import net.CommandCode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client
{
    private final String serverHost;
    private final int serverPort;

    public Client(String serverHost, int serverPort)
    {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public static void main(String[] args) throws IOException
    {
        Client client = new Client("localhost", 8080);
        client.start();
    }
    public void start() throws IOException
    {
        try
        {
            Socket socket = new Socket(serverHost, serverPort);// 建立与服务器的 Socket 连接
            System.out.println(String.format("Client connected to on host %s and port %d",serverHost, serverPort));
            // 获取输入流和输出流
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            // 初始化车辆方向为随机方向
            CommandCode[] directions = {CommandCode.UP, CommandCode.DOWN, CommandCode.LEFT, CommandCode.RIGHT};
            CommandCode direction = directions[(int) (Math.random() * directions.length)];
            System.out.println(direction);
            // 不断循环向服务器发送方向和步长信息
            while (true)
            {
                // 向服务器发送方向和步长信息
                out.writeUTF(direction.name());// 发送方向
                out.writeUTF(Integer.toString(20));// 发送步长
                // 读取服务器的响应，判断是否会越界
                boolean result = in.readBoolean();
                if (!result) {
                    // 如果越界，选择新的方向
                    direction = directions[(int) (Math.random() * directions.length)];
                    System.out.println("Hit a roadblock, now change direction:" + direction);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}