package other;

//import pack1.Bank; - 이 방법 추천...

import pack1.*;


public class BankMain2 {
		public static void main(String[] args) {
			// 다른 패키지의 클래스 호출

				Bank john = new Bank();
				//john.imsi2;			// 접근지정자가 public	인 경우 다른 패키지에서 참조 가능
				//john.imsi;				// 접근지정자가 default 인 경우 다른 패키지에서 참조 불가
				System.out.println(john.getMoney());
}
}
