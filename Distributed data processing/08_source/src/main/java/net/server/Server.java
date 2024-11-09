package net.server;

import car.BasicCarServer;
import car.CarEventsListener;
import car.CarPainter;
import car.FieldMatrix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends BasicCarServer implements Runnable{
    private final int port;

    public Server(FieldMatrix fieldMatrix, CarEventsListener carEventsListener, int port){
        super(fieldMatrix,carEventsListener);
        this.port = port;
        new Thread(this).start();
    }

    public static void main(String[] args) {
        InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("Field10x10.txt");
        FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is));
        CarPainter p = new CarPainter(fm);
        new Server(fm, p, 8080);
    }

    @Override
    public void run() {
        try {
            //创建 ServerSocket 实例，绑定到指定的端口
            ServerSocket serverSocket = new ServerSocket(port);
            //在一个无限循环中，等待客户端的连接
            while(true) {
                // 当有客户端连接时，accept 方法返回一个新的 Socket 对象
                Socket socket = serverSocket.accept();
                // 为每个客户端连接创建一个新的线程
                // 每个线程的工作由 ClientWorker 类的实例来处理
                new Thread(new ClientWorker(socket, this)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
