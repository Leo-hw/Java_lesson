package pack1;
//AWT  컴포넌트 : Radio, Choice, Checkbox

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EventTest2 extends Frame implements ItemListener, ActionListener {

	private Checkbox rad1, rad2, rad3, chk1, chk2, chk3;
	private Choice cho;
	private Panel pn1, pn2;
	private Color c; // 테두리 선 색
	private int sel = 1; // 도형의 종류
	private Button btnOk;
	public EventTest2() {

//Radio

		pn1 = new Panel();
		CheckboxGroup group = new CheckboxGroup();
		rad1 = new Checkbox("line", group, true);
		rad2 = new Checkbox("circle", group, false);
		rad3 = new Checkbox("rect", group, false);

		rad1.addItemListener(this);
		rad2.addItemListener(this);
		rad3.addItemListener(this);

		pn1.add(rad1);
		pn1.add(rad2);
		pn1.add(rad3);

//Choice

		cho = new Choice();
		cho.addItem("red");
		cho.addItem("yell");
		cho.addItem("blue");
		cho.addItem("black");
		cho.addItemListener(this);
		pn1.add(new Label("color select", Label.RIGHT));
		pn1.add(cho);

//Checkbox

		chk1 = new Checkbox("kor", true);
		chk2 = new Checkbox("jpa", false);
		chk3 = new Checkbox("usa", false);
		pn2 = new Panel();
		btnOk = new Button("ok");
		btnOk.addActionListener(this);
		pn2.add(new Label("select contry : "));
		pn2.add(chk1);
		pn2.add(chk2);
		pn2.add(chk3);
		pn2.add(btnOk);

		this.add(pn1, BorderLayout.NORTH);
		this.add(pn2, BorderLayout.SOUTH);
		setBounds(200, 100, 400, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == rad1)
			sel = 1;
		else if (e.getSource() == rad2)
			sel = 2;
		else if (e.getSource() == rad3)
			sel = 3;
		if (e.getItem().equals("red"))
			c = Color.red;
		else if (e.getItem().equals("yell"))
			c = Color.yellow;
		else if (e.getItem().equals("blue"))
			c = Color.blue;
		else if (e.getItem().equals("black"))
			c = Color.black;

		repaint(); // paint() 메소드 수동 호출

	}

	public void paint(Graphics g) { // 프로그램 실행 시 update() -> paint()메소드 순으로 자동호출

		g.setColor(c);

		Random aa = new Random();
		int x = aa.nextInt(100);
		int y = aa.nextInt(100);
		int w = aa.nextInt(300);
		int h = aa.nextInt(300);

		switch (sel) {
		case 1:
			g.drawLine(x, y, w, h);
			break;
		case 2:
			g.drawOval(x, y, w, h);
			break;
		case 3:
			g.drawRect(x, y, w, h);
			break;
		}
	}

	public void actionPerformed(ActionEvent ae) {

		String ss = "";
		if (chk1.getState() == true)
			ss += chk1.getLabel();
		if (chk2.getState() == true)
			ss += chk2.getLabel();
		if (chk3.getState() == true)
			ss += chk3.getLabel();

		super.setTitle(ss);
	}

	public static void main(String[] args) {
		new EventTest2();

	}

} // end class
