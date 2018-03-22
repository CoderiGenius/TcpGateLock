package ConnectionUtil;
import java.io.IOException;

import Socket.StartSocket;

public class DetectThread extends Thread{
	public static String statusOfSocket = null;
	public void run(){
		int count = 0;
		while(true){
			count++;
			System.out.println("检测线程开始运行第"+count+"次");
		try {
			StartSocket.socketStatus = "off";
			
			try {
				//休眠41秒，等待连接
				Thread.sleep(11000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(StartSocket.socketStatus.equals("on")){
				statusOfSocket = "OK";
				System.out.println("socket现在的状态是："+statusOfSocket);
				continue;
			}else{
				statusOfSocket = "offline";
				System.out.println("socket现在的状态是："+statusOfSocket);
				continue;
			}
			//StartSocket.StratListening();
			
			//SocketClient.StartClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	}

}
