package Controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import View.TopPane;

public class Server{

	static ServerSocket ss;
	static Socket s;
	
	
	public Server(int port){
		
		try {
			ss = new ServerSocket(port);
			TopPane.log.appendText("Server started\n");
			//System.out.println("Server started");
			TopPane.log.appendText("Waiting for robot\n");
			//System.out.println("Waiting for robot");
			s = ss.accept();
			TopPane.log.appendText("Robot Connected\n");
			//System.out.println("Robot Connected");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendEnd (int x, int y) throws IOException {

		int[] endpoints = new int[2];
		endpoints[0] = x;
		endpoints[1] = y;
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		out.writeObject(endpoints);
		ss.close();
		
	}

	
}
