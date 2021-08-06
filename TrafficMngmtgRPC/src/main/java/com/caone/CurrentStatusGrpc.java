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
    comments = "Source: trafficStatus.proto")
public final class CurrentStatusGrpc {

  private CurrentStatusGrpc() {}

  public static final String SERVICE_NAME = "traffic.CurrentStatus";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.caone.trafficRequest,
      com.caone.trafficStatus> getCurrentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "currentStatus",
      requestType = com.caone.trafficRequest.class,
      responseType = com.caone.trafficStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.caone.trafficRequest,
      com.caone.trafficStatus> getCurrentStatusMethod() {
    io.grpc.MethodDescriptor<com.caone.trafficRequest, com.caone.trafficStatus> getCurrentStatusMethod;
    if ((getCurrentStatusMethod = CurrentStatusGrpc.getCurrentStatusMethod) == null) {
      synchronized (CurrentStatusGrpc.class) {
        if ((getCurrentStatusMethod = CurrentStatusGrpc.getCurrentStatusMethod) == null) {
          CurrentStatusGrpc.getCurrentStatusMethod = getCurrentStatusMethod = 
              io.grpc.MethodDescriptor.<com.caone.trafficRequest, com.caone.trafficStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "traffic.CurrentStatus", "currentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.trafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.trafficStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new CurrentStatusMethodDescriptorSupplier("currentStatus"))
                  .build();
          }
        }
     }
     return getCurrentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.caone.futureTrafficRequest,
      com.caone.forecastTrafficStatus> getFutureStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "futureStatus",
      requestType = com.caone.futureTrafficRequest.class,
      responseType = com.caone.forecastTrafficStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.caone.futureTrafficRequest,
      com.caone.forecastTrafficStatus> getFutureStatusMethod() {
    io.grpc.MethodDescriptor<com.caone.futureTrafficRequest, com.caone.forecastTrafficStatus> getFutureStatusMethod;
    if ((getFutureStatusMethod = CurrentStatusGrpc.getFutureStatusMethod) == null) {
      synchronized (CurrentStatusGrpc.class) {
        if ((getFutureStatusMethod = CurrentStatusGrpc.getFutureStatusMethod) == null) {
          CurrentStatusGrpc.getFutureStatusMethod = getFutureStatusMethod = 
              io.grpc.MethodDescriptor.<com.caone.futureTrafficRequest, com.caone.forecastTrafficStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "traffic.CurrentStatus", "futureStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.futureTrafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.forecastTrafficStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new CurrentStatusMethodDescriptorSupplier("futureStatus"))
                  .build();
          }
        }
     }
     return getFutureStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrentStatusStub newStub(io.grpc.Channel channel) {
    return new CurrentStatusStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrentStatusBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurrentStatusBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CurrentStatusFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurrentStatusFutureStub(channel);
  }

  /**
   */
  public static abstract class CurrentStatusImplBase implements io.grpc.BindableService {

    /**
     */
    public void currentStatus(com.caone.trafficRequest request,
        io.grpc.stub.StreamObserver<com.caone.trafficStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrentStatusMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.caone.futureTrafficRequest> futureStatus(
        io.grpc.stub.StreamObserver<com.caone.forecastTrafficStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getFutureStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCurrentStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.caone.trafficRequest,
                com.caone.trafficStatus>(
                  this, METHODID_CURRENT_STATUS)))
          .addMethod(
            getFutureStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.caone.futureTrafficRequest,
                com.caone.forecastTrafficStatus>(
                  this, METHODID_FUTURE_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class CurrentStatusStub extends io.grpc.stub.AbstractStub<CurrentStatusStub> {
    private CurrentStatusStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrentStatusStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrentStatusStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrentStatusStub(channel, callOptions);
    }

    /**
     */
    public void currentStatus(com.caone.trafficRequest request,
        io.grpc.stub.StreamObserver<com.caone.trafficStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCurrentStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.caone.futureTrafficRequest> futureStatus(
        io.grpc.stub.StreamObserver<com.caone.forecastTrafficStatus> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFutureStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CurrentStatusBlockingStub extends io.grpc.stub.AbstractStub<CurrentStatusBlockingStub> {
    private CurrentStatusBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrentStatusBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrentStatusBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrentStatusBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.caone.trafficStatus currentStatus(com.caone.trafficRequest request) {
      return blockingUnaryCall(
          getChannel(), getCurrentStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CurrentStatusFutureStub extends io.grpc.stub.AbstractStub<CurrentStatusFutureStub> {
    private CurrentStatusFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrentStatusFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrentStatusFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrentStatusFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.caone.trafficStatus> currentStatus(
        com.caone.trafficRequest request) {
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
    private final CurrentStatusImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrentStatusImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CURRENT_STATUS:
          serviceImpl.currentStatus((com.caone.trafficRequest) request,
              (io.grpc.stub.StreamObserver<com.caone.trafficStatus>) responseObserver);
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
              (io.grpc.stub.StreamObserver<com.caone.forecastTrafficStatus>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CurrentStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CurrentStatusBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.caone.TrafficStatusImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CurrentStatus");
    }
  }

  private static final class CurrentStatusFileDescriptorSupplier
      extends CurrentStatusBaseDescriptorSupplier {
    CurrentStatusFileDescriptorSupplier() {}
  }

  private static final class CurrentStatusMethodDescriptorSupplier
      extends CurrentStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CurrentStatusMethodDescriptorSupplier(String methodName) {
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
      synchronized (CurrentStatusGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrentStatusFileDescriptorSupplier())
              .addMethod(getCurrentStatusMethod())
              .addMethod(getFutureStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
