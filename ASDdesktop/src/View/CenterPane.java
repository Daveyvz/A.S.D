package View;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CenterPane extends Pane {
	
	
	static ImageView ivRobot;
	
	//array voor obstacles
	static ArrayList<ImageView> ObOnArray;
	static ArrayList<ImageView> ObBetweenArray;
	
	// ints voor obstacle array iteration
	static int i = 0;
	static int a = 0;
	
	public CenterPane() {
		
		//image grid
		Image imgGrid = new Image("file:grid.png");// grid image
		ImageView ivGrid = new ImageView(imgGrid);
		ivGrid.relocate(120, 24);
		ivGrid.setFitHeight(450);
		ivGrid.setFitWidth(450);
				
		//image robot
		Image imgRobot = new Image("file:robot.png");// grid image
		ivRobot = new ImageView(imgRobot);
		ivRobot.setFitHeight(30);
		ivRobot.setFitWidth(30);
						
		ObOnArray  = new ArrayList<>();
		// obstacle imageviews for obstacles on a coordinate
		Image imgObOn = new Image("file:obstacleOn.png");
		ImageView ivObOn = new ImageView(imgObOn);
		ivObOn.setFitHeight(30);
		ivObOn.setFitWidth(30);
				
		Image imgObOn1 = new Image("file:obstacleOn.png");
		ImageView ivObOn1 = new ImageView(imgObOn1);
		ivObOn1.setFitHeight(30);
		ivObOn1.setFitWidth(30);
				
		Image imgObOn2 = new Image("file:obstacleOn.png");
		ImageView ivObOn2 = new ImageView(imgObOn2);
		ivObOn2.setFitHeight(30);
		ivObOn2.setFitWidth(30);
				
		Image imgObOn3 = new Image("file:obstacleOn.png");
		ImageView ivObOn3 = new ImageView(imgObOn3);
		ivObOn3.setFitHeight(30);
		ivObOn3.setFitWidth(30);
				
		Image imgObOn4 = new Image("file:obstacleOn.png");
		ImageView ivObOn4 = new ImageView(imgObOn4);
		ivObOn4.setFitHeight(30);
		ivObOn4.setFitWidth(30);
				
		ObOnArray.add(ivObOn);
		ObOnArray.add(ivObOn1);
		ObOnArray.add(ivObOn2);
		ObOnArray.add(ivObOn3);
		ObOnArray.add(ivObOn4);
				
		ObBetweenArray = new ArrayList<>();	
		//obstacle between image views
		Image imgObBet = new Image("file:cone.png");
		ImageView ivObBet = new ImageView(imgObBet);
		ivObBet.setFitHeight(20);
		ivObBet.setFitWidth(20);
				
		Image imgObBet1 = new Image("file:cone.png");
		ImageView ivObBet1 = new ImageView(imgObBet1);
		ivObBet1.setFitHeight(20);
		ivObBet1.setFitWidth(20);
				
		Image imgObBet2 = new Image("file:cone.png");
		ImageView ivObBet2 = new ImageView(imgObBet2);
		ivObBet2.setFitHeight(20);
		ivObBet2.setFitWidth(20);
				
		Image imgObBet3 = new Image("file:cone.png");
		ImageView ivObBet3 = new ImageView(imgObBet3);
		ivObBet3.setFitHeight(20);
		ivObBet3.setFitWidth(20);
				
		Image imgObBet4 = new Image("file:cone.png");
		ImageView ivObBet4 = new ImageView(imgObBet4);
		ivObBet4.setFitHeight(20);
		ivObBet4.setFitWidth(20);
				
		ObBetweenArray.add(ivObBet);
		ObBetweenArray.add(ivObBet1);
		ObBetweenArray.add(ivObBet2);
		ObBetweenArray.add(ivObBet3);
		ObBetweenArray.add(ivObBet4);
				
		getChildren().addAll(ivGrid, ivRobot);
		getChildren().addAll(ObOnArray);
		getChildren().addAll(ObBetweenArray);
				
		
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
		}
		
	}
		
	// functie voor een obstakel op de grid plaatsen wanneer de robot eentje vind op een xy
	public static void placeObstacleOn(long x, long y) {	

		ObOnArray.get(i).relocate(106 + (x * 56), 455 - (y * 56));
		i++;
		
	}
	
	// functie voor een obstakel op de grid plaatsen wanneer de robot eentje vind tussen 2 xy's
	public static void placeObstacleBetween(long fromX, long fromY, long toX, long toY) {	

		// actual location of image view on grid
		long layXFrom, layYFrom;
		layXFrom = 111 + (fromX * 56);
		layYFrom = 460 - (fromY * 56);
		
		if(fromX < toX) {
			//halfstep right
			
			ObBetweenArray.get(a).relocate(layXFrom + 30 , layYFrom);
			
		}else if(fromX > toX) {
			//halfstep left
			
			ObBetweenArray.get(a).relocate(layXFrom - 30, layYFrom);
			
		}
		
		if(fromY < toY) {
			//halfstep up
			
			ObBetweenArray.get(a).relocate(layXFrom, layYFrom - 30);
			
			
		}else if(fromY > toY) {
			//halfstep down
			
			ObBetweenArray.get(a).relocate(layXFrom, layYFrom + 30);
			
		}
		
		a++;
		
	}

}
