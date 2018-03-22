package Socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SetSocket extends Thread{
    public  static Socket socket;
    public static InputStream inputStream;
    public  static OutputStream outputStream;
    SetSocket(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }catch (Exception e){
            TCP.logger1.error("Get socket i/ostream erro,erro message:");
            TCP.logger1.error(e.getMessage(),e);
        }
    }

}
