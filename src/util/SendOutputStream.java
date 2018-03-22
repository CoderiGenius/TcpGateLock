package util;

import Socket.TCP;

import java.io.OutputStream;
import java.io.PrintWriter;

public class SendOutputStream {
    public static void OutputStream(OutputStream outputStream,String msg){
        try {
            OutputStream os = outputStream;
            PrintWriter pw = new PrintWriter(os);
            pw.println(msg);
            TCP.logger1.info("Send to client successfully,content:"+msg);
            pw.flush();
        }catch(Exception e){
            TCP.logger1.error("sendOutputStream failed");
            TCP.logger1.error(e.getMessage(),e);
        }
    }
}
