package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class Chamjo extends JFrame implements ActionListener {
	JTextField tc, tn, ts, td;
	JButton btn1 = new JButton("추가");
	JTextArea txtResult = new JTextArea();

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs, rs1;

	public Chamjo() {
		super("상품 처리");

		layInit();
		accDb();
		accDb2();
		setBounds(300, 300, 500, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {
		JLabel lbl1 = new JLabel("코드 : ");
		tc = new JTextField("", 4);
		JLabel lbl2 = new JLabel("품명 : ");
		tn = new JTextField("", 4);
		JLabel lbl3 = new JLabel("수량 : ");
		ts = new JTextField("", 4);
		JLabel lbl4 = new JLabel("단가 : ");
		td = new JTextField("", 4);
		JPanel pn1 = new JPanel();

		pn1.add(lbl1);
		pn1.add(tc);
		pn1.add(lbl2);
		pn1.add(tn);
		pn1.add(lbl3);
		pn1.add(ts);
		pn1.add(lbl4);
		pn1.add(td);
		pn1.add(btn1);
		btn1.addActionListener(this); // 추가버튼

		txtResult.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResult);
		add("North", pn1);
		add("Center", scrollPane);

	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
			
			
		} catch (Exception e) {
			System.out.println("accDberr : " + e);
		}
	}
	private void accDb2() {
		// TODO Auto-generated method stub
		try {
			String sql = "select code, sang, su, FORMAT(dan,0) as dan, FORMAT(su*dan, 0) as mo from sangdata";
			int count = 0;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			txtResult.setText("");
			txtResult.setText("코드\t상품명\t수량\t단가\t금액\n");
			while (rs.next()) {
				System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " "
						+ rs.getString("dan"));
				String ss = rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + "\t"
						+ rs.getString("dan") + "\t" +rs.getString("mo")+ "\n";
				txtResult.append(ss);
				count += 1;
			}
			txtResult.append("인원수 : " + count + "명");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
	
			if (e.getSource() == btn1) {
				if (tc.getText().equals("")) {// 여기서부터
					JOptionPane.showMessageDialog(this, "코드를 입력하시오");// 메세지창을 호출
					tc.requestFocus();
					return;// 메소드 탈출
				} else if(tn.getText().equals("")){
					JOptionPane.showMessageDialog(this, "상품을 입력하시오");// 메세지창을 호출
					tn.requestFocus();
					return;
				}else if(ts.getText().equals("")){
					JOptionPane.showMessageDialog(this, "수량을 입력하시오");// 메세지창을 호출
					ts.requestFocus();
					return;
				}else if(td.getText().equals("")){
					JOptionPane.showMessageDialog(this, "단가를 입력하시오");// 메세지창을 호출
					td.requestFocus();
					return;
				} else {
					accDb();
					String isql = "insert into sangdata values(?,?,?,?,?)";
					pstmt = conn.prepareStatement(isql);
					pstmt.setInt(1, Integer.parseInt(tc.getText()));
					pstmt.setString(2, "tn.getText()");
					pstmt.setInt(3, Integer.parseInt(ts.getText()));
					pstmt.setInt(4, Integer.parseInt(td.getText()));
					pstmt.setString(5, "FORMAT(ts.getText()*td.getText()),0");
					rs1 = pstmt.executeQuery();
					if(rs1.next()) {
						String ss = rs1.getString(1) + "\t" + rs1.getString(2) + "\t" + rs1.getInt(3) + "\t"
								+ rs1.getInt(4) + "\t" +rs1.getString(5)+ "\n";
						txtResult.append(ss);
//						count += 1;
					}
				}

			}
		}catch (Exception e2) {
			System.out.println("여기냐 :" + e2);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs1 != null)
					rs1.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e3) {
				
			}
		}
		
	}

	public static void main(String[] args) {
		new Chamjo();
	}

}