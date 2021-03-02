package pack1;

public class Test2 {
		public static void main(String[] args) {
				// 산술연산자
				int a = 5;		//치환 연산자
				int b = 3;
				int c = a + b;
				
				
				System.out.println(a + b);
				System.out.println(a - b);
				System.out.println(a * b);
				System.out.println(a / b);	//몫
				System.out.println(a % b);	//나머지
				System.out.println(a / (double)b);	//몫, 나머지
				//System.out.println(a / 0);	//err : bye zero
				System.out.println(a / 0.0);	// Infinity
				System.out.println(a % 0.0);	//NaN
				System.out.println(0 / 0.0);	//NaN
				System.out.println();
				System.out.println(3+4*5);	// * , / > + , - > = (치환)
				int mbc = 3+4*5;
				System.out.println((3+4)*5);
				
				System.out.println();
				String ss1 = "대한";
				String ss2 = "민국";
				String ss3 = ss1 + ss2;	// 문자열 더하기
				System.out.println(ss3);
				System.out.println(ss3 + " " + 2020);
				System.out.println(ss3 + " " + (2000 + 20));
				System.out.println(ss3 + " " + 2000 + 20);
				String ss4 = "5"+6;		// 자동으로 문자열로 변환
				System.out.println(ss4);
				int ia = Integer.parseInt("5") +6; // 강제적으로 문자열을 정수화 
				System.out.println(ia);
				String ss5 = Integer.toString(5)+6;
				System.out.println(ss5);
				
				//누적
				int no  = 1;
				no = no + 1;
				no += 1;
				no++;		//증감 연산자 ++, --
				++no;
				System.out.println("no :" + Integer.toString(no));		// " no : " + no
				
				
				System.out.println();
				//증감연산자
				int imsi = 5;
				int result = ++imsi +1;		// 비권장
				System.out.println(imsi);
				System.out.println(result);
				
				int imsi2 = 5;
				int result2 = imsi2++ +1;
				System.out.println(imsi2);
				System.out.println(result2);
				
				//부호에 대해
				System.out.println();
				int imsi3 = 3;
				System.out.println(imsi3);
				System.out.println(-imsi3);
				System.out.println(imsi3*-1);
		}
}
