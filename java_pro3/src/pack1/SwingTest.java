package pack1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingTest extends JFrame implements ActionListener { // J가 붙으면 스윙
	int count = 0;
	JLabel lblshow;

	public SwingTest() {
		setTitle("스윙");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		
		JButton btn = new JButton("클릭(C)");
		btn.setMnemonic(KeyEvent.VK_C);
		btn.addActionListener(this);
		panel.add(btn);

		lblshow = new JLabel("버튼 클릭 수 : 0");
		panel.add(lblshow);

		// add("Center", panel);
		add(panel, BorderLayout.CENTER);

		setBounds(300, 250, 400, 300);
		setVisible(true);
		/*
		 * addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosing(WindowEvent e) { System.exit(0); } });
		 */

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//   종료만 할 경우 사용. 종료시 다른 행동을 하기 위해서는 전과 동일하게 사용
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	count +=1;
	lblshow.setText("버튼 클릭 수 : "+ count);
	}

	public static void main(String[] args) {
		new SwingTest();

	}

}
