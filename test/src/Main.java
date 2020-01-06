import javafx.application.Application;

import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        Pathfinder pathfinder = new Pathfinder();
        Node start = new Node(0,0);
        Node end = new Node(5,5);
        ArrayList<Node> path =  pathfinder.AStarPathfinder(start,end);
        for (Node node: path)
        {
            System.out.println(node.positionX + ", " + node.positionY);
        }
    }
}
