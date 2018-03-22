package Socket;

import Config.Config;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 持续监听accept线程
 */
public class AcceptTcp extends Thread
{
    public static Socket socket = null;
    ServerSocket serverSocket;
    AcceptTcp(){

        try {
            serverSocket = new ServerSocket(Config.port);
        }catch (Exception e){
            TCP.logger1.error("Start serverSocket failed，erro message as below：");
            TCP.logger1.error(e.getMessage(),e);
        }
}
    public void run(){
        try{

        while (true) {
            TCP.logger1.info("Start listening socket acception");
            //开始accept
            socket = serverSocket.accept();
            TCP.logger1.info("Got socket connection,INFO："+ socket);
            //新开线程保存socket并获取iostream
            SetSocket setSocket = new SetSocket(socket);
            setSocket.start();
           // StartSocket.SendMsg("123");

            }
        }catch(Exception e){
            TCP.logger1.error("Start listening socket acception failed，erro message as below：");
            TCP.logger1.error(e.getMessage(),e);
        }
    }
}
