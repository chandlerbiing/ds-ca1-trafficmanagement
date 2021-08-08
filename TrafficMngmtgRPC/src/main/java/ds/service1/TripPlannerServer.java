package ds.service1;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.service1.TripPlannerGrpc.TripPlannerImplBase;


public class TripPlannerServer extends TripPlannerImplBase{

	public static void main(String[] args) throws InterruptedException , IOException {
		// TODO Auto-generated method stub
		
		
		TripPlannerServer trippy = new TripPlannerServer();
		
		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(trippy)
				.build()
				.start();

		System.out.println("Service 1 started, listening on " + port);

		server.awaitTermination();
	

	}
	
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts decimal degrees to radians             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private double deg2rad(double deg) {
	  return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts radians to decimal degrees             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private double rad2deg(double rad) {
	  return (rad * 180.0 / Math.PI);
	}

	
	public void currentStatus (trafficRequest request, StreamObserver<trafficStatus> responseObserver) {
		
		String trafficSituation;
		
		System.out.println("receiving coordinates" + request.getLatitudeCur() + " , " + request.getLongitudeCur() + " " + 
		request.getLongitudeDes() + " "  + request.getLatitudeDes());
				
		double theta = request.getLongitudeCur() - request.getLongitudeDes();
			
		 double dist = Math.sin(deg2rad(request.getLatitudeCur())) * Math.sin(deg2rad(request.getLatitudeDes())) + Math.cos(deg2rad(request.getLatitudeCur())) * Math.cos(deg2rad(request.getLatitudeDes())) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;	
		  
		  dist = dist * 1.609344; //Assume distance is in Kilometers 
		  
		  if (dist > 100.00) {
			  
			  
			  trafficSituation = " Traffic Congestion Expected for this route";
		  } else {
			  
			  
			 trafficSituation = " Traffic Congestion Not Expected for this route";
			  
		  }
		  
		  trafficStatus reply = trafficStatus.newBuilder().setMessage(trafficSituation).build();
		  
		  responseObserver.onNext(reply);

		  responseObserver.onCompleted();
		  
		  
		}

	
	public StreamObserver<futureTrafficRequest> futureStatus(StreamObserver<forecastTrafficStatus> responseObserver) {
		
		
		return new StreamObserver<futureTrafficRequest> () {

			@Override
			public void onNext(futureTrafficRequest request) {
			
				
				String futureTrafficSituation;
				
				System.out.println("receiving coordinates" + request.getLatitudeCur() + " , " + request.getLongitudeCur() + " " + 
				request.getLongitudeDes() + " "  + request.getLatitudeDes() + " " + request.getDepartureTime());
				
				double time = request.getDepartureTime();
				
				double theta = request.getLongitudeCur() - request.getLongitudeDes();
					
				 double dist = Math.sin(deg2rad(request.getLatitudeCur())) * Math.sin(deg2rad(request.getLatitudeDes())) + Math.cos(deg2rad(request.getLatitudeCur())) * Math.cos(deg2rad(request.getLatitudeDes())) * Math.cos(deg2rad(theta));
				  dist = Math.acos(dist);
				  dist = rad2deg(dist);
				  dist = dist * 60 * 1.1515;	
				  
				  dist = dist * 1.609344; //Assume distance is in Kilometers 
				  
				  if (dist > 100.00 && (time < 10.00 ||time > 16.00)){
					  
					  
					  futureTrafficSituation = " Traffic Congestion Expected for this route";
				  } else {
					  
					  
					  futureTrafficSituation  = " Traffic Congestion Not Expected for this route";
					  
				  }
				  
				  forecastTrafficStatus  reply = forecastTrafficStatus.newBuilder().setName(futureTrafficSituation ).build();
				  
				  responseObserver.onNext(reply);

				
			}

			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				
			
				
				//completed too
				responseObserver.onCompleted();
				
			}
			
			
			
			
			
			
		};
		
		
		
	}
	
	
	


}
