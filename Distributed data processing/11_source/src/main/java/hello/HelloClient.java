package hello;

public class HelloClient {
    public static final String url = "http://10.22.10.176:8080/?wsdl";

    public static void main(String[] args) throws Exception {
        hello.Server hello = new hello.Server(); // 更改为 hello 包下的 Server 类
        hello.Message msg = new hello.Message(); // 更改为 hello 包下的 Message 类

        System.out.println("Sending Message:");
        System.out.println("Address: " + msg.getAddress());
        System.out.println("Wsdl: " + msg.getWsdl());
        System.out.println("ImplementationClass："+msg.getImplementationClass());
        String txt = hello.sendMessage(msg);
        System.out.println(txt);
        System.out.println(hello.sayHello());
    }
}
