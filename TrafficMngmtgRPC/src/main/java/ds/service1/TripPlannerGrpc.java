package ds.service1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1TripPlanner.proto")
public final class TripPlannerGrpc {

  private TripPlannerGrpc() {}

  public static final String SERVICE_NAME = "service1.TripPlanner";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service1.trafficRequest,
      ds.service1.trafficStatus> getCurrentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "currentStatus",
      requestType = ds.service1.trafficRequest.class,
      responseType = ds.service1.trafficStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service1.trafficRequest,
      ds.service1.trafficStatus> getCurrentStatusMethod() {
    io.grpc.MethodDescriptor<ds.service1.trafficRequest, ds.service1.trafficStatus> getCurrentStatusMethod;
    if ((getCurrentStatusMethod = TripPlannerGrpc.getCurrentStatusMethod) == null) {
      synchronized (TripPlannerGrpc.class) {
        if ((getCurrentStatusMethod = TripPlannerGrpc.getCurrentStatusMethod) == null) {
          TripPlannerGrpc.getCurrentStatusMethod = getCurrentStatusMethod = 
              io.grpc.MethodDescriptor.<ds.service1.trafficRequest, ds.service1.trafficStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.TripPlanner", "currentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.trafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.trafficStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new TripPlannerMethodDescriptorSupplier("currentStatus"))
                  .build();
          }
        }
     }
     return getCurrentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service1.futureTrafficRequest,
      ds.service1.forecastTrafficStatus> getFutureStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "futureStatus",
      requestType = ds.service1.futureTrafficRequest.class,
      responseType = ds.service1.forecastTrafficStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service1.futureTrafficRequest,
      ds.service1.forecastTrafficStatus> getFutureStatusMethod() {
    io.grpc.MethodDescriptor<ds.service1.futureTrafficRequest, ds.service1.forecastTrafficStatus> getFutureStatusMethod;
    if ((getFutureStatusMethod = TripPlannerGrpc.getFutureStatusMethod) == null) {
      synchronized (TripPlannerGrpc.class) {
        if ((getFutureStatusMethod = TripPlannerGrpc.getFutureStatusMethod) == null) {
          TripPlannerGrpc.getFutureStatusMethod = getFutureStatusMethod = 
              io.grpc.MethodDescriptor.<ds.service1.futureTrafficRequest, ds.service1.forecastTrafficStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.TripPlanner", "futureStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.futureTrafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.forecastTrafficStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new TripPlannerMethodDescriptorSupplier("futureStatus"))
                  .build();
          }
        }
     }
     return getFutureStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TripPlannerStub newStub(io.grpc.Channel channel) {
    return new TripPlannerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TripPlannerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TripPlannerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TripPlannerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TripPlannerFutureStub(channel);
  }

  /**
   */
  public static abstract class TripPlannerImplBase implements io.grpc.BindableService {

    /**
     */
    public void currentStatus(ds.service1.trafficRequest request,
        io.grpc.stub.StreamObserver<ds.service1.trafficStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrentStatusMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service1.futureTrafficRequest> futureStatus(
        io.grpc.stub.StreamObserver<ds.service1.forecastTrafficStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getFutureStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrentStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service1.trafficRequest,
                ds.service1.trafficStatus>(
                  this, METHODID_CURRENT_STATUS)))
          .addMethod(
            getFutureStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.service1.futureTrafficRequest,
                ds.service1.forecastTrafficStatus>(
                  this, METHODID_FUTURE_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class TripPlannerStub extends io.grpc.stub.AbstractStub<TripPlannerStub> {
    private TripPlannerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TripPlannerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TripPlannerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TripPlannerStub(channel, callOptions);
    }

    /**
     */
    public void currentStatus(ds.service1.trafficRequest request,
        io.grpc.stub.StreamObserver<ds.service1.trafficStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCurrentStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service1.futureTrafficRequest> futureStatus(
        io.grpc.stub.StreamObserver<ds.service1.forecastTrafficStatus> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFutureStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TripPlannerBlockingStub extends io.grpc.stub.AbstractStub<TripPlannerBlockingStub> {
    private TripPlannerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TripPlannerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TripPlannerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TripPlannerBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.service1.trafficStatus currentStatus(ds.service1.trafficRequest request) {
      return blockingUnaryCall(
          getChannel(), getCurrentStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TripPlannerFutureStub extends io.grpc.stub.AbstractStub<TripPlannerFutureStub> {
    private TripPlannerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TripPlannerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TripPlannerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TripPlannerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service1.trafficStatus> currentStatus(
        ds.service1.trafficRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCurrentStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CURRENT_STATUS = 0;
  private static final int METHODID_FUTURE_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TripPlannerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TripPlannerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CURRENT_STATUS:
          serviceImpl.currentStatus((ds.service1.trafficRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.trafficStatus>) responseObserver);
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
        case METHODID_FUTURE_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.futureStatus(
              (io.grpc.stub.StreamObserver<ds.service1.forecastTrafficStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TripPlannerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TripPlannerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service1.TrafficStatusImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TripPlanner");
    }
  }

  private static final class TripPlannerFileDescriptorSupplier
      extends TripPlannerBaseDescriptorSupplier {
    TripPlannerFileDescriptorSupplier() {}
  }

  private static final class TripPlannerMethodDescriptorSupplier
      extends TripPlannerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TripPlannerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TripPlannerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TripPlannerFileDescriptorSupplier())
              .addMethod(getCurrentStatusMethod())
              .addMethod(getFutureStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
