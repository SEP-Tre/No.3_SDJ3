package via.sdj3.grpcslaughterhouse.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: RecallService.proto")
public final class SlaughterhouseServiceGrpc {

  private SlaughterhouseServiceGrpc() {}

  public static final String SERVICE_NAME = "slaughterhouse.grpc.SlaughterhouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg,
      via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg> getRegisterAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerAnimal",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg,
      via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg> getRegisterAnimalMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg, via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg> getRegisterAnimalMethod;
    if ((getRegisterAnimalMethod = SlaughterhouseServiceGrpc.getRegisterAnimalMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getRegisterAnimalMethod = SlaughterhouseServiceGrpc.getRegisterAnimalMethod) == null) {
          SlaughterhouseServiceGrpc.getRegisterAnimalMethod = getRegisterAnimalMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg, via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("registerAnimal"))
              .build();
        }
      }
    }
    return getRegisterAnimalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg,
      via.sdj3.grpcslaughterhouse.protobuf.PartList> getCutAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CutAnimal",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.PartList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg,
      via.sdj3.grpcslaughterhouse.protobuf.PartList> getCutAnimalMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg, via.sdj3.grpcslaughterhouse.protobuf.PartList> getCutAnimalMethod;
    if ((getCutAnimalMethod = SlaughterhouseServiceGrpc.getCutAnimalMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getCutAnimalMethod = SlaughterhouseServiceGrpc.getCutAnimalMethod) == null) {
          SlaughterhouseServiceGrpc.getCutAnimalMethod = getCutAnimalMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg, via.sdj3.grpcslaughterhouse.protobuf.PartList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CutAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.PartList.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("CutAnimal"))
              .build();
        }
      }
    }
    return getCutAnimalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.PartList,
      via.sdj3.grpcslaughterhouse.protobuf.TrayList> getPackIntoTrayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PackIntoTray",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.PartList.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.TrayList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.PartList,
      via.sdj3.grpcslaughterhouse.protobuf.TrayList> getPackIntoTrayMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.PartList, via.sdj3.grpcslaughterhouse.protobuf.TrayList> getPackIntoTrayMethod;
    if ((getPackIntoTrayMethod = SlaughterhouseServiceGrpc.getPackIntoTrayMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getPackIntoTrayMethod = SlaughterhouseServiceGrpc.getPackIntoTrayMethod) == null) {
          SlaughterhouseServiceGrpc.getPackIntoTrayMethod = getPackIntoTrayMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.PartList, via.sdj3.grpcslaughterhouse.protobuf.TrayList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PackIntoTray"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.PartList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("PackIntoTray"))
              .build();
        }
      }
    }
    return getPackIntoTrayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.TrayList,
      via.sdj3.grpcslaughterhouse.protobuf.ProductList> getPackForDistributionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PackForDistribution",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.TrayList.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.ProductList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.TrayList,
      via.sdj3.grpcslaughterhouse.protobuf.ProductList> getPackForDistributionMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.TrayList, via.sdj3.grpcslaughterhouse.protobuf.ProductList> getPackForDistributionMethod;
    if ((getPackForDistributionMethod = SlaughterhouseServiceGrpc.getPackForDistributionMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getPackForDistributionMethod = SlaughterhouseServiceGrpc.getPackForDistributionMethod) == null) {
          SlaughterhouseServiceGrpc.getPackForDistributionMethod = getPackForDistributionMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.TrayList, via.sdj3.grpcslaughterhouse.protobuf.ProductList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PackForDistribution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.ProductList.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("PackForDistribution"))
              .build();
        }
      }
    }
    return getPackForDistributionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg,
      via.sdj3.grpcslaughterhouse.protobuf.ProductMsg> getPackHalfAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PackHalfAnimal",
      requestType = via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg.class,
      responseType = via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg,
      via.sdj3.grpcslaughterhouse.protobuf.ProductMsg> getPackHalfAnimalMethod() {
    io.grpc.MethodDescriptor<via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg, via.sdj3.grpcslaughterhouse.protobuf.ProductMsg> getPackHalfAnimalMethod;
    if ((getPackHalfAnimalMethod = SlaughterhouseServiceGrpc.getPackHalfAnimalMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getPackHalfAnimalMethod = SlaughterhouseServiceGrpc.getPackHalfAnimalMethod) == null) {
          SlaughterhouseServiceGrpc.getPackHalfAnimalMethod = getPackHalfAnimalMethod =
              io.grpc.MethodDescriptor.<via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg, via.sdj3.grpcslaughterhouse.protobuf.ProductMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PackHalfAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("PackHalfAnimal"))
              .build();
        }
      }
    }
    return getPackHalfAnimalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterhouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub>() {
        @java.lang.Override
        public SlaughterhouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterhouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub>() {
        @java.lang.Override
        public SlaughterhouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceBlockingStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterhouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub>() {
        @java.lang.Override
        public SlaughterhouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceFutureStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SlaughterhouseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterAnimalMethod(), responseObserver);
    }

    /**
     */
    public void cutAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.PartList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCutAnimalMethod(), responseObserver);
    }

    /**
     */
    public void packIntoTray(via.sdj3.grpcslaughterhouse.protobuf.PartList request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.TrayList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPackIntoTrayMethod(), responseObserver);
    }

    /**
     */
    public void packForDistribution(via.sdj3.grpcslaughterhouse.protobuf.TrayList request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.ProductList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPackForDistributionMethod(), responseObserver);
    }

    /**
     */
    public void packHalfAnimal(via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.ProductMsg> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPackHalfAnimalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg,
                via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg>(
                  this, METHODID_REGISTER_ANIMAL)))
          .addMethod(
            getCutAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg,
                via.sdj3.grpcslaughterhouse.protobuf.PartList>(
                  this, METHODID_CUT_ANIMAL)))
          .addMethod(
            getPackIntoTrayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.PartList,
                via.sdj3.grpcslaughterhouse.protobuf.TrayList>(
                  this, METHODID_PACK_INTO_TRAY)))
          .addMethod(
            getPackForDistributionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.TrayList,
                via.sdj3.grpcslaughterhouse.protobuf.ProductList>(
                  this, METHODID_PACK_FOR_DISTRIBUTION)))
          .addMethod(
            getPackHalfAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg,
                via.sdj3.grpcslaughterhouse.protobuf.ProductMsg>(
                  this, METHODID_PACK_HALF_ANIMAL)))
          .build();
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceStub extends io.grpc.stub.AbstractAsyncStub<SlaughterhouseServiceStub> {
    private SlaughterhouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterAnimalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cutAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.PartList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCutAnimalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void packIntoTray(via.sdj3.grpcslaughterhouse.protobuf.PartList request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.TrayList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPackIntoTrayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void packForDistribution(via.sdj3.grpcslaughterhouse.protobuf.TrayList request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.ProductList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPackForDistributionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void packHalfAnimal(via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg request,
        io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.ProductMsg> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPackHalfAnimalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SlaughterhouseServiceBlockingStub> {
    private SlaughterhouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg registerAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterAnimalMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.PartList cutAnimal(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCutAnimalMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayList packIntoTray(via.sdj3.grpcslaughterhouse.protobuf.PartList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPackIntoTrayMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.ProductList packForDistribution(via.sdj3.grpcslaughterhouse.protobuf.TrayList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPackForDistributionMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sdj3.grpcslaughterhouse.protobuf.ProductMsg packHalfAnimal(via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPackHalfAnimalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SlaughterhouseServiceFutureStub> {
    private SlaughterhouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg> registerAnimal(
        via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterAnimalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.PartList> cutAnimal(
        via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCutAnimalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.TrayList> packIntoTray(
        via.sdj3.grpcslaughterhouse.protobuf.PartList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPackIntoTrayMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.ProductList> packForDistribution(
        via.sdj3.grpcslaughterhouse.protobuf.TrayList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPackForDistributionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sdj3.grpcslaughterhouse.protobuf.ProductMsg> packHalfAnimal(
        via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPackHalfAnimalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_ANIMAL = 0;
  private static final int METHODID_CUT_ANIMAL = 1;
  private static final int METHODID_PACK_INTO_TRAY = 2;
  private static final int METHODID_PACK_FOR_DISTRIBUTION = 3;
  private static final int METHODID_PACK_HALF_ANIMAL = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SlaughterhouseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SlaughterhouseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_ANIMAL:
          serviceImpl.registerAnimal((via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg>) responseObserver);
          break;
        case METHODID_CUT_ANIMAL:
          serviceImpl.cutAnimal((via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.PartList>) responseObserver);
          break;
        case METHODID_PACK_INTO_TRAY:
          serviceImpl.packIntoTray((via.sdj3.grpcslaughterhouse.protobuf.PartList) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.TrayList>) responseObserver);
          break;
        case METHODID_PACK_FOR_DISTRIBUTION:
          serviceImpl.packForDistribution((via.sdj3.grpcslaughterhouse.protobuf.TrayList) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.ProductList>) responseObserver);
          break;
        case METHODID_PACK_HALF_ANIMAL:
          serviceImpl.packHalfAnimal((via.sdj3.grpcslaughterhouse.protobuf.HalfAnimalMsg) request,
              (io.grpc.stub.StreamObserver<via.sdj3.grpcslaughterhouse.protobuf.ProductMsg>) responseObserver);
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

  private static abstract class SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterhouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SlaughterhouseService");
    }
  }

  private static final class SlaughterhouseServiceFileDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier {
    SlaughterhouseServiceFileDescriptorSupplier() {}
  }

  private static final class SlaughterhouseServiceMethodDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SlaughterhouseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SlaughterhouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterhouseServiceFileDescriptorSupplier())
              .addMethod(getRegisterAnimalMethod())
              .addMethod(getCutAnimalMethod())
              .addMethod(getPackIntoTrayMethod())
              .addMethod(getPackForDistributionMethod())
              .addMethod(getPackHalfAnimalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
