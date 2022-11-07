// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecallService.proto

package via.sdj3.grpcslaughterhouse.protobuf;

/**
 * Protobuf type {@code slaughterhouse.grpc.TrayList}
 */
public final class TrayList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:slaughterhouse.grpc.TrayList)
    TrayListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TrayList.newBuilder() to construct.
  private TrayList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TrayList() {
    trays_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TrayList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TrayList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              trays_ = new java.util.ArrayList<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg>();
              mutable_bitField0_ |= 0x00000001;
            }
            trays_.add(
                input.readMessage(via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        trays_ = java.util.Collections.unmodifiableList(trays_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_TrayList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_TrayList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            via.sdj3.grpcslaughterhouse.protobuf.TrayList.class, via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder.class);
  }

  public static final int TRAYS_FIELD_NUMBER = 1;
  private java.util.List<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg> trays_;
  /**
   * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
   */
  @java.lang.Override
  public java.util.List<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg> getTraysList() {
    return trays_;
  }
  /**
   * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder> 
      getTraysOrBuilderList() {
    return trays_;
  }
  /**
   * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
   */
  @java.lang.Override
  public int getTraysCount() {
    return trays_.size();
  }
  /**
   * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
   */
  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.TrayMsg getTrays(int index) {
    return trays_.get(index);
  }
  /**
   * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
   */
  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder getTraysOrBuilder(
      int index) {
    return trays_.get(index);
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
    for (int i = 0; i < trays_.size(); i++) {
      output.writeMessage(1, trays_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < trays_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, trays_.get(i));
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
    if (!(obj instanceof via.sdj3.grpcslaughterhouse.protobuf.TrayList)) {
      return super.equals(obj);
    }
    via.sdj3.grpcslaughterhouse.protobuf.TrayList other = (via.sdj3.grpcslaughterhouse.protobuf.TrayList) obj;

    if (!getTraysList()
        .equals(other.getTraysList())) return false;
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
    if (getTraysCount() > 0) {
      hash = (37 * hash) + TRAYS_FIELD_NUMBER;
      hash = (53 * hash) + getTraysList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList parseFrom(
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
  public static Builder newBuilder(via.sdj3.grpcslaughterhouse.protobuf.TrayList prototype) {
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
   * Protobuf type {@code slaughterhouse.grpc.TrayList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:slaughterhouse.grpc.TrayList)
      via.sdj3.grpcslaughterhouse.protobuf.TrayListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_TrayList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_TrayList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              via.sdj3.grpcslaughterhouse.protobuf.TrayList.class, via.sdj3.grpcslaughterhouse.protobuf.TrayList.Builder.class);
    }

    // Construct using via.sdj3.grpcslaughterhouse.protobuf.TrayList.newBuilder()
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
        getTraysFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (traysBuilder_ == null) {
        trays_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        traysBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_TrayList_descriptor;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.TrayList getDefaultInstanceForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance();
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.TrayList build() {
      via.sdj3.grpcslaughterhouse.protobuf.TrayList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.TrayList buildPartial() {
      via.sdj3.grpcslaughterhouse.protobuf.TrayList result = new via.sdj3.grpcslaughterhouse.protobuf.TrayList(this);
      int from_bitField0_ = bitField0_;
      if (traysBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          trays_ = java.util.Collections.unmodifiableList(trays_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
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
      if (other instanceof via.sdj3.grpcslaughterhouse.protobuf.TrayList) {
        return mergeFrom((via.sdj3.grpcslaughterhouse.protobuf.TrayList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(via.sdj3.grpcslaughterhouse.protobuf.TrayList other) {
      if (other == via.sdj3.grpcslaughterhouse.protobuf.TrayList.getDefaultInstance()) return this;
      if (traysBuilder_ == null) {
        if (!other.trays_.isEmpty()) {
          if (trays_.isEmpty()) {
            trays_ = other.trays_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTraysIsMutable();
            trays_.addAll(other.trays_);
          }
          onChanged();
        }
      } else {
        if (!other.trays_.isEmpty()) {
          if (traysBuilder_.isEmpty()) {
            traysBuilder_.dispose();
            traysBuilder_ = null;
            trays_ = other.trays_;
            bitField0_ = (bitField0_ & ~0x00000001);
            traysBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTraysFieldBuilder() : null;
          } else {
            traysBuilder_.addAllMessages(other.trays_);
          }
        }
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
      via.sdj3.grpcslaughterhouse.protobuf.TrayList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (via.sdj3.grpcslaughterhouse.protobuf.TrayList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg> trays_ =
      java.util.Collections.emptyList();
    private void ensureTraysIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        trays_ = new java.util.ArrayList<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg>(trays_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        via.sdj3.grpcslaughterhouse.protobuf.TrayMsg, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder, via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder> traysBuilder_;

    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public java.util.List<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg> getTraysList() {
      if (traysBuilder_ == null) {
        return java.util.Collections.unmodifiableList(trays_);
      } else {
        return traysBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public int getTraysCount() {
      if (traysBuilder_ == null) {
        return trays_.size();
      } else {
        return traysBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayMsg getTrays(int index) {
      if (traysBuilder_ == null) {
        return trays_.get(index);
      } else {
        return traysBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder setTrays(
        int index, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg value) {
      if (traysBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTraysIsMutable();
        trays_.set(index, value);
        onChanged();
      } else {
        traysBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder setTrays(
        int index, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder builderForValue) {
      if (traysBuilder_ == null) {
        ensureTraysIsMutable();
        trays_.set(index, builderForValue.build());
        onChanged();
      } else {
        traysBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder addTrays(via.sdj3.grpcslaughterhouse.protobuf.TrayMsg value) {
      if (traysBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTraysIsMutable();
        trays_.add(value);
        onChanged();
      } else {
        traysBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder addTrays(
        int index, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg value) {
      if (traysBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTraysIsMutable();
        trays_.add(index, value);
        onChanged();
      } else {
        traysBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder addTrays(
        via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder builderForValue) {
      if (traysBuilder_ == null) {
        ensureTraysIsMutable();
        trays_.add(builderForValue.build());
        onChanged();
      } else {
        traysBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder addTrays(
        int index, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder builderForValue) {
      if (traysBuilder_ == null) {
        ensureTraysIsMutable();
        trays_.add(index, builderForValue.build());
        onChanged();
      } else {
        traysBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder addAllTrays(
        java.lang.Iterable<? extends via.sdj3.grpcslaughterhouse.protobuf.TrayMsg> values) {
      if (traysBuilder_ == null) {
        ensureTraysIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, trays_);
        onChanged();
      } else {
        traysBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder clearTrays() {
      if (traysBuilder_ == null) {
        trays_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        traysBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public Builder removeTrays(int index) {
      if (traysBuilder_ == null) {
        ensureTraysIsMutable();
        trays_.remove(index);
        onChanged();
      } else {
        traysBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder getTraysBuilder(
        int index) {
      return getTraysFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder getTraysOrBuilder(
        int index) {
      if (traysBuilder_ == null) {
        return trays_.get(index);  } else {
        return traysBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public java.util.List<? extends via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder> 
         getTraysOrBuilderList() {
      if (traysBuilder_ != null) {
        return traysBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(trays_);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder addTraysBuilder() {
      return getTraysFieldBuilder().addBuilder(
          via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.getDefaultInstance());
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder addTraysBuilder(
        int index) {
      return getTraysFieldBuilder().addBuilder(
          index, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.getDefaultInstance());
    }
    /**
     * <code>repeated .slaughterhouse.grpc.TrayMsg trays = 1;</code>
     */
    public java.util.List<via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder> 
         getTraysBuilderList() {
      return getTraysFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        via.sdj3.grpcslaughterhouse.protobuf.TrayMsg, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder, via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder> 
        getTraysFieldBuilder() {
      if (traysBuilder_ == null) {
        traysBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            via.sdj3.grpcslaughterhouse.protobuf.TrayMsg, via.sdj3.grpcslaughterhouse.protobuf.TrayMsg.Builder, via.sdj3.grpcslaughterhouse.protobuf.TrayMsgOrBuilder>(
                trays_,
                ((bitField0_ & 0x00000001) != 0),
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


    // @@protoc_insertion_point(builder_scope:slaughterhouse.grpc.TrayList)
  }

  // @@protoc_insertion_point(class_scope:slaughterhouse.grpc.TrayList)
  private static final via.sdj3.grpcslaughterhouse.protobuf.TrayList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new via.sdj3.grpcslaughterhouse.protobuf.TrayList();
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.TrayList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TrayList>
      PARSER = new com.google.protobuf.AbstractParser<TrayList>() {
    @java.lang.Override
    public TrayList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TrayList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TrayList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TrayList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.TrayList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

