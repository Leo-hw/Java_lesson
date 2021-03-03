package pack2;

public class Father extends GrandFa{	//단일 상속 : private 멤버를 제외한 나머지 자원을 자식에게 제공. 
	private int nai = 55;				// 캡슐화
	public String gabo  = "꽃병";			// 부모 멤버와 같은 멤버필드.	은닉화
	private int house = 1;				// Father 고유멤버
	
	
	public Father() {
			super();					// 부모 생성자 호출. 생략 가능
			System.out.println(" 아버지 생성자-");
		}
		
		public Father(int n) {
			super(n);
			System.out.println(" 아버지 생성자-");
		}
		
		@Override						//annotation 
		public int getNai(){			//method override	
			System.out.println("자식이 부모 메소드를 재정의 함");
			return nai;
		}
		public int getHouse() {
			return house;
		}
		public final void showData() {		// Father 고유 메소드
			String gabo = "컴퓨터";
			System.out.println("가보 : "+ gabo);
			System.out.println("가보 : "+ this.gabo);
			System.out.println("가보 : "+ super.gabo);	// 한 단계 상위 클래스만 허용.
			getNai();
			this.getNai();
			super.getNai();
		}
		
		
}
