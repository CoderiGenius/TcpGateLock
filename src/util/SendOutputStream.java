package util;

import Socket.TCP;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 通过传入Socket的outputstream来想客户端发送内容
 */

public class SendOutputStream {
    public static boolean OutputStream(OutputStream outputStream,String msg){
        try {
            OutputStream os = outputStream;
            PrintWriter pw = new PrintWriter(os);
            pw.println(msg);
            TCP.logger1.info("Send to client successfully,content:"+msg);
            pw.flush();
            return true;
        }catch(Exception e){
            TCP.logger1.error("sendOutputStream failed,erro msg:");
            TCP.logger1.error(e.getMessage(),e);
        }
        return false;
    }
}
