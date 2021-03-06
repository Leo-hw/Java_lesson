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

public class DbTest4RecMove extends JFrame implements ActionListener {
	JButton btnF, btnP, btnN, btnL;
	JLabel lblNo, lblName;
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DbTest4RecMove() {
		super("레코드 이동");

		layInit();
		accDb();
		
		setBounds(300, 300, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() {
		lblNo = new JLabel("");
		lblName = new JLabel("");
		JPanel panel = new JPanel();
		panel.add(new JLabel("직원 자료 : "));
		panel.add(lblNo);
		panel.add(lblName);
		add("North", panel);

		btnF = new JButton("|<<");
		btnP = new JButton("<");
		btnN = new JButton(">");
		btnL = new JButton(">>|");
		JPanel panel2 = new JPanel();
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);
		
		btnF.addActionListener(this);
		btnN.addActionListener(this);
		btnP.addActionListener(this);
		btnL.addActionListener(this);
		add("Center", panel2);
	}

	private void accDb() {								// 어플리케이션일 경우만, 미리 자료를 긁어와서 붙여놓고, 계속해서 이동 가능./ 웹에서는 절대!사용하면 안됨.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			//경우에 따라서 DB연결이 지속적이어야 한다. - 가급적이면 하지 않을 것을 권장
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root","123");
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);		// 역방향 
			rs = stmt.executeQuery("select jikwon_no, jikwon_name from jikwon");
			
			rs.next();
			display();
			
			
		} catch (Exception e) {
			System.out.println("accDb err: " + e);
		}
	}
	private void display() {
		try {
			lblNo.setText(rs.getString("jikwon_no"));
			lblName.setText(rs.getString("jikwon_name"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnF) rs.first();
			else if(e.getSource()== btnP) rs.previous();
			else if(e.getSource()== btnN) rs.next();
			else if(e.getSource()== btnL) rs.last();
			
			display();
			
			
			
			
			
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new DbTest4RecMove();
	}
}
