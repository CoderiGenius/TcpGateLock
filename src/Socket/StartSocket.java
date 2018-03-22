package Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class StartSocket {
	public static String socketStatus = null;
	//新建serverSocket和socket
	public static ServerSocket serverSocket = null;
	public static Socket socket = null;

	public static void StratListening() throws IOException{
		/**
		 * 基于TCP协议的Socket通信，实现心跳包机制，服务端
		 */
	//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
		serverSocket = new ServerSocket(1026);
	//2、调用accept()方法开始监听，等待客户端的连接
		socket = serverSocket.accept();
	//System.out.println("Starting server success");
	//3、获取输入流，并读取客户端信息
	if (socket!=null){
		try{
		System.out.println("connected!"+socket);
		/*InputStream is = socket.getInputStream();
		InputStreamReader isr =new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String info =null;
		byte[] buffer = new byte[6];
		
		int index = is.read(buffer, 0, 6);
		System.out.println(index);
		if((info=br.readLine())!=null){
			System.out.println("我是服务器，客户端说："+info);
		}
		
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.println("connect to server successfully!");
		pw.flush();
		pw.flush();
		pw.flush();
		*/
		 Reader reader = new InputStreamReader(socket.getInputStream());  
	      char chars[] = new char[64];  
	      int len;  
	      StringBuilder sb = new StringBuilder();  
	      while ((len=reader.read(chars)) != -1) {  
	         sb.append(new String(chars, 0, len));  
	         socketStatus = "on";
	         System.out.println("from client: " + sb); 
	         
	         OutputStream os = socket.getOutputStream();
	     	PrintWriter pw = new PrintWriter(os);
	     	pw.print("open door");
	     	pw.flush();
	     	//pw.close();
	      }  
		}catch(IOException e){
			System.out.println("心跳包连接断开，等待重新连接……");
			CloseSource();
		}
	}
	else{
		System.out.println("心跳包连接断开，等待重新连接……");
		CloseSource();
	}
	}
/**
 * 关闭资源
 * @throws IOException
 */
		public static void CloseSource() throws IOException{
			socket.close();
			serverSocket.close();
	}
}
