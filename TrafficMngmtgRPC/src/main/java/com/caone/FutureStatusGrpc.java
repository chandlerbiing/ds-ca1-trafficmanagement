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
public final class FutureStatusGrpc {

  private FutureStatusGrpc() {}

  public static final String SERVICE_NAME = "trafficStatus.FutureStatus";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.caone.trafficRequest,
      com.caone.forecastTrafficStatus> getFutureStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "futureStatus",
      requestType = com.caone.trafficRequest.class,
      responseType = com.caone.forecastTrafficStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.caone.trafficRequest,
      com.caone.forecastTrafficStatus> getFutureStatusMethod() {
    io.grpc.MethodDescriptor<com.caone.trafficRequest, com.caone.forecastTrafficStatus> getFutureStatusMethod;
    if ((getFutureStatusMethod = FutureStatusGrpc.getFutureStatusMethod) == null) {
      synchronized (FutureStatusGrpc.class) {
        if ((getFutureStatusMethod = FutureStatusGrpc.getFutureStatusMethod) == null) {
          FutureStatusGrpc.getFutureStatusMethod = getFutureStatusMethod = 
              io.grpc.MethodDescriptor.<com.caone.trafficRequest, com.caone.forecastTrafficStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "trafficStatus.FutureStatus", "futureStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.trafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.caone.forecastTrafficStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new FutureStatusMethodDescriptorSupplier("futureStatus"))
                  .build();
          }
        }
     }
     return getFutureStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FutureStatusStub newStub(io.grpc.Channel channel) {
    return new FutureStatusStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FutureStatusBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FutureStatusBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FutureStatusFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FutureStatusFutureStub(channel);
  }

  /**
   */
  public static abstract class FutureStatusImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.caone.trafficRequest> futureStatus(
        io.grpc.stub.StreamObserver<com.caone.forecastTrafficStatus> responseObserver) {
      return asyncUnimplementedStreamingCall(getFutureStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFutureStatusMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.caone.trafficRequest,
                com.caone.forecastTrafficStatus>(
                  this, METHODID_FUTURE_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class FutureStatusStub extends io.grpc.stub.AbstractStub<FutureStatusStub> {
    private FutureStatusStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FutureStatusStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FutureStatusStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FutureStatusStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.caone.trafficRequest> futureStatus(
        io.grpc.stub.StreamObserver<com.caone.forecastTrafficStatus> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFutureStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FutureStatusBlockingStub extends io.grpc.stub.AbstractStub<FutureStatusBlockingStub> {
    private FutureStatusBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FutureStatusBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FutureStatusBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FutureStatusBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class FutureStatusFutureStub extends io.grpc.stub.AbstractStub<FutureStatusFutureStub> {
    private FutureStatusFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FutureStatusFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FutureStatusFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FutureStatusFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_FUTURE_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FutureStatusImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FutureStatusImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
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

  private static abstract class FutureStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FutureStatusBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.caone.TrafficMngmtImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FutureStatus");
    }
  }

  private static final class FutureStatusFileDescriptorSupplier
      extends FutureStatusBaseDescriptorSupplier {
    FutureStatusFileDescriptorSupplier() {}
  }

  private static final class FutureStatusMethodDescriptorSupplier
      extends FutureStatusBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FutureStatusMethodDescriptorSupplier(String methodName) {
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
      synchronized (FutureStatusGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FutureStatusFileDescriptorSupplier())
              .addMethod(getFutureStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
