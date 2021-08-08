package ds.service1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.service1.TripPlannerGrpc.TripPlannerImplBase;


public class TripPlannerServer extends TripPlannerImplBase{

	public static void main(String[] args) throws InterruptedException , IOException {
		// TODO Auto-generated method stub
		
		
		TripPlannerServer trippy = new TripPlannerServer();
		
		Properties prop = trippy.getProperties();
		
		trippy.registerService(prop);
		
	
		
		int port = 50051;
		
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(trippy)
				.build()
				.start();

		System.out.println("Service 1 started, listening on " + port);

		server.awaitTermination();
	

	} catch (IOException e) {
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
		  
		  if (dist > 40.00) {
			  
			  
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

				System.out.println("receiving coordinates" + request.getLatitudeCur() + " , "
						+ request.getLongitudeCur() + " " + request.getLongitudeDes() + " " + request.getLatitudeDes()
						+ " " + request.getDepartureTime());

				double time = request.getDepartureTime();

				double theta = request.getLongitudeCur() - request.getLongitudeDes();

				double dist = Math.sin(deg2rad(request.getLatitudeCur())) * Math.sin(deg2rad(request.getLatitudeDes()))
						+ Math.cos(deg2rad(request.getLatitudeCur())) * Math.cos(deg2rad(request.getLatitudeDes()))
								* Math.cos(deg2rad(theta));
				dist = Math.acos(dist);
				dist = rad2deg(dist);
				dist = dist * 60 * 1.1515;

				dist = dist * 1.609344; // Assume distance is in Kilometers

				if (dist > 100.00 && (time < 10.00 || time > 16.00)) {

					futureTrafficSituation = " Traffic Congestion Expected for this route";
				} else {

					futureTrafficSituation = " Traffic Congestion Not Expected for this route";

				}

				forecastTrafficStatus reply = forecastTrafficStatus.newBuilder().setName(futureTrafficSituation)
						.build();

				responseObserver.onNext(reply);

			}

			@Override
			public void onError(Throwable t) {

				t.printStackTrace();

			}

			@Override
			public void onCompleted() {

				// completed too
				responseObserver.onCompleted();

			}

		};

	}
	


}
