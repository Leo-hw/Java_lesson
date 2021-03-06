package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest5excute {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbTest5excute() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			process();
		} catch (Exception e) {
			System.out.println("load err:"+e);
		}
	
	}
	
	private void process() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			stmt = conn.createStatement();
			boolean b = false;
			// select 이외인 경우 false 를 return
			b = stmt.execute("update sangdata set sang = '카네이션' where code=5"); 
			System.out.println("update 후 :" +b);
			int re = stmt.getUpdateCount();
			
			if(re>=1) {
				System.out.println("수정성공");
				
			}else {
				System.out.println("수정실패");
			}
			
			System.out.println("----------");
			b = stmt.execute("select * from sangdata");				// select 인 경우 true 를 return
			System.out.println("select 후 : " + b);					// executequery 를 추천
			
			if(b) {
				rs = stmt.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("process err:" +e);
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest5excute();
	}
}
