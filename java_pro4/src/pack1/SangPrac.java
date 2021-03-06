package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SangPrac extends JFrame implements ActionListener {
	Connection conn;
	PreparedStatement pstmt;//선처리 방식: 동일한 sql 문을 공유. ? 연산자를 사용해 보안 강화 
	ResultSet rs;
	JButton badd;
	JTextArea txtResult = new JTextArea();
	JLabel lblcode, lblpum, lblnum, lblcost;
	JTextField txt1, txt2, txt3, txt4;
	public SangPrac() {
		super("상품 처리");
		layInit();
		accDb();
		
		setBounds(300,300,300,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO Auto-generated constructor stub
	}
	private void accDb() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDberr : " + e);
		}
		
	}
	private void layInit() {
		lblcode = new JLabel("코드: ");
		txt1 = new JTextField("",4);
		lblpum = new JLabel("품명: ");
		txt2 = new JTextField("",4);
		lblnum = new JLabel("수량: ");
		txt3 = new JTextField("",4);
		lblcost = new JLabel("단가: ");
		txt4 = new JTextField("",4);
		badd = new JButton("추가");
		JPanel panel = new JPanel();
		
		panel.add(lblcode);
		panel.add(txt1);
		panel.add(lblpum);
		panel.add(txt2);
		panel.add(lblnum);
		panel.add(txt3);
		panel.add(lblcost);
		panel.add(txt4);
		panel.add(badd);
		add("North",panel);
		txtResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);
		add("Center",scrollPane);
		badd.addActionListener(this);
		
	}
	private void display() {
		try {
			txt1.setText(rs.getString("code"));
			txt2.setText(rs.getString("sang"));
			txt3.setText(rs.getString("su"));
			txt4.setText(rs.getString("dan"));
			
		}catch (Exception e) {
		// TODO: handle exception
		}
	}
	private void accDb2() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			String isql = "select * from sangdata";
			pstmt = conn.prepareStatement(isql);
			txtResult.setText("");
			txtResult.setText("코드\t상품명\t수량\t단가\t금액\n");
			rs = pstmt.executeQuery(isql);
			
			int count =0;
			while (rs.next()) {
				String ss = rs.getString("code") + "\t" + rs.getString("sang") + "\t"
						+ rs.getString("su") + "\t" + rs.getString("dan") + "\t"
						+ rs.getInt("su") + "\n";
				txtResult.append(ss);
				count += 1;
				
			}
		} catch (Exception e) {
			
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			String isql = "insert into sangdata values(?,?,?,?)";
			pstmt =conn.prepareStatement(isql);
			
			if(e.getSource()==badd) {
				pstmt = conn.prepareStatement(isql);
				pstmt.setString(1,txt1.getText());
				pstmt.setString(2,txt2.getText());
				pstmt.setString(3,txt3.getText());
				pstmt.setString(4,txt4.getText());
				
				int re = pstmt.executeUpdate();
				if(re ==1)
					System.out.println("추가 성공");
				
				//rs = pstmt.executeQuery(isql);
			}
			
		}
		catch (Exception e2)
		{
			
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				
			}
		}
		accDb2();
		display();
	}

	public static void main(String[] args) {
		new SangPrac();
		
	}

	

}