import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class NetTest3Client {
	Socket socket;
	PrintWriter out;
	BufferedReader reader;
	
	public NetTest3Client() {
	
		try {
			socket = new Socket("192.168.0.52", 7777);
			out = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			System.out.println("NetTest3Client err: " + e);
		}
	}
	public void sendMsg() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("전송메세지 : ");
			String data = scanner.nextLine();
			out.println(data);							// 서버로 메세지 전송
			
			String re_data = reader.readLine();
			System.out.println("수신 자료는 " + re_data);
			
			
		} catch (Exception e) {
			System.out.println("sendMSg err :" +e);
		}finally {
			try {
				reader.close();
				out.close();
				socket.close();
				
			} catch (Exception e2) {
				
			}
		}
		
	}

	
	public static void main(String[] args) {
		NetTest3Client client = new NetTest3Client();
		client.sendMsg();
	}
	
}
