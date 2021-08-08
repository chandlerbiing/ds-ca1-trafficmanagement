package ds.service2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.service1.TripPlannerServer;
import ds.service2.TrafficUpdatesGrpc.TrafficUpdatesImplBase;

public class TrafficUpdatesServer extends TrafficUpdatesImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		TrafficUpdatesServer traffic = new TrafficUpdatesServer();
		
		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(traffic)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	

	}
	
	

	//registration
	
	public StreamObserver<registration> newUser( StreamObserver<registrationStatus> 
	responseObserver) {
		
		
		return new StreamObserver<registration>() {
			
			
			ArrayList<String> list = new ArrayList<String>();
			
			
			@Override
			public void onNext(registration request) {
				
				
			System.out.println("Recieveing registration details "+ request.getUserName() + request.getEmail());

			list.add(request.getUserName());	
			
			list.add(request.getEmail());	
				
			}
			

			@Override
			public void onError(Throwable t) {
			

			}

			@Override
			public void onCompleted() {
				
				
				
				// TODO Auto-generated method stub
				
				boolean validUsername = true;
				boolean validEmail = true;
				
				String msg = "";
				
				String s = list.get(0);
				
				String e = list.get(1);
			
				
				char[] a = s.toCharArray();
				
				
				//Username validator

				for (char c: a)
				{
					validUsername = ((c >= 'a') && (c <= 'z')) || 
				            ((c >= 'A') && (c <= 'Z')) || 
				            ((c >= '0') && (c <= '9'));
				    
				 

				    if (!validUsername)
				    {
				        break;
				    }
				}
	
				
				//Email Validator
				final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
				validEmail =  EMAIL_REGEX.matcher(e).matches();
				
	
				
				
				if (validUsername == true && validEmail == true) {
					
					msg  = "Registration Successful";
				} else {
					
					
					msg  = "Registration UnSuccessful. Invalid Username or Email";
					
				}
				registrationStatus reply = registrationStatus.newBuilder().setStatus(msg).build();
				
				
				
				responseObserver.onNext(reply);

				responseObserver.onCompleted();
	
				
			}
		};
		
	}
		
		public void liveUpdate (currentLocation request, StreamObserver<trafficUpdate> responseObserver) {
			
			
			request.getLatitudeCur();
			
			request.getLongitudeCur();
			
			String Update = "No traffic Updates at this time";
			
			trafficUpdate reply = trafficUpdate.newBuilder().setUpdate(Update).build();
			
			responseObserver.onNext(reply);
			
			try {
				//wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	
	
	
}
