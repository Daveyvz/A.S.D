package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import View.MainScreen;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author nathaniel veldkamp
 *
 */
public class FireDB {
	
	public FireDB() {
		
		try {
			
			FileInputStream serviceAccount = new FileInputStream("ServiceAccountKey.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder()
				    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				    .setDatabaseUrl("https://lijnvolger-20778.firebaseio.com/")
				    .build();
				FirebaseApp.initializeApp(options);
								
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// fucntie voor robot positie
	public void CurrentPos() {
			
		DatabaseReference ref = FirebaseDatabase.getInstance() // database reference nodig om het te gebruiken
		    .getReference();
		ref.child("Position").child("Current").addValueEventListener(new ValueEventListener() { // locatie van de data
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				// TODO Auto-generated method stub
				
				Object X = snapshot.child("X").getValue(); // X data
				Object Y = snapshot.child("Y").getValue(); // Y data
				
				//data convert naar long omdat de database dat zo wilt
				Long lX = (Long) X; 
				Long lY = (Long) Y;
				MainScreen.relocateRobot(lX, lY); // positie word visual geupdate
			
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	// data voor als ene obstakel op een coordinaat is
	public void ObStacleOnPos() {
		
		DatabaseReference ref = FirebaseDatabase.getInstance() // database reference nodig om het te gebruiken
		    .getReference();
		ref.child("ObstacleOnXY").addChildEventListener(new ChildEventListener() {
			@Override
			public void onChildRemoved(DataSnapshot snapshot) {
				// TODO Auto-generated method stub

				
			}
			
			@Override
			public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
				// TODO Auto-generated method stub
				
				
			}
			
			// Obstacle on data
			@Override
			public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
				// data retrieval
				if(snapshot.exists()) {
					
					Object X = snapshot.child("X").getValue(); // X data
					Object Y = snapshot.child("Y").getValue(); // Y data
				
					Long lX = (Long) X;
					Long lY = (Long) Y;
							
					MainScreen.placeObstacleOn(lX, lY);
				}else {
					System.out.println("No obstacles found");
				}
					
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	// Data voor een obstakel die tussen twee coordinaten wordt gevonden
	public void ObstacleBetweenPos(){
		
		DatabaseReference ref = FirebaseDatabase.getInstance() // database reference nodig om het te gebruiken
			    .getReference();
			ref.child("ObstacleBetweenXY").addChildEventListener(new ChildEventListener() {
				@Override
				public void onChildRemoved(DataSnapshot snapshot) {
					// TODO Auto-generated method stub

					
				}
				
				@Override
				public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub
					
					
				}
				
				// Obstacle on data
				@Override
				public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
					// data retrieval
					if(snapshot.exists()) {
						
						Object fromX = snapshot.child("FromX").getValue(); // X data
						Object fromY = snapshot.child("FromY").getValue(); // Y data
						Object toX = snapshot.child("ToX").getValue(); // X data
						Object toY = snapshot.child("ToY").getValue(); // Y data
					
						Long lfromX = (Long) fromX;
						Long lfromY = (Long) fromY;
						Long ltoX = (Long) toX;
						Long ltoY = (Long) toY;
								
						MainScreen.placeObstacleBetween(lfromX, lfromY, ltoX, ltoY);
					}else {
						System.out.println("No obstacles found");
					}
						
				}
				
				@Override
				public void onCancelled(DatabaseError error) {
					// TODO Auto-generated method stub
					
				}
			});
		
	}
	
}


