
import org.apache.log4j.Logger;

/**
 * 主要类，生成jar包可供直接调用
 */

public class TCP {
    public static org.apache.log4j.Logger logger1 = Logger.getLogger(TCP.class);
    public static void startTCP(){
        //ConnectThread connectSocket = new ConnectThread();
        AcceptTcp acceptTcp = new AcceptTcp();
        StartSocket startSocket = new StartSocket();
        System.out.println("Starting server...running in background");

        //启动服务端监听
        try {
            //启动监听
            acceptTcp.start();
            //启动TCP处理主线程
            startSocket.run();


        }catch(Exception e){
            logger1.error("启动监听失败");
            TCP.logger1.error(e.getMessage(),e);
        }
        }
}
