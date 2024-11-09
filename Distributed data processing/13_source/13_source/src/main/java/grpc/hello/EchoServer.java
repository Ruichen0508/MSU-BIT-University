package grpc.hello;
import io.grpc.*;

public class EchoServer extends EchoServiceGrpc.EchoServiceImplBase {
    @Override
    public void echo(EchoRequest request,
                     io.grpc.stub.StreamObserver<EchoResponse> responseObserver) {
        System.out.println("receive:"+request.getMessage());
        EchoResponse response = EchoResponse.newBuilder().setMessage("from server:"+request.getMessage()).build();
        responseObserver.onNext(response);//responseObserver.onNext(rsp ); 调用回调的方法以及传入的参数
        responseObserver.onCompleted();//requestObserver.onCompleted();  所有回调完成的回调方法，这个在接受方也可写具体的方法逻辑
    }

    @Override
    //На сервере в методе sumarray() для получения массива можно вызвать request.getArrayList();
    public void sumarray(SummArrayRequest request,io.grpc.stub.StreamObserver<SummArrayResponse> responseObserver){
        SummArrayResponse response = SummArrayResponse.newBuilder().setRes(
                request.getListList().stream().reduce(Integer::sum).orElse(0)//Stream.reduce(Integer::sum)相当于求和
                //数组里没东西的时候就是0
        ).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    //2. Добавить в этом же файле в блоке service новый метод summ принимающий и возвращающий новые типы сообщений.
    public void summ(summRequest request,io.grpc.stub.StreamObserver<summResponse> responseObserver){
        //request inupt responseobserve output
        System.out.println("receive:"+request.getNum1() + " " + request.getNum2());
        summResponse response = summResponse.newBuilder().setRes(request.getNum1()+request.getNum2()).build();
        responseObserver.onNext(response);//send给client
        responseObserver.onCompleted();
    }
    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new EchoServer()).build();//向服务器添加类
        server.start();
        System.out.println("Server started");
        server.awaitTermination();
    }
}
