package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest4Yeon extends JFrame implements ActionListener{
	JButton btnF,btnP, btnN, btnL;
	JLabel lblNo, lblName, lblJik, lblbuser, lblbunum;
	JTextArea txtResult = new JTextArea();
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public DbTest4Yeon() {
		super("레코드 이동");
		layInit();
		accDb();
		setBounds(300,300,300,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layInit() {
		lblNo = new JLabel("");
		lblName = new JLabel("");
		lblJik = new JLabel("");
		lblbuser = new JLabel("");
		lblbunum = new JLabel("");
		JPanel panel = new JPanel();
		panel.add(new JLabel("직원자료: "));
		panel.add(lblNo);
		panel.add(lblName);
		panel.add(lblJik);
		panel.add(lblbuser);
		panel.add(lblbunum);
		add("North",panel);
		txtResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);
		btnF = new JButton("|<<");
		btnP = new JButton("<");
		btnN = new JButton(">");
		btnL = new JButton(">>|");
		JPanel panel2 = new JPanel();
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);
		add("South", panel2);
		add("Center",scrollPane);
		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);
	}
	private void display() {
		try {
			lblNo.setText(rs.getString("jikwon_no"));
			lblName.setText(rs.getString("jikwon_name"));
			lblJik.setText(rs.getString("jikwon_jik"));
			lblbuser.setText(rs.getString("buser_name"));
			lblbunum.setText(rs.getString("buser_tel"));
		}catch (Exception e) {
		// TODO: handle exception
		}
	}
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //역방향 이동도 가능
			
			rs= stmt.executeQuery("select jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel from jikwon inner join buser on buser_num=buser_no");
			//경우에 따라서는 DB 연결이 지속적이어야 한다 
			rs.next();
			display();
	
			
			
		} catch (Exception e) {
			System.out.println("accDb err: "+e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//String sql = "select gogek_no, gogek_name, case when substr(gogek_jumin,8,1)=1 then '남' else '여' end as 성별 , YEAR(NOW())-Date_format(SUBSTR(gogek_jumin, 1,6), '%Y') +1 AS 나이 from gogek";
			if(e.getSource()==btnF) rs.first(); 
			else if(e.getSource()==btnP) rs.previous();
			else if(e.getSource()==btnN) rs.next();
			else if(e.getSource()==btnL) rs.last();
			display();
			
			
				} catch (Exception e2) {
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		new DbTest4Yeon();
	}

}
