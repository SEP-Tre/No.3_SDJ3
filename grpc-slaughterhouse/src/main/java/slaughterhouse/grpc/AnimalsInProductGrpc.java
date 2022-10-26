package slaughterhouse.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: RecallService.proto")
public final class AnimalsInProductGrpc {

  private AnimalsInProductGrpc() {}

  public static final String SERVICE_NAME = "slaughterhouse.grpc.AnimalsInProduct";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<slaughterhouse.grpc.ProductId,
      slaughterhouse.grpc.AnimalsIdList> getAnimalsInProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "animalsInProduct",
      requestType = slaughterhouse.grpc.ProductId.class,
      responseType = slaughterhouse.grpc.AnimalsIdList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<slaughterhouse.grpc.ProductId,
      slaughterhouse.grpc.AnimalsIdList> getAnimalsInProductMethod() {
    io.grpc.MethodDescriptor<slaughterhouse.grpc.ProductId, slaughterhouse.grpc.AnimalsIdList> getAnimalsInProductMethod;
    if ((getAnimalsInProductMethod = AnimalsInProductGrpc.getAnimalsInProductMethod) == null) {
      synchronized (AnimalsInProductGrpc.class) {
        if ((getAnimalsInProductMethod = AnimalsInProductGrpc.getAnimalsInProductMethod) == null) {
          AnimalsInProductGrpc.getAnimalsInProductMethod = getAnimalsInProductMethod =
              io.grpc.MethodDescriptor.<slaughterhouse.grpc.ProductId, slaughterhouse.grpc.AnimalsIdList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "animalsInProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  slaughterhouse.grpc.ProductId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  slaughterhouse.grpc.AnimalsIdList.getDefaultInstance()))
              .setSchemaDescriptor(new AnimalsInProductMethodDescriptorSupplier("animalsInProduct"))
              .build();
        }
      }
    }
    return getAnimalsInProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnimalsInProductStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnimalsInProductStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnimalsInProductStub>() {
        @java.lang.Override
        public AnimalsInProductStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnimalsInProductStub(channel, callOptions);
        }
      };
    return AnimalsInProductStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnimalsInProductBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnimalsInProductBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnimalsInProductBlockingStub>() {
        @java.lang.Override
        public AnimalsInProductBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnimalsInProductBlockingStub(channel, callOptions);
        }
      };
    return AnimalsInProductBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnimalsInProductFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnimalsInProductFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnimalsInProductFutureStub>() {
        @java.lang.Override
        public AnimalsInProductFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnimalsInProductFutureStub(channel, callOptions);
        }
      };
    return AnimalsInProductFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AnimalsInProductImplBase implements io.grpc.BindableService {

    /**
     */
    public void animalsInProduct(slaughterhouse.grpc.ProductId request,
        io.grpc.stub.StreamObserver<slaughterhouse.grpc.AnimalsIdList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnimalsInProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnimalsInProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                slaughterhouse.grpc.ProductId,
                slaughterhouse.grpc.AnimalsIdList>(
                  this, METHODID_ANIMALS_IN_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class AnimalsInProductStub extends io.grpc.stub.AbstractAsyncStub<AnimalsInProductStub> {
    private AnimalsInProductStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalsInProductStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnimalsInProductStub(channel, callOptions);
    }

    /**
     */
    public void animalsInProduct(slaughterhouse.grpc.ProductId request,
        io.grpc.stub.StreamObserver<slaughterhouse.grpc.AnimalsIdList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnimalsInProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AnimalsInProductBlockingStub extends io.grpc.stub.AbstractBlockingStub<AnimalsInProductBlockingStub> {
    private AnimalsInProductBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalsInProductBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnimalsInProductBlockingStub(channel, callOptions);
    }

    /**
     */
    public slaughterhouse.grpc.AnimalsIdList animalsInProduct(slaughterhouse.grpc.ProductId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnimalsInProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnimalsInProductFutureStub extends io.grpc.stub.AbstractFutureStub<AnimalsInProductFutureStub> {
    private AnimalsInProductFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnimalsInProductFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnimalsInProductFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<slaughterhouse.grpc.AnimalsIdList> animalsInProduct(
        slaughterhouse.grpc.ProductId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnimalsInProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANIMALS_IN_PRODUCT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnimalsInProductImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnimalsInProductImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANIMALS_IN_PRODUCT:
          serviceImpl.animalsInProduct((slaughterhouse.grpc.ProductId) request,
              (io.grpc.stub.StreamObserver<slaughterhouse.grpc.AnimalsIdList>) responseObserver);
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

  private static abstract class AnimalsInProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnimalsInProductBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return slaughterhouse.grpc.RecallService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnimalsInProduct");
    }
  }

  private static final class AnimalsInProductFileDescriptorSupplier
      extends AnimalsInProductBaseDescriptorSupplier {
    AnimalsInProductFileDescriptorSupplier() {}
  }

  private static final class AnimalsInProductMethodDescriptorSupplier
      extends AnimalsInProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnimalsInProductMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnimalsInProductGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnimalsInProductFileDescriptorSupplier())
              .addMethod(getAnimalsInProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
