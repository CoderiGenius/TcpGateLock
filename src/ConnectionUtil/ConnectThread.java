package ConnectionUtil;
import java.io.IOException;

import Socket.StartSocket;

public class ConnectThread extends Thread{
	public static String statusOfSocket = null;
	public void run(){
		try {
			System.out.println("Starting server...running in background");
			StartSocket.StratListening();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
