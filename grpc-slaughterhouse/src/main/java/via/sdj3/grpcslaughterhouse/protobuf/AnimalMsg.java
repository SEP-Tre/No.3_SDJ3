// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecallService.proto

package via.sdj3.grpcslaughterhouse.protobuf;

/**
 * Protobuf type {@code slaughterhouse.grpc.AnimalMsg}
 */
public final class AnimalMsg extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:slaughterhouse.grpc.AnimalMsg)
    AnimalMsgOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AnimalMsg.newBuilder() to construct.
  private AnimalMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AnimalMsg() {
    type_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AnimalMsg();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AnimalMsg(
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
          case 13: {

            weight_ = input.readFloat();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            type_ = s;
            break;
          }
          case 24: {

            id_ = input.readInt32();
            break;
          }
          case 32: {

            isConverted_ = input.readBool();
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
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_AnimalMsg_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_AnimalMsg_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.class, via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.Builder.class);
  }

  public static final int WEIGHT_FIELD_NUMBER = 1;
  private float weight_;
  /**
   * <code>float weight = 1;</code>
   * @return The weight.
   */
  @java.lang.Override
  public float getWeight() {
    return weight_;
  }

  public static final int TYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object type_;
  /**
   * <code>string type = 2;</code>
   * @return The type.
   */
  @java.lang.Override
  public java.lang.String getType() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      type_ = s;
      return s;
    }
  }
  /**
   * <code>string type = 2;</code>
   * @return The bytes for type.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTypeBytes() {
    java.lang.Object ref = type_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      type_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 3;
  private int id_;
  /**
   * <code>int32 id = 3;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
  }

  public static final int ISCONVERTED_FIELD_NUMBER = 4;
  private boolean isConverted_;
  /**
   * <code>bool isConverted = 4;</code>
   * @return The isConverted.
   */
  @java.lang.Override
  public boolean getIsConverted() {
    return isConverted_;
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
    if (java.lang.Float.floatToRawIntBits(weight_) != 0) {
      output.writeFloat(1, weight_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(type_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, type_);
    }
    if (id_ != 0) {
      output.writeInt32(3, id_);
    }
    if (isConverted_ != false) {
      output.writeBool(4, isConverted_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (java.lang.Float.floatToRawIntBits(weight_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, weight_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(type_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, type_);
    }
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, id_);
    }
    if (isConverted_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, isConverted_);
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
    if (!(obj instanceof via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg)) {
      return super.equals(obj);
    }
    via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg other = (via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg) obj;

    if (java.lang.Float.floatToIntBits(getWeight())
        != java.lang.Float.floatToIntBits(
            other.getWeight())) return false;
    if (!getType()
        .equals(other.getType())) return false;
    if (getId()
        != other.getId()) return false;
    if (getIsConverted()
        != other.getIsConverted()) return false;
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
    hash = (37 * hash) + WEIGHT_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getWeight());
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + ISCONVERTED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsConverted());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parseFrom(
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
  public static Builder newBuilder(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg prototype) {
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
   * Protobuf type {@code slaughterhouse.grpc.AnimalMsg}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:slaughterhouse.grpc.AnimalMsg)
      via.sdj3.grpcslaughterhouse.protobuf.AnimalMsgOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_AnimalMsg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_AnimalMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.class, via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.Builder.class);
    }

    // Construct using via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.newBuilder()
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
      weight_ = 0F;

      type_ = "";

      id_ = 0;

      isConverted_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_AnimalMsg_descriptor;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg getDefaultInstanceForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.getDefaultInstance();
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg build() {
      via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg buildPartial() {
      via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg result = new via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg(this);
      result.weight_ = weight_;
      result.type_ = type_;
      result.id_ = id_;
      result.isConverted_ = isConverted_;
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
      if (other instanceof via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg) {
        return mergeFrom((via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg other) {
      if (other == via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg.getDefaultInstance()) return this;
      if (other.getWeight() != 0F) {
        setWeight(other.getWeight());
      }
      if (!other.getType().isEmpty()) {
        type_ = other.type_;
        onChanged();
      }
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (other.getIsConverted() != false) {
        setIsConverted(other.getIsConverted());
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
      via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float weight_ ;
    /**
     * <code>float weight = 1;</code>
     * @return The weight.
     */
    @java.lang.Override
    public float getWeight() {
      return weight_;
    }
    /**
     * <code>float weight = 1;</code>
     * @param value The weight to set.
     * @return This builder for chaining.
     */
    public Builder setWeight(float value) {
      
      weight_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float weight = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearWeight() {
      
      weight_ = 0F;
      onChanged();
      return this;
    }

    private java.lang.Object type_ = "";
    /**
     * <code>string type = 2;</code>
     * @return The type.
     */
    public java.lang.String getType() {
      java.lang.Object ref = type_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        type_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string type = 2;</code>
     * @return The bytes for type.
     */
    public com.google.protobuf.ByteString
        getTypeBytes() {
      java.lang.Object ref = type_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        type_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string type = 2;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string type = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      
      type_ = getDefaultInstance().getType();
      onChanged();
      return this;
    }
    /**
     * <code>string type = 2;</code>
     * @param value The bytes for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      type_ = value;
      onChanged();
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 3;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 3;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private boolean isConverted_ ;
    /**
     * <code>bool isConverted = 4;</code>
     * @return The isConverted.
     */
    @java.lang.Override
    public boolean getIsConverted() {
      return isConverted_;
    }
    /**
     * <code>bool isConverted = 4;</code>
     * @param value The isConverted to set.
     * @return This builder for chaining.
     */
    public Builder setIsConverted(boolean value) {
      
      isConverted_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isConverted = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsConverted() {
      
      isConverted_ = false;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:slaughterhouse.grpc.AnimalMsg)
  }

  // @@protoc_insertion_point(class_scope:slaughterhouse.grpc.AnimalMsg)
  private static final via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg();
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AnimalMsg>
      PARSER = new com.google.protobuf.AbstractParser<AnimalMsg>() {
    @java.lang.Override
    public AnimalMsg parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AnimalMsg(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AnimalMsg> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AnimalMsg> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.AnimalMsg getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

