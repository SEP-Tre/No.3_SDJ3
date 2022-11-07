// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecallService.proto

package via.sdj3.grpcslaughterhouse.protobuf;

/**
 * Protobuf type {@code slaughterhouse.grpc.PartList}
 */
public final class PartList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:slaughterhouse.grpc.PartList)
    PartListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PartList.newBuilder() to construct.
  private PartList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PartList() {
    parts_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PartList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PartList(
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
              parts_ = new java.util.ArrayList<via.sdj3.grpcslaughterhouse.protobuf.PartMsg>();
              mutable_bitField0_ |= 0x00000001;
            }
            parts_.add(
                input.readMessage(via.sdj3.grpcslaughterhouse.protobuf.PartMsg.parser(), extensionRegistry));
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
        parts_ = java.util.Collections.unmodifiableList(parts_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_PartList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_PartList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            via.sdj3.grpcslaughterhouse.protobuf.PartList.class, via.sdj3.grpcslaughterhouse.protobuf.PartList.Builder.class);
  }

  public static final int PARTS_FIELD_NUMBER = 1;
  private java.util.List<via.sdj3.grpcslaughterhouse.protobuf.PartMsg> parts_;
  /**
   * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
   */
  @java.lang.Override
  public java.util.List<via.sdj3.grpcslaughterhouse.protobuf.PartMsg> getPartsList() {
    return parts_;
  }
  /**
   * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder> 
      getPartsOrBuilderList() {
    return parts_;
  }
  /**
   * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
   */
  @java.lang.Override
  public int getPartsCount() {
    return parts_.size();
  }
  /**
   * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
   */
  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.PartMsg getParts(int index) {
    return parts_.get(index);
  }
  /**
   * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
   */
  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder getPartsOrBuilder(
      int index) {
    return parts_.get(index);
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
    for (int i = 0; i < parts_.size(); i++) {
      output.writeMessage(1, parts_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < parts_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, parts_.get(i));
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
    if (!(obj instanceof via.sdj3.grpcslaughterhouse.protobuf.PartList)) {
      return super.equals(obj);
    }
    via.sdj3.grpcslaughterhouse.protobuf.PartList other = (via.sdj3.grpcslaughterhouse.protobuf.PartList) obj;

    if (!getPartsList()
        .equals(other.getPartsList())) return false;
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
    if (getPartsCount() > 0) {
      hash = (37 * hash) + PARTS_FIELD_NUMBER;
      hash = (53 * hash) + getPartsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static via.sdj3.grpcslaughterhouse.protobuf.PartList parseFrom(
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
  public static Builder newBuilder(via.sdj3.grpcslaughterhouse.protobuf.PartList prototype) {
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
   * Protobuf type {@code slaughterhouse.grpc.PartList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:slaughterhouse.grpc.PartList)
      via.sdj3.grpcslaughterhouse.protobuf.PartListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_PartList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_PartList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              via.sdj3.grpcslaughterhouse.protobuf.PartList.class, via.sdj3.grpcslaughterhouse.protobuf.PartList.Builder.class);
    }

    // Construct using via.sdj3.grpcslaughterhouse.protobuf.PartList.newBuilder()
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
        getPartsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (partsBuilder_ == null) {
        parts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        partsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.RecallService.internal_static_slaughterhouse_grpc_PartList_descriptor;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.PartList getDefaultInstanceForType() {
      return via.sdj3.grpcslaughterhouse.protobuf.PartList.getDefaultInstance();
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.PartList build() {
      via.sdj3.grpcslaughterhouse.protobuf.PartList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public via.sdj3.grpcslaughterhouse.protobuf.PartList buildPartial() {
      via.sdj3.grpcslaughterhouse.protobuf.PartList result = new via.sdj3.grpcslaughterhouse.protobuf.PartList(this);
      int from_bitField0_ = bitField0_;
      if (partsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          parts_ = java.util.Collections.unmodifiableList(parts_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.parts_ = parts_;
      } else {
        result.parts_ = partsBuilder_.build();
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
      if (other instanceof via.sdj3.grpcslaughterhouse.protobuf.PartList) {
        return mergeFrom((via.sdj3.grpcslaughterhouse.protobuf.PartList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(via.sdj3.grpcslaughterhouse.protobuf.PartList other) {
      if (other == via.sdj3.grpcslaughterhouse.protobuf.PartList.getDefaultInstance()) return this;
      if (partsBuilder_ == null) {
        if (!other.parts_.isEmpty()) {
          if (parts_.isEmpty()) {
            parts_ = other.parts_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePartsIsMutable();
            parts_.addAll(other.parts_);
          }
          onChanged();
        }
      } else {
        if (!other.parts_.isEmpty()) {
          if (partsBuilder_.isEmpty()) {
            partsBuilder_.dispose();
            partsBuilder_ = null;
            parts_ = other.parts_;
            bitField0_ = (bitField0_ & ~0x00000001);
            partsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPartsFieldBuilder() : null;
          } else {
            partsBuilder_.addAllMessages(other.parts_);
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
      via.sdj3.grpcslaughterhouse.protobuf.PartList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (via.sdj3.grpcslaughterhouse.protobuf.PartList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<via.sdj3.grpcslaughterhouse.protobuf.PartMsg> parts_ =
      java.util.Collections.emptyList();
    private void ensurePartsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        parts_ = new java.util.ArrayList<via.sdj3.grpcslaughterhouse.protobuf.PartMsg>(parts_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        via.sdj3.grpcslaughterhouse.protobuf.PartMsg, via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder, via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder> partsBuilder_;

    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public java.util.List<via.sdj3.grpcslaughterhouse.protobuf.PartMsg> getPartsList() {
      if (partsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(parts_);
      } else {
        return partsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public int getPartsCount() {
      if (partsBuilder_ == null) {
        return parts_.size();
      } else {
        return partsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.PartMsg getParts(int index) {
      if (partsBuilder_ == null) {
        return parts_.get(index);
      } else {
        return partsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder setParts(
        int index, via.sdj3.grpcslaughterhouse.protobuf.PartMsg value) {
      if (partsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartsIsMutable();
        parts_.set(index, value);
        onChanged();
      } else {
        partsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder setParts(
        int index, via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder builderForValue) {
      if (partsBuilder_ == null) {
        ensurePartsIsMutable();
        parts_.set(index, builderForValue.build());
        onChanged();
      } else {
        partsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder addParts(via.sdj3.grpcslaughterhouse.protobuf.PartMsg value) {
      if (partsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartsIsMutable();
        parts_.add(value);
        onChanged();
      } else {
        partsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder addParts(
        int index, via.sdj3.grpcslaughterhouse.protobuf.PartMsg value) {
      if (partsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartsIsMutable();
        parts_.add(index, value);
        onChanged();
      } else {
        partsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder addParts(
        via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder builderForValue) {
      if (partsBuilder_ == null) {
        ensurePartsIsMutable();
        parts_.add(builderForValue.build());
        onChanged();
      } else {
        partsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder addParts(
        int index, via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder builderForValue) {
      if (partsBuilder_ == null) {
        ensurePartsIsMutable();
        parts_.add(index, builderForValue.build());
        onChanged();
      } else {
        partsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder addAllParts(
        java.lang.Iterable<? extends via.sdj3.grpcslaughterhouse.protobuf.PartMsg> values) {
      if (partsBuilder_ == null) {
        ensurePartsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, parts_);
        onChanged();
      } else {
        partsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder clearParts() {
      if (partsBuilder_ == null) {
        parts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        partsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public Builder removeParts(int index) {
      if (partsBuilder_ == null) {
        ensurePartsIsMutable();
        parts_.remove(index);
        onChanged();
      } else {
        partsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder getPartsBuilder(
        int index) {
      return getPartsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder getPartsOrBuilder(
        int index) {
      if (partsBuilder_ == null) {
        return parts_.get(index);  } else {
        return partsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public java.util.List<? extends via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder> 
         getPartsOrBuilderList() {
      if (partsBuilder_ != null) {
        return partsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(parts_);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder addPartsBuilder() {
      return getPartsFieldBuilder().addBuilder(
          via.sdj3.grpcslaughterhouse.protobuf.PartMsg.getDefaultInstance());
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder addPartsBuilder(
        int index) {
      return getPartsFieldBuilder().addBuilder(
          index, via.sdj3.grpcslaughterhouse.protobuf.PartMsg.getDefaultInstance());
    }
    /**
     * <code>repeated .slaughterhouse.grpc.PartMsg parts = 1;</code>
     */
    public java.util.List<via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder> 
         getPartsBuilderList() {
      return getPartsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        via.sdj3.grpcslaughterhouse.protobuf.PartMsg, via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder, via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder> 
        getPartsFieldBuilder() {
      if (partsBuilder_ == null) {
        partsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            via.sdj3.grpcslaughterhouse.protobuf.PartMsg, via.sdj3.grpcslaughterhouse.protobuf.PartMsg.Builder, via.sdj3.grpcslaughterhouse.protobuf.PartMsgOrBuilder>(
                parts_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        parts_ = null;
      }
      return partsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:slaughterhouse.grpc.PartList)
  }

  // @@protoc_insertion_point(class_scope:slaughterhouse.grpc.PartList)
  private static final via.sdj3.grpcslaughterhouse.protobuf.PartList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new via.sdj3.grpcslaughterhouse.protobuf.PartList();
  }

  public static via.sdj3.grpcslaughterhouse.protobuf.PartList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PartList>
      PARSER = new com.google.protobuf.AbstractParser<PartList>() {
    @java.lang.Override
    public PartList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PartList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PartList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PartList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public via.sdj3.grpcslaughterhouse.protobuf.PartList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

