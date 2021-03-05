package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingTest2 extends JPanel implements ActionListener {

	JButton btnR, btnG, btnB; // 버튼
	JMenuBar mbar;
	JMenuItem mnuMes, mnuOk, mnuInput; // 종류가 비슷한 기능끼리 모아두는 것이 암묵적 약속
	JTextArea txtArea = new JTextArea("", 10, 50); // 세퍼레이터.비슷한 기능중에서도 따로나눠둔 것
													// ... 이 있는 경우 창이 뜬다는 약속.

	public SwingTest2() {
		setLayout(new BorderLayout()); // 레이아웃 변경
		layoutShow();
		layoutMenuShow();
	}

	private void layoutShow() {
		btnR = new JButton("빨강");
		btnG = new JButton("초록");
		btnB = new JButton("파랑");
		btnR.addActionListener(this); // 버튼 눌렀을 때의 액션
		btnG.addActionListener(this);
		btnB.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(btnR);
		panel.add(btnG);
		panel.add(btnB);

		add("South", panel);
		add("Center", txtArea);

	}

	private void layoutMenuShow() {
		mbar = new JMenuBar();

		JMenu menu = new JMenu("대화 상자 연습");
		mnuMes = new JMenuItem("메세지 창");
		mnuOk = new JMenuItem("확인 창");
		mnuInput = new JMenuItem("입력 창");
		menu.add(mnuMes); // 메뉴에 메뉴 아이템 등록
		menu.add(mnuOk);
		menu.add(mnuInput);

		mbar.add(menu); // 메뉴바에 메뉴 아이템 등록
		// 메뉴에 리스너 장착
		mnuMes.addActionListener(this);
		mnuOk.addActionListener(this);
		mnuInput.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnR) {
			txtArea.setBackground(Color.red);
		} else if (e.getSource() == btnG) {
			txtArea.setBackground(new Color(0, 100, 200));
		} else if (e.getSource() == btnB) {
			txtArea.setBackground(new Color(100, 250, 100));
		} else if (e.getSource() == mnuMes) { // 메세지 창 띄우기
			JOptionPane.showMessageDialog(this, "메세지", "알림", JOptionPane.INFORMATION_MESSAGE);
			txtArea.setText("와우");
		} else if (e.getSource() == mnuOk) { // 선택 창 띄우기
			int re = JOptionPane.showConfirmDialog(this, "버튼 선택", "골라", JOptionPane.YES_NO_CANCEL_OPTION);
			// System.out.println("re : "+ re);

			switch (re) {
			//case 0:
			case JOptionPane.YES_OPTION: 
				txtArea.append("예 선택\n");
				break;
			case JOptionPane.NO_OPTION:
			//case 1: 
				txtArea.append("아니오 선택\n");
				break;
			case JOptionPane.CANCEL_OPTION:
				txtArea.append("취소 선택\n");
				break;
			//case 2:
			}
		} else if (e.getSource() == mnuInput) { // 소량의 자료 입력창
			String str = JOptionPane.showInputDialog(this, "자료 입력");
			txtArea.append(str+"\n");
			
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("대화상자 연습");

		SwingTest2 test2 = new SwingTest2(); // JPanel
		// JPanel 여러개 준비...

		frame.getContentPane().add(test2, "Center"); // JPanel을 JFrame 에 배치

		frame.setJMenuBar(test2.mbar);

		frame.setBounds(300, 250, 400, 300);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
