package Socket;

/**
 * 持续监听accept线程
 */
public class AcceptTcp extends Thread
{
    public void run(){
        try{

        while (true) {
            TCP.logger1.info("Start listening socket acception");
            StartSocket.socket = StartSocket.serverSocket.accept();
           // StartSocket.SendMsg("123");
            TCP.logger1.info("Got socket connection,INFO："+ StartSocket.socket);
            }
        }catch(Exception e){
            TCP.logger1.error("Start listening socket acception failed，erro message as below：");
            TCP.logger1.error(e.getMessage(),e);
        }
    }
}
