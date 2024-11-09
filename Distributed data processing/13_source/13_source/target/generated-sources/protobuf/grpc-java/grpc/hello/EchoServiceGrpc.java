package grpc.hello;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: hello.proto")
public final class EchoServiceGrpc {

  private EchoServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.EchoService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.hello.EchoRequest,
      grpc.hello.EchoResponse> METHOD_ECHO =
      io.grpc.MethodDescriptor.<grpc.hello.EchoRequest, grpc.hello.EchoResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.EchoService", "echo"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.hello.EchoRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.hello.EchoResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.hello.summRequest,
      grpc.hello.summResponse> METHOD_SUMM =
      io.grpc.MethodDescriptor.<grpc.hello.summRequest, grpc.hello.summResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.EchoService", "summ"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.hello.summRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.hello.summResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.hello.SummArrayRequest,
      grpc.hello.SummArrayResponse> METHOD_SUMARRAY =
      io.grpc.MethodDescriptor.<grpc.hello.SummArrayRequest, grpc.hello.SummArrayResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.EchoService", "sumarray"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.hello.SummArrayRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.hello.SummArrayResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EchoServiceStub newStub(io.grpc.Channel channel) {
    return new EchoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EchoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EchoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EchoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EchoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EchoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void echo(grpc.hello.EchoRequest request,
        io.grpc.stub.StreamObserver<grpc.hello.EchoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ECHO, responseObserver);
    }

    /**
     */
    public void summ(grpc.hello.summRequest request,
        io.grpc.stub.StreamObserver<grpc.hello.summResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUMM, responseObserver);
    }

    /**
     */
    public void sumarray(grpc.hello.SummArrayRequest request,
        io.grpc.stub.StreamObserver<grpc.hello.SummArrayResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUMARRAY, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ECHO,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.hello.EchoRequest,
                grpc.hello.EchoResponse>(
                  this, METHODID_ECHO)))
          .addMethod(
            METHOD_SUMM,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.hello.summRequest,
                grpc.hello.summResponse>(
                  this, METHODID_SUMM)))
          .addMethod(
            METHOD_SUMARRAY,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.hello.SummArrayRequest,
                grpc.hello.SummArrayResponse>(
                  this, METHODID_SUMARRAY)))
          .build();
    }
  }

  /**
   */
  public static final class EchoServiceStub extends io.grpc.stub.AbstractStub<EchoServiceStub> {
    private EchoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoServiceStub(channel, callOptions);
    }

    /**
     */
    public void echo(grpc.hello.EchoRequest request,
        io.grpc.stub.StreamObserver<grpc.hello.EchoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void summ(grpc.hello.summRequest request,
        io.grpc.stub.StreamObserver<grpc.hello.summResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUMM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sumarray(grpc.hello.SummArrayRequest request,
        io.grpc.stub.StreamObserver<grpc.hello.SummArrayResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUMARRAY, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EchoServiceBlockingStub extends io.grpc.stub.AbstractStub<EchoServiceBlockingStub> {
    private EchoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.hello.EchoResponse echo(grpc.hello.EchoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ECHO, getCallOptions(), request);
    }

    /**
     */
    public grpc.hello.summResponse summ(grpc.hello.summRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUMM, getCallOptions(), request);
    }

    /**
     */
    public grpc.hello.SummArrayResponse sumarray(grpc.hello.SummArrayRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUMARRAY, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EchoServiceFutureStub extends io.grpc.stub.AbstractStub<EchoServiceFutureStub> {
    private EchoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.hello.EchoResponse> echo(
        grpc.hello.EchoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.hello.summResponse> summ(
        grpc.hello.summRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUMM, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.hello.SummArrayResponse> sumarray(
        grpc.hello.SummArrayRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUMARRAY, getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO = 0;
  private static final int METHODID_SUMM = 1;
  private static final int METHODID_SUMARRAY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EchoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EchoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ECHO:
          serviceImpl.echo((grpc.hello.EchoRequest) request,
              (io.grpc.stub.StreamObserver<grpc.hello.EchoResponse>) responseObserver);
          break;
        case METHODID_SUMM:
          serviceImpl.summ((grpc.hello.summRequest) request,
              (io.grpc.stub.StreamObserver<grpc.hello.summResponse>) responseObserver);
          break;
        case METHODID_SUMARRAY:
          serviceImpl.sumarray((grpc.hello.SummArrayRequest) request,
              (io.grpc.stub.StreamObserver<grpc.hello.SummArrayResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class EchoServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.hello.EchoServiceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EchoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EchoServiceDescriptorSupplier())
              .addMethod(METHOD_ECHO)
              .addMethod(METHOD_SUMM)
              .addMethod(METHOD_SUMARRAY)
              .build();
        }
      }
    }
    return result;
  }
}
