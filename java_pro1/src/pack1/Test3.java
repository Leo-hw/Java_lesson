package pack1;

public class Test3 {
		public static void main(String[] args) {
			//관계연산자, 논리 연산자, 기타
			int a = 5;
					
			System.out.println(a >3);
			System.out.println(a <=3);
			System.out.println(a ==3);
			System.out.println(a !=3);
			
			System.out.println();
			int b = 10;
			System.out.println(a>3 && b <=10	);
			System.out.println(a>3 && b ==10	);
			System.out.println(a>20 && b <=5	);	// &&(논리곱) a 가 false 일 경우 b는 검사 x
			System.out.println(a>20 & b <=5	);		// &  a가 false일 경우에도 b 검사
			System.out.println(a > 6 ||  b<10);
			System.out.println(a > 6 ||  b<20);
			System.out.println(a > 6 |  b< 20 + 4  * 2);		//연산자 우선순위 : ( ) > 산술(*,/,% > +,- ) > 관계 > 논리 > 치환
			
			System.out.println();
			//shift 연산자			java에서ㅡㄴ 주로 game sound 제외하고 잘 쓰이지 않음
			int ii = 8, ij;
			//System.out.println(ii + " " + ij);		// 지역변수는 초기화 필수
			System.out.println("ii:" +ii +" " + Integer.toBinaryString(ii));
				ij = ii << 1; // 좌로 1bit 이동. 남는 우측  1bit 는 0 으로 채움
			System.out.println("ij:"+ ij+" " + Integer.toBinaryString(ij));
				ij = ii >> 2; // 우로 2bit 이동. 남는 좌측  2bit 는 부호와 같은 값으로 채움
				System.out.println("ij:"+ ij+" " + Integer.toBinaryString(ij));
				ij = ii >>> 2; // 우로 2bit 이동. 남는 우측  2bit 는 0 으로 채움
			System.out.println("ij:"+ ij+" " + Integer.toBinaryString(ij));
			
			System.out.println();
			int result = (ii < 5)?100:100+50;	//  상수, 모듈, 메소드 불러올 수 있음
			System.out.println("result :" + result);
			
			System.out.println();
			int x, y, z;
			x = y = z = 5;
			System.out.println(x + " " + y + " " + z);
			
			System.out.println("---");
			aa();
			System.out.println("---");
			System.out.println(bb(12));
			int mbc = bb(11);
			System.out.println("mbc:"+" " + mbc);
			System.out.println("프로그램 종료");
			
			
		}
		public static void aa()	{
			System.out.println("aa 메소드(단위프로그램:unit) 수행	");
		}
		
			public static int bb(int arg)	{
				System.out.println("bb 메소드(단위프로그램:unit) 수행	");
				int imsi = arg + 100;
				return imsi;
				//변수 명에 이름값을 주는 것 1. 변수 =값
				// 2. 인수= argument, parameter 
		}
}
