package ds.service2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.service1.TripPlannerServer;

import ds.service2.TrafficUpdatesGrpc.TrafficUpdatesImplBase;

public class TrafficUpdatesServer extends TrafficUpdatesImplBase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		TrafficUpdatesServer traffic = new TrafficUpdatesServer();
		
		Properties prop = traffic.getProperties();
		
		traffic.registerService(prop);
		
		int port = 50051;
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(traffic)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	

	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/TrafficMngmt.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Traffic Service properties ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	

	private  void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example";
	           // int service_port = 1234;
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
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
