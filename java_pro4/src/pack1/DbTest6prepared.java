package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbTest6prepared {

	Connection conn;
	PreparedStatement pstmt; // 선처리 방식 : 동일한 SQL 문을 공유. ?연산자를 사용해 보안 강화
	ResultSet rs;

	public DbTest6prepared() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");
			
			// 자료 추가
			/*
			String isql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(isql);
			pstmt.setString(1, "7");
			pstmt.setString(2, "빅맥");
			pstmt.setString(3, "5");
			pstmt.setString(4, "7500");
			
			int re = pstmt.executeUpdate();
			if(re == 1)
				System.out.println("추가 성공");
			*/
			
			// 자료 수정
			/*
			String usql = "update sangdata set sang=?, su?, dan=? where code =?";
			pstmt = conn.prepareStatement(usql);
			pstmt.setString(1, "치킨버거");
			pstmt.setInt(2, 15);
			pstmt.setInt(3, 6000);
			pstmt.setString(4, "7");
			
			int re = pstmt.executeUpdate();
			if(re >= 1)
				System.out.println("수정 성공");
			*/
			
			//자료 삭제
			String dsql = "delete from sangdata where code =?";
			pstmt = conn.prepareStatement(dsql);
			pstmt.setString(1, "7");
			int re = pstmt.executeUpdate();
			if(re == 1)
				System.out.println("삭제 성공");
			
			
			// 전체 자료 읽기
			String sql = "select*from sangdata"; // 칼럼명을 써주는 게 좋음
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(
						rs.getString("code")+" "+
						rs.getString("sang")+" "+
						rs.getString("su")+" "+
						rs.getString("dan")
						
				);
			}
			
			System.out.println();
			
			// 부분 자료 읽기
			String co = "1";
			//sql = "select *from sangdata where code =" +co;
			sql = "select *from sangdata where code =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, co);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(
						rs.getString(1)+" "+
						rs.getString(2)+" "+
						rs.getString(3)+" "+
						rs.getString(4)
						
				);
			}else {
				System.out.println("그런 자료는 없다 ㅠㅠㅠㅠ");
			}
			
			
		} catch (Exception e) {
			System.out.println(" err : " + e);

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new DbTest6prepared();

	}

}
