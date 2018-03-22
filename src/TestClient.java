import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket测试客户端
 */

public class TestClient {
public static void main(String args[]) throws UnknownHostException, IOException{
	
		//客户端
		//1、创建客户端Socket，指定服务器地址和端口
		Socket socket =new Socket("192.168.0.57",1027);
		//2、获取输出流，向服务器端发送信息
		OutputStream os = socket.getOutputStream();//字节输出流
		PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
		pw.write("用户名：admin；密码：123");
		pw.write("用户名：dmin；密码：23");
		pw.flush();
		//socket.shutdownOutput();
		//3、获取输入流，并读取服务器端的响应信息
		InputStream is = socket.getInputStream();
		//BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//String info = null;
		Reader reader = new InputStreamReader(socket.getInputStream());  
	      char chars[] = new char[64];  
	      int len;  
	      StringBuilder sb = new StringBuilder();  
	      while ((len=reader.read(chars)) != -1) {  
		         sb.append(new String(chars, 0, len));  

		 System.out.println("我是客户端，服务器说："+sb);
		 
		}

		//4、关闭资源
		/*br.close();
		is.close();
		pw.close();
		os.close();
		socket.close();*/

}
}
