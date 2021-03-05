package pack1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest extends Frame implements ActionListener {
	private Button btn1 = new Button("button1");
	private Button btn2 = new Button("button2");
	private Button btn3 = new Button("button3");
	private Button btn4 = new Button("button4");
	private Button btn5 = new Button("button5(exit)");

	public EventTest() {
		super("event test");
		addLayout();
		setBounds(300, 250, 400, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {					// 내부 무명 클래스
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void addLayout() {
		add("East", btn1); // frame은 BorderLayout 이므로
		add("West", btn2);
		add("Center", btn3);
		add("South", btn4);
		add("North", btn5);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(new MyEvent()); 			// 내부 클래스 사용
		btn4.addMouseListener(new OurEvent());
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getActionCommand());
		// System.out.println(e.getSource());
		if (e.getSource() == btn1) {
			setTitle("button1 click");
		} else if (e.getSource() == btn2) {
			setTitle("button2 click");
		} //else if (e.getSource() == btn5) {
			//System.exit(0);
		//}
	}
	class OurEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			setTitle("button4 click");
		}
	}
	
	
	class MyEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setTitle("button third press");
		}
	}

	public static void main(String[] args) {
		new EventTest();
	}

}
