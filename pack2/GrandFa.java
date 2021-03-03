package pack2;

public class GrandFa {
		private int nai = 80;
		public String gabo  = "상감청자";
		protected String gahun = "차카게살자";	//protected 자식이 있다.
		
		public GrandFa() {
			System.out.println("할아버지 생성자");
		}
		public GrandFa(int nai	) {
			this();									// 자신의 또 다른 생성자 호출 - 가장 먼저 적어줘야 함.
			this.nai = nai;						// 자신의 멤버필드 this
		}
		protected String say()	{			// GrandFa 의 자식 클래스에서만 불러들일 수 있음.
			return "할아버지 말씀 : 자바에 미쳐...";
		}
		void eat() {
			System.out.println("밥은 맛있게...");
		}
		public int getNai() {
			return nai;
			
		}
}
