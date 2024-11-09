package grpc.carservice;

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
    comments = "Source: CarService.proto")
public final class CarServiceGrpc {

  private CarServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.ex1.CarService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.carservice.AddNewCarRequest,
      grpc.carservice.AddNewCarResponse> METHOD_CREATE_CAR =
      io.grpc.MethodDescriptor.<grpc.carservice.AddNewCarRequest, grpc.carservice.AddNewCarResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.ex1.CarService", "createCar"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.carservice.AddNewCarRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.carservice.AddNewCarResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.carservice.SetCarColorRequest,
      com.google.protobuf.Empty> METHOD_SET_CAR_COLOR =
      io.grpc.MethodDescriptor.<grpc.carservice.SetCarColorRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.ex1.CarService", "setCarColor"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.carservice.SetCarColorRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.carservice.MoveCarRequest,
      grpc.carservice.MoveCarResponse> METHOD_MOVE_CAR =
      io.grpc.MethodDescriptor.<grpc.carservice.MoveCarRequest, grpc.carservice.MoveCarResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.ex1.CarService", "moveCar"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.carservice.MoveCarRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.carservice.MoveCarResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<grpc.carservice.SetCarNameRequest,
      com.google.protobuf.Empty> METHOD_SET_CAR_NAME =
      io.grpc.MethodDescriptor.<grpc.carservice.SetCarNameRequest, com.google.protobuf.Empty>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "grpc.ex1.CarService", "setCarName"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              grpc.carservice.SetCarNameRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.google.protobuf.Empty.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarServiceStub newStub(io.grpc.Channel channel) {
    return new CarServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CarServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CarServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CarServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCar(grpc.carservice.AddNewCarRequest request,
        io.grpc.stub.StreamObserver<grpc.carservice.AddNewCarResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE_CAR, responseObserver);
    }

    /**
     * <pre>
     *即使接口不需要参数或返回值，也得指定一个message
     * </pre>
     */
    public void setCarColor(grpc.carservice.SetCarColorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_CAR_COLOR, responseObserver);
    }

    /**
     */
    public void moveCar(grpc.carservice.MoveCarRequest request,
        io.grpc.stub.StreamObserver<grpc.carservice.MoveCarResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MOVE_CAR, responseObserver);
    }

    /**
     */
    public void setCarName(grpc.carservice.SetCarNameRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_CAR_NAME, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE_CAR,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.carservice.AddNewCarRequest,
                grpc.carservice.AddNewCarResponse>(
                  this, METHODID_CREATE_CAR)))
          .addMethod(
            METHOD_SET_CAR_COLOR,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.carservice.SetCarColorRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SET_CAR_COLOR)))
          .addMethod(
            METHOD_MOVE_CAR,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.carservice.MoveCarRequest,
                grpc.carservice.MoveCarResponse>(
                  this, METHODID_MOVE_CAR)))
          .addMethod(
            METHOD_SET_CAR_NAME,
            asyncUnaryCall(
              new MethodHandlers<
                grpc.carservice.SetCarNameRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SET_CAR_NAME)))
          .build();
    }
  }

  /**
   */
  public static final class CarServiceStub extends io.grpc.stub.AbstractStub<CarServiceStub> {
    private CarServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCar(grpc.carservice.AddNewCarRequest request,
        io.grpc.stub.StreamObserver<grpc.carservice.AddNewCarResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE_CAR, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *即使接口不需要参数或返回值，也得指定一个message
     * </pre>
     */
    public void setCarColor(grpc.carservice.SetCarColorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_CAR_COLOR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void moveCar(grpc.carservice.MoveCarRequest request,
        io.grpc.stub.StreamObserver<grpc.carservice.MoveCarResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MOVE_CAR, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setCarName(grpc.carservice.SetCarNameRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_CAR_NAME, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CarServiceBlockingStub extends io.grpc.stub.AbstractStub<CarServiceBlockingStub> {
    private CarServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.carservice.AddNewCarResponse createCar(grpc.carservice.AddNewCarRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE_CAR, getCallOptions(), request);
    }

    /**
     * <pre>
     *即使接口不需要参数或返回值，也得指定一个message
     * </pre>
     */
    public com.google.protobuf.Empty setCarColor(grpc.carservice.SetCarColorRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_CAR_COLOR, getCallOptions(), request);
    }

    /**
     */
    public grpc.carservice.MoveCarResponse moveCar(grpc.carservice.MoveCarRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MOVE_CAR, getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty setCarName(grpc.carservice.SetCarNameRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_CAR_NAME, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CarServiceFutureStub extends io.grpc.stub.AbstractStub<CarServiceFutureStub> {
    private CarServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.carservice.AddNewCarResponse> createCar(
        grpc.carservice.AddNewCarRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE_CAR, getCallOptions()), request);
    }

    /**
     * <pre>
     *即使接口不需要参数或返回值，也得指定一个message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> setCarColor(
        grpc.carservice.SetCarColorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_CAR_COLOR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.carservice.MoveCarResponse> moveCar(
        grpc.carservice.MoveCarRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MOVE_CAR, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> setCarName(
        grpc.carservice.SetCarNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_CAR_NAME, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CAR = 0;
  private static final int METHODID_SET_CAR_COLOR = 1;
  private static final int METHODID_MOVE_CAR = 2;
  private static final int METHODID_SET_CAR_NAME = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CarServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CarServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CAR:
          serviceImpl.createCar((grpc.carservice.AddNewCarRequest) request,
              (io.grpc.stub.StreamObserver<grpc.carservice.AddNewCarResponse>) responseObserver);
          break;
        case METHODID_SET_CAR_COLOR:
          serviceImpl.setCarColor((grpc.carservice.SetCarColorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_MOVE_CAR:
          serviceImpl.moveCar((grpc.carservice.MoveCarRequest) request,
              (io.grpc.stub.StreamObserver<grpc.carservice.MoveCarResponse>) responseObserver);
          break;
        case METHODID_SET_CAR_NAME:
          serviceImpl.setCarName((grpc.carservice.SetCarNameRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static final class CarServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.carservice.CarServiceProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CarServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarServiceDescriptorSupplier())
              .addMethod(METHOD_CREATE_CAR)
              .addMethod(METHOD_SET_CAR_COLOR)
              .addMethod(METHOD_MOVE_CAR)
              .addMethod(METHOD_SET_CAR_NAME)
              .build();
        }
      }
    }
    return result;
  }
}
