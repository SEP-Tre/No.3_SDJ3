// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecallService.proto

package via.sdj3.grpcslaughterhouse.protobuf;

/**
 * Protobuf type {@code slaughterhouse.grpc.ProductMsg}
 */
public final class ProductMsg extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:slaughterhouse.grpc.ProductMsg)
    ProductMsgOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ProductMsg.newBuilder() to construct.
  private ProductMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProductMsg() {
    productType_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ProductMsg();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ProductMsg(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            productId_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            productType_ = s;
            break;
          }
          case 26: {
            via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder subBuilder = null;
            if (trays_ != null) {
              subBuilder = trays_.toBuilder();
            }
            trays_ = input.readMessage(via.sdj3.grpcslaughterhouse.protobuf.TrayList.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(trays_);
              trays_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_ProductMsg_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_ProductMsg_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.class, via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.Builder.class);
  }

  public static final int PRODUCTID_FIELD_NUMBER = 1;
  private int productId_;
  /**
   * <code>int32 productId = 1;</code>
   * @return The productId.
   */
  @java.lang.Override
  public int getProductId() {
    return productId_;
  }

  public static final int PRODUCTTYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object productType_;
  /**
   * <code>string productType = 2;</code>
   * @return The productType.
   */
  @java.lang.Override
  public java.lang.String getProductType() {
    java.lang.Object ref = productType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productType_ = s;
      return s;
    }
  }
  /**
   * <code>string productType = 2;</code>
   * @return The bytes for productType.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getProductTypeBytes() {
    java.lang.Object ref = productType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRAYS_FIELD_NUMBER = 3;
  private via.sdj3.grpcslaughterhouse.protobuf.TrayList trays_;
  /**
   * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
   * @return Whether the trays field is set.
   */
  @java.lang.Override
  public boolean hasTrays() {
    return trays_ != null;
  }
  /**
   * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
   * @return The trays.
   */
  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.TrayList getTrays() {
    return trays_ == null ? via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance() : trays_;
  }
  /**
   * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
   */
  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.TrayListOrBuilder getTraysOrBuilder() {
    return getTrays();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (productId_ != 0) {
      output.writeInt32(1, productId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(productType_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, productType_);
    }
    if (trays_ != null) {
      output.writeMessage(3, getTrays());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (productId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, productId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(productType_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, productType_);
    }
    if (trays_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getTrays());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof via.sdj3.grpcslaughterhouse.protobuf.ProductMsg)) {
      return super.equals(obj);
    }
    via.sdj3.grpcslaughterhouse.protobuf.ProductMsg other = (via.sdj3.grpcslaughterhouse.protobuf.ProductMsg) obj;

    if (getProductId()
        != other.getProductId()) return false;
    if (!getProductType()
        .equals(other.getProductType())) return false;
    if (hasTrays() != other.hasTrays()) return false;
    if (hasTrays()) {
      if (!getTrays()
          .equals(other.getTrays())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PRODUCTID_FIELD_NUMBER;
    hash = (53 * hash) + getProductId();
    hash = (37 * hash) + PRODUCTTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getProductType().hashCode();
    if (hasTrays()) {
      hash = (37 * hash) + TRAYS_FIELD_NUMBER;
      hash = (53 * hash) + getTrays().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(via.sdj3.grpcslaughterhouse.protobuf.ProductMsg prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code slaughterhouse.grpc.ProductMsg}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:slaughterhouse.grpc.ProductMsg)
      via.sdj3.grpcslaughterhouse.protobuf.ProductMsgOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_ProductMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_ProductMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.class, via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.Builder.class);
    }

    // Construct using via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      productId_ = 0;

      productType_ = "";

      if (traysBuilder_ == null) {
        trays_ = null;
      } else {
        trays_ = null;
        traysBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_ProductMsg_descriptor;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.ProductMsg getDefaultInstanceForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.getDefaultInstance();
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.ProductMsg build() {
      via.sdj3.grpcslaughterhouse.protobuf.ProductMsg result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.ProductMsg buildPartial() {
      via.sdj3.grpcslaughterhouse.protobuf.ProductMsg result = new via.sdj3.grpcslaughterhouse.protobuf.ProductMsg(this);
      result.productId_ = productId_;
      result.productType_ = productType_;
      if (traysBuilder_ == null) {
        result.trays_ = trays_;
      } else {
        result.trays_ = traysBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof via.sdj3.grpcslaughterhouse.protobuf.ProductMsg) {
        return mergeFrom((via.sdj3.grpcslaughterhouse.protobuf.ProductMsg)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(via.sdj3.grpcslaughterhouse.protobuf.ProductMsg other) {
      if (other == via.sdj3.grpcslaughterhouse.protobuf.ProductMsg.getDefaultInstance()) return this;
      if (other.getProductId() != 0) {
        setProductId(other.getProductId());
      }
      if (!other.getProductType().isEmpty()) {
        productType_ = other.productType_;
        onChanged();
      }
      if (other.hasTrays()) {
        mergeTrays(other.getTrays());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      via.sdj3.grpcslaughterhouse.protobuf.ProductMsg parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (via.sdj3.grpcslaughterhouse.protobuf.ProductMsg) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int productId_ ;
    /**
     * <code>int32 productId = 1;</code>
     * @return The productId.
     */
    @java.lang.Override
    public int getProductId() {
      return productId_;
    }
    /**
     * <code>int32 productId = 1;</code>
     * @param value The productId to set.
     * @return This builder for chaining.
     */
    public Builder setProductId(int value) {
      
      productId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 productId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearProductId() {
      
      productId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object productType_ = "";
    /**
     * <code>string productType = 2;</code>
     * @return The productType.
     */
    public java.lang.String getProductType() {
      java.lang.Object ref = productType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string productType = 2;</code>
     * @return The bytes for productType.
     */
    public com.google.protobuf.ByteString
        getProductTypeBytes() {
      java.lang.Object ref = productType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string productType = 2;</code>
     * @param value The productType to set.
     * @return This builder for chaining.
     */
    public Builder setProductType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string productType = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearProductType() {
      
      productType_ = getDefaultInstance().getProductType();
      onChanged();
      return this;
    }
    /**
     * <code>string productType = 2;</code>
     * @param value The bytes for productType to set.
     * @return This builder for chaining.
     */
    public Builder setProductTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productType_ = value;
      onChanged();
      return this;
    }

    private via.sdj3.grpcslaughterhouse.protobuf.TrayList trays_;
    private com.google.protobuf.SingleFieldBuilderV3<
        via.sdj3.grpcslaughterhouse.protobuf.TrayList, via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder, via.sdj3.grpcslaughterhouse.protobuf.TrayListOrBuilder> traysBuilder_;
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     * @return Whether the trays field is set.
     */
    public boolean hasTrays() {
      return traysBuilder_ != null || trays_ != null;
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     * @return The trays.
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayList getTrays() {
      if (traysBuilder_ == null) {
        return trays_ == null ? via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance() : trays_;
      } else {
        return traysBuilder_.getMessage();
      }
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    public Builder setTrays(via.sdj3.grpcslaughterhouse.protobuf.TrayList value) {
      if (traysBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        trays_ = value;
        onChanged();
      } else {
        traysBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    public Builder setTrays(
        via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder builderForValue) {
      if (traysBuilder_ == null) {
        trays_ = builderForValue.build();
        onChanged();
      } else {
        traysBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    public Builder mergeTrays(via.sdj3.grpcslaughterhouse.protobuf.TrayList value) {
      if (traysBuilder_ == null) {
        if (trays_ != null) {
          trays_ =
            via.sdj3.grpcslaughterhouse.protobuf.TrayList.newBuilder(trays_).mergeFrom(value).buildPartial();
        } else {
          trays_ = value;
        }
        onChanged();
      } else {
        traysBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    public Builder clearTrays() {
      if (traysBuilder_ == null) {
        trays_ = null;
        onChanged();
      } else {
        trays_ = null;
        traysBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder getTraysBuilder() {
      
      onChanged();
      return getTraysFieldBuilder().getBuilder();
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayListOrBuilder getTraysOrBuilder() {
      if (traysBuilder_ != null) {
        return traysBuilder_.getMessageOrBuilder();
      } else {
        return trays_ == null ?
            via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance() : trays_;
      }
    }
    /**
     * <code>.slaughterhouse.grpc.TrayList trays = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        via.sdj3.grpcslaughterhouse.protobuf.TrayList, via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder, via.sdj3.grpcslaughterhouse.protobuf.TrayListOrBuilder> 
        getTraysFieldBuilder() {
      if (traysBuilder_ == null) {
        traysBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            via.sdj3.grpcslaughterhouse.protobuf.TrayList, via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder, via.sdj3.grpcslaughterhouse.protobuf.TrayListOrBuilder>(
                getTrays(),
                getParentForChildren(),
                isClean());
        trays_ = null;
      }
      return traysBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:slaughterhouse.grpc.ProductMsg)
  }

  // @@protoc_insertion_point(class_scope:slaughterhouse.grpc.ProductMsg)
  private static final via.sdj3.grpcslaughterhouse.protobuf.ProductMsg DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new via.sdj3.grpcslaughterhouse.protobuf.ProductMsg();
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.ProductMsg getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProductMsg>
      PARSER = new com.google.protobuf.AbstractParser<ProductMsg>() {
    @java.lang.Override
    public ProductMsg parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProductMsg(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ProductMsg> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProductMsg> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.ProductMsg getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

