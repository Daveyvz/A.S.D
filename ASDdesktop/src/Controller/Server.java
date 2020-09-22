package Controller;

//imports
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import View.TopPane;

public class Server{

	//static variables voor het schrijven van de server functionaliteit
	static ServerSocket ss;
	static Socket s;
	
	//Server Object wordt gecreeerd met de port nummer als parameter
	public Server(int port){
		
		try {
			ss = new ServerSocket(port); // Server socket wordt gemaakt met de aangegeven port nummer
			TopPane.log.appendText("Server started\n"); // de staat wordt op de scherm aangegeven
			//System.out.println("Server started");
			TopPane.log.appendText("Waiting for robot\n"); // de staat wordt op de scherm aangegeven
			//System.out.println("Waiting for robot");
			s = ss.accept(); //er wordt een connectie gemaakt tussen de computer en de robot
			TopPane.log.appendText("Robot Connected\n"); // de staat wordt op de scherm aangegeven
			//System.out.println("Robot Connected");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//functie voor het sturen van eind coordinaten naar de robot
	public void sendEnd (int x, int y) throws IOException {

		int[] endpoints = new int[2];
		endpoints[0] = x;
		endpoints[1] = y;
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		out.writeObject(endpoints);
		ss.close();
		
	}

	
}
