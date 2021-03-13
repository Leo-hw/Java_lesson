import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetTest3Server {
	ServerSocket ss;
	Socket socket;
	PrintWriter out;
	BufferedReader reader;

	public NetTest3Server() {
		try {
			ss = new ServerSocket(7777);
			
		} catch (Exception e) {
			System.out.println("NetTest3Server err ; " + e);
			return;

		}
		System.out.println("서버 서비스 출발...");

		try {
			socket = ss.accept();
			out = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (Exception e) {
			System.out.println("에러 : " + e);
		}
	}
	public void serviceMsg() {
		try {
			 String msg = reader.readLine();
			 System.out.println("receive msg" + msg);
			 out.println("from server: "+ msg+ " 첨언 : 수고해랑 ");
			 
			 reader.close();
			 out.close();
			 socket.close();
			 ss.close();
			
		} catch (Exception e) {
			System.out.println("serviceMsg err :" +e);
		}
	}

	public static void main(String[] args) {
		while (true) {
			NetTest3Server server = new NetTest3Server();
			server.serviceMsg();

		}
	}
}
