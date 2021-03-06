package pack1;

import java.awt.GridLayout;
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

public class DbTest4Ex extends JFrame implements ActionListener {

	JLabel lblno, lblname, lbljik, lblbu, lbltel;
	JButton btnF, btnN, btnP, btnL;
	JTextArea txtResult = new JTextArea();
	Connection conn;
	Statement stmt;
	ResultSet rs, gg;

	public DbTest4Ex() {
		super("사원별 고객현황");

		layInit();
		accDb();

		setBounds(300, 300, 500, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() { // 레이아웃
		setLayout(new GridLayout(4, 1));

		JPanel pn1 = new JPanel();
		JPanel pn2 = new JPanel();
		JPanel pn3 = new JPanel();
		JPanel pn4 = new JPanel();

		JLabel lb1 = new JLabel("사번 :");
		JLabel lb2 = new JLabel("직원명 :");
		JLabel lb3 = new JLabel("직급 :");
		JLabel lb4 = new JLabel("부서명 :");
		JLabel lb5 = new JLabel("부서전화 :");
		lblno = new JLabel("");
		lblname = new JLabel("");
		lbljik = new JLabel("");
		lblbu = new JLabel("");
		lbltel = new JLabel("");

		pn1.add(lb1);
		pn1.add(lblno);
		pn1.add(lb2);
		pn1.add(lblname);
		pn1.add(lb3);
		pn1.add(lbljik);
		pn2.add(lb4);
		pn2.add(lblbu);
		pn2.add(lb5);
		pn2.add(lbltel);

		add("South", pn1);
		add("Center", pn2);

		btnF = new JButton("|<<");
		btnP = new JButton("<");
		btnN = new JButton(">");
		btnL = new JButton(">>|");
		pn3.add(btnF);
		pn3.add(btnP);
		pn3.add(btnN);
		pn3.add(btnL);
		add(pn3);

		btnF.addActionListener(this);
		btnN.addActionListener(this);
		btnP.addActionListener(this);
		btnL.addActionListener(this);

		txtResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);
		txtResult.setText("고객번호\t고객명\t성별\t나이\n");
		add("South", scrollPane);
	}

	private void accDb() { // 어플리케이션일 경우만, 미리 자료를 긁어와서 붙여놓고, 계속해서 이동 가능./ 웹에서는 절대!사용하면 안됨.
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			// 경우에 따라서 DB연결이 지속적이어야 한다. - 가급적이면 하지 않을 것을 권장
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // 역방향
			rs = stmt.executeQuery(
					"select jikwon_no, jikwon_name, jikwon_jik, buser_name, buser_tel from jikwon join buser on buser_num = buser_no");

			rs.next();
			display();

		} catch (Exception e) {
			System.out.println("accDb err: " + e);
		}
	}

	private void display() {

		try {
			lblno.setText(rs.getString("jikwon_no"));
			lblname.setText(rs.getString("jikwon_name"));
			lbljik.setText(rs.getString("jikwon_jik"));
			lblbu.setText(rs.getString("buser_name"));
			lbltel.setText(rs.getString("buser_tel"));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String go = "select gogek_no, gogek_name, case(substr(gogek_jumin, 8,1) when 1 then '남' when 2 then '여') end as gen, (YEAR(NOW()) - DATE_FORMAT(SUBSTR(gogek_jumin,1,6), '%Y') +1) as nai from gogek";
		try {
			gg = stmt.executeQuery(go);
			String ss = gg.getString("gogek_no") + gg.getString("gogek_name") + gg.getString("gen")
			+ gg.getString("nai");

			if (e.getSource() == btnF) {
				rs.first();
				txtResult.append(ss);
				txtResult.setText(ss);
			}

			else if (e.getSource() == btnP) {
				rs.previous();
				txtResult.append(ss);
				txtResult.setText(ss);

			} else if (e.getSource() == btnN) {
				rs.next();
				txtResult.append(ss);
				txtResult.setText(ss);

			} else if (e.getSource() == btnL) {
				rs.last();
			txtResult.append(ss);
			txtResult.setText(ss);
			}
			display();
			txtResult.setText("고객번호\t고객명\t성별\t나이\n");
			
			while(rs.next()) {
				txtResult.append(ss);
				txtResult.setText(ss);
			}
			
		//	String ss = rs.getString("gogek_no") + rs.getString("gogek_name") + rs.getString("gen")	+ rs.getString("nai");
		

		} catch (Exception e2) {
			System.out.println("exception 2");
		}

	}

	public static void main(String[] args) {
		new DbTest4Ex();

	}

}
