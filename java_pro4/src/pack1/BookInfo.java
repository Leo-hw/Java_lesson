package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookInfo extends JFrame implements ActionListener {
	JButton btnRe, btnEx;
	JLabel lblUno, lblUname, lblUju, lblUbi, lblUmok;
	JTextField txtUno, txtUname, txtUju, txtUbi;
	String [][] bdatas = new String [0][5];
	
	
	public BookInfo() {
		setTitle("이용자 정보");
		
		setBounds(300, 300, 300, 300);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void main(String[] args) {
		new BookInfo();
	}
}
