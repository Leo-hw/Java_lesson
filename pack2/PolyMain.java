package pack2;

public class PolyMain {

	public static void main(String[] args) {
		// 다형성 연습
		PolyCar car1 = new PolyCar();
		PolyBus bus1 = new PolyBus();
		PolyTaxi taxi1 = new PolyTaxi();
		
		System.out.println();
		car1.dispData();
		System.out.println(car1.getSpeed());
		
		System.out.println("======================");
		bus1.dispData();
		bus1.show();
		System.out.println(bus1.getSpeed());
		System.out.println();
		
		System.out.println("======================");
		taxi1.dispData();
		
		System.out.println(taxi1.getSpeed());
		
		
		System.out.println("\n *********************************************************");
		PolyCar car2 = new PolyBus();			// promotion 자식의 객체 주소를 부모 객체에게 줌.
		car2.dispData();						// 오버라이딩 된 경우라 가능
		//car2.show();							// 파생클래스 고유 메소드 이므로 에러
		System.out.println(car2.getSpeed());	// 오버라이딩은 메소드에서만 가능	
		
		System.out.println();
		PolyCar car3 = taxi1;
		car3.dispData();
		
		System.out.println("@@@@@@@@@@@@@@@");
		//PolyBus bus2 = new PolyCar();
		PolyBus bus2 = (PolyBus)car2;			// casting 
		bus2.dispData();
		bus2.show();
		System.out.println(bus2.getSpeed());
		
		System.out.println();
		//PolyTaxi taxi2 = new PolyCar();
		PolyTaxi taxi2 = (PolyTaxi)car3;
		taxi2.dispData();
		//PolyTaxi taxi3 = (PolyTaxi)car1;		// 실행오류 : class pakc2.PolyCar cannot be cast
		
		
		System.out.println("^^;^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		PolyCar p[]	= new PolyCar[3];			// 배열 선언
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		
		System.out.println("p.length : " + p.length);
		for(int a = 0;  a<p.length; a++) {
			p[a].dispData();
		}
		System.out.println("여기까지 -----");
		for(PolyCar hi:p) {
			hi.dispData();
			System.out.println();
			
		}
		
	}

}
