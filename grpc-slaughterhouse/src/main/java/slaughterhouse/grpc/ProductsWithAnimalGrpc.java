package slaughterhouse.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: RecallService.proto")
public final class ProductsWithAnimalGrpc {

  private ProductsWithAnimalGrpc() {}

  public static final String SERVICE_NAME = "slaughterhouse.grpc.ProductsWithAnimal";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<slaughterhouse.grpc.AnimalId,
      slaughterhouse.grpc.ProductIdList> getProductsWithAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "productsWithAnimal",
      requestType = slaughterhouse.grpc.AnimalId.class,
      responseType = slaughterhouse.grpc.ProductIdList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<slaughterhouse.grpc.AnimalId,
      slaughterhouse.grpc.ProductIdList> getProductsWithAnimalMethod() {
    io.grpc.MethodDescriptor<slaughterhouse.grpc.AnimalId, slaughterhouse.grpc.ProductIdList> getProductsWithAnimalMethod;
    if ((getProductsWithAnimalMethod = ProductsWithAnimalGrpc.getProductsWithAnimalMethod) == null) {
      synchronized (ProductsWithAnimalGrpc.class) {
        if ((getProductsWithAnimalMethod = ProductsWithAnimalGrpc.getProductsWithAnimalMethod) == null) {
          ProductsWithAnimalGrpc.getProductsWithAnimalMethod = getProductsWithAnimalMethod =
              io.grpc.MethodDescriptor.<slaughterhouse.grpc.AnimalId, slaughterhouse.grpc.ProductIdList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "productsWithAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  slaughterhouse.grpc.AnimalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  slaughterhouse.grpc.ProductIdList.getDefaultInstance()))
              .setSchemaDescriptor(new ProductsWithAnimalMethodDescriptorSupplier("productsWithAnimal"))
              .build();
        }
      }
    }
    return getProductsWithAnimalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductsWithAnimalStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductsWithAnimalStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductsWithAnimalStub>() {
        @java.lang.Override
        public ProductsWithAnimalStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductsWithAnimalStub(channel, callOptions);
        }
      };
    return ProductsWithAnimalStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductsWithAnimalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductsWithAnimalBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductsWithAnimalBlockingStub>() {
        @java.lang.Override
        public ProductsWithAnimalBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductsWithAnimalBlockingStub(channel, callOptions);
        }
      };
    return ProductsWithAnimalBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductsWithAnimalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductsWithAnimalFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductsWithAnimalFutureStub>() {
        @java.lang.Override
        public ProductsWithAnimalFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductsWithAnimalFutureStub(channel, callOptions);
        }
      };
    return ProductsWithAnimalFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductsWithAnimalImplBase implements io.grpc.BindableService {

    /**
     */
    public void productsWithAnimal(slaughterhouse.grpc.AnimalId request,
        io.grpc.stub.StreamObserver<slaughterhouse.grpc.ProductIdList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProductsWithAnimalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProductsWithAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                slaughterhouse.grpc.AnimalId,
                slaughterhouse.grpc.ProductIdList>(
                  this, METHODID_PRODUCTS_WITH_ANIMAL)))
          .build();
    }
  }

  /**
   */
  public static final class ProductsWithAnimalStub extends io.grpc.stub.AbstractAsyncStub<ProductsWithAnimalStub> {
    private ProductsWithAnimalStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductsWithAnimalStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductsWithAnimalStub(channel, callOptions);
    }

    /**
     */
    public void productsWithAnimal(slaughterhouse.grpc.AnimalId request,
        io.grpc.stub.StreamObserver<slaughterhouse.grpc.ProductIdList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProductsWithAnimalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductsWithAnimalBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductsWithAnimalBlockingStub> {
    private ProductsWithAnimalBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductsWithAnimalBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductsWithAnimalBlockingStub(channel, callOptions);
    }

    /**
     */
    public slaughterhouse.grpc.ProductIdList productsWithAnimal(slaughterhouse.grpc.AnimalId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProductsWithAnimalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductsWithAnimalFutureStub extends io.grpc.stub.AbstractFutureStub<ProductsWithAnimalFutureStub> {
    private ProductsWithAnimalFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductsWithAnimalFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductsWithAnimalFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<slaughterhouse.grpc.ProductIdList> productsWithAnimal(
        slaughterhouse.grpc.AnimalId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProductsWithAnimalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRODUCTS_WITH_ANIMAL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductsWithAnimalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductsWithAnimalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRODUCTS_WITH_ANIMAL:
          serviceImpl.productsWithAnimal((slaughterhouse.grpc.AnimalId) request,
              (io.grpc.stub.StreamObserver<slaughterhouse.grpc.ProductIdList>) responseObserver);
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

  private static abstract class ProductsWithAnimalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductsWithAnimalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return slaughterhouse.grpc.RecallService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductsWithAnimal");
    }
  }

  private static final class ProductsWithAnimalFileDescriptorSupplier
      extends ProductsWithAnimalBaseDescriptorSupplier {
    ProductsWithAnimalFileDescriptorSupplier() {}
  }

  private static final class ProductsWithAnimalMethodDescriptorSupplier
      extends ProductsWithAnimalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductsWithAnimalMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductsWithAnimalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductsWithAnimalFileDescriptorSupplier())
              .addMethod(getProductsWithAnimalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
