package pack2;

public class PolyCar {
	protected int speed = 30;			// 자식. 
	
	public PolyCar() {					// 생성자.
		System.out.println("난 자동차야!!!!!!!");
	}
	
	public void dispData() {
		System.out.println(" 속도 : " +speed);
		
	}
	public int getSpeed(){
		return speed;
		
	}
	
}
