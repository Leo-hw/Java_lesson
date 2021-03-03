package pack2;

public class DogMain {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.print();
		System.out.println(dog.callName());
		
		System.out.println("--------------------");
		HouseDog hd = new HouseDog("집개");
		hd.print();
		hd.show();
		System.out.println(hd.callName());
		
		System.out.println("-------------------");
		WolfDog wd = new WolfDog("늑대");
		wd.print();
		System.out.println(wd.callName());
		wd.display();
		
		System.out.println("^^^^^^^^^^^^^^^^^^");
		
		WolfDog bushdog= wd;
		bushdog.print();
		
		System.out.println();
		Dog dog2 = hd; 					// 자식 객체의 주소를 부모 개체에 치환 가능 (promotion)
		dog2.print();					
		//dog2.display();				// 오버라이딩 된 메소드에만 가능.
										// 자식 고유의 메소드는 간섭 불가능.
										// 동일한 스테이트먼트로 다양한 결과를 얻어낼 수 있음 - 폴리모피즘(다형성)
		System.out.println();
		dog2 = wd;
		dog2.print();
		
		System.out.println();
		WolfDog	bushdog2 = (WolfDog)dog2;		//casting 부모 객체의 주소를 자식 객체에게 줌  <-> promotion
		bushdog2.print();
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");
		Dog coyote = new Dog("코요테");
		coyote.print();
		
		System.out.println();
		coyote = bushdog;
		coyote.print();
		
		System.out.println();
		coyote = hd;
		coyote.print();
		
		
		
		if(dog2.equals(wd)) {
			System.out.println("늑대 귀여워");
		}
		
		
		
		
	}

}
