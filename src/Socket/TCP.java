package Socket;

import org.apache.log4j.Logger;
import Socket.*;


/**
 * 主要类，生成jar包可供直接调用
 */

public class TCP {
    public static Logger logger1 = Logger.getLogger(TCP.class);
    public static void startTCP(){
        //ConnectThread connectSocket = new ConnectThread();
        AcceptTcp acceptTcp = new AcceptTcp();
        //Socket.StartSocket startSocket = new StartSocket();
<<<<<<< HEAD

=======
       
>>>>>>> b9cb17f8ca76f01ebf10c9891a917a4cbb291c1f

        //启动服务端监听
        try {
            //启动监听
            acceptTcp.run();
<<<<<<< HEAD

=======
          
>>>>>>> b9cb17f8ca76f01ebf10c9891a917a4cbb291c1f


        }catch(Exception e){
            logger1.error("启动监听失败");
            TCP.logger1.error(e.getMessage(),e);
        }
        }
}
