package pack1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LayoutTest extends Frame implements ActionListener {
	Panel pn1 = new Panel(); // flow layout 레이아웃이 기본
	Panel pn2 = new Panel();
	Panel pn3 = new Panel();
	Panel pn4 = new Panel();
	Panel pn5 = new Panel();
	Panel pn6 = new Panel();

	Button btnGo;
	TextField txtBun, txtIrum;
	CardLayout card = new CardLayout(); // layout 을 겹쳐서 사용해서 필요할 때마다 꺼내서 보는 형식

	public LayoutTest() {				// frame 의 레이아웃을 GridLayout으로 변경
		setLayout(new GridLayout(2,1));
		
		// 첫번째 행
		Label lbl1 = new Label("bunho:");		// 패널이므로 flow layout 
		txtBun = new TextField("10", 10);		// 키보드로 값을 줄 수 있음.
		pn1.add(lbl1);							 
		pn1.add(txtBun);						
		pn1.setBackground(Color.YELLOW);
		//add(pn1);								// frame 에 panel 을 배치
		
		Label lbl2 = new Label("irum:");
		txtIrum = new TextField("홍길동", 10);	// textfiled (내용값, 자릿수)
		pn2.add(lbl2);							 
		pn2.add(txtIrum);						
		pn2.setBackground(Color.MAGENTA);
		//add(pn2);		
		
		pn3.setLayout(card); 					// card layout 으로 변경
		pn3.add("aa", pn1);
		pn3.add("bb",pn2);
		btnGo = new Button("OK");
		btnGo.addActionListener(this);
		pn4.add(pn3);
		pn4.add(btnGo);
		
		add(pn4);
		
		
		// 두번째 행
		pn5.setBackground(Color.PINK);
		pn5.setLayout(new BorderLayout());
		pn5.add("Center", new Label("Centro", Label.CENTER));
		pn5.add("East", new Label("este"));
		pn5.add("West", new Label("oyeste"));
		pn5.add("South", new Label("sur"));
		pn5.add("North", new Label("norte"));
		
		add(pn5);
		
		//---------------------
		setTitle("레이아웃 연습");
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// pn3에 포함된 pn1과 pn2를 번갈아 출력 (클릭시 레이아웃 변경)
		//System.out.println(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("ok")) {
			btnGo.setLabel("click");
			card.show(pn3, "bb");
		}else {
			btnGo.setLabel("ok");
			card.show(pn3, "aa");
		}
	}

	public static void main(String[] args) { // 레이아웃 매니저로 화면 디자인
		new LayoutTest();

	}

}
