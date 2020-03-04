package CSChat;
/**
 * �����ҷ����
 * @author 13662
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	/*
	 * �����ڷ���˵�ServerSocket��Ҫ����:
	 * 1����ϵͳ�������˿�
	 *    �ͻ��˾���ͨ������˿���֮���ӵġ�
	 * 2����������ķ���˿ڣ���һ���ͻ���ͨ���ö˿ڳ��Խ�������ʱ��
	 *    ServerSocket���ڷ���˴���һ��Socket��ͷ��˽������ӡ�
	 */
	private ServerSocket server;
	
	/*
	 * �������пͻ���������ļ���
	 */
	private List<PrintWriter> allOut;
	
	/**
	 * ������ʼ�������
	 */
	public Server() throws Exception {
		/*
		 * ��ʼ����ͬʱ�������˿�
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter>(); 
	}
	/**
	 * ����������������빲����
	 * @param out
	 */
	private synchronized void addOut(PrintWriter out) {
		allOut.add(out);
	}
	/**
	 * ��������������ӹ�������ɾ��
	 * @param out
	 */
	private synchronized void removeOut(PrintWriter out) {
		allOut.remove(out);
	}
	/**
	 * ����������Ϣ���͸����пͻ���
	 */
	private synchronized void sendMessage(String message) {
		for(PrintWriter out:allOut) {
			out.println(message);
		}
	}
	
	
	/**
	 * ����˿�ʼ�����ķ���
	 */
	public void start() {
		try {
			/*
			 * ServerSocket��accept����
			 * ��һ������������
			 * �����Ǽ�������˿ڣ�ֱ��һ���ͻ������Ӳ�����һ��Socket��
			 * ʹ�ø�Socket����������ӵĿͻ��˽��н���
			 */
			while(true) {
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				System.out.println("һ���ͻ���������!");
				
				/*
				 * ����һ���̣߳��������ÿͻ��˵Ľ���
				 */
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	 
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���������ʧ��");
		}
	}
	
	/**
	 * ���̸߳�����һ���ͻ��˵Ľ���
	 * @author 13662
	 *
	 */
	class ClientHandler implements Runnable
	{
		/*
		 * ���̴߳���Ŀͻ��˵�Socket
		 */
		private Socket socket;
		
		//�ͻ��˵ĵ�ַ��Ϣ
		private String host;
		
		//���û��ǳ�
		private String nickName;
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
			
			/*
			 * ͨ��Socket���Ի�ȡԶ�˼�����ĵ�ַ��Ϣ.
			 */
			InetAddress address = socket.getInetAddress();
			//��ȡIP��ַ
			host = address.getHostAddress();
		}
		
		public void run() {
			PrintWriter pw = null;
			try {
				
				
				/*
				 * Socket�ṩ�ķ���
				 * InputStream getInputStream()
				 * �÷������Ի�ȡһ�����������Ӹ�����ȡ�����ݾ��Ǵ�Զ�˼�������͹�����
				 */
				InputStream in = socket.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(in,"UTF-8");
				
				BufferedReader br = new BufferedReader(isr);
				
				
				//���ȶ�ȡһ���ַ���Ϊ�ǳ�
				nickName = br.readLine();
				sendMessage(nickName+"������!");
				
				
				/*
				 * ͨ��Socket������������ڽ���Ϣ���͸��ͻ���
				 */
				OutputStream out = socket.getOutputStream();
				
				OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
				
				pw = new PrintWriter(out, true);
				
				/*
				 * ���ÿͻ��˵���������뵽��������
				 */
				addOut(pw);
				
				String message = null;
				/*
				 * br.readLine�ڶ�ȡ�ͻ��˷��͹�������Ϣʱ��
				 * ���ڿͻ��˶��ߣ��������ϵͳ�Ĳ�ͬ�������ȡ��Ľ����ͬ��
				 * ��windows�Ŀͻ��˶Ͽ�ʱ��br.readLine���׳��쳣
				 * ��Linux�Ŀͻ��˶Ͽ�ʱ��br.readLine�᷵��null
				 */
				while( (message = br.readLine()) != null ) {
					System.out.println(nickName+"˵:"+message);
//					pw.println(nickName+"˵:"+message);
					//�㲥��Ϣ
					sendMessage(nickName+"˵"+message);
				}
			} catch (Exception e) {
				
			}finally {
				/*
				 * ����ǰ�ͻ��˶Ͽ�����߼�
				 */
				//���ÿͻ��˵�������ӹ�������ɾ��
				removeOut(pw);
				
				
				sendMessage(nickName+"������!");
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}












