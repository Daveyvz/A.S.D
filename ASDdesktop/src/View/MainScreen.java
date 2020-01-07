package View;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import Controller.Server;
import Model.FireDB;

/**
 * 
 * @author nathaniel veldkamp
 *
 */
public class MainScreen extends BorderPane {
	
	//Pane voor route interface
	public static Pane center = new CenterPane();
	public static Pane top = new TopPane();
	
	// db instance
	FireDB db = new FireDB();
	
	public MainScreen() {
			
		//db functions
		db.CurrentPos();
		db.ObStacleOnPos();
		db.ObstacleBetweenPos();
				
		//pane voor top en center size
		top.setPrefSize(700, 200);
		center.setPrefSize(700, 500);
		
		setTop(top);
		setCenter(center);
		
				
	}

	
}
