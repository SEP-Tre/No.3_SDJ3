// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RecallService.proto

package slaughterhouse.grpc;

/**
 * Protobuf type {@code slaughterhouse.grpc.AnimalsIdList}
 */
public final class AnimalsIdList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:slaughterhouse.grpc.AnimalsIdList)
    AnimalsIdListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AnimalsIdList.newBuilder() to construct.
  private AnimalsIdList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AnimalsIdList() {
    list_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AnimalsIdList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AnimalsIdList(
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
              list_ = new java.util.ArrayList<slaughterhouse.grpc.AnimalId>();
              mutable_bitField0_ |= 0x00000001;
            }
            list_.add(
                input.readMessage(slaughterhouse.grpc.AnimalId.parser(), extensionRegistry));
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
        list_ = java.util.Collections.unmodifiableList(list_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return slaughterhouse.grpc.RecallService.internal_static_slaughterhouse_grpc_AnimalsIdList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return slaughterhouse.grpc.RecallService.internal_static_slaughterhouse_grpc_AnimalsIdList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            slaughterhouse.grpc.AnimalsIdList.class, slaughterhouse.grpc.AnimalsIdList.Builder.class);
  }

  public static final int LIST_FIELD_NUMBER = 1;
  private java.util.List<slaughterhouse.grpc.AnimalId> list_;
  /**
   * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
   */
  @java.lang.Override
  public java.util.List<slaughterhouse.grpc.AnimalId> getListList() {
    return list_;
  }
  /**
   * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends slaughterhouse.grpc.AnimalIdOrBuilder> 
      getListOrBuilderList() {
    return list_;
  }
  /**
   * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
   */
  @java.lang.Override
  public int getListCount() {
    return list_.size();
  }
  /**
   * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
   */
  @java.lang.Override
  public slaughterhouse.grpc.AnimalId getList(int index) {
    return list_.get(index);
  }
  /**
   * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
   */
  @java.lang.Override
  public slaughterhouse.grpc.AnimalIdOrBuilder getListOrBuilder(
      int index) {
    return list_.get(index);
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
    for (int i = 0; i < list_.size(); i++) {
      output.writeMessage(1, list_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < list_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, list_.get(i));
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
    if (!(obj instanceof slaughterhouse.grpc.AnimalsIdList)) {
      return super.equals(obj);
    }
    slaughterhouse.grpc.AnimalsIdList other = (slaughterhouse.grpc.AnimalsIdList) obj;

    if (!getListList()
        .equals(other.getListList())) return false;
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
    if (getListCount() > 0) {
      hash = (37 * hash) + LIST_FIELD_NUMBER;
      hash = (53 * hash) + getListList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static slaughterhouse.grpc.AnimalsIdList parseFrom(
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
  public static Builder newBuilder(slaughterhouse.grpc.AnimalsIdList prototype) {
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
   * Protobuf type {@code slaughterhouse.grpc.AnimalsIdList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:slaughterhouse.grpc.AnimalsIdList)
      slaughterhouse.grpc.AnimalsIdListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return slaughterhouse.grpc.RecallService.internal_static_slaughterhouse_grpc_AnimalsIdList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return slaughterhouse.grpc.RecallService.internal_static_slaughterhouse_grpc_AnimalsIdList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              slaughterhouse.grpc.AnimalsIdList.class, slaughterhouse.grpc.AnimalsIdList.Builder.class);
    }

    // Construct using slaughterhouse.grpc.AnimalsIdList.newBuilder()
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
        getListFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (listBuilder_ == null) {
        list_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        listBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return slaughterhouse.grpc.RecallService.internal_static_slaughterhouse_grpc_AnimalsIdList_descriptor;
    }

    @java.lang.Override
    public slaughterhouse.grpc.AnimalsIdList getDefaultInstanceForType() {
      return slaughterhouse.grpc.AnimalsIdList.getDefaultInstance();
    }

    @java.lang.Override
    public slaughterhouse.grpc.AnimalsIdList build() {
      slaughterhouse.grpc.AnimalsIdList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public slaughterhouse.grpc.AnimalsIdList buildPartial() {
      slaughterhouse.grpc.AnimalsIdList result = new slaughterhouse.grpc.AnimalsIdList(this);
      int from_bitField0_ = bitField0_;
      if (listBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          list_ = java.util.Collections.unmodifiableList(list_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.list_ = list_;
      } else {
        result.list_ = listBuilder_.build();
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
      if (other instanceof slaughterhouse.grpc.AnimalsIdList) {
        return mergeFrom((slaughterhouse.grpc.AnimalsIdList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(slaughterhouse.grpc.AnimalsIdList other) {
      if (other == slaughterhouse.grpc.AnimalsIdList.getDefaultInstance()) return this;
      if (listBuilder_ == null) {
        if (!other.list_.isEmpty()) {
          if (list_.isEmpty()) {
            list_ = other.list_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureListIsMutable();
            list_.addAll(other.list_);
          }
          onChanged();
        }
      } else {
        if (!other.list_.isEmpty()) {
          if (listBuilder_.isEmpty()) {
            listBuilder_.dispose();
            listBuilder_ = null;
            list_ = other.list_;
            bitField0_ = (bitField0_ & ~0x00000001);
            listBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getListFieldBuilder() : null;
          } else {
            listBuilder_.addAllMessages(other.list_);
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
      slaughterhouse.grpc.AnimalsIdList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (slaughterhouse.grpc.AnimalsIdList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<slaughterhouse.grpc.AnimalId> list_ =
      java.util.Collections.emptyList();
    private void ensureListIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        list_ = new java.util.ArrayList<slaughterhouse.grpc.AnimalId>(list_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        slaughterhouse.grpc.AnimalId, slaughterhouse.grpc.AnimalId.Builder, slaughterhouse.grpc.AnimalIdOrBuilder> listBuilder_;

    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public java.util.List<slaughterhouse.grpc.AnimalId> getListList() {
      if (listBuilder_ == null) {
        return java.util.Collections.unmodifiableList(list_);
      } else {
        return listBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public int getListCount() {
      if (listBuilder_ == null) {
        return list_.size();
      } else {
        return listBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public slaughterhouse.grpc.AnimalId getList(int index) {
      if (listBuilder_ == null) {
        return list_.get(index);
      } else {
        return listBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder setList(
        int index, slaughterhouse.grpc.AnimalId value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.set(index, value);
        onChanged();
      } else {
        listBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder setList(
        int index, slaughterhouse.grpc.AnimalId.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.set(index, builderForValue.build());
        onChanged();
      } else {
        listBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder addList(slaughterhouse.grpc.AnimalId value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.add(value);
        onChanged();
      } else {
        listBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder addList(
        int index, slaughterhouse.grpc.AnimalId value) {
      if (listBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureListIsMutable();
        list_.add(index, value);
        onChanged();
      } else {
        listBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder addList(
        slaughterhouse.grpc.AnimalId.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.add(builderForValue.build());
        onChanged();
      } else {
        listBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder addList(
        int index, slaughterhouse.grpc.AnimalId.Builder builderForValue) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.add(index, builderForValue.build());
        onChanged();
      } else {
        listBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder addAllList(
        java.lang.Iterable<? extends slaughterhouse.grpc.AnimalId> values) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, list_);
        onChanged();
      } else {
        listBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder clearList() {
      if (listBuilder_ == null) {
        list_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        listBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public Builder removeList(int index) {
      if (listBuilder_ == null) {
        ensureListIsMutable();
        list_.remove(index);
        onChanged();
      } else {
        listBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public slaughterhouse.grpc.AnimalId.Builder getListBuilder(
        int index) {
      return getListFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public slaughterhouse.grpc.AnimalIdOrBuilder getListOrBuilder(
        int index) {
      if (listBuilder_ == null) {
        return list_.get(index);  } else {
        return listBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public java.util.List<? extends slaughterhouse.grpc.AnimalIdOrBuilder> 
         getListOrBuilderList() {
      if (listBuilder_ != null) {
        return listBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(list_);
      }
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public slaughterhouse.grpc.AnimalId.Builder addListBuilder() {
      return getListFieldBuilder().addBuilder(
          slaughterhouse.grpc.AnimalId.getDefaultInstance());
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public slaughterhouse.grpc.AnimalId.Builder addListBuilder(
        int index) {
      return getListFieldBuilder().addBuilder(
          index, slaughterhouse.grpc.AnimalId.getDefaultInstance());
    }
    /**
     * <code>repeated .slaughterhouse.grpc.AnimalId list = 1;</code>
     */
    public java.util.List<slaughterhouse.grpc.AnimalId.Builder> 
         getListBuilderList() {
      return getListFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        slaughterhouse.grpc.AnimalId, slaughterhouse.grpc.AnimalId.Builder, slaughterhouse.grpc.AnimalIdOrBuilder> 
        getListFieldBuilder() {
      if (listBuilder_ == null) {
        listBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            slaughterhouse.grpc.AnimalId, slaughterhouse.grpc.AnimalId.Builder, slaughterhouse.grpc.AnimalIdOrBuilder>(
                list_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        list_ = null;
      }
      return listBuilder_;
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


    // @@protoc_insertion_point(builder_scope:slaughterhouse.grpc.AnimalsIdList)
  }

  // @@protoc_insertion_point(class_scope:slaughterhouse.grpc.AnimalsIdList)
  private static final slaughterhouse.grpc.AnimalsIdList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new slaughterhouse.grpc.AnimalsIdList();
  }

  public static slaughterhouse.grpc.AnimalsIdList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AnimalsIdList>
      PARSER = new com.google.protobuf.AbstractParser<AnimalsIdList>() {
    @java.lang.Override
    public AnimalsIdList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AnimalsIdList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AnimalsIdList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AnimalsIdList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public slaughterhouse.grpc.AnimalsIdList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

