package grpc.hello;
import io.grpc.*;

import java.util.List;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        EchoServiceGrpc.EchoServiceBlockingStub client = createClient("localhost",8080);
        System.out.println("Connected to server");
        Scanner console = new Scanner(System.in);

        int num1 = console.nextShort();//Интерфейс командной строки 读取输入的下一个标记
        int num2 = console.nextShort();
        summRequest summrequest = summRequest.newBuilder().setNum1(num1).setNum2(num2).build();
        summResponse summresponse = client.summ(summrequest);
        System.out.println("res = "+summresponse.getRes());

        //На клиенте для заполнения массива можно вызвать метод addAllArray(List.of(10, 20, 40))
        SummArrayRequest sumarrayrequest = SummArrayRequest.newBuilder().addAllList(List.of(10, 20, 40)).build();

        //5. Написать вызов опубликованной функции на клиенте, прописав любые входные данные.
        // Вывести полученный ответ от сервера на экран клиента.
        SummArrayResponse sumarrayresponse = client.sumarray(sumarrayrequest);
        System.out.println("list res = "+sumarrayresponse.getRes());

        //Используется для чтения входного строкового сообщения из консоли,
        // создания его в виде объекта запроса EchoRequest для отправки на сервер gRPC
        // получения ответа EchoResponse, возвращаемого сервером,
        // содержащего эхо сервера на входное сообщение, и печати результата эха.
        String message;
        while((message = console.nextLine())!=null){
            EchoRequest request = EchoRequest.newBuilder().setMessage(message).build();
            EchoResponse response = client.echo(request);
            System.out.println("response="+response.getMessage());
        }
    }

    private static EchoServiceGrpc.EchoServiceBlockingStub createClient(String host, int port){
        Channel channel = ManagedChannelBuilder.forAddress(host,port)
                .usePlaintext()
                .build();
        return EchoServiceGrpc.newBlockingStub(channel);
    }
}
