package pack1;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DbTest8CRUD extends JFrame implements ActionListener {
	JButton btnInsert, btnUpdate, btnDelete, btnExit;
	String [][] datas = new String [0][4];
	String [] titles = {"코드", "상품명	", "수량", "단가"};
	DefaultTableModel model = new DefaultTableModel(datas, titles);
	JTable table = new JTable(model);
	JLabel lblCou = new JLabel("건수 : 0");
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest8CRUD() {
		super("상품관리");
		layInit();
		accDb();
		
		setResizable(false);
		setBounds(300, 300, 300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {					// 쇼 컨펌 다이얼로그를 통해 종료하는 전형적인 방법.
		@Override
		public void windowClosing(WindowEvent e) {
			int re = JOptionPane.showConfirmDialog(DbTest8CRUD.this,
					"정말 종료하시겠습니까?", "종료", JOptionPane.OK_CANCEL_OPTION);
			if(re == JOptionPane.OK_OPTION) {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
										
				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.exit(0);
				
			}else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
		}
		});
	}
	
	private void layInit() {
		btnInsert = new JButton("추가");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		btnExit = new JButton("종료");
		
		JPanel panel = new JPanel();
		panel.add(btnInsert);
		panel.add(btnUpdate);
		panel.add(btnDelete);
		panel.add(btnExit);
		
		add("North", panel);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30); 				// 테이블의 열 폭 조정
		JScrollPane scrollPane = new JScrollPane(table);
		add("Center", scrollPane);
		add("South", lblCou);
		
		
		btnInsert.addActionListener(this);
		//btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		
		
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
				
			dispData();
			
		} catch (Exception e) {
			System.out.println("accDb err: "+ e);
		}
	}
	
	private void dispData() {
		model.setNumRows(0); 			// table 초기화.
		try {

			conn = DriverManager.getConnection("jdbc:mysql:localhost:3310/test", "root","qhdghks5");
			String sql = "select*from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int count = 0;
			
			while(rs.next()) {
				String [] imsi = {
					rs.getString("code"),
					rs.getString("sang"),
					rs.getString("su"),
					rs.getString("dan")
				};
				model.addRow(imsi);
				count += 1;
				
			}
			lblCou.setText("건수 : " +count);
			
		} catch (Exception e) {
			System.out.println("dispData err :" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInsert) {			// 상품추가
			InsertForm insertForm = new InsertForm(this);
			dispData();					// 추가 후 목록보기
			
			
		}else if(e.getSource() == btnUpdate) {			// 상품수정 
			// 생략
			
		}else if(e.getSource() == btnDelete) {			// 상품삭제
			String delNo = JOptionPane.showInputDialog(this, "삭제할 코드 번호 입력");
			if(delNo == null) return;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root","123");
				String sql = "delete from sangdata where code =?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, delNo);
				
				if(pstmt.executeUpdate() == 0) {
					JOptionPane.showMessageDialog(this, delNo+"상품이 존재하지 않습니다.");
					return;
				}
				dispData();		// 삭제 후 목록보기
				
			} catch (Exception e2) {
				System.out.println("삭제 오류 : " +e2);
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		}else if(e.getSource() == btnExit) {			// 종료
			int re = JOptionPane.showConfirmDialog(DbTest8CRUD.this,
					"정말 종료하시겠습니까?", "종료", JOptionPane.OK_CANCEL_OPTION);
			if(re == JOptionPane.OK_OPTION) {
				try {
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
										
				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.exit(0);
				
			}else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
			
		}
	}
	
	// 추가를 위한 내부 클래스 
	class InsertForm extends JDialog implements ActionListener{
		JTextField txtSang = new JTextField();
		JTextField txtsu = new JTextField();
		JTextField txtdan = new JTextField();
		JButton btnOk = new JButton("등록");
		JButton btnCancel = new JButton("취소");
			
		public InsertForm(Frame frame) {
			super(frame, "상품추가");
			setModal(true);
			
			// 추가 화면 디자인
			JPanel pn1 = new JPanel(new GridLayout(4,2));
			pn1.add(new JLabel("품명 : ", JLabel.RIGHT));
			pn1.add(txtSang);
			
			pn1.add(new JLabel("수량 : ", JLabel.RIGHT));
			pn1.add(txtsu);
			
			pn1.add(new JLabel("단가 : ", JLabel.RIGHT));
			pn1.add(txtdan);
			
			pn1.add(btnOk);
			pn1.add(btnCancel);
			
			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);
			
			add("North", new JLabel("자료 입력하기"));
			add("Center",pn1);
			setBounds(310, 310, 150, 150);
			setVisible(true);
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
				
				}
			});
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOk) {				// 신상품 추가
				// 입력자료 검사
				if(txtSang.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(this, "상품명 입력");
					txtSang.requestFocus();
					return;
				}
				//수량, 단가는 생략
				
				//수량, 단가는 숫자.
				int su = 0;
				try {
					su = Integer.parseInt(txtsu.getText());
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(this, "수량은 숫자만 입력 가능");
					txtsu.requestFocus();
					return;
				}
				
				int dan = 0;
				try {
					dan = Integer.parseInt(txtdan.getText());
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(this, "단가는 숫자만 입력 가능");
					txtdan.requestFocus();
					return;
				}
				// 등록 가능한 상태
				
				try {
					conn = DriverManager.getConnection("jdbc:mysql://192.168.0.61:3306/test", "root","123");
					
					//신상 code 구하기
					int new_code = 0;
					String sql = "select max(code) from sangdata";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						new_code = rs.getInt(1);
						
					}
					//System.out.println(new_code +1);
					
					sql = "insert into sangdata values(?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, new_code+1);
					pstmt.setString(2, txtSang.getText().trim());
					pstmt.setInt(3, su);
					pstmt.setInt(4, dan);
					if(pstmt.executeUpdate() >0) {
						JOptionPane.showMessageDialog(this, "등록 성공");
						dispose();
					}else {
						JOptionPane.showMessageDialog(this, "허걱 실패");
						
					}
					
				} catch (Exception e2) {
					System.out.println("등록 실패" + e2);
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}else if(e.getSource() == btnCancel) {		// 입력자료 초기화
				txtSang.setText("");
				txtsu.setText("");
				txtdan.setText("");
				txtSang.requestFocus();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		new DbTest8CRUD();
		
	}

}
