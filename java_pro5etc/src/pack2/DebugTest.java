package pack2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DebugTest extends JFrame implements ActionListener {
	int cou = 0;
	int tot = 0;
	JButton btn = new JButton("클릭");
	JTextField txtA = new JTextField();
	
	
	public DebugTest() {
		add("North", txtA);
		add("Center", btn);
		btn.addActionListener(this);
		
		setBounds(300, 300, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * for (int i = 0; i < 5; i++) { cou++; // System.out.println("cou : "+cou); //
		 * 변수 값 확인 1 : console tot += cou;
		 * 
		 * } System.out.println("tot : " + tot);
		 */	
		
		// 변수 값 확인 2 : 메세지 다이얼로그
		//JOptionPane.showMessageDialog(this, cou);
		
		
		// 변수 값 확인 3 : 임의의 Component
		//txtA.setText("cout : " +cou+" , 합은 "+tot);
		
		// 변수 값 확인 4: eclipse의 Debug 도구
		for (int i = 0; i < 5; i++) {
			cou +=1;
		
			/*
			String a = "a";
			String b = "b";
			String c = "c";
			String d = a+b+c;		// 비권장
			
			StringBuffer buffer = new StringBuffer();		// 권장
			buffer.append("a");
			buffer.append("b");
			buffer.append("c");
			String d2 = buffer.toString();
			System.out.println(buffer.toString());		
			*/
			
	//		System.out.println("cou : " + cou);
	//		System.out.println("aaa");
			tot +=cou;
	//		System.out.println("bbb");
	//		System.out.println("tot : " + tot);
			aa();
		}
		//System.out.println("bye");
	}
	private void aa() {
		for (int i = 0; i < 3; i++) {
			cou++;
			tot+=cou;
			bb();
			//System.out.println("cou : "+ cou +", tot : " +tot);
		}
	}
	
	private void bb() {
		int kbs = 9;
//		System.out.println("kbs : " + kbs);
	}
	
	public static void main(String[] args) {
		// 이클립스에서 임의의 프로그램 실행 중 임의의 변수 값을 알고 싶은 경우
		
		new DebugTest();
		
	}

}
