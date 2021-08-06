package com.caone;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;



public class TrafficMngmntClient {
	
	private static CurrentStatusGrpc.CurrentStatusBlockingStub blockingStub;
	
	private static FutureStatusGrpc.FutureStatusBlockingStub blockingStubFut;
	
	public static void main (String[] args) throws Exception {
		
		
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		//stubs -- generate from proto
		blockingStub = CurrentStatusGrpc.newBlockingStub(channel);
		
		
		
		currentStatus();
		
		
		
	}

	
	
	public static void currentStatus() {
		// TODO Auto-generated method stub
		
		
		trafficRequest req = trafficRequest.newBuilder().setCurrentdestination ("Barrow Street").setDesireddestination ("Grafton Street").build();
	
		
		trafficStatus response = blockingStub.currentStatus(req);
		
		System.out.println(response.getMessage());
	}
	
	
	
	
	
	

}
