package pack1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbTest2 { // CRUD
	private Connection conn;
	private Statement stmt;
	private ResultSet rs, rs1;
	Properties properties = new Properties();

	public DbTest2() {
		try {
			properties.load(new FileInputStream("C:\\work\\jsou\\java_pro4\\src\\pack1\\test.properties")); // 중요 정보는 밖에
																											// 빼놓고 암호화
																											// 프로그램을 통해
																											// 암호화.

			Class.forName(properties.getProperty("driver"));
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password"));
			stmt = conn.createStatement();

			String sql = "";
			// insert : autocommit

			/*
			 * sql = "insert into sangdata values(5, '새우깡', 2, 1500)"; // 추가적으로 시도할 경우
			 * primary key 중복으로 에러. int re = stmt.executeUpdate(sql); // select 이외의 SQL 문은
			 * executeUpdate if(re ==1) System.out.println("추가성공");
			 */

			// transaction : 하나의 작업 단위. insert, update, delete... 후 commit or rollback;
			/*
			 * conn.setAutoCommit(false); //transaction 수동
			 * 
			 * sql = "insert into sangdata values(7, '파래깡', 2, 2000)"; // 추가적으로 시도할 경우
			 * primary key 중복으로 에러. stmt.executeUpdate(sql); //conn.rollback();
			 * conn.commit(); conn.setAutoCommit(true); //transaction 수동 종료
			 */
			// -----------------------------------------------------------------------------

			// update
			/*
			 * sql = "update sangdata set sang='허니칩', dan = 2100 where code = 6"; int re =
			 * stmt.executeUpdate(sql); if(re >= 1) System.out.println("수정 성공!");
			 */

			// delete

			sql = "delete from sangdata where code = 7";
			int re = stmt.executeUpdate(sql);
			if (re >= 1)
				System.out.println("삭제 성공!");
			else
				System.out.println("삭제 실패");

			// select
			rs = stmt.executeQuery("select*from sangdata order by code desc");
			int cou = 0;
			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " "
						+ rs.getString("dan"));
				cou += 1;

			}
			System.out.println("건수: " + cou);
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {

			}
		}
	}

	public static void main(String[] args) {
		// 중요 정보 별도 파일로 작성 후 읽기.
		new DbTest2();
	}
}
