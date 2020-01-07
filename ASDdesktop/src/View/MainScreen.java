package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import Model.FireDB;

/**
 * 
 * @author nathaniel veldkamp
 *
 */
public class MainScreen extends BorderPane {
	//webview voor lokale server
	WebView mWebView = new WebView();
	WebEngine engine = mWebView.getEngine();
	
	//Pane voor route interface
	static Pane inter = new Pane();
	static ImageView ivRobot;

	FireDB db = new FireDB();
	
	public static ArrayList<ImageView> ObOnArray = new ArrayList<>();
	
	public MainScreen() {
		
		db.CurrentPos();
		//db.ObStacleOnPos();
				
		mWebView.setPrefSize(700, 200);
		setTop(mWebView);
		
		inter.setPrefSize(700, 500);
		Image imgGrid = new Image("file:grid.png");// grid image
		ImageView ivGrid = new ImageView(imgGrid);
		ivGrid.relocate(120, 24);
		ivGrid.setFitHeight(450);
		ivGrid.setFitWidth(450);
		
		Image imgRobot = new Image("file:robot.png");// grid image
		ivRobot = new ImageView(imgRobot);
		ivRobot.setFitHeight(30);
		ivRobot.setFitWidth(30);
				
		inter.getChildren().add(ivGrid);
		inter.getChildren().add(ivRobot);
		
		setCenter(inter);

	}

	//functie voor het updaten van de robot op de grid
	public static void relocateRobot(long x, long y) {
		// TODO Auto-generated method stub
		if(x > 8 || y > 8) {
			ivRobot.relocate(106, 455);
			System.out.println("xy values invalid");
		}else if(x < 0 || y < 0) {
			ivRobot.relocate(106, 455);
			System.out.println("xy values invalid");
		}else {
			ivRobot.relocate(106 + (x * 56), 455 - (y * 56));
			System.out.println(ivRobot.getLayoutX() + " " + ivRobot.getLayoutY());
		}
		
	}
	
	// functie voor een obstakel op de grid plaatsen wanneer de robot eentje vind op een xy
	public static void placeObstacleOn(long x, long y) {	
		
		
		
	}
	
}
