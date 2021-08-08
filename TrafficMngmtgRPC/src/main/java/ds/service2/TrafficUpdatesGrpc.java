package ds.service2;

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
    comments = "Source: service2TrafficUpdates.proto")
public final class TrafficUpdatesGrpc {

  private TrafficUpdatesGrpc() {}

  public static final String SERVICE_NAME = "service2.TrafficUpdates";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service2.currentLocation,
      ds.service2.trafficUpdate> getLiveUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "liveUpdate",
      requestType = ds.service2.currentLocation.class,
      responseType = ds.service2.trafficUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.currentLocation,
      ds.service2.trafficUpdate> getLiveUpdateMethod() {
    io.grpc.MethodDescriptor<ds.service2.currentLocation, ds.service2.trafficUpdate> getLiveUpdateMethod;
    if ((getLiveUpdateMethod = TrafficUpdatesGrpc.getLiveUpdateMethod) == null) {
      synchronized (TrafficUpdatesGrpc.class) {
        if ((getLiveUpdateMethod = TrafficUpdatesGrpc.getLiveUpdateMethod) == null) {
          TrafficUpdatesGrpc.getLiveUpdateMethod = getLiveUpdateMethod = 
              io.grpc.MethodDescriptor.<ds.service2.currentLocation, ds.service2.trafficUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.TrafficUpdates", "liveUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.currentLocation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.trafficUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new TrafficUpdatesMethodDescriptorSupplier("liveUpdate"))
                  .build();
          }
        }
     }
     return getLiveUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.registration,
      ds.service2.registrationStatus> getNewUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newUser",
      requestType = ds.service2.registration.class,
      responseType = ds.service2.registrationStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.registration,
      ds.service2.registrationStatus> getNewUserMethod() {
    io.grpc.MethodDescriptor<ds.service2.registration, ds.service2.registrationStatus> getNewUserMethod;
    if ((getNewUserMethod = TrafficUpdatesGrpc.getNewUserMethod) == null) {
      synchronized (TrafficUpdatesGrpc.class) {
        if ((getNewUserMethod = TrafficUpdatesGrpc.getNewUserMethod) == null) {
          TrafficUpdatesGrpc.getNewUserMethod = getNewUserMethod = 
              io.grpc.MethodDescriptor.<ds.service2.registration, ds.service2.registrationStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service2.TrafficUpdates", "newUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.registration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.registrationStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new TrafficUpdatesMethodDescriptorSupplier("newUser"))
                  .build();
          }
        }
     }
     return getNewUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrafficUpdatesStub newStub(io.grpc.Channel channel) {
    return new TrafficUpdatesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrafficUpdatesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrafficUpdatesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrafficUpdatesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrafficUpdatesFutureStub(channel);
  }

  /**
   */
  public static abstract class TrafficUpdatesImplBase implements io.grpc.BindableService {

    /**
     */
    public void liveUpdate(ds.service2.currentLocation request,
        io.grpc.stub.StreamObserver<ds.service2.trafficUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getLiveUpdateMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service2.registration> newUser(
        io.grpc.stub.StreamObserver<ds.service2.registrationStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getNewUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLiveUpdateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service2.currentLocation,
                ds.service2.trafficUpdate>(
                  this, METHODID_LIVE_UPDATE)))
          .addMethod(
            getNewUserMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.service2.registration,
                ds.service2.registrationStatus>(
                  this, METHODID_NEW_USER)))
          .build();
    }
  }

  /**
   */
  public static final class TrafficUpdatesStub extends io.grpc.stub.AbstractStub<TrafficUpdatesStub> {
    private TrafficUpdatesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrafficUpdatesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrafficUpdatesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrafficUpdatesStub(channel, callOptions);
    }

    /**
     */
    public void liveUpdate(ds.service2.currentLocation request,
        io.grpc.stub.StreamObserver<ds.service2.trafficUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLiveUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.service2.registration> newUser(
        io.grpc.stub.StreamObserver<ds.service2.registrationStatus> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getNewUserMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TrafficUpdatesBlockingStub extends io.grpc.stub.AbstractStub<TrafficUpdatesBlockingStub> {
    private TrafficUpdatesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrafficUpdatesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrafficUpdatesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrafficUpdatesBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<ds.service2.trafficUpdate> liveUpdate(
        ds.service2.currentLocation request) {
      return blockingServerStreamingCall(
          getChannel(), getLiveUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TrafficUpdatesFutureStub extends io.grpc.stub.AbstractStub<TrafficUpdatesFutureStub> {
    private TrafficUpdatesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrafficUpdatesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrafficUpdatesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrafficUpdatesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIVE_UPDATE = 0;
  private static final int METHODID_NEW_USER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrafficUpdatesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrafficUpdatesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIVE_UPDATE:
          serviceImpl.liveUpdate((ds.service2.currentLocation) request,
              (io.grpc.stub.StreamObserver<ds.service2.trafficUpdate>) responseObserver);
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
        case METHODID_NEW_USER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.newUser(
              (io.grpc.stub.StreamObserver<ds.service2.registrationStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TrafficUpdatesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrafficUpdatesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service2.DynamicTrafficControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrafficUpdates");
    }
  }

  private static final class TrafficUpdatesFileDescriptorSupplier
      extends TrafficUpdatesBaseDescriptorSupplier {
    TrafficUpdatesFileDescriptorSupplier() {}
  }

  private static final class TrafficUpdatesMethodDescriptorSupplier
      extends TrafficUpdatesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrafficUpdatesMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrafficUpdatesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrafficUpdatesFileDescriptorSupplier())
              .addMethod(getLiveUpdateMethod())
              .addMethod(getNewUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
