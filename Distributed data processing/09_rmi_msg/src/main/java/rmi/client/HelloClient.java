package rmi.client;

import rmi.common.HelloChat;
import rmi.common.Message;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
1.在 message（） 函数中返回给服务器，对收到的消息的响应形式为：“Hello， <name>！在客户端上显示此响应。
2.将新的 Message 类添加到包含字符串名称和消息的服务器。添加到类 HelloServer 函数是一个接受 Message 类对象的 objMessage（） 函数。
将此类的对象发送到客户端，并从服务器输出响应。
3.向客户端添加一个名为 Message2 的新类，该类继承自 Message 之外，除了名称和消息字符串外，还包含一个返回名称的 getName（） 方法。
通过分配相同的 serialVersionUID 实现客户端对对象的传输 的消息类和使用不可变的 objMessage（） 函数在服务器上接收消息 2。
*/
public class HelloClient {
    public static final int serverport = 8081;
    public static final String name = "HelloChat";
    public static final String serverhost = "127.0.0.1";

    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry(serverhost, serverport);
        System.out.println(String.format("Client connected to registry on host %s and port %d",serverhost, serverport));
        HelloChat server = (HelloChat) registry.lookup(name);
        System.out.println("server = "+server);
        String res1 = server.message("Alex");
        System.out.println(res1);//1.接收服务器端的message()函数中返回格式为"Hello, <name>!"的应答，并在客户端显示该应答。
        String res2 = server.objMessage(new Message("Alex","hello!message"));
        System.out.println(res2);//2.创建Message对象并发送给服务器，打印服务器响应
        String res3 = server.objMessage(new Message2("Alex","hello!message2"));
        System.out.println(res3);
        //server.message("Alex", "Hello");
    }
}
