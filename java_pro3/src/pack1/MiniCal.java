package pack1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MiniCal extends JFrame implements ActionListener {

	JTextField txtNum1, txtNum2;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rdoP, rdoM, rdoB, rdoF;
	JButton cal, reset, exit;
	JLabel lblResult;

	public MiniCal() {
		super("미니계산기");
		layOut();

		setBounds(300, 250, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layOut() {
		setLayout(new GridLayout(5, 2));
		// 숫자1
		JLabel lbl1 = new JLabel("숫자1 :");
		txtNum1 = new JTextField("", 5);
		JPanel pn1 = new JPanel();
		pn1.add(lbl1);
		pn1.add(txtNum1);
		add(pn1);

		// 숫자2
		JLabel lbl2 = new JLabel("숫자2 :");
		txtNum2 = new JTextField("", 5);
		JPanel pn2 = new JPanel();
		pn2.add(lbl2);
		pn2.add(txtNum2);
		add(pn2);

		// 연산선택
		JLabel lbl3 = new JLabel("연산선택 : ");
		rdoP = new JRadioButton("+", true);
		rdoM = new JRadioButton("-", false);
		rdoB = new JRadioButton("*", false);
		rdoF = new JRadioButton("/", false);
		buttonGroup.add(rdoP);
		buttonGroup.add(rdoM);
		buttonGroup.add(rdoB);
		buttonGroup.add(rdoF);
		JPanel pn3 = new JPanel();
		pn3.add(lbl3);
		pn3.add(rdoP);
		pn3.add(rdoM);
		pn3.add(rdoB);
		pn3.add(rdoF);
		add(pn3);

		// 결과
		lblResult = new JLabel("결과 : ", JLabel.CENTER);
		add(lblResult);

		txtNum1.requestFocus();

		// 선택버튼
		/// 계산버튼
		cal = new JButton("계산");
		cal.addActionListener(this);
		JPanel pn5 = new JPanel();
		pn5.add(cal);
		/// 초기화버튼
		reset = new JButton("초기화");
		reset.addActionListener(this);
		pn5.add(reset);
		/// 종료버튼
		exit = new JButton("종료");
		exit.addActionListener(this);
		pn5.add(exit);
		add(pn5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력자료 유효성
		
		try {
			if (e.getSource() == cal) {

			int num1 = 0;
			int num2 = 0;
			//try {

				num1 = Integer.parseInt(txtNum1.getText());
				num2 = Integer.parseInt(txtNum2.getText());

			//} catch (Exception e2) {
			//	JOptionPane.showMessageDialog(this, "숫자만 허용");
			//	txtNum1.requestFocus();

				double result = 0;
				if (rdoP.isSelected()) {
					result = num1 + num2;

				} else if (rdoM.isSelected()) {
					result = num1 - num2;
				} else if (rdoB.isSelected()) {
					result = num1 * num2;
				} else if (rdoF.isSelected()) {
					result = num1 / num2;
				}
				String ss = "계산 결과 : " + result;
				lblResult.setText(ss);
				
			//}

		} else if (e.getSource() == reset) {
			txtNum1.setText(null);
			txtNum2.setText(null);
			String ss = "";
			lblResult.setText(ss);
			txtNum1.requestFocus();
			
		} else if (e.getSource() == exit) {
			int re = JOptionPane.showConfirmDialog(this, "종료하시겠습니까? ", "종료창", JOptionPane.YES_NO_CANCEL_OPTION);
			switch (re) {

			case JOptionPane.YES_OPTION:
				System.exit(0);
			case JOptionPane.NO_OPTION:
				txtNum1.requestFocus();
				break;
			case JOptionPane.CANCEL_OPTION:
				break;
			}
		}
	}catch(ArithmeticException e2){
		JOptionPane.showMessageDialog(this, "0으로 나눌 수 없습니다.");
		txtNum1.requestFocus();
	}catch(Exception e3) {
		JOptionPane.showMessageDialog(this, "숫자만 허용");
		txtNum1.requestFocus();
	}
		
	}

	public static void main(String[] args) {
		new MiniCal();
	}

}
