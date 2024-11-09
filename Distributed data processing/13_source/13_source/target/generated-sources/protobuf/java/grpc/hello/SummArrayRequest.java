// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello.proto

package grpc.hello;

/**
 * Protobuf type {@code grpc.SummArrayRequest}
 */
public  final class SummArrayRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.SummArrayRequest)
    SummArrayRequestOrBuilder {
  // Use SummArrayRequest.newBuilder() to construct.
  private SummArrayRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SummArrayRequest() {
    list_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private SummArrayRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              list_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            list_.add(input.readInt32());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              list_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              list_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        list_ = java.util.Collections.unmodifiableList(list_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.hello.EchoServiceProto.internal_static_grpc_SummArrayRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.hello.EchoServiceProto.internal_static_grpc_SummArrayRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.hello.SummArrayRequest.class, grpc.hello.SummArrayRequest.Builder.class);
  }

  public static final int LIST_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Integer> list_;
  /**
   * <code>repeated int32 list = 1;</code>
   */
  public java.util.List<java.lang.Integer>
      getListList() {
    return list_;
  }
  /**
   * <code>repeated int32 list = 1;</code>
   */
  public int getListCount() {
    return list_.size();
  }
  /**
   * <code>repeated int32 list = 1;</code>
   */
  public int getList(int index) {
    return list_.get(index);
  }
  private int listMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getListList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(listMemoizedSerializedSize);
    }
    for (int i = 0; i < list_.size(); i++) {
      output.writeInt32NoTag(list_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < list_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(list_.get(i));
      }
      size += dataSize;
      if (!getListList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      listMemoizedSerializedSize = dataSize;
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.hello.SummArrayRequest)) {
      return super.equals(obj);
    }
    grpc.hello.SummArrayRequest other = (grpc.hello.SummArrayRequest) obj;

    boolean result = true;
    result = result && getListList()
        .equals(other.getListList());
    return result;
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

  public static grpc.hello.SummArrayRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.hello.SummArrayRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.hello.SummArrayRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.hello.SummArrayRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.hello.SummArrayRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.hello.SummArrayRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.hello.SummArrayRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code grpc.SummArrayRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.SummArrayRequest)
      grpc.hello.SummArrayRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.hello.EchoServiceProto.internal_static_grpc_SummArrayRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.hello.EchoServiceProto.internal_static_grpc_SummArrayRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.hello.SummArrayRequest.class, grpc.hello.SummArrayRequest.Builder.class);
    }

    // Construct using grpc.hello.SummArrayRequest.newBuilder()
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
    public Builder clear() {
      super.clear();
      list_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.hello.EchoServiceProto.internal_static_grpc_SummArrayRequest_descriptor;
    }

    public grpc.hello.SummArrayRequest getDefaultInstanceForType() {
      return grpc.hello.SummArrayRequest.getDefaultInstance();
    }

    public grpc.hello.SummArrayRequest build() {
      grpc.hello.SummArrayRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public grpc.hello.SummArrayRequest buildPartial() {
      grpc.hello.SummArrayRequest result = new grpc.hello.SummArrayRequest(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        list_ = java.util.Collections.unmodifiableList(list_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.list_ = list_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.hello.SummArrayRequest) {
        return mergeFrom((grpc.hello.SummArrayRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.hello.SummArrayRequest other) {
      if (other == grpc.hello.SummArrayRequest.getDefaultInstance()) return this;
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
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.hello.SummArrayRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.hello.SummArrayRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Integer> list_ = java.util.Collections.emptyList();
    private void ensureListIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        list_ = new java.util.ArrayList<java.lang.Integer>(list_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getListList() {
      return java.util.Collections.unmodifiableList(list_);
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public int getListCount() {
      return list_.size();
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public int getList(int index) {
      return list_.get(index);
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public Builder setList(
        int index, int value) {
      ensureListIsMutable();
      list_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public Builder addList(int value) {
      ensureListIsMutable();
      list_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public Builder addAllList(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureListIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, list_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 list = 1;</code>
     */
    public Builder clearList() {
      list_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:grpc.SummArrayRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.SummArrayRequest)
  private static final grpc.hello.SummArrayRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.hello.SummArrayRequest();
  }

  public static grpc.hello.SummArrayRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SummArrayRequest>
      PARSER = new com.google.protobuf.AbstractParser<SummArrayRequest>() {
    public SummArrayRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new SummArrayRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SummArrayRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SummArrayRequest> getParserForType() {
    return PARSER;
  }

  public grpc.hello.SummArrayRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
