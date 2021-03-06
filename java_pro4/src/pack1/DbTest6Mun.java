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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest6Mun extends JFrame implements ActionListener{
	private Connection conn;
	private PreparedStatement pstmt; // 선처리 방식 : 동일한 SQL문을 공유. ? 연산자를 사용해 보안 강화
	private ResultSet rs;
	private JLabel lblCode, lblName, lblbNum, lblAccount;
	private JTextField txtCode, txtName, txtNum, txtAccount;
	private JButton btnAdd;
	private JTextArea result;

	public DbTest6Mun() {
		setTitle("상품 처리");
		layInit();
		accDb();

		setBounds(200, 200, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {
		lblCode = new JLabel("코드 : ");
		lblName = new JLabel("품명 : "); 
		lblbNum = new JLabel("수량 : "); 
		lblAccount = new JLabel("단가 : ");

		txtCode = new JTextField("", 5);
		txtName = new JTextField("", 5); 
		txtNum = new JTextField("", 5);
		txtAccount = new JTextField("", 5);
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);

		JPanel p1 = new JPanel();
		p1.add(lblCode);
		p1.add(txtCode);
		p1.add(lblName);
		p1.add(txtName);
		p1.add(lblbNum);
		p1.add(txtNum);
		p1.add(lblAccount);
		p1.add(txtAccount);
		p1.add(btnAdd);

		add("North", p1);
		result = new JTextArea();
		result.setEditable(false);
		JScrollPane jsp = new JScrollPane(result);
		add("Center", jsp);
	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			display();
		} catch (Exception e) {
			System.out.println("accDB err" + e);
		}
	}
 
	private void addDisplay() {
		try {
			String addsql = "insert into sangdata values (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(addsql);
			pstmt.setInt(1, Integer.parseInt(txtCode.getText()));		
			pstmt.setString(2, txtName.getText());
			pstmt.setInt(3, Integer.parseInt(txtNum.getText()));
			pstmt.setInt(4, Integer.parseInt(txtAccount.getText()));
 
			int re = pstmt.executeUpdate();
			if(re == 1)
				System.out.println("추가 성공");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "중복데이터");
		}
	}

	private void display() {
		result.setText("코드" + "\t" + "상품명" + "\t" + "수량" + "\t" + "단가" + "\t" + "금액" + "\n");
		try {
			String sql = "select *, format(su*dan, 0) as 금액 from sangdata order by code asc";
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			int count = 0; 
			while(rs.next()) {
				String ss = rs.getString("code") + "\t" +
							rs.getString("sang") + "\t" +
							rs.getString("su") + "\t" +
							rs.getString("dan") + "\t" +
							rs.getString("금액") + "\n";
				result.append(ss);
				count += 1;
			}
			result.append("건수 : " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			// 공백 확인
			if(txtCode.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "코드 입력");
				txtCode.requestFocus();
			}else if(txtName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "품명 입력");
				txtName.requestFocus();
			}else if(txtNum.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "수량 입력");
				txtNum.requestFocus();
			}else if(txtAccount.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "단가 입력");
				txtAccount.requestFocus();
			}
			// 입력자료 검사
			try {
				Integer.parseInt(txtCode.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "코드 : 숫자만 입력가능");
			}
			try {
				Integer.parseInt(txtNum.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "수량 : 숫자만 입력가능");
			}
			try {
				Integer.parseInt(txtAccount.getText());
				addDisplay();
				display();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "단가 : 숫자만 입력가능");
			}
			txtCode.setText("");
			txtName.setText("");
			txtNum.setText("");
			txtAccount.setText("");
		}
	}
	public static void main(String[] args) {
		new DbTest6Mun();
	}
}