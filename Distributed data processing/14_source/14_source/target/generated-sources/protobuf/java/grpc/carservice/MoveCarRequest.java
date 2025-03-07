// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CarService.proto

package grpc.carservice;

/**
 * Protobuf type {@code grpc.ex1.MoveCarRequest}
 */
public  final class MoveCarRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.ex1.MoveCarRequest)
    MoveCarRequestOrBuilder {
  // Use MoveCarRequest.newBuilder() to construct.
  private MoveCarRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MoveCarRequest() {
    carIndex_ = 0;
    direction_ = 0;
    count_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private MoveCarRequest(
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

            carIndex_ = input.readInt32();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            direction_ = rawValue;
            break;
          }
          case 24: {

            count_ = input.readInt32();
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.carservice.CarServiceProto.internal_static_grpc_ex1_MoveCarRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.carservice.CarServiceProto.internal_static_grpc_ex1_MoveCarRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.carservice.MoveCarRequest.class, grpc.carservice.MoveCarRequest.Builder.class);
  }

  public static final int CARINDEX_FIELD_NUMBER = 1;
  private int carIndex_;
  /**
   * <code>int32 carIndex = 1;</code>
   */
  public int getCarIndex() {
    return carIndex_;
  }

  public static final int DIRECTION_FIELD_NUMBER = 2;
  private int direction_;
  /**
   * <code>.grpc.ex1.Direction direction = 2;</code>
   */
  public int getDirectionValue() {
    return direction_;
  }
  /**
   * <code>.grpc.ex1.Direction direction = 2;</code>
   */
  public grpc.carservice.Direction getDirection() {
    grpc.carservice.Direction result = grpc.carservice.Direction.valueOf(direction_);
    return result == null ? grpc.carservice.Direction.UNRECOGNIZED : result;
  }

  public static final int COUNT_FIELD_NUMBER = 3;
  private int count_;
  /**
   * <code>int32 count = 3;</code>
   */
  public int getCount() {
    return count_;
  }

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
    if (carIndex_ != 0) {
      output.writeInt32(1, carIndex_);
    }
    if (direction_ != grpc.carservice.Direction.UP.getNumber()) {
      output.writeEnum(2, direction_);
    }
    if (count_ != 0) {
      output.writeInt32(3, count_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (carIndex_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, carIndex_);
    }
    if (direction_ != grpc.carservice.Direction.UP.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, direction_);
    }
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, count_);
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
    if (!(obj instanceof grpc.carservice.MoveCarRequest)) {
      return super.equals(obj);
    }
    grpc.carservice.MoveCarRequest other = (grpc.carservice.MoveCarRequest) obj;

    boolean result = true;
    result = result && (getCarIndex()
        == other.getCarIndex());
    result = result && direction_ == other.direction_;
    result = result && (getCount()
        == other.getCount());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CARINDEX_FIELD_NUMBER;
    hash = (53 * hash) + getCarIndex();
    hash = (37 * hash) + DIRECTION_FIELD_NUMBER;
    hash = (53 * hash) + direction_;
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getCount();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.carservice.MoveCarRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.carservice.MoveCarRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.carservice.MoveCarRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.carservice.MoveCarRequest parseFrom(
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
  public static Builder newBuilder(grpc.carservice.MoveCarRequest prototype) {
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
   * Protobuf type {@code grpc.ex1.MoveCarRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.ex1.MoveCarRequest)
      grpc.carservice.MoveCarRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.carservice.CarServiceProto.internal_static_grpc_ex1_MoveCarRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.carservice.CarServiceProto.internal_static_grpc_ex1_MoveCarRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.carservice.MoveCarRequest.class, grpc.carservice.MoveCarRequest.Builder.class);
    }

    // Construct using grpc.carservice.MoveCarRequest.newBuilder()
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
      carIndex_ = 0;

      direction_ = 0;

      count_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.carservice.CarServiceProto.internal_static_grpc_ex1_MoveCarRequest_descriptor;
    }

    public grpc.carservice.MoveCarRequest getDefaultInstanceForType() {
      return grpc.carservice.MoveCarRequest.getDefaultInstance();
    }

    public grpc.carservice.MoveCarRequest build() {
      grpc.carservice.MoveCarRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public grpc.carservice.MoveCarRequest buildPartial() {
      grpc.carservice.MoveCarRequest result = new grpc.carservice.MoveCarRequest(this);
      result.carIndex_ = carIndex_;
      result.direction_ = direction_;
      result.count_ = count_;
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
      if (other instanceof grpc.carservice.MoveCarRequest) {
        return mergeFrom((grpc.carservice.MoveCarRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.carservice.MoveCarRequest other) {
      if (other == grpc.carservice.MoveCarRequest.getDefaultInstance()) return this;
      if (other.getCarIndex() != 0) {
        setCarIndex(other.getCarIndex());
      }
      if (other.direction_ != 0) {
        setDirectionValue(other.getDirectionValue());
      }
      if (other.getCount() != 0) {
        setCount(other.getCount());
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
      grpc.carservice.MoveCarRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.carservice.MoveCarRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int carIndex_ ;
    /**
     * <code>int32 carIndex = 1;</code>
     */
    public int getCarIndex() {
      return carIndex_;
    }
    /**
     * <code>int32 carIndex = 1;</code>
     */
    public Builder setCarIndex(int value) {
      
      carIndex_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 carIndex = 1;</code>
     */
    public Builder clearCarIndex() {
      
      carIndex_ = 0;
      onChanged();
      return this;
    }

    private int direction_ = 0;
    /**
     * <code>.grpc.ex1.Direction direction = 2;</code>
     */
    public int getDirectionValue() {
      return direction_;
    }
    /**
     * <code>.grpc.ex1.Direction direction = 2;</code>
     */
    public Builder setDirectionValue(int value) {
      direction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.ex1.Direction direction = 2;</code>
     */
    public grpc.carservice.Direction getDirection() {
      grpc.carservice.Direction result = grpc.carservice.Direction.valueOf(direction_);
      return result == null ? grpc.carservice.Direction.UNRECOGNIZED : result;
    }
    /**
     * <code>.grpc.ex1.Direction direction = 2;</code>
     */
    public Builder setDirection(grpc.carservice.Direction value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      direction_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.grpc.ex1.Direction direction = 2;</code>
     */
    public Builder clearDirection() {
      
      direction_ = 0;
      onChanged();
      return this;
    }

    private int count_ ;
    /**
     * <code>int32 count = 3;</code>
     */
    public int getCount() {
      return count_;
    }
    /**
     * <code>int32 count = 3;</code>
     */
    public Builder setCount(int value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 count = 3;</code>
     */
    public Builder clearCount() {
      
      count_ = 0;
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


    // @@protoc_insertion_point(builder_scope:grpc.ex1.MoveCarRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.ex1.MoveCarRequest)
  private static final grpc.carservice.MoveCarRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.carservice.MoveCarRequest();
  }

  public static grpc.carservice.MoveCarRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MoveCarRequest>
      PARSER = new com.google.protobuf.AbstractParser<MoveCarRequest>() {
    public MoveCarRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new MoveCarRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MoveCarRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MoveCarRequest> getParserForType() {
    return PARSER;
  }

  public grpc.carservice.MoveCarRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

