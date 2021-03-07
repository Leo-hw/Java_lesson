package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonEventLambda extends JFrame {
	
	public ButtonEventLambda() {
		super("lambda");
		
		layInit();
		
		setBounds(300, 300, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	// 자바에서 람다식은 제한적 - 추상메소드가 하나인 경우에 대해서만 람다를 사용할 수 있기 때문에.
	private void layInit() {
		setLayout(null);
		JButton btn = new JButton("버턴1");
		btn.setBounds(10, 50, 100, 50);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("첫번째 버턴 클릭");
			}
		});
		
		JButton btn2 = new JButton("버턴2");
		btn2.setBounds(10, 150, 100, 50);
		add(btn2);
		
		//btn2.addActionListener(e -> setTitle("두번째 버턴 클릭"));
	
		btn2.addActionListener(new ActionListener() {					// quick fix 가능
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("두번째 버턴 클릭");
			}
		});
	
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		new ButtonEventLambda();
	}
}
