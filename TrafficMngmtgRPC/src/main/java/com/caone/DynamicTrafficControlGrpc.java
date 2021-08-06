package com.caone;

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
    comments = "Source: dynamicTrafficControl.proto")
public final class DynamicTrafficControlGrpc {

  private DynamicTrafficControlGrpc() {}

  public static final String SERVICE_NAME = "dynamic.DynamicTrafficControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.caone.currentLocation,
      com.caone.trafficUpdate> getLiveUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "liveUpdate",
      requestType = com.caone.currentLocation.class,
      responseType = com.caone.trafficUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.caone.currentLocation,
      com.caone.trafficUpdate> getLiveUpdateMethod() {
    io.grpc.MethodDescriptor<com.caone.currentLocation, com.caone.trafficUpdate> getLiveUpdateMethod;
    if ((getLiveUpdateMethod = DynamicTrafficControlGrpc.getLiveUpdateMethod) == null) {
      synchronized (DynamicTrafficControlGrpc.class) {
        if ((getLiveUpdateMethod = DynamicTrafficControlGrpc.getLiveUpdateMethod) == null) {
          DynamicTrafficControlGrpc.getLiveUpdateMethod = getLiveUpdateMethod = 
              io.grpc.MethodDescriptor.<com.caone.currentLocation, com.caone.trafficUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "dynamic.DynamicTrafficControl", "liveUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.currentLocation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.trafficUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new DynamicTrafficControlMethodDescriptorSupplier("liveUpdate"))
                  .build();
          }
        }
     }
     return getLiveUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.caone.registration,
      com.caone.registrationStatus> getUserOpsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "userOps",
      requestType = com.caone.registration.class,
      responseType = com.caone.registrationStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.caone.registration,
      com.caone.registrationStatus> getUserOpsMethod() {
    io.grpc.MethodDescriptor<com.caone.registration, com.caone.registrationStatus> getUserOpsMethod;
    if ((getUserOpsMethod = DynamicTrafficControlGrpc.getUserOpsMethod) == null) {
      synchronized (DynamicTrafficControlGrpc.class) {
        if ((getUserOpsMethod = DynamicTrafficControlGrpc.getUserOpsMethod) == null) {
          DynamicTrafficControlGrpc.getUserOpsMethod = getUserOpsMethod = 
              io.grpc.MethodDescriptor.<com.caone.registration, com.caone.registrationStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "dynamic.DynamicTrafficControl", "userOps"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.registration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.registrationStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new DynamicTrafficControlMethodDescriptorSupplier("userOps"))
                  .build();
          }
        }
     }
     return getUserOpsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DynamicTrafficControlStub newStub(io.grpc.Channel channel) {
    return new DynamicTrafficControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DynamicTrafficControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DynamicTrafficControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DynamicTrafficControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DynamicTrafficControlFutureStub(channel);
  }

  /**
   */
  public static abstract class DynamicTrafficControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void liveUpdate(com.caone.currentLocation request,
        io.grpc.stub.StreamObserver<com.caone.trafficUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getLiveUpdateMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.caone.registration> userOps(
        io.grpc.stub.StreamObserver<com.caone.registrationStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getUserOpsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLiveUpdateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.caone.currentLocation,
                com.caone.trafficUpdate>(
                  this, METHODID_LIVE_UPDATE)))
          .addMethod(
            getUserOpsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.caone.registration,
                com.caone.registrationStatus>(
                  this, METHODID_USER_OPS)))
          .build();
    }
  }

  /**
   */
  public static final class DynamicTrafficControlStub extends io.grpc.stub.AbstractStub<DynamicTrafficControlStub> {
    private DynamicTrafficControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DynamicTrafficControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DynamicTrafficControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DynamicTrafficControlStub(channel, callOptions);
    }

    /**
     */
    public void liveUpdate(com.caone.currentLocation request,
        io.grpc.stub.StreamObserver<com.caone.trafficUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLiveUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.caone.registration> userOps(
        io.grpc.stub.StreamObserver<com.caone.registrationStatus> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUserOpsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class DynamicTrafficControlBlockingStub extends io.grpc.stub.AbstractStub<DynamicTrafficControlBlockingStub> {
    private DynamicTrafficControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DynamicTrafficControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DynamicTrafficControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DynamicTrafficControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.caone.trafficUpdate> liveUpdate(
        com.caone.currentLocation request) {
      return blockingServerStreamingCall(
          getChannel(), getLiveUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DynamicTrafficControlFutureStub extends io.grpc.stub.AbstractStub<DynamicTrafficControlFutureStub> {
    private DynamicTrafficControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DynamicTrafficControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DynamicTrafficControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DynamicTrafficControlFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LIVE_UPDATE = 0;
  private static final int METHODID_USER_OPS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DynamicTrafficControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DynamicTrafficControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIVE_UPDATE:
          serviceImpl.liveUpdate((com.caone.currentLocation) request,
              (io.grpc.stub.StreamObserver<com.caone.trafficUpdate>) responseObserver);
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
        case METHODID_USER_OPS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.userOps(
              (io.grpc.stub.StreamObserver<com.caone.registrationStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DynamicTrafficControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DynamicTrafficControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.caone.DynamicTrafficControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DynamicTrafficControl");
    }
  }

  private static final class DynamicTrafficControlFileDescriptorSupplier
      extends DynamicTrafficControlBaseDescriptorSupplier {
    DynamicTrafficControlFileDescriptorSupplier() {}
  }

  private static final class DynamicTrafficControlMethodDescriptorSupplier
      extends DynamicTrafficControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DynamicTrafficControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (DynamicTrafficControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DynamicTrafficControlFileDescriptorSupplier())
              .addMethod(getLiveUpdateMethod())
              .addMethod(getUserOpsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
