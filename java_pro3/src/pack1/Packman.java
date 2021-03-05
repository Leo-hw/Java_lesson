package pack1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Packman extends JFrame implements KeyListener {
	Image image;
	int x = 100, y = 100, sel = 1; // 초기 좌표

	public Packman() {
		super("상하좌우 화살표를 누르시오");

		// 프레임 아이콘 이미지 변경.
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack1.jpg"));
		setLayout(null);
		setResizable(false);
		setBounds(300, 300, 400, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this);

		x = getWidth() / 2;
		y = getHeight() / 2;
	}

	@Override
	public void paint(Graphics g) {
		switch (sel) { // switch 를 이용해 각 상황별 아이콘 이미지 변경
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack1.jpg");
			break;

		case 2:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("C:/work/jsou/java_pro3/src/pack/pack8.jpg");
			break;
		}

		g.clearRect(0, 0, getWidth(), getHeight()); // 잔상을 없애기 위해. 배경을 지우고 시작.

		// g.drawImage(image, x, y, this);
		g.drawImage(image, x - image.getWidth(this) / 2, y - image.getHeight(this) / 2, this);
	}

	@Override
	public void keyPressed(KeyEvent e) { // 키를 눌렀을 때
		int key = e.getKeyCode();
		// System.out.println(key); // 각 키를 눌렀을 때의 값을 구하기위해.

		// 오른쪽 화살표
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			// System.out.println("우측");
			// if(sel==1) sel = 2; else sel = 1;
			sel = (sel == 1) ? 2 : 1;
			// x= x+10;
			x = (x < getWidth()) ? x += 10 : -image.getWidth(this); // 삼항 연산자. x 값이 프레임보다 클 경우 0으로 다시 시작

		} else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
			sel = (sel == 3) ? 4 : 3;
			x = (x > 0) ? x -= 10 : this.getWidth()+image.getWidth(this)/2;

		} else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {
			sel = (sel == 5) ? 6 : 5;
			y = (y < getHeight()) ? y += 10 : 0-image.getHeight(this)/2;

		}	 else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
			sel =(sel ==7)?8:7; 
			y = ( y > 0)?y -= 10:getHeight()+image.getHeight(this)/2;
			 
		}
		repaint(); // 페인트 값을 초기화하고 다시 불러옴.
	}

	@Override
	public void keyReleased(KeyEvent e) { // 키보드뗏을때
	}

	@Override
	public void keyTyped(KeyEvent e) { // 키보드타이핑
	}

	public static void main(String[] args) {
		// 키보드이벤트 연습
		new Packman();

	}
}
