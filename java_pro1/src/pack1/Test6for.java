package pack1;

public class Test6for {
		public static void main(String[] args) {
			//반복문 for(초기치;조건;증가치;){}
		int a;	
		int hap = 0;		//누적 기억장소 : 초기화 권장
			for(a = 1; a <=10; a++) {
				System.out.print(a + "\t");
				// a = 3;		X.
				hap += a;
			}
		
		System.out.println("\na:" +a);
		System.out.println("10까지의합은 " + hap);
		
		System.out.println();
		for(int i = 65; i <=90; i++) {
			System.out.print((char)i + " ");
			
		}
		for (int i = 'A'; i <='Z'; i++) {
			System.out.println(i+ " ");
		}
		System.out.println();
		for (int i =4+6; i>1; i -=2) {
			System.out.println(i+" ");
			
		}
		System.out.println();
		for (int i =50+150; i>2; i /=2) {
			System.out.println(i+" ");
			}
		System.out.println();
		for (int ytn =0, tv=5; ytn<=5; ytn++, tv++) {
			System.out.print(ytn + " " +tv+" : " );
			
			
		}
		System.out.println();
		int aa = 1;
		for(; aa <=5; aa++ ) {
			if(aa == 2) System.out.println("만세");
			
			System.out.println(aa+ " ");
		}
		// 블럭은 블럭을 포함할 수 있음. 다만 겹칠 순 없음
		
		System.out.println("\n다중 for --------------"	);
		for(int m=1; m<=3; m++) {
			System.out.println("m= " + m);
			for(int n=1; n<=4; n++) {
				System.out.print("n: "+ n + " ");
				
			}
			System.out.println();
			
		}
		System.out.println();
		for(char i = 65; i<=90; i++) {
			System.out.print(i +" : ");
			for(char j = i; j <='Z'; j++) {
				System.out.print(j);
			}
		System.out.println();
		}
		System.out.println();
		
		
		//구구단 출력(3단)
		for(int count =1; count <10; count ++) {
			System.out.println(" 3 * "+count +" = "+(3*count));
		}
		
		//문1 : 키보드로 부터 숫자를 받아 구구단 출력 ( 2~9 까지만 허용)
		
		//문2 : 1~100사이의 정수 중 3의 배수이면서 5의 배수인 수를 출력하고 그들의 합을 출력
		
		//문3 : 2 ~ 9 까지 출력 (다중 for)
		
		//문4 :  *********
		//			 *******
		//			  *****
		//				***
		//				 *
		//문5 : 문4 결과 뒤집어 출력
		System.out.println("프로그램 종료");
		}			
}
