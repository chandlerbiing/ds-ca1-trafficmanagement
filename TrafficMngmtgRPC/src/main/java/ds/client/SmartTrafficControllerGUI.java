package ds.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	
	private static 	TripPlannerGrpc.TripPlannerBlockingStub blockingStub;
	private static TripPlannerGrpc.TripPlannerStub asyncStub ;
	
	//private static TrafficUpdatesGrpc.TrafficUpdatesBlockingStub tBlockingStub;
	
	private static TrafficUpdatesGrpc.TrafficUpdatesStub tAsyncStub;
	
	
	//A panel for each service
	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 1");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 10);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	
	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Invoke Service 2");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 10);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	
	public static void main(String[] args) {

		SmartTrafficControllerGUI gui = new SmartTrafficControllerGUI();

		gui.build();
	}
	
	
	private void build() { 

		JFrame frame = new JFrame("Service Controller Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService2JPanel() );
		

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand(); 
		

		if(label.equals("Invoke Service 1")) {
			System.out.println("service 1 to be invoked ...");

		
			
			
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			
			blockingStub = TripPlannerGrpc.newBlockingStub(channel);

			asyncStub = TripPlannerGrpc.newStub(channel);
		
			/*
			 * currentStatus implementation
			 */

			currentStatus();

			
			futureStatus();
			
		
		}else {
			
			
			System.out.println("service 2 to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			
		
			tAsyncStub = TrafficUpdatesGrpc.newStub(channel);


			/*
			 * liveUpdate implementation
			 */
			liveUpdate();
			
			
			

			/*
			 * newUser implementation
			 */
			newUser();
			
			
			
		}
		
	}



	private void newUser() {
		
		
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
			
		}  catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
			
		
	}



	private void liveUpdate() {
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
			
			tAsyncStub.liveUpdate(request, responseObserver);
			
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}



	private void currentStatus() {
		// TODO Auto-generated method stub
		
		double numLat1 = 53.2734;
		double numLong1 = -7.77832031;
		double numLat2 = 44.21370930989555;
		double numLong2 = 4.042968750000001;
	
		//preparing message to send
		trafficRequest reqqy = trafficRequest.newBuilder().setLatitudeCur(numLat1).setLongitudeCur(numLong1).
		setLongitudeDes(numLat2).setLatitudeDes(numLong2).build();
		
		//retrieving reply from service
		
		trafficStatus response2 = blockingStub.currentStatus(reqqy);
	
		System.out.println("Traffic For the journey requested is " + response2.getMessage());	
		
	}



	private void futureStatus() {
		// TODO Auto-generated method stub
		
		

		
		
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
					
				}catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}

		
	}



	
	
	
	
	
	

}
