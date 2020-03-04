package CSChat;
/**
 * 聊天室客户端
 * @author 13662
 *
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	/*
	 * 套接字
	 * java.net.Socket
	 * 封装了TCP协议，使用它就可以基于TCP协议进行网络通讯
	 * Socket是运行在客户端的
	 */
	private Socket socket;
	
	/**
	 * 构造方法，用来初始化客户端
	 * 实例化Socket的时候需要传入两个参数:
	 * 1:服务端地址:通过IP地址可以找到服务端的计算机。
	 * 2:服务端端口:通过端口可以找到服务端计算机上的服务端应用程序。
	 * 
	 * 实例化Socket的过程就是连接的过程，若远端计算机没有响应会抛出异常。
	 */
	public Client2() throws Exception{
		System.out.println("正在连接服务端...");
		socket = new Socket("localhost",8088);
		System.out.println("已与服务端建立联系!");
	}
	
	/**
	 * 启动客户端的方法
	 */
	public void start() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			
			/*
			 * 先要求用户输入一个昵称
			 */
			System.out.println("请输入昵称：");
			String nickName = scanner.nextLine();
			
			
			/*
			 * Socket提供的方法：
			 * OutputStream getoutputStream
			 * 获取一个字节输出流，通过该流写出的数据会被发出至远端计算机。
			 */
			OutputStream out = socket.getOutputStream();
			
			//转换流
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			
			//缓冲流
			PrintWriter pw = new PrintWriter(osw,true);//true：自动行刷新
			
			
			//现将昵称发送给服务器
			pw.println(nickName);
			
			
			/*
			 * 启动读取服务器端发送过来消息的线程
			 */
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			
			
			/*
			 * 将字符串发送至服务端
			 */
			while(true) {
				//String str = scanner.nextLine();
				pw.println(scanner.nextLine());
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Client2 client2 = new Client2();
			client2.start();
		} catch (Exception e) {
			System.out.println("客户端启动失败!");
		}
	}
	
	/**
	 * 该线程用来读取服务端发送过来的消息
	 * 并输出到客户端控制台显示
	 * @author 13662
	 *
	 */
	class ServerHandler implements Runnable
	{
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String message = null;
				while( (message = br.readLine()) != null ) {
					System.out.println(message);
				}
				
			} catch (Exception e) {

			}
		}
	}

}















