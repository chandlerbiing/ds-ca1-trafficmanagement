package com.caone;

import io.grpc.stub.StreamObserver;
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

public class SmartTrafficMngmtClient {
	
	private static CurrentStatusGrpc.CurrentStatusBlockingStub blockingStub;
	private static CurrentStatusGrpc.CurrentStatusStub blockingStuby;
	
	private static DynamicTrafficControlGrpc.DynamicTrafficControlBlockingStub blockingstubDy;
	
	private static DynamicTrafficControlGrpc.DynamicTrafficControlStub stubDy;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		//stubs -- generate from proto
		blockingStub = CurrentStatusGrpc.newBlockingStub(channel);
		
		stubDy = DynamicTrafficControlGrpc.newStub(channel);
		
		blockingStuby = CurrentStatusGrpc.newStub(channel);
		
		currentStatus();
		
		futureStatus();
		
		liveUpdate();
		
		userOps();

	}

	private static void userOps() {
	
	StreamObserver<registrationStatus> responseObserver = new StreamObserver<registrationStatus>() {

		@Override
		public void onNext(registrationStatus value) {
			
			System.out.println("receiving average number " + value.getStatus() );
			
		}

		@Override
		public void onError(Throwable t) {
			// TODO Auto-generated method stub
			t.printStackTrace();
		}

		@Override
		public void onCompleted() {
			// TODO Auto-generated method stub
			System.out.println("stream is completed ... Registration Completed");
		}
		
		
		
	};
	
	
	StreamObserver<registration> requestObserver = stubDy.userOps(responseObserver);
	try {
	
		requestObserver.onNext(registration.newBuilder().setUserName("tanya007").build());
		Thread.sleep(500);
		
		requestObserver.onNext(registration.newBuilder().setEmail("myemail@distributedsystems.com").build());
		Thread.sleep(500);
		
		
		
		// Mark the end of requests
		requestObserver.onCompleted();
		
		
		Thread.sleep(10000);
		
	}  catch (RuntimeException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {			
		e.printStackTrace();
	}
	
	
	}

	private static void liveUpdate() {
		// TODO Auto-generated method stub
	
	
		currentLocation request = currentLocation.newBuilder().setLatitudeCur(53.2734).setLongitudeCur(-7.77832031).build();
	
	StreamObserver<trafficUpdate> responseObserver = new StreamObserver<trafficUpdate>(){
		
		
	int count;

		@Override
		public void onNext(trafficUpdate value) {
		
			
			System.out.println("receiving traffic update" + value.getUpdate());
			count++;
		}

		@Override
		public void onError(Throwable t) {
		
			t.printStackTrace();
		}

		@Override
		public void onCompleted() {
			System.out.println("stream is completed. Received "+ count+ " traffic related updates");
			
		}};
		
		stubDy.liveUpdate(request, responseObserver);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void futureStatus() {
	
		
		
		
		StreamObserver<forecastTrafficStatus> responseObserver = new StreamObserver<forecastTrafficStatus>() {

			@Override
			public void onNext(forecastTrafficStatus value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
			
			
			
		};
		

		StreamObserver<futureTrafficRequest> requestObserver = blockingStuby.futureStatus(responseObserver);

				try {
							
					requestObserver.onNext(futureTrafficRequest.newBuilder().setLatitudeCur(53.2734).
						setLongitudeCur(-7.77832031).setLatitudeDes(44.21370930989555).setLongitudeDes(4.042968750000001).setDepartureTime(14.30).build());	
					Thread.sleep(500);
					
					requestObserver.onNext(futureTrafficRequest.newBuilder().setLatitudeCur(54.2734).
							setLongitudeCur(-6.77832031).setLatitudeDes(45.21370930989555).setLongitudeDes(4.142968750000001).setDepartureTime(15.30).build());	
					Thread.sleep(500);
				
					
					// Mark the end of requests
					requestObserver.onCompleted();

					
					Thread.sleep(10000);
					
				}catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}

		
		
	}

	private static void currentStatus() {
		
		double numLat1 = 53.2734;
		double numLong1 = -7.77832031;
		double numLat2 = 44.21370930989555;
		double numLong2 = 4.042968750000001;
	
		trafficRequest reqqy = trafficRequest.newBuilder().setLatitudeCur(numLat1).setLongitudeCur(numLong1).
				setLongitudeDes(numLat2).setLatitudeDes(numLong2).build();
		
		
		
		trafficStatus response =  blockingStub.currentStatus(reqqy);
	
		System.out.println("Traffic For the journey requested is " + response.getMessage());
	}

}
