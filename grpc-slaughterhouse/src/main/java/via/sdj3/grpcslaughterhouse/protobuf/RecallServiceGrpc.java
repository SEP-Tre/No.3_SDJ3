package via.sdj3.grpcslaughterhouse.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: RecallService.proto")
public final class RecallServiceGrpc {

  private RecallServiceGrpc() {}

  public static final String SERVICE_NAME = "slaughterhouse.grpc.RecallService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalId,
      via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse> getProductsWithAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "productsWithAnimal",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.AnimalId.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalId,
      via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse> getProductsWithAnimalMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalId, via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse> getProductsWithAnimalMethod;
    if ((getProductsWithAnimalMethod = RecallServiceGrpc.getProductsWithAnimalMethod) == null) {
      synchronized (RecallServiceGrpc.class) {
        if ((getProductsWithAnimalMethod = RecallServiceGrpc.getProductsWithAnimalMethod) == null) {
          RecallServiceGrpc.getProductsWithAnimalMethod = getProductsWithAnimalMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.AnimalId, via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "productsWithAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.AnimalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecallServiceMethodDescriptorSupplier("productsWithAnimal"))
              .build();
        }
      }
    }
    return getProductsWithAnimalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.ProductId,
      via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse> getAnimalsInProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "animalsInProduct",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.ProductId.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.ProductId,
      via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse> getAnimalsInProductMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.ProductId, via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse> getAnimalsInProductMethod;
    if ((getAnimalsInProductMethod = RecallServiceGrpc.getAnimalsInProductMethod) == null) {
      synchronized (RecallServiceGrpc.class) {
        if ((getAnimalsInProductMethod = RecallServiceGrpc.getAnimalsInProductMethod) == null) {
          RecallServiceGrpc.getAnimalsInProductMethod = getAnimalsInProductMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.ProductId, via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "animalsInProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.ProductId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecallServiceMethodDescriptorSupplier("animalsInProduct"))
              .build();
        }
      }
    }
    return getAnimalsInProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecallServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecallServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecallServiceStub>() {
        @java.lang.Override
        public RecallServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecallServiceStub(channel, callOptions);
        }
      };
    return RecallServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecallServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecallServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecallServiceBlockingStub>() {
        @java.lang.Override
        public RecallServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecallServiceBlockingStub(channel, callOptions);
        }
      };
    return RecallServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecallServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecallServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecallServiceFutureStub>() {
        @java.lang.Override
        public RecallServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecallServiceFutureStub(channel, callOptions);
        }
      };
    return RecallServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecallServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void productsWithAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalId request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProductsWithAnimalMethod(), responseObserver);
    }

    /**
     */
    public void animalsInProduct(via.sdj3.grpcslaughterhouse.protobuf.ProductId request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnimalsInProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProductsWithAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.AnimalId,
                via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse>(
                  this, METHODID_PRODUCTS_WITH_ANIMAL)))
          .addMethod(
            getAnimalsInProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.ProductId,
                via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse>(
                  this, METHODID_ANIMALS_IN_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class RecallServiceStub extends io.grpc.stub.AbstractAsyncStub<RecallServiceStub> {
    private RecallServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecallServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecallServiceStub(channel, callOptions);
    }

    /**
     */
    public void productsWithAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalId request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProductsWithAnimalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void animalsInProduct(via.sdj3.grpcslaughterhouse.protobuf.ProductId request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnimalsInProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecallServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecallServiceBlockingStub> {
    private RecallServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecallServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecallServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse productsWithAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProductsWithAnimalMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse animalsInProduct(via.sdj3.grpcslaughterhouse.protobuf.ProductId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnimalsInProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecallServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RecallServiceFutureStub> {
    private RecallServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecallServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecallServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse> productsWithAnimal(
        via.sdj3.grpcslaughterhouse.protobuf.AnimalId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProductsWithAnimalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse> animalsInProduct(
        via.sdj3.grpcslaughterhouse.protobuf.ProductId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnimalsInProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRODUCTS_WITH_ANIMAL = 0;
  private static final int METHODID_ANIMALS_IN_PRODUCT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecallServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecallServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRODUCTS_WITH_ANIMAL:
          serviceImpl.productsWithAnimal((via.sdj3.grpcslaughterhouse.protobuf.AnimalId) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.productsWithAnimalResponse>) responseObserver);
          break;
        case METHODID_ANIMALS_IN_PRODUCT:
          serviceImpl.animalsInProduct((via.sdj3.grpcslaughterhouse.protobuf.ProductId) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.animalsInProductResponse>) responseObserver);
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

  private static abstract class RecallServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecallServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecallService");
    }
  }

  private static final class RecallServiceFileDescriptorSupplier
      extends RecallServiceBaseDescriptorSupplier {
    RecallServiceFileDescriptorSupplier() {}
  }

  private static final class RecallServiceMethodDescriptorSupplier
      extends RecallServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecallServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecallServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecallServiceFileDescriptorSupplier())
              .addMethod(getProductsWithAnimalMethod())
              .addMethod(getAnimalsInProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
