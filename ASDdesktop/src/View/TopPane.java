package View;

import java.io.IOException;

import Controller.Server;
import Model.FireDB;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class TopPane extends Pane {

	public static TextArea log;
	
	public TopPane() {
		
		TextField endX, endY;
		Button btn;
		endX = new TextField();
		endY = new TextField();
		
		endX.setPromptText("Destination X");
		endX.relocate(20, 50);
		
		endY.setPromptText("Destination Y");
		endY.relocate(230, 50);
		
		log = new TextArea();
		log.setPrefSize(250, 140);
		log.relocate(430, 30);
		
		btn = new Button("Submit");
		btn.relocate(20, 100);
		btn.setOnAction(e -> {			
			
			try {
				FireDB.deskApp.sendEnd(Integer.parseInt(endX.getText()), Integer.parseInt(endY.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		
		getChildren().addAll(endX, endY,log,btn);
		
		
	}
	
}
