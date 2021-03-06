package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DbTest7table extends JFrame {
	String [][] datas = new String [0][5];
	String [] title = {"코드","상품명","수량","단가", "금액"};
	DefaultTableModel model;
	JTable table;			// mvc : model 을 view 를 통해서 보여주는 컴포넌트.
	JLabel lblCount;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public DbTest7table() {
		setTitle("테이블 연습");
		
		layInit();
		accDb();
		
		setBounds(300, 300, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void layInit() {
		model = new DefaultTableModel(datas, title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		
		lblCount = new JLabel("건수 : 0");
		
		add("Center", scrollPane);
		add("South", lblCount);
		
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			
			pstmt = conn.prepareStatement("select*from sangdata");
			rs = pstmt.executeQuery();
			int cou = 0;
			while(rs.next()) {
				String code = rs.getString("code");
				String sang = rs.getString("sang");
				String su = rs.getString("su");
				String dan = rs.getString("dan");
				int kum = rs.getInt("su")*rs.getInt("dan");
				String [] imsi = {code, sang, su, dan, Integer.toString(kum)};
				model.addRow(imsi);
				cou++;
				
			}
			
			lblCount.setText("건수 : " + cou);
			
		} catch (Exception e) {
			System.out.println("accDb err : "+e);			// 프로그래머를 위한 에러 메세지
		}finally {
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
		new DbTest7table();
		
	}
}
