package ds.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ds.service1.TripPlannerGrpc;
import ds.service1.forecastTrafficStatus;
import ds.service1.futureTrafficRequest;
import ds.service1.trafficRequest;
import ds.service1.trafficStatus;
import ds.service2.TrafficUpdatesGrpc;
import ds.service2.currentLocation;
import ds.service2.registration;
import ds.service2.registrationStatus;
import ds.service2.trafficUpdate;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartTrafficControllerGUI implements ActionListener{

	private JTextField entry1, entry2, reply1;
	private JTextField entry3, entry4, reply2;
	private JTextField entry5, entry6, entry7, entry8, reply3;
	private JTextField entry9, entry10, entry11, entry12, entry13, reply4;
	
	private static 	TripPlannerGrpc.TripPlannerBlockingStub blockingStub;
	private static TripPlannerGrpc.TripPlannerStub asyncStub ;
	
	//private static TrafficUpdatesGrpc.TrafficUpdatesBlockingStub tBlockingStub;
	
	private static TrafficUpdatesGrpc.TrafficUpdatesStub tAsyncStub;
	
	private ServiceInfo trafficServiceInfo;
	
	
	
	//A panel for each RPC
	private JPanel getRegistrationPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter User Name")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		
		
		
		JLabel label2 = new JLabel("Enter Email")	;
		panel.add(label2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		

		JButton button = new JButton("Register");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	
	private JPanel getLiveUpdatePanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label3 = new JLabel("Enter Longitude")	;
		panel.add(label3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("",10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		
		JLabel label = new JLabel("Enter Latitude")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry4 = new JTextField("",10);
		panel.add(entry4);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		

		JButton button = new JButton("Live Update");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	
	
	
	private JPanel getCurrentStatusPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label3 = new JLabel("Enter Current Longitude")	;
		panel.add(label3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry5 = new JTextField("",10);
		panel.add(entry5);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		
		JLabel label = new JLabel("Enter Current Latitude")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry6 = new JTextField("",10);
		panel.add(entry6);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		

		JLabel label4 = new JLabel("Enter Destination Longitude")	;
		panel.add(label4);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry7 = new JTextField("",10);
		panel.add(entry7);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		
		JLabel label5 = new JLabel("Enter Destination Latitude")	;
		panel.add(label5);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry8 = new JTextField("",10);
		panel.add(entry8);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		

		JButton button = new JButton("Current Traffic Status");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 20);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	
	
	private JPanel getForecastStatusPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label3 = new JLabel("Enter Current Longitude")	;
		panel.add(label3);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry9 = new JTextField("",10);
		panel.add(entry9);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		
		JLabel label = new JLabel("Enter Current Latitude")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry10 = new JTextField("",10);
		panel.add(entry10);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		

		JLabel label4 = new JLabel("Enter Destination Longitude")	;
		panel.add(label4);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry11 = new JTextField("",10);
		panel.add(entry11);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		
		JLabel label5 = new JLabel("Enter Destination Latitude")	;
		panel.add(label5);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry12 = new JTextField("",10);
		panel.add(entry12);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JLabel label6 = new JLabel("Enter Departure Time")	;
		panel.add(label6);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry13 = new JTextField("",10);
		panel.add(entry13);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		

		JButton button = new JButton("Predict Traffic Status");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply4 = new JTextField("", 10);
		reply4 .setEditable(false);
		panel.add(reply4 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	
	
	
	public static void main(String[] args) {

		SmartTrafficControllerGUI gui = new SmartTrafficControllerGUI();
		
	

		gui.build();
	}
	
	
	private void build() { 
		
		String traffic_service_type = "_http._tcp.local.";
		discoverSmartTrafficMngmtService(traffic_service_type);
		
		JFrame frame = new JFrame("Smart Traffic Management Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getRegistrationPanel() );
		panel.add( getLiveUpdatePanel() );
		panel.add( getCurrentStatusPanel() );
		panel.add( getForecastStatusPanel() );
		

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	
	private void discoverSmartTrafficMngmtService(String service_type) {
		
		
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

				
			jmdns.addServiceListener(service_type, new ServiceListener() {
				
				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Traffic Managment Service resolved: " + event.getInfo());

					trafficServiceInfo = event.getInfo();

					int port = trafficServiceInfo.getPort();
					
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + trafficServiceInfo.getNiceTextString());
					System.out.println("\t host: " + trafficServiceInfo.getHostAddresses()[0]);
				
					
				}
				
				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Traffic Service removed: " + event.getInfo());

					
				}
				
				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Traffic Service added: " + event.getInfo());

					
				}
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand(); 
		
		

		if(label.equals("Current Traffic Status")) {
			System.out.println("currentStatus to be invoked ...");

		
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			
			blockingStub = TripPlannerGrpc.newBlockingStub(channel);

			asyncStub = TripPlannerGrpc.newStub(channel);
			
			
			
			double numLat1 = 53.2734;
			double numLong1 = -7.77832031;
			double numLat2 = 44.21370930989555;
			double numLong2 = 4.042968750000001;
		
			//preparing message to send
			trafficRequest reqqy = trafficRequest.newBuilder().setLatitudeCur(numLat1).setLongitudeCur(numLong1).
			setLongitudeDes(numLat2).setLatitudeDes(numLong2).build();
			
			//retrieving reply from service
			
			trafficStatus response2 = blockingStub.currentStatus(reqqy);
		
			System.out.println("Status:  " + response2.getMessage());	
		
			
		
		}else if(label.equals("Predict Traffic Status")){
			
			
			System.out.println("futureTrafficStatus to be invoked ...");
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			
			blockingStub = TripPlannerGrpc.newBlockingStub(channel);

			asyncStub = TripPlannerGrpc.newStub(channel);
			
			
			StreamObserver<forecastTrafficStatus> responseObserver2 = new StreamObserver<forecastTrafficStatus>() {

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
			

			StreamObserver<futureTrafficRequest> requestObserver2 = asyncStub.futureStatus(responseObserver2);

					try {
								
						requestObserver2.onNext(futureTrafficRequest.newBuilder().setLatitudeCur(53.2734).
							setLongitudeCur(-7.77832031).setLatitudeDes(44.21370930989555).setLongitudeDes(4.042968750000001).setDepartureTime(14.30).build());	
						Thread.sleep(500);
						
						requestObserver2.onNext(futureTrafficRequest.newBuilder().setLatitudeCur(54.2734).
								setLongitudeCur(-6.77832031).setLatitudeDes(45.21370930989555).setLongitudeDes(4.142968750000001).setDepartureTime(15.30).build());	
						Thread.sleep(500);
					
						
						// Mark the end of requests
						requestObserver2.onCompleted();

						
						Thread.sleep(10000);
						
					}catch (RuntimeException e5) {
						e5.printStackTrace();
					} catch (InterruptedException e6) {			
						e6.printStackTrace();
					}


		
			
			
			
		} else if(label.equals("Live Update")){
			
			System.out.println("liveUpdate to be invoked ...");
			
			

			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			
			
			tAsyncStub = TrafficUpdatesGrpc.newStub(channel);
			
			
			
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
					System.out.println("stream is completed. Received "+ count + " traffic related updates");
					
				}
				
			};
				
				tAsyncStub.liveUpdate(request, responseObserver);
				
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

			
			
		} else if(label.equals("Register")) {
			
			
			System.out.println("newUser to be invoked ...");
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			
			
			tAsyncStub = TrafficUpdatesGrpc.newStub(channel);
			
			
			StreamObserver<registrationStatus> responseObserver = new StreamObserver<registrationStatus>() {

				@Override
				public void onNext(registrationStatus value) {
					
					
					
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
			
			
			StreamObserver<registration> requestObserver = tAsyncStub.newUser(responseObserver);
			try {
			
				requestObserver.onNext(registration.newBuilder().setUserName("tanya007").build());
				Thread.sleep(500);
				
				requestObserver.onNext(registration.newBuilder().setEmail("myemail@distributedsystems.com").build());
				Thread.sleep(500);
				
				
				
				// Mark the end of requests
				requestObserver.onCompleted();
				
				
				Thread.sleep(10000);
				
			}  catch (RuntimeException e3) {
				e3.printStackTrace();
			} catch (InterruptedException e4) {			
				e4.printStackTrace();
			}
			
				
			
			
		} else {
			
		}
		
		
		
		
		
	}
	
}//end of SmartTrafficController Class




// -----------------------------

//	private void newUser() {
//		
//		
//		StreamObserver<registrationStatus> responseObserver = new StreamObserver<registrationStatus>() {
//
//			@Override
//			public void onNext(registrationStatus value) {
//				
//				
//				
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				// TODO Auto-generated method stub
//				t.printStackTrace();
//			}
//
//			@Override
//			public void onCompleted() {
//				// TODO Auto-generated method stub
//				System.out.println("stream is completed ... Registration Completed");
//			}
//			
//			
//			
//		};
//		
//		
//		StreamObserver<registration> requestObserver = tAsyncStub.newUser(responseObserver);
//		try {
//		
//			requestObserver.onNext(registration.newBuilder().setUserName("tanya007").build());
//			Thread.sleep(500);
//			
//			requestObserver.onNext(registration.newBuilder().setEmail("myemail@distributedsystems.com").build());
//			Thread.sleep(500);
//			
//			
//			
//			// Mark the end of requests
//			requestObserver.onCompleted();
//			
//			
//			Thread.sleep(10000);
//			
//		}  catch (RuntimeException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {			
//			e.printStackTrace();
//		}
//		
//			
//		
//	}
//
//
//
//	private void liveUpdate() {
//		// TODO Auto-generated method stub
//		
//		currentLocation request = currentLocation.newBuilder().setLatitudeCur(53.2734).setLongitudeCur(-7.77832031).build();
//		
//		StreamObserver<trafficUpdate> responseObserver = new StreamObserver<trafficUpdate>(){
//			
//			
//		int count;
//
//			@Override
//			public void onNext(trafficUpdate value) {
//			
//				
//				System.out.println("receiving traffic update" + value.getUpdate());
//				count++;
//			}
//
//			@Override
//			public void onError(Throwable t) {
//			
//				t.printStackTrace();
//			}
//
//			@Override
//			public void onCompleted() {
//				System.out.println("stream is completed. Received "+ count+ " traffic related updates");
//				
//			}};
//			
//			tAsyncStub.liveUpdate(request, responseObserver);
//			
//			try {
//				Thread.sleep(15000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//	}
//
//
//
//	private void currentStatus() {
//		// TODO Auto-generated method stub
//		
//		double numLat1 = 53.2734;
//		double numLong1 = -7.77832031;
//		double numLat2 = 44.21370930989555;
//		double numLong2 = 4.042968750000001;
//	
//		//preparing message to send
//		trafficRequest reqqy = trafficRequest.newBuilder().setLatitudeCur(numLat1).setLongitudeCur(numLong1).
//		setLongitudeDes(numLat2).setLatitudeDes(numLong2).build();
//		
//		//retrieving reply from service
//		
//		trafficStatus response2 = blockingStub.currentStatus(reqqy);
//	
//		System.out.println("Traffic For the journey requested is " + response2.getMessage());	
//		
//	}
//
//
//
//	private void futureStatus() {
//		// TODO Auto-generated method stub
//		
//		
//
//		
//		
//		StreamObserver<forecastTrafficStatus> responseObserver2 = new StreamObserver<forecastTrafficStatus>() {
//
//			@Override
//			public void onNext(forecastTrafficStatus value) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				t.printStackTrace();
//			}
//
//			@Override
//			public void onCompleted() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			
//			
//		};
//		
//
//		StreamObserver<futureTrafficRequest> requestObserver2 = asyncStub.futureStatus(responseObserver2);
//
//				try {
//							
//					requestObserver2.onNext(futureTrafficRequest.newBuilder().setLatitudeCur(53.2734).
//						setLongitudeCur(-7.77832031).setLatitudeDes(44.21370930989555).setLongitudeDes(4.042968750000001).setDepartureTime(14.30).build());	
//					Thread.sleep(500);
//					
//					requestObserver2.onNext(futureTrafficRequest.newBuilder().setLatitudeCur(54.2734).
//							setLongitudeCur(-6.77832031).setLatitudeDes(45.21370930989555).setLongitudeDes(4.142968750000001).setDepartureTime(15.30).build());	
//					Thread.sleep(500);
//				
//					
//					// Mark the end of requests
//					requestObserver2.onCompleted();
//
//					
//					Thread.sleep(10000);
//					
//				}catch (RuntimeException e) {
//					e.printStackTrace();
//				} catch (InterruptedException e) {			
//					e.printStackTrace();
//				}
//
//		
//	}
//
//
//
//	
//	
//	
//	
//	
//	
//
//}
