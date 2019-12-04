package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainScreen extends BorderPane {
	//webview voor lokale server
	WebView mWebView = new WebView();
	WebEngine engine = mWebView.getEngine();
	
	//Pane voor route interface
	Pane inter = new Pane();
	
	ImageView ivRobot;

	public MainScreen() {
		
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
		relocateRobot(0,0);
		inter.getChildren().add(ivGrid);
		inter.getChildren().add(ivRobot);
		
		setCenter(inter);

	}

	private void relocateRobot(int x, int y) {
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
	
}
