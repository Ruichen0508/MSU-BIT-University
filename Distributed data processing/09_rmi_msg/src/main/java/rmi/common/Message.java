package rmi.common;

import java.io.Serializable;

/*
1.在服务器的 message（） 函数中返回给服务器，对收到的消息的响应形式为：“Hello， <name>！在客户端上显示此响应。
2.将新的 Message 类添加到包含字符串名称和消息的服务器。添加到类 HelloServer 函数是一个接受 Message 类对象的 objMessage（） 函数。
将此类的对象发送到客户端，并从服务器输出响应。
3.向客户端添加一个名为 Message2 的新类，该类继承自 Message 之外，除了名称和消息字符串外，还包含一个返回名称的 getName（） 方法。
通过分配相同的 serialVersionUID 实现客户端对对象的传输 的消息类和使用不可变的 objMessage（） 函数在服务器上接收消息 2。
*/
public class Message implements Serializable {
    public String name;
    public String message;

    public Message(String name, String message) {
        this.message = message;
        this.name = name;
    }
}
