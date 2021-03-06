package pack1;

import java.awt.Color;
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

public class Jeongbo extends JFrame implements ActionListener {
	JButton btnOk = new JButton("OK");
	JButton btnReset = new JButton("초기화");
	JTextArea txtResult = new JTextArea();
	JLabel lbl = new JLabel();
	JTextField txtFi = new JTextField();

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public Jeongbo() {
		setTitle("직원정보");
		layInit();
		accDb();
		setBounds(300, 300, 450, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void layInit() {								// 레이아웃
		JPanel pn1 = new JPanel();
		txtFi = new JTextField("", 5);
		lbl = new JLabel("직급  : ");
		btnOk.setBackground(new Color(200,0,200));
		btnReset.setBackground(new Color(200,0,200));
		pn1.add(lbl);
		pn1.add(txtFi);
		pn1.add(btnOk);
		pn1.add(btnReset);

		txtResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);

		add("North", pn1);
		add("Center", scrollPane);

		btnOk.addActionListener(this);
		btnReset.addActionListener(this);
	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err:" + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {		// 버튼 클릭시 동작
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");
			stmt = conn.createStatement();
			String sql = "select jikwon_no, jikwon_name, jikwon_jik, jikwon_gen, jikwon_pay from jikwon";
			String jj = "";
			int avgpay = 0;
			try {
				if (e.getSource() == btnOk) {
					jj = txtFi.getText();
					if(e.getSource() == ""){
					JOptionPane.showMessageDialog(this, "직급입력");
					txtFi.requestFocus();
					return;
				}else {
					sql += " where jikwon_jik = '" + txtFi.getText()+"'";
						
					}
				
					int count = 0;
					rs = stmt.executeQuery(sql);
					
					if(rs.absolute(0)== true) {
						txtResult.setText("사번\t직원명\t직급\t성별\t연봉\n");
					}
					while (rs.next()) {
						String ss = rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t"
								+ rs.getString("jikwon_jik") + "\t" + rs.getString("jikwon_gen") + "\t"
								+ rs.getString("jikwon_pay") + "\n";
						txtResult.append(ss);
						count += 1;
						avgpay += Integer.parseInt(rs.getString("jikwon_pay"));
					}
					txtResult.append("\n인원수 : " + count + "명" + "\t\t" + "연봉 평균 : " + (avgpay / count) + "\n");
					
					
				} else if (e.getSource() == btnReset) {
					txtResult.setText("");
					txtFi.setText("");
					txtFi.requestFocus();
				}
			} catch (Exception e2) {
				
			}
		} catch (Exception e2) {
		
		} finally {							// close
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Jeongbo();

	}

}
