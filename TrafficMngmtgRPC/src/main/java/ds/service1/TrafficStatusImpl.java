// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service1TripPlanner.proto

package ds.service1;

public final class TrafficStatusImpl {
  private TrafficStatusImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_trafficRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_trafficRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_futureTrafficRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_futureTrafficRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_trafficStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_trafficStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_forecastTrafficStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_forecastTrafficStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031service1TripPlanner.proto\022\010service1\"f\n" +
      "\016trafficRequest\022\023\n\013latitudeCur\030\001 \001(\001\022\024\n\014" +
      "longitudeCur\030\002 \001(\001\022\023\n\013latitudeDes\030\003 \001(\001\022" +
      "\024\n\014longitudeDes\030\004 \001(\001\"\203\001\n\024futureTrafficR" +
      "equest\022\023\n\013latitudeCur\030\001 \001(\001\022\024\n\014longitude" +
      "Cur\030\002 \001(\001\022\023\n\013latitudeDes\030\003 \001(\001\022\024\n\014longit" +
      "udeDes\030\004 \001(\001\022\025\n\rdepartureTime\030\005 \001(\001\" \n\rt" +
      "rafficStatus\022\017\n\007message\030\001 \001(\t\"%\n\025forecas" +
      "tTrafficStatus\022\014\n\004name\030\001 \001(\t2\252\001\n\013TripPla" +
      "nner\022D\n\rcurrentStatus\022\030.service1.traffic" +
      "Request\032\027.service1.trafficStatus\"\000\022U\n\014fu" +
      "tureStatus\022\036.service1.futureTrafficReque" +
      "st\032\037.service1.forecastTrafficStatus\"\000(\0010" +
      "\001B\"\n\013ds.service1B\021TrafficStatusImplP\001b\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_service1_trafficRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service1_trafficRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_trafficRequest_descriptor,
        new java.lang.String[] { "LatitudeCur", "LongitudeCur", "LatitudeDes", "LongitudeDes", });
    internal_static_service1_futureTrafficRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service1_futureTrafficRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_futureTrafficRequest_descriptor,
        new java.lang.String[] { "LatitudeCur", "LongitudeCur", "LatitudeDes", "LongitudeDes", "DepartureTime", });
    internal_static_service1_trafficStatus_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service1_trafficStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_trafficStatus_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_service1_forecastTrafficStatus_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service1_forecastTrafficStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_forecastTrafficStatus_descriptor,
        new java.lang.String[] { "Name", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
