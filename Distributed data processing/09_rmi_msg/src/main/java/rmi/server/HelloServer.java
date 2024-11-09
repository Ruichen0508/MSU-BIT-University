package rmi.server;

import rmi.common.HelloChat;
import rmi.common.Message;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/*
1.在服务器message（） 函数中返回给服务器，对收到的消息的响应形式为：“Hello， <name>！在客户端上显示此响应。
2.将新的 Message 类添加到包含字符串名称和消息的服务器。添加到类 HelloServer 函数是一个接受 Message 类对象的 objMessage（） 函数。
将此类的对象发送到客户端，并从服务器输出响应。
3.向客户端添加一个名为 Message2 的新类，该类继承自 Message 之外，除了名称和消息字符串外，还包含一个返回名称的 getName（） 方法。
通过分配相同的 serialVersionUID 实现客户端对对象的传输 的消息类和使用不可变的 objMessage（） 函数在服务器上接收消息 2。
*/

public class HelloServer implements HelloChat {
    public static final int serverport = 8081;
    public static final String name = "HelloChat";

    @Override
    //服务器message（） 函数中返回给服务器，对收到的消息的响应形式为：“Hello， <name>！"
    public String message(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    //在服务器端添加一个名为Message的新类，包含name和message字符串。
    // 在HelloServer类中添加一个名为objMessage()的函数，该函数接受Message类的对象。
    // 客户端发送Message类的对象，并显示服务器的响应。
    public String objMessage(Message msg) throws RemoteException {
        return "Hello, "+msg.name+"!  Message:"+msg.message;
    }

    public static void main(String[] args) throws Exception{
        HelloServer server = new HelloServer();
        Registry registry = LocateRegistry.createRegistry(serverport);
        HelloChat obj = (HelloChat) UnicastRemoteObject.exportObject(server, 0);
        registry.bind(name, obj);
        System.out.println("Server started on port: "+serverport);
    }
}
