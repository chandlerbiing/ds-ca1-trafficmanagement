// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trafficStatus.proto

package com.caone;

/**
 * Protobuf type {@code traffic.futureTrafficRequest}
 */
public  final class futureTrafficRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:traffic.futureTrafficRequest)
    futureTrafficRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use futureTrafficRequest.newBuilder() to construct.
  private futureTrafficRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private futureTrafficRequest() {
    latitudeCur_ = 0;
    longitudeCur_ = 0;
    latitudeDes_ = 0;
    longitudeDes_ = 0;
    departureTime_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private futureTrafficRequest(
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
          case 8: {

            latitudeCur_ = input.readInt32();
            break;
          }
          case 16: {

            longitudeCur_ = input.readInt32();
            break;
          }
          case 24: {

            latitudeDes_ = input.readInt32();
            break;
          }
          case 32: {

            longitudeDes_ = input.readInt32();
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            departureTime_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.caone.TrafficStatusImpl.internal_static_traffic_futureTrafficRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.caone.TrafficStatusImpl.internal_static_traffic_futureTrafficRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.caone.futureTrafficRequest.class, com.caone.futureTrafficRequest.Builder.class);
  }

  public static final int LATITUDECUR_FIELD_NUMBER = 1;
  private int latitudeCur_;
  /**
   * <code>int32 latitudeCur = 1;</code>
   */
  public int getLatitudeCur() {
    return latitudeCur_;
  }

  public static final int LONGITUDECUR_FIELD_NUMBER = 2;
  private int longitudeCur_;
  /**
   * <code>int32 longitudeCur = 2;</code>
   */
  public int getLongitudeCur() {
    return longitudeCur_;
  }

  public static final int LATITUDEDES_FIELD_NUMBER = 3;
  private int latitudeDes_;
  /**
   * <code>int32 latitudeDes = 3;</code>
   */
  public int getLatitudeDes() {
    return latitudeDes_;
  }

  public static final int LONGITUDEDES_FIELD_NUMBER = 4;
  private int longitudeDes_;
  /**
   * <code>int32 longitudeDes = 4;</code>
   */
  public int getLongitudeDes() {
    return longitudeDes_;
  }

  public static final int DEPARTURETIME_FIELD_NUMBER = 5;
  private volatile java.lang.Object departureTime_;
  /**
   * <code>string departureTime = 5;</code>
   */
  public java.lang.String getDepartureTime() {
    java.lang.Object ref = departureTime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      departureTime_ = s;
      return s;
    }
  }
  /**
   * <code>string departureTime = 5;</code>
   */
  public com.google.protobuf.ByteString
      getDepartureTimeBytes() {
    java.lang.Object ref = departureTime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      departureTime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (latitudeCur_ != 0) {
      output.writeInt32(1, latitudeCur_);
    }
    if (longitudeCur_ != 0) {
      output.writeInt32(2, longitudeCur_);
    }
    if (latitudeDes_ != 0) {
      output.writeInt32(3, latitudeDes_);
    }
    if (longitudeDes_ != 0) {
      output.writeInt32(4, longitudeDes_);
    }
    if (!getDepartureTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, departureTime_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (latitudeCur_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, latitudeCur_);
    }
    if (longitudeCur_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, longitudeCur_);
    }
    if (latitudeDes_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, latitudeDes_);
    }
    if (longitudeDes_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, longitudeDes_);
    }
    if (!getDepartureTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, departureTime_);
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
    if (!(obj instanceof com.caone.futureTrafficRequest)) {
      return super.equals(obj);
    }
    com.caone.futureTrafficRequest other = (com.caone.futureTrafficRequest) obj;

    boolean result = true;
    result = result && (getLatitudeCur()
        == other.getLatitudeCur());
    result = result && (getLongitudeCur()
        == other.getLongitudeCur());
    result = result && (getLatitudeDes()
        == other.getLatitudeDes());
    result = result && (getLongitudeDes()
        == other.getLongitudeDes());
    result = result && getDepartureTime()
        .equals(other.getDepartureTime());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LATITUDECUR_FIELD_NUMBER;
    hash = (53 * hash) + getLatitudeCur();
    hash = (37 * hash) + LONGITUDECUR_FIELD_NUMBER;
    hash = (53 * hash) + getLongitudeCur();
    hash = (37 * hash) + LATITUDEDES_FIELD_NUMBER;
    hash = (53 * hash) + getLatitudeDes();
    hash = (37 * hash) + LONGITUDEDES_FIELD_NUMBER;
    hash = (53 * hash) + getLongitudeDes();
    hash = (37 * hash) + DEPARTURETIME_FIELD_NUMBER;
    hash = (53 * hash) + getDepartureTime().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.caone.futureTrafficRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.caone.futureTrafficRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.caone.futureTrafficRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.caone.futureTrafficRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.caone.futureTrafficRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.caone.futureTrafficRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.caone.futureTrafficRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.caone.futureTrafficRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.caone.futureTrafficRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.caone.futureTrafficRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.caone.futureTrafficRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.caone.futureTrafficRequest parseFrom(
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
  public static Builder newBuilder(com.caone.futureTrafficRequest prototype) {
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
   * Protobuf type {@code traffic.futureTrafficRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:traffic.futureTrafficRequest)
      com.caone.futureTrafficRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.caone.TrafficStatusImpl.internal_static_traffic_futureTrafficRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.caone.TrafficStatusImpl.internal_static_traffic_futureTrafficRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.caone.futureTrafficRequest.class, com.caone.futureTrafficRequest.Builder.class);
    }

    // Construct using com.caone.futureTrafficRequest.newBuilder()
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
      latitudeCur_ = 0;

      longitudeCur_ = 0;

      latitudeDes_ = 0;

      longitudeDes_ = 0;

      departureTime_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.caone.TrafficStatusImpl.internal_static_traffic_futureTrafficRequest_descriptor;
    }

    @java.lang.Override
    public com.caone.futureTrafficRequest getDefaultInstanceForType() {
      return com.caone.futureTrafficRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.caone.futureTrafficRequest build() {
      com.caone.futureTrafficRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.caone.futureTrafficRequest buildPartial() {
      com.caone.futureTrafficRequest result = new com.caone.futureTrafficRequest(this);
      result.latitudeCur_ = latitudeCur_;
      result.longitudeCur_ = longitudeCur_;
      result.latitudeDes_ = latitudeDes_;
      result.longitudeDes_ = longitudeDes_;
      result.departureTime_ = departureTime_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.caone.futureTrafficRequest) {
        return mergeFrom((com.caone.futureTrafficRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.caone.futureTrafficRequest other) {
      if (other == com.caone.futureTrafficRequest.getDefaultInstance()) return this;
      if (other.getLatitudeCur() != 0) {
        setLatitudeCur(other.getLatitudeCur());
      }
      if (other.getLongitudeCur() != 0) {
        setLongitudeCur(other.getLongitudeCur());
      }
      if (other.getLatitudeDes() != 0) {
        setLatitudeDes(other.getLatitudeDes());
      }
      if (other.getLongitudeDes() != 0) {
        setLongitudeDes(other.getLongitudeDes());
      }
      if (!other.getDepartureTime().isEmpty()) {
        departureTime_ = other.departureTime_;
        onChanged();
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
      com.caone.futureTrafficRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.caone.futureTrafficRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int latitudeCur_ ;
    /**
     * <code>int32 latitudeCur = 1;</code>
     */
    public int getLatitudeCur() {
      return latitudeCur_;
    }
    /**
     * <code>int32 latitudeCur = 1;</code>
     */
    public Builder setLatitudeCur(int value) {
      
      latitudeCur_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 latitudeCur = 1;</code>
     */
    public Builder clearLatitudeCur() {
      
      latitudeCur_ = 0;
      onChanged();
      return this;
    }

    private int longitudeCur_ ;
    /**
     * <code>int32 longitudeCur = 2;</code>
     */
    public int getLongitudeCur() {
      return longitudeCur_;
    }
    /**
     * <code>int32 longitudeCur = 2;</code>
     */
    public Builder setLongitudeCur(int value) {
      
      longitudeCur_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 longitudeCur = 2;</code>
     */
    public Builder clearLongitudeCur() {
      
      longitudeCur_ = 0;
      onChanged();
      return this;
    }

    private int latitudeDes_ ;
    /**
     * <code>int32 latitudeDes = 3;</code>
     */
    public int getLatitudeDes() {
      return latitudeDes_;
    }
    /**
     * <code>int32 latitudeDes = 3;</code>
     */
    public Builder setLatitudeDes(int value) {
      
      latitudeDes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 latitudeDes = 3;</code>
     */
    public Builder clearLatitudeDes() {
      
      latitudeDes_ = 0;
      onChanged();
      return this;
    }

    private int longitudeDes_ ;
    /**
     * <code>int32 longitudeDes = 4;</code>
     */
    public int getLongitudeDes() {
      return longitudeDes_;
    }
    /**
     * <code>int32 longitudeDes = 4;</code>
     */
    public Builder setLongitudeDes(int value) {
      
      longitudeDes_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 longitudeDes = 4;</code>
     */
    public Builder clearLongitudeDes() {
      
      longitudeDes_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object departureTime_ = "";
    /**
     * <code>string departureTime = 5;</code>
     */
    public java.lang.String getDepartureTime() {
      java.lang.Object ref = departureTime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        departureTime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string departureTime = 5;</code>
     */
    public com.google.protobuf.ByteString
        getDepartureTimeBytes() {
      java.lang.Object ref = departureTime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        departureTime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string departureTime = 5;</code>
     */
    public Builder setDepartureTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      departureTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string departureTime = 5;</code>
     */
    public Builder clearDepartureTime() {
      
      departureTime_ = getDefaultInstance().getDepartureTime();
      onChanged();
      return this;
    }
    /**
     * <code>string departureTime = 5;</code>
     */
    public Builder setDepartureTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      departureTime_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:traffic.futureTrafficRequest)
  }

  // @@protoc_insertion_point(class_scope:traffic.futureTrafficRequest)
  private static final com.caone.futureTrafficRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.caone.futureTrafficRequest();
  }

  public static com.caone.futureTrafficRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<futureTrafficRequest>
      PARSER = new com.google.protobuf.AbstractParser<futureTrafficRequest>() {
    @java.lang.Override
    public futureTrafficRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new futureTrafficRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<futureTrafficRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<futureTrafficRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.caone.futureTrafficRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
