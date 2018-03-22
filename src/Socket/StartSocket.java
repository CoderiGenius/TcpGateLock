package Socket;

import Config.Config;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 获得已连接的socket，等待传输开门命令
 */

public class StartSocket extends Thread {
    static int socketStatus = 0;
    //新建serverSocket和socket
    public static ServerSocket serverSocket = null;
    public static Socket socket = null;
    //public static OutputStream os;
    //public static PrintWriter pw;

    //接受socket线程
    public void run() {
        try {
            StartSocket.StratListening(Config.port);
        } catch (Exception e) {
            TCP.logger1.error("Starting socket processer failed，erro message as below:");
            TCP.logger1.error(e.getMessage(), e);
        }
    }

    public static void StratListening(int port) throws IOException {
        /**
         * 基于TCP协议的Socket通信，实现心跳包机制，服务端
         */
        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        serverSocket = new ServerSocket(port);
        TCP.logger1.info("Started serverSocket successfully");
                //2、调用accept()方法开始监听，等待客户端的连接

        //此处不accept，由另一个线程不断accept

                //socket = serverSocket.accept();

        //3、获取输入流，并读取客户端信息

        while (true) {

            if (socket != null) {
                //标记socket状态
                socketStatus = 0;
                try {
                    //System.out.println("connected!"+socket);
                    //TCP.logger1.info("成功连接：" + socket);

                    //输入流获取信息
                    Reader reader = new InputStreamReader(socket.getInputStream());
                    char chars[] = new char[64];
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while ((len = reader.read(chars)) != -1) {
                        sb.append(new String(chars, 0, len));

                        //System.out.println("from client: " + sb);
                        TCP.logger1.info("Message from client：" + sb);

                        //发送内容给客户端
                        SendMsg("ok");

                        //关闭流
                        //pw.close();
                    }
                } catch (IOException e) {
                    if(socketStatus!=0){
                        //标记socket错误次数
                    socketStatus++;
                    //为了避免日志过多，分别在第一次和第100次以及倍数次记录日志
                    if(socketStatus==1||socketStatus%100==0) {
                        TCP.logger1.error("Connection was shut down,waiting for acception…… socketStatus："+socketStatus);
                        TCP.logger1.error(e.getMessage(), e);
                    }

                    }
                }
            } else {

                //TCP.logger1.error("未获得连接");
                try {
                    //为了防止堵塞，sleep一秒钟
                    Thread.sleep(1000);
                    //CloseSource();
                } catch (Exception e) {
                    TCP.logger1.error("线程等待失败");
                    TCP.logger1.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 关闭资源
     *
     * @throws IOException
     */
    public static void CloseSource() {
        try {
            //socket.close();
            //serverSocket.close();
        } catch (Exception e) {
            TCP.logger1.error("关闭资源失败");
            TCP.logger1.error(e.getMessage(), e);
        }
    }

    public static void SendMsg(String Msg) {
        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println(Msg);
            pw.flush();
            //pw.close();
            TCP.logger1.info("Sending message to client,content:" + Msg);
        } catch (Exception e) {
            TCP.logger1.error("发送内容给客户端失败");
            TCP.logger1.error(e.getMessage(), e);
        }
    }
}
