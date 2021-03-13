import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;



public class NetTest1 {
	
	
	
	public static void main(String[] args) {
			// Network
			InetAddress ia;
			InetAddress ia2[];
			
			try {
				ia = InetAddress.getByName("www.naver.com");
				System.out.println(ia);
				System.out.println(ia.getHostAddress());
				System.out.println(ia.getHostName());
				
				System.out.println();
				ia2 = InetAddress.getAllByName("www.daum.net");
				for (InetAddress a:ia2) {
					System.out.println(ia.getHostAddress());
				}
				System.out.println("--------------");
				InetAddress ia3 = InetAddress.getByName("www.google.com");
				Socket socket = new Socket(ia, 80);
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
				out.println("Get www.google.com");
				out.flush();
				
				// 웹 서버에서 넘어온 자료 출력
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true) {
					String str = reader.readLine();
					if(str == null) break;
					System.out.println(str);
					
					
				}
				reader.close();
				out.close();
				socket.close();
				
			} catch (Exception e) {
				System.out.println("err :"+e);
			}
	}
}
