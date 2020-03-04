package CSChat;
/**
 * �����ҿͻ���
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
	 * �׽���
	 * java.net.Socket
	 * ��װ��TCPЭ�飬ʹ�����Ϳ��Ի���TCPЭ���������ͨѶ
	 * Socket�������ڿͻ��˵�
	 */
	private Socket socket;
	
	/**
	 * ���췽����������ʼ���ͻ���
	 * ʵ����Socket��ʱ����Ҫ������������:
	 * 1:����˵�ַ:ͨ��IP��ַ�����ҵ�����˵ļ������
	 * 2:����˶˿�:ͨ���˿ڿ����ҵ�����˼�����ϵķ����Ӧ�ó���
	 * 
	 * ʵ����Socket�Ĺ��̾������ӵĹ��̣���Զ�˼����û����Ӧ���׳��쳣��
	 */
	public Client2() throws Exception{
		System.out.println("�������ӷ����...");
		socket = new Socket("localhost",8088);
		System.out.println("�������˽�����ϵ!");
	}
	
	/**
	 * �����ͻ��˵ķ���
	 */
	public void start() {
		try {
			Scanner scanner = new Scanner(System.in);
			
			
			/*
			 * ��Ҫ���û�����һ���ǳ�
			 */
			System.out.println("�������ǳƣ�");
			String nickName = scanner.nextLine();
			
			
			/*
			 * Socket�ṩ�ķ�����
			 * OutputStream getoutputStream
			 * ��ȡһ���ֽ��������ͨ������д�������ݻᱻ������Զ�˼������
			 */
			OutputStream out = socket.getOutputStream();
			
			//ת����
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			
			//������
			PrintWriter pw = new PrintWriter(osw,true);//true���Զ���ˢ��
			
			
			//�ֽ��ǳƷ��͸�������
			pw.println(nickName);
			
			
			/*
			 * ������ȡ�������˷��͹�����Ϣ���߳�
			 */
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			
			
			/*
			 * ���ַ��������������
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
			System.out.println("�ͻ�������ʧ��!");
		}
	}
	
	/**
	 * ���߳�������ȡ����˷��͹�������Ϣ
	 * ��������ͻ��˿���̨��ʾ
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















