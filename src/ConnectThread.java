import java.io.IOException;

/**
 * 心跳包检测，已废弃
 */

public class ConnectThread extends Thread{
    int count = 1;
    boolean socketStatus = true;
    boolean socketServerStatus = true;
	public void run(){

		while(true){
			try {
				//心跳包每40秒运行一次
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			System.out.println("心跳包检测第"+count+"次");

			//如果socket出问题，则初始化重新监听
            try{

                        socketStatus = StartSocket.socket.isClosed();
                        socketServerStatus = StartSocket.serverSocket.isClosed();

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(socketServerStatus+""+socketStatus);
			if(socketStatus||socketServerStatus||StartSocket.socket!=null){
                StartSocket.StratListening(1027);
				count++;
			}
			else{

				count++;
				continue;

			}


		}
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	}

}
