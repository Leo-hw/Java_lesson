import java.io.PrintWriter;
import java.net.Socket;

public class NetTest2Client {
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.0.74", 9999);

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			out.println("안녕하세요. "+"\n");			// 서버로 자료를 전송
			out.close();
			socket.close();
			
			
			
		} catch (Exception e) {
			System.out.println(" client err : " + e);

		}

	}
}
