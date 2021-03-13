import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetTest2Server {
	
	
	
	public static void main(String[] args) {
		// Echo server
		ServerSocket ss = null;		// TCP/IP protocol 을 지원하는 서버용 클래스
		Socket socket = null;		// 클라이언트 컴과 통신용클래스
		
		try {
			ss =new ServerSocket(9999);
			System.out.println("서버 서비스 중...");
			socket = ss.accept(); // 클라이언트 접속이 있는 경우 반응
			System.out.println("접속자 정보: " +socket.toString());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = reader.readLine();
			System.out.println("수신 자료 :  " + data);
			
			reader.close();
			socket.close();
			ss.close();
			
		} catch (Exception e) {
			System.out.println("server err : "+e);
		}
		
		
		
	}
}
