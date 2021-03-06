package pack1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest6_Ex extends JFrame implements ActionListener {
	JButton btnAdd = new JButton();
	JTextField txtCode, txtPum, txtSu, txtDan;
	JTextArea txtRe = new JTextArea();
	JLabel lblNo, lblPum, lblSu, lblDan;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DecimalFormat deci = new DecimalFormat("###,###");

	public DbTest6_Ex() {
		setTitle("상품처리");
		layInit();
		accDb();
		
		setBounds(300, 300, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() { // 레이아웃
//		setLayout(new GridLayout(2, 1));
		JPanel pn1 = new JPanel();
		

		// 라벨 작성
		lblNo = new JLabel("코드 : ");
		lblPum = new JLabel("품목 : ");
		lblSu = new JLabel("수량 : ");
		lblDan = new JLabel("단가 : ");

		// 텍스트 필드 작성
		txtCode = new JTextField("", 5);
		txtPum = new JTextField("", 5);
		txtSu = new JTextField("", 5);
		txtDan = new JTextField("", 5);

		// 버튼 작성
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);

		// 패널에 추가
		pn1.add(lblNo);
		pn1.add(txtCode);
		pn1.add(lblPum);
		pn1.add(txtPum);
		pn1.add(lblSu);
		pn1.add(txtSu);
		pn1.add(lblDan);
		pn1.add(txtDan);
		pn1.add(btnAdd);

		// txtArea 추가
		txtRe = new JTextArea();
		txtRe.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtRe);

		// 패널을 프레임에 추가
		add("North", pn1);
		add("Center", scrollPane);
	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			printData();

		} catch (Exception e) {
			System.out.println(" accDb 에러 : " + e);
		}
	}

	private void insertData() {
		try {
			String isql = "insert into sangdata value (?,?,?,?)";

			pstmt = conn.prepareStatement(isql);
			pstmt.setInt(1, Integer.parseInt(txtCode.getText()));
			pstmt.setString(2, txtPum.getText());
			pstmt.setInt(3, Integer.parseInt(txtSu.getText()));
			pstmt.setInt(4, Integer.parseInt(txtDan.getText()));
			
			int re = pstmt.executeUpdate(isql);
			if (re == 1)
				System.out.println("추가성공!");
				txtCode.setText("");
				txtPum.setText("");
				txtSu.setText("");
				txtDan.setText("");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "중복된 코드는 등록할 수 없습니다");
		}
	}

	private void printData() {
		txtRe.setText("코드" + "\t" + "상품명" + "\t" + "수량" + "\t" + "단가" + "\t" + "금액" + "\n");
		try {
			String psql = "select code, sang, su, dan, su*dan as 금액 from sangdata order by code asc";
			pstmt = conn.prepareStatement(psql);
			rs = pstmt.executeQuery();
			int count=0;
			
			while (rs.next()) {
				String ss = rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + "\t"
						+ rs.getString("dan") + "\t" + deci.format("금액") + "\n";

				txtRe.append(ss);
				count += 1;
			}
			txtRe.append("건수 : " + count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			if (txtCode.getText().equals("") ) {
				JOptionPane.showMessageDialog(this, "코드를 입력해주세요");
				txtCode.requestFocus();
			} else if (txtPum.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "품목을 입력해주세요");
				txtPum.requestFocus();
			} else if (txtSu.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "수량를 입력해주세요");
				txtSu.requestFocus();
			} else if (txtDan.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "단가를 입력해주세요");
				txtDan.requestFocus();
			}
			try {
				Integer.parseInt(txtCode.getText());
			} catch (Exception e2) {
				JOptionPane.showInternalMessageDialog(this, "코드에는 숫자만 입력가능");
			}
			try {
				Integer.parseInt(txtSu.getText());
			} catch (Exception e2) {
				JOptionPane.showInternalMessageDialog(this, "갯수에는 숫자만 입력가능");
			}
			try {
				Integer.parseInt(txtDan.getText());
				insertData();
				printData();
			} catch (Exception e2) {
				JOptionPane.showInternalMessageDialog(this, "단가에는 숫자만 입력가능");
			}
			
				txtCode.setText("");
				txtPum.setText("");
				txtSu.setText("");
				txtDan.setText("");
			}
		}
	

	public static void main(String[] args) {
		new DbTest6_Ex();
	}
}