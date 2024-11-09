package rmi.client;

/*
1.在 message（） 函数中返回给服务器，对收到的消息的响应形式为：“Hello， <name>！在客户端上显示此响应。
2.将新的 Message 类添加到包含字符串名称和消息的服务器。添加到类 HelloServer 函数是一个接受 Message 类对象的 objMessage（） 函数。
将此类的对象发送到客户端，并从服务器输出响应。
3.向客户端添加一个名为 Message2 的新类，该类继承自 Message 之外，除了名称和消息字符串外，还包含一个返回名称的 getName（） 方法。
通过分配相同的 serialVersionUID 实现客户端对对象的传输 的消息类和使用不可变的 objMessage（） 函数在服务器上接收消息 2。
*/

import rmi.common.Message;

public class Message2 extends Message {
    private static final long serialVersionUID = 31L;
    //在类中显式声明serialVersionUID = 1L 后，即便更改类属性，反序列化也不会出现异常报错，
    //只是新更改的属性或者新添加的属性不会在反序列化的时候读取到而已。

    public Message2(String name, String message) {
        super(name, message);// 调用父类构造函数
    }

    public String getName() {
        return name;
    }
}
