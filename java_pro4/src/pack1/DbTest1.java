package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs, rs1;

	public DbTest1() {
		// 1. Driver load
		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("Driver load 실패" + e);
		}

		// 2. DB와 연결
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");

		} catch (Exception e) {
			System.out.println("DB와 연결실패" + e);
		}

		// 3. 자료 읽기
		try {
			stmt = conn.createStatement();

			/*
			 * rs = stmt.executeQuery("select*from sangdata"); rs.next(); // 레코드 포인터 이동 :
			 * 자료가 있으면 True ㅇ벗으면 false String code = rs.getString("code"); String sang =
			 * rs.getString("sang"); int su = rs.getInt("su"); int dan = rs.getInt("dan");
			 * System.out.println(code+ " " + sang+ " "+ su+ " "+ dan);
			 */

			rs = stmt.executeQuery("select code as 코드,sang,su,dan from sangdata");
			int count = 0;
			while (rs.next()) {
				String code = rs.getString("코드");
				String sang = rs.getString("sang");
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sang + " " + su + " " + dan);
				count += 1; // 클라이언트에서 계산.

			}
			System.out.println("건수: " + count);
			String sql = "select count(*) from sangdata"; // db 서버에서 계산.

			rs1 = stmt.executeQuery(sql);
			if (rs1.next())
				System.out.println("건수 : " + rs1.getInt(1));

		} catch (Exception e) {
			System.out.println("SQL 오류" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs1 != null)
					rs1.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		// MariaDB 연동 프로그래밍
		new DbTest1();

	}
}
