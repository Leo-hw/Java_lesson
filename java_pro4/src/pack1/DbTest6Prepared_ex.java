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

public class DbTest6Prepared_ex extends JFrame implements ActionListener {
	JButton btnAdd;
	JLabel lblResult;
	JTextField txtCode, txtPum, txtSu, txtDan;
	JTextArea txtFin;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DecimalFormat deci = new DecimalFormat();
	
	
	public DbTest6Prepared_ex() {
		super("상품처리");

		layInit();
		accDb();
		setBounds(300, 300, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void layInit() {
		setLayout(new GridLayout(2, 1)); // 그리드 레이아웃
		JPanel pn1 = new JPanel();
readData();
		// jlabel 생성
		JLabel lbl1 = new JLabel("코드 :");
		JLabel lbl2 = new JLabel("품명 :");
		JLabel lbl3 = new JLabel("수량 :");
		JLabel lbl4 = new JLabel("단가 :");
		// txt 필드 생성
		txtCode = new JTextField("", 5);
		txtPum = new JTextField("", 5);
		txtSu = new JTextField("", 5);
		txtDan = new JTextField("", 5);
		// 버튼 추가
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);

		// 첫번째 줄 추가
		pn1.add(lbl1);
		pn1.add(txtCode);
		pn1.add(lbl2);
		pn1.add(txtPum);
		pn1.add(lbl3);
		pn1.add(txtSu);
		pn1.add(lbl4);
		pn1.add(txtDan);
		pn1.add(btnAdd);
		add(pn1);
		// txt 에어리어 설정
		txtFin = new JTextArea();
		txtFin.setEditable(false);
		txtFin.setText(" 코드\t상품명\t수량\t단가\t금액\n");
		txtFin.append(
				"-------------------------------------------------------------------------------------------------------------------");

		JScrollPane scrollPane = new JScrollPane(txtFin);
		scrollPane.setPreferredSize(getMaximumSize());
		add(scrollPane);

	}

	private void insertData() {
		try {
			String isql = "insert into sangdata values(?,?,?,?)";
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");

			pstmt = conn.prepareStatement(isql);
			pstmt.setString(1, txtCode.getText());
			pstmt.setString(2, txtPum.getText());
			pstmt.setString(3, txtSu.getText());
			pstmt.setString(4, txtDan.getText());

			int re = pstmt.executeUpdate();
			if (re == 1)
				System.out.println("추가 성공");
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "중복된 코드를 입력할 수 없습니다.");
			System.out.println("오류" + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {

			}
		}
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			readData();
		} catch (Exception e) {
			System.out.println("accDB err" + e);
		}

	}

	

	private void readData() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root", "123");
			Class.forName("org.mariadb.jdbc.Driver");
			String sql = "select*from sangdata"; // 칼럼명을 써주는 게 좋음
			int tot = 0;
			int count =0;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			tot = Integer.parseInt(rs.getString("su")) * Integer.parseInt(rs.getString("dan"));
			
			
			
			while (rs.next()) {
				String ss =	rs.getString("code")+"\t"+
						rs.getString("sang")+"\t"+
						rs.getString("su")+"\t"+
						rs.getString("dan")+"\t"+ deci.format(tot)+"\n";
				
				txtFin.append(ss);
				count += 1;
				
			}
			txtFin.append("건수  : "+count);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnAdd)
				readData();
				insertData();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "자료를 입력해주세요.");
			return;
		}
		// if(e.getSource())
	}

	public static void main(String[] args) {
		new DbTest6Prepared_ex();
	}

}
