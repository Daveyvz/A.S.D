package View;

import java.io.IOException;

import Controller.Server;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		launch(args);	
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		BorderPane root = new MainScreen();
		Scene scene = new Scene(root, 700,700);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Boebot interface");
		primaryStage.show();
		
				
	}

}
