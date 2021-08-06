package com.caone;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.caone.CurrentStatusGrpc.CurrentStatusImplBase;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;



public class TrafficMngmntServer extends CurrentStatusImplBase  {
	
	private static final Logger logger = Logger.getLogger(TrafficMngmntServer.class.getName());

	public static void main(String[] args)  throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		
		TrafficMngmntServer trafficServer = new TrafficMngmntServer();
		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port).addService(trafficServer).build().start();
		
		
		logger.info("Server has started on " + port);
		
		server.awaitTermination();
		
		
		
		
		

	}
	
	
	public void currentStatus(StreamObserver<trafficRequest> requestObserver,  trafficStatus response) {
		
		trafficRequest stb1 = new trafficRequest();
		
		trafficRequest stb2 = new trafficRequest();
		
		stb1.getCurrentdestination();
		
		stb2.getDesireddestination();
		
		requestObserver.onNext(stb2);
		
		requestObserver.onCompleted();
		
		
		
		//Check if traffic is congested or not
		
		
		trafficStatus reply = trafficStatus.newBuilder().setMessage(" Traffic is Okay").build()
		;
		
	}

}
