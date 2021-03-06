package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest3GUI extends JFrame implements ActionListener {
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
		
	public DbTest3GUI() {
	 // sangdata 를 frame 으로 출력
		setTitle("고객출력");
		layInit();
		accDb();
		
		setBounds(300, 300, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void layInit() {
		JPanel panel = new JPanel();
		panel.add(btnA);
		panel.add(btnM);
		panel.add(btnF);
		
		txtResult.setEditable(false); 	// read only
		JScrollPane scrollPane = new JScrollPane(txtResult);
		
		add("North", panel);
		add("Center", scrollPane);
		
		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);
		
	}
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err: "+ e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("a");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root","123");
			stmt = conn.createStatement();
			String sql = "select gogek_no, gogek_name, gogek_jumin from gogek";
						
			if(e.getSource() == btnA) {
				//System.out.println("전체");
			}else if (e.getSource() == btnM) {
				//System.out.println("남");
				sql += " where gogek_jumin like '%-1%'";
				//sql += " where substr(gogek_jumin, 8,1)=1";
			}else if (e.getSource() == btnF) {
				//System.out.println("여");
				sql += " where gogek_jumin like '%-2%'";
			}
			//System.out.println(sql);
			
			txtResult.setText("");		// txtArea 초기화
			int count = 0;
			rs = stmt.executeQuery(sql);
			
			txtResult.setText("고객번호\t고객명\t주민번호\n");
			while(rs.next()) {
				//System.out.println(rs.getString(1));
				String ss = rs.getString("gogek_no")+"\t" +
						rs.getString("gogek_name")+"\t" +
						rs.getString("gogek_jumin")+"\n";
				txtResult.append(ss);
				count += 1;
			}
			txtResult.append("인원수 : " +count +"명");
						
		} catch (Exception e2) {
			System.out.println("actionPerformed err: " + e);
			
		}finally {
			try {
				if(rs !=null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new DbTest3GUI();
	}

}
