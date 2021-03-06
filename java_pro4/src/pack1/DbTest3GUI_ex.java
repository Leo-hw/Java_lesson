package pack1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest3GUI_ex extends JFrame implements ActionListener {
	JTextField Jik;
	JButton btnOK = new JButton("OK");
	JButton btn1 = new JButton("초기화");
	JTextArea txtResult = new JTextArea();

	Connection conn;
	Statement stmt;
	ResultSet rs, rs1;

	public DbTest3GUI_ex() {
		super("직원정보");
		layInit();
		accDb();

		setBounds(300, 300, 300, 300);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {
		JLabel lbl1 = new JLabel("직급 : ");
		Jik = new JTextField("", 5);
		JPanel pn1 = new JPanel();
		btnOK.setBackground(Color.MAGENTA);
		btn1.setBackground(Color.MAGENTA);
		pn1.add(lbl1);
		pn1.add(Jik);
		pn1.add(btnOK);
		pn1.add(btn1);
		pn1.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnOK.addActionListener(this); // OK버튼
		btn1.addActionListener(this); // 초기화버튼

		txtResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);
		add("North", pn1);
		add("Center", scrollPane);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDberr : " + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			stmt = conn.createStatement();
			String sql = "select jikwon_no, jikwon_name, jikwon_jik, jikwon_gen, jikwon_pay from jikwon";
			String sql1 = "select round(avg(jikwon_pay),0) from jikwon";
			if (e.getSource() == btnOK) {
				if (Jik.getText().equals("")) {// 여기서부터
					JOptionPane.showMessageDialog(this, "직급 입력");// 메세지창을 호출
					Jik.requestFocus();
					return;// 메소드 탈출
				} else { // 직원의 직급이 없을때 올바른 직원을 출력하는 법
					sql += " where jikwon_jik = '" + Jik.getText() + "'";
					sql1 += " where jikwon_jik = '" + Jik.getText() + "'";
					int count = 0;
					rs = stmt.executeQuery(sql);
					if (rs.absolute(0) == true) {// 행의 값이 있을때 실행
						txtResult.setText("");
						txtResult.setText("사번\t직원명\t직급\t성별\t연봉\n");
						while (rs.next()) {
							String ss = rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t"
									+ rs.getString("jikwon_jik") + "\t" + rs.getString("jikwon_gen") + "\t"
									+ rs.getString("jikwon_pay") + "\n";
							txtResult.append(ss);
							count += 1;
						}
						txtResult.append("인원수 : " + count + "명");

					} else {// 그 외일 때 실행
						JOptionPane.showMessageDialog(this, "올바른 직급을 입력해주세요.");
						Jik.setText("");
						txtResult.setText("");
						return;
					}
				}
			} else if (e.getSource() == btn1) {
				Jik.setText("");
				txtResult.setText("");
				return;
			}
			rs1 = stmt.executeQuery(sql1);
			if (rs1.next()) {
				String avg = rs1.getString(1);
				txtResult.append("\t" + "평균 연봉 " + avg + "만원");
			}
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e);
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
			} catch (Exception e3) {

			}
		}
	}

	public static void main(String[] args) {
		new DbTest3GUI_ex();
	}

}
